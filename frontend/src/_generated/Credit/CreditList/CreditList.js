import React, {Component, useEffect, useState} from 'react';
import {DataTable, EmptyPane, WaitingPane, Wizard, WizardConfirm} from "_components/_common";
import CreditAdd from "_generated/Credit/CreditAdd";
import {CreditService} from "_services/_generated/Credit.services";
import CreditDetails from "_generated/Credit/CreditDetails";
import {Input} from "reactstrap";
import {Link} from "react-router-dom";
import queryString from 'query-string';
import {coreUri} from '_helpers/CoreUri';
import { commons } from '_helpers/commons.js';
import {toast} from "react-toastify";

import {DataExportService} from "_services/DataExport.services";
import FileSaver from "file-saver";
import {StatusHelper} from "_helpers/StatusHelper";
// IMPORT

function CreditList(props) {

    const[pageSize, setPageSize] = useState(14)
    const[loading, setLoading] = useState(true)
    const[datas, setDatas] = useState([])
    const[page, setPage] = useState(0)
    const[subviewMode, setSubviewMode] = useState('list')
    const[metaData, setMetaData] = useState()
    const[searchTerm, setSearchTerm] = useState()


    const runExport = async () => {
    var form = {}
    form['separator.char'] = '|'
    form['comment.char'] = '#'
    form['domain'] = commons.getWorkingContainerPath(props.userContext)
    form['container'] = commons.getWorkingContainerPath(props.userContext)
    form['attach.discarded.file'] = false
    form['attach.log.file'] = false
    form['log.file.extension'] = '.log'
    form['notify.on.error'] = 'false'
    form['notify.on.success'] = 'false'
    form['mail.on.success'] = false
    form['mail.on.error'] = false

    const containerId = props.containerId
    const exportConfig = await DataExportService.getByInternalName('EXPORT_CREDIT', containerId).then(response => {
        return response
    })

    if(!commons.isRequestError(exportConfig)){
        const id = exportConfig.data.attributes.id
        DataExportService.runExport(id, form, containerId).then(response => {
            if(response.ok) {
                return response.text()
            }
            else {
                toast.error("Echec de l'export des données")
            }

            return null;
        }).then(response => {
            if(response){
                var blob = new Blob([response], {type:"plain/text;charset=UTF-8"});
                FileSaver.saveAs(blob, "Credit.csv");
            }
        }).catch(error => {
            toast.error("Echec de l'export des données")
        })
    }
    else {
        toast.error("Configuration introuvable pour l'export")
    }

}
const typeOf =  (v, i) => {
        return <td width={'20%'} className="td-center">
           <div className='type-badge-display type-badge-display-inherit'>               {i.businessType?.displayName ? i.businessType.displayName.substring(0,2) : ''}           </div>
        </td>
    }

	
const status = (v, i) => {
        return <td className={'td-center'}  width={'10%'}>
            <div className="table-status">               {v.lifecycleInfo?.currentState ? StatusHelper.uiDisplay(v.lifecycleInfo.currentState) : ''}            </div>
        </td>
    }

// METHOD

    const onCreateSuccess = (wizardCloseFunction) => {
        wizardCloseFunction()
        loadDatas(page)
    }

    const wizardContent = (wizardCloseFunction) => {
        return <CreditAdd onCreateSuccess={() => onCreateSuccess(wizardCloseFunction)} {...props}/>
    }

    useEffect(() => {
        loadDatas(0)
    }, [])

    const goToPage = (index) => {
      loadDatas(index)
    }

    const refresh = () => {
        loadDatas(page)
    }

    const loadDatas = (index) => {
        setLoading(true)
        const statusFromUrl = commons.getValueFromUrl('status');
        const params = {
          status: statusFromUrl ? statusFromUrl : ""
        }
        CreditService.listEntity(index, pageSize, props.containerId, params).then(response => {
            if(!commons.isRequestError(response)){
                setPage(index)
                setDatas(response.data)
                setSubviewMode('list')
                setMetaData(response.metaData)
                setLoading(false)
             }
             else {
                setDatas([])
                setLoading(false)
             }
        })

    }

    const searchTermUpdated = (e) => {
        setLoading(true)
        let searchTerm = e.target.value
        if(searchTerm){
            CreditService.searchEntity(0, 10, searchTerm , props.containerId).then(response => {
                setPage(0)
                setDatas(response.data)
                setSubviewMode('search')
                setMetaData(response.metaData)
                setSearchTerm(searchTerm)
                setLoading(false)
            })
        }
        else {
            loadDatas(0)
        }
    }

    const getRootObjectForDetailsId = () => {
        const queryUrlParams = queryString.parse(props.location.search);
        let objectforDetailsId = queryUrlParams.rootId;
        return objectforDetailsId
    }

    const displayDetails = (e, id) => {
        if(e) e.preventDefault();
        let tabName = commons.getValueFromUrl('tab');
        let view = commons.getValueFromUrl('name');
        const url = coreUri.backOfficeViewURL(tabName, view, ["rootId=" +  id]);
        props.history.push(url);
    }

    const deleteRow = (id) => {
        CreditService.deleteEntity(id, props.containerId).then(response => {
            const error = commons.isRequestError(response)
            if(error) {
                toast.error(commons.toastError(response));
            }
            else {
                loadDatas(page)
                toast(commons.toastSuccess("L'élément a été supprimé"));
            }
        })
    }

    const deleteRowAction = (id) => {
        return <>
            <WizardConfirm
                buttonIconComp={<i className={'fa fa-trash fa-lg'}></i>}
                onConfirm={() => deleteRow(id)}
                dialogMessage="Voulez vous supprimer l'élément?"
                dialogTitle='Supprimer'
            />
        </>
    }

    // METHOD

    const tableActions = (v, i) => {
        return <td width={'20%'} className="td-right">
            <div className="btn-toolbar-right table-info-link">
                <button onClick={(e) => displayDetails(e, v.id)}>
                    <i className={'fa fa-info fa-lg'}></i>
                </button>
                 {deleteRowAction(v.id)}
            </div>
        </td>
    }

    const itemsDatatableRowItemName = (v, i) => {
        return <td className={'td-left table-info-link'}>
            <a href='#/details' onClick={(e) => displayDetails(e, v.id)}>
                {v.dateExpiration && v.dateExpiration.length > 0 ? v.dateExpiration : "> Infos"}
            </a>
        </td>
    }

    const table = () => {
        if(!datas || datas.length === 0){
            return <EmptyPane />
        }

        let tableConfig ={
            columnsConfig: [
                {name:'DateExpiration', displayComponent: (v, i) => itemsDatatableRowItemName(v,i), dataField: 'attributes', headerClass: 'td-left'},
{name: "Consumed", dataField: "attributes.consumed", type: "number", headerClass: "td-left", className: "td-left"},
{name: "Quantity", dataField: "attributes.quantity", type: "number", headerClass: "td-left", className: "td-left"},
{name:'Type', dataField: 'attributes',  displayComponent: (v, i) => typeOf(v,i), headerClass: 'td-center', className: 'td-center'},
	{name:'Statut', dataField: 'attributes', displayComponent:(v,i) => status(v,i), headerClass: 'td-center', className: 'td-center'},
// DATA_TABLE_ATTRIBUTES_LIST
                {dataField: 'attributes', displayComponent: (v,i) => tableActions(v,i), headerClass: 'td-left', className: 'td-left'},
            ],
        }
        var datatable = <DataTable items={JSON.stringify(datas)}
                                       tableConfig={tableConfig}
                                       pagination={true}
                                       goToPage={goToPage}
                                       metaData={JSON.stringify(metaData)}
                                       displayTotalElements={true}
                                       paginate={subviewMode === 'list' ? true : false}/>

        return datatable
    }


    let objectforDetailsId = getRootObjectForDetailsId()
    if(!objectforDetailsId) {
        var content;
        if (loading) {
            content = <WaitingPane/>
        } else {
            content = table();
        }

        return <div className="portlet-box">
                <div className="admin-filters-root">
                    <Input type="text"
                           className="admin-hover-input"
                           name="input1-group2"
                           placeholder="Chercher un élément"
                           autocomplete="off"
                           onChange={(e) => searchTermUpdated(e)}
                           defaultValue={searchTerm}/>
                    <div className="btn-toolbar btn-toolbar-right">
                        <Wizard buttonTitle={'Ajouter'}
                                buttonIcon={'fa fa-plus fa-md'}
                                hideFooter={true}
                                dialogSize="md"
                                dialogTitle="Ajouter une entité"
                                dialogContentProvider={(wizardCloseFunction) => wizardContent(wizardCloseFunction)}/>
                        <button onClick={runExport}><i className={'fa fa-sm fa-file-excel-o'}></i>&nbsp;Exporter</button>
{/*ACTIONS*/}
                        <button onClick={refresh}>Refresh</button>
                    </div>
            </div>
            <div className="portlet-content">
                {content}
            </div>
        </div>
    }
    else {
        return <CreditDetails {...props} refresh={refresh} forwardToDetailsUrl={null}/>
    }
}

export default CreditList;


// FOOTER
