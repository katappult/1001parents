import React, {useEffect, useState} from 'react';
import {AttributeListGroup, WaitingPane} from "_components/_common";
import {DemandeService} from "_services/_generated/Demande.services";
import {toast} from "react-toastify";
import {commons} from "_helpers/commons";
import {typeService} from "_services/type.services";
import Form from "react-bootstrap/Form";
// IMPORT

function DemandeAdd(props) {

    const[formData, setFormData] = useState()
    const[loading, setLoading] = useState(false)
    const[errors, setErrors] = useState([])
const[types, setTypes] = useState([])
    const[businessType, setBusinessType] = useState('com.katappult.online.types.DemandeType')
// CONST

    const findFormErrors = (form) => {
        const { title,theme,description/*FORM ERRORS ATTR*/} = form
        const newErrors = {}

if (!title || title === '') newErrors.title = 'Champs invalide';
if (!theme || theme === '') newErrors.theme = 'Champs invalide';
if (!description || description === '') newErrors.description = 'Champs invalide';
/*FORM ERRORS VALIDATION*/
        return newErrors;
    }

    const create = (formData) => {
        setFormData(formData)
        setLoading(true)

        formData.containerId = props.containerId;
formData.businessType = businessType// ADDITIONAL_ATTRIBUTES

        DemandeService.createEntity(formData, props.containerId).then(response => {
            const error = commons.isRequestError(response)
            if(error) {
                setLoading(false)
                let message = response.errorFamily + ' - ' + response.message
                toast.error(commons.toastError(response));
                setErrors([message])
            }
            else {
                setLoading(false)
                props.onCreateSuccess();
                toast(commons.toastSuccess("Un élément a été créé"));
            }
        })
    }

    const attributesList = () => {
        const attributesList = {
            saveButtonTitle: 'CRÉER',
            onSubmit: (formData) => create(formData),
            formValidity: (formData) => findFormErrors(formData),
            attributes: [
{name: "Titre de la demande", dataField: "title",  required: true,  placeHolder: "Titre de la demande", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
{name: "Theme", dataField: "theme",  required: true,  placeHolder: "Theme", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
{name: "Description", dataField: "description",  required: true,  placeHolder: "Description", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
// CREATE_FORM_ATTRIBUTES_LIST
            ]
        }

        return attributesList;
    }

useEffect(() => {
        const rootType = businessType
        const containerId = props.containerId
        typeService.getByPath(rootType, containerId).then(response => {
            const id = response.data.attributes.id
            const firstElement = [response.data]
            typeService.getSubtypeOf(id, true, containerId).then(types => {
                const typeDatas = types.data
                setTypes(firstElement.concat(typeDatas))
                setBusinessType(rootType)
            })
        })
    }, [])

    const typeSelectionChange = (e) => {
        setBusinessType(e.target.value)
    }

    const typesSelect = () => {
        const options = types.map(type =>
            <option value={type.attributes.logicalPath}>{type.attributes.displayName}</option>
        )

        return <Form.Control as="select" onChange={typeSelectionChange}>
            {options}
        </Form.Control>
    }

// METHOD

    if(loading){
        return <WaitingPane/>
    }

    const form = {...formData}
    const attributes = {

        // INITIAL_ATTRIBUTES_VALUE
    }
    form['attributes'] = attributes;

    return (
        <div className="container-create-root">
            <p className=" form-error">{errors}</p>
<Form.Group className="field field-string attributes-list">
                <Form.Label>Type</Form.Label>
                {typesSelect()}
            </Form.Group>

{/*FORM*/}
            <AttributeListGroup
                attributesListConfig={attributesList()}
                data={form}
                standardFooterActions="true"
                formMode='create_object'/>
        </div>
    )
}

export default DemandeAdd;

// FOOTER
