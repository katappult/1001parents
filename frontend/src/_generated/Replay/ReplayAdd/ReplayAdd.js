import React, {useEffect, useState} from 'react';
import {AttributeListGroup, WaitingPane} from "_components/_common";
import {ReplayService} from "_services/_generated/Replay.services";
import {toast} from "react-toastify";
import {commons} from "_helpers/commons";
// IMPORT

function ReplayAdd(props) {

    const[formData, setFormData] = useState()
    const[loading, setLoading] = useState(false)
    const[errors, setErrors] = useState([])
// CONST

    const findFormErrors = (form) => {
        const { title,description,mediaType,externalLink,webinarSource/*FORM ERRORS ATTR*/} = form
        const newErrors = {}

if (!title || title === '') newErrors.title = 'Champs invalide';
if (!description || description === '') newErrors.description = 'Champs invalide';
if (!mediaType || mediaType === '') newErrors.mediaType = 'Champs invalide';
if (!externalLink || externalLink === '') newErrors.externalLink = 'Champs invalide';
if (!webinarSource || webinarSource === '') newErrors.webinarSource = 'Champs invalide';
/*FORM ERRORS VALIDATION*/
        return newErrors;
    }

    const create = (formData) => {
        setFormData(formData)
        setLoading(true)

        formData.containerId = props.containerId;
// ADDITIONAL_ATTRIBUTES

        ReplayService.createEntity(formData, props.containerId).then(response => {
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
{name: "Titre", dataField: "title",  required: true,  placeHolder: "Titre", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
{name: "Description", dataField: "description",  required: true,  placeHolder: "Description", type: "textarea", invalidFeedBack: "Veuillez renseigner ce champs"},
{name: "MediaType", dataField: "mediaType",  required: true,  placeHolder: "MediaType", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
{name: "ExternalLink", dataField: "externalLink",  required: true,  placeHolder: "ExternalLink", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
{name: "WebinarSource", dataField: "webinarSource",  required: true,  placeHolder: "WebinarSource", type: "text", invalidFeedBack: "Veuillez renseigner ce champs"},
// CREATE_FORM_ATTRIBUTES_LIST
            ]
        }

        return attributesList;
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
{/*FORM*/}
            <AttributeListGroup
                attributesListConfig={attributesList()}
                data={form}
                standardFooterActions="true"
                formMode='create_object'/>
        </div>
    )
}

export default ReplayAdd;

// FOOTER
