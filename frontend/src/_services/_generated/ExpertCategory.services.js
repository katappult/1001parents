import { _doPost,_doGet,_doPut, API_ROOT, _doDelete, buildURLQuery } from '../utils/services.config';

export const ExpertCategoryService = {
    createEntity,
    listEntity,
    updateEntity,
    updateEntityMaster,
    deleteEntity,
    detailsEntity,
    searchEntity,
    // EXPORT
}

async function createEntity(formData, containerId){
    const uri = '/katappult/cloud/app/v1/secured/api/expertcategory/create';
    var url = `${API_ROOT}` + uri + "?containerId=" + containerId
    return _doPost(url, JSON.stringify(formData))
}

async function listEntity(page, pageSize, containerId, params){
    const uri = "/katappult/cloud/app/v1/secured/api/expertcategory/list?page=" + page + "&pageSize=" + pageSize + "&containerId=" + containerId;
    let url = `${API_ROOT}` + uri;
    if(params){
       var p = buildURLQuery(params);
       url = url + '&' + p;
    }

    return _doGet(url);
}

async function updateEntity(entityId, formdata, containerId){
    const uri = "/katappult/cloud/app/v1/secured/api/expertcategory/update".concat("?containerId=").concat(containerId).concat("&entityId=" + entityId);
    const url = `${API_ROOT}` + uri;
    return _doPut(url, formdata);
}

async function updateEntityMaster(entityId, formdata, containerId){
    const uri = "/katappult/cloud/app/v1/secured/api/expertcategory/updateMaster".concat("?containerId=").concat(containerId).concat("&entityId=" + entityId);
    const url = `${API_ROOT}` + uri;
    return _doPut(url, formdata);
}

async function detailsEntity(entityId, containerId){
    const uri = "/katappult/cloud/app/v1/secured/api/expertcategory/details?entityId=" + entityId + "&containerId=" + containerId;
    const url = `${API_ROOT}` + uri;
    return _doGet(url);
}

async function deleteEntity(entityId, containerId){
    const uri = "/katappult/cloud/app/v1/secured/api/expertcategory/delete?entityId=" + entityId + "&containerId=" + containerId;
    const url = `${API_ROOT}` + uri;
    return _doDelete(url);
}

async function searchEntity(page, pageSize, searchTerm, containerId){
    const uri = "/katappult/cloud/app/v1/secured/api/expertcategory/search?searchTerm=" + searchTerm+ "&page="  + page + "&pageSize=" + pageSize + "&containerId=" + containerId;
    const url = `${API_ROOT}` + uri;
    return _doGet(url);
}

// FUNCTIONS
