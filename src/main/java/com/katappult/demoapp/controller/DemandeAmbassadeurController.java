package com.katappult.demoapp.controller;

import com.katappult.cloud.platform.generated.model.DemandeAmbassadeur;
import com.katappult.cloud.platform.generated.services.api.IDemandeAmbassadeurService;
import com.katappult.core.bridge.operation.IOperationResult;
import com.katappult.core.jsf.controller.BaseCRUDController;
import com.katappult.core.jsf.utils.CRUDMessageType;
import com.katappult.core.jsf.utils.JSFAuthUtils;
import com.katappult.core.model.account.UserAccount;
import com.katappult.core.model.persistable.IPersistable;
import com.katappult.core.utils.UIAttributes;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

@Lazy
@ManagedBean
@ViewScoped
public class DemandeAmbassadeurController extends BaseCRUDController implements Serializable {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemandeAmbassadeurController.class);

  private String entityName = "DemandeAmbassadeur";
  private String entityNameLower = "demandeAmbassadeur";
  private String entityDetailsView = String.format("/secured/%s/%sDetails.xhtml", entityName, entityNameLower);
  private String entityAddView = String.format("/secured/%s/add%s.xhtml", entityName, entityName);
  private String entityImportView = String.format("/secured/%s/import%s.xhtml", entityName, entityName);
  private String entityListView = String.format("/secured/%s/%sList.xhtml", entityName, entityNameLower);

  private DemandeAmbassadeur selectedElementForDetails;
  private DemandeAmbassadeur newElement = new DemandeAmbassadeur();

  @Inject private IDemandeAmbassadeurService entityService;

  @PostConstruct
  public void initController(){

  }

  public PageResult loadDataModelPaginatedList(PageRequest pageRequest) {
    PageResult datas;
    if (StringUtils.isEmpty(searchTerm)) {
      datas =
          entityService.list(
              pageRequest, services.containerService().getApplicationContainer(), new HashMap<>());
    } else {
      datas =
          entityService.searchByNameLike(
              searchTerm, pageRequest, services.containerService().getApplicationContainer());
    }

    return datas;
  }

  public void _doDeleteElement(Long oid) {
    if (Objects.isNull(oid)) {
      addDefaultErrorMessage(CRUDMessageType.PLEASE_SELECT_ELEMENT);
      return;
    }

    IPersistable elementToDelete = services.persistableService().findById(oid, DemandeAmbassadeur.class);
    if (Objects.isNull(elementToDelete)) {
      addDefaultErrorMessage(CRUDMessageType.ELEMENT_TO_DELETE_NOT_FOUND);
      return;
    }

    try {
      entityService.delete((DemandeAmbassadeur) elementToDelete, getWorkingContainer());
    } catch (Exception ex) {
      LOGGER.error(ex.getMessage(), ex);
      JSFAuthUtils.addErrorMessage(ex.getMessage());
      return;
    }

    addDefaultSuccessMessage(CRUDMessageType.ELEMENT_HAVE_BEEN_DELETED);
  }

  public String _doCreateNewElementAction() {

    try {
      UIAttributes uiAttributes = new UIAttributes();
      uiAttributes.setTarget(newElement);

      uiAttributes.validateAttributes(IOperationResult.basicSuccess());
      DemandeAmbassadeur createdElement = entityService.create(uiAttributes, getWorkingContainer());

      newElement = new DemandeAmbassadeur();
      return entityDetailsView + "?faces-redirect=true&msg=new&id=" + createdElement.getOid();

    } catch (Exception ex) {
      LOGGER.error(ex.getMessage(), ex);
      JSFAuthUtils.addErrorMessage(ex.getMessage());
    }

    return null;
  }

  public void _doUpdateElement() {

    try {

      UIAttributes uiAttributes = new UIAttributes();
      uiAttributes.setTarget(selectedElementForDetails);

      uiAttributes.validateAttributes(IOperationResult.basicSuccess());

      selectedElementForDetails = entityService.update(uiAttributes, getWorkingContainer());

      addDefaultSuccessMessage(CRUDMessageType.ELEMENT_HAVE_BEEN_UPDATED);
    } catch (Exception e) {
      JSFAuthUtils.addErrorMessage(e.getMessage());
    }
  }

  private void loadDetails(boolean refresh) {
    String id =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

    boolean shouldReLoadDatas =
        selectedElementForDetails == null
            || (StringUtils.isNotBlank(id)
                && !selectedElementForDetails.getOid().equals(Long.valueOf(id)));

    if (shouldReLoadDatas || refresh) {
      if (shouldReLoadDatas) {
        selectedElementForDetails =
            (DemandeAmbassadeur) services.persistableService().findById(Long.valueOf(id), DemandeAmbassadeur.class);
      }

      if (refresh) {
        selectedElementForDetails =
            (DemandeAmbassadeur)
                services
                    .persistableService()
                    .findByIdFetchType(selectedElementForDetails.getOid(), DemandeAmbassadeur.class);
      }
    }
  }

  public void _doRefreshListAction() {
    loadDataModelPaginatedList(new PageRequest(0, 10));
  }

  @Override
  protected String getJobType() {
    return "manage" + getEntityName();
  }

  public DemandeAmbassadeur getSelectedElementForDetails() {
    loadDetails(false);
    return selectedElementForDetails;
  }

  public void setSelectedElementForDetails(DemandeAmbassadeur selectedElementForDetails) {
    this.selectedElementForDetails = selectedElementForDetails;
  }

  public DemandeAmbassadeur getNewElement() {
    return newElement;
  }

  public void setNewElement(DemandeAmbassadeur newElement) {
    this.newElement = newElement;
  }

  public String getEntityName() {
    return entityName;
  }

  public void setEntityName(String entityName) {
    this.entityName = entityName;
  }

  public String getEntityNameLower() {
    return entityNameLower;
  }

  public void setEntityNameLower(String entityNameLower) {
    this.entityNameLower = entityNameLower;
  }

  public String getEntityDetailsView() {
    return entityDetailsView;
  }

  public void setEntityDetailsView(String entityDetailsView) {
    this.entityDetailsView = entityDetailsView;
  }

  public String getEntityAddView() {
    return entityAddView;
  }

  public void setEntityAddView(String entityAddView) {
    this.entityAddView = entityAddView;
  }

  public String getEntityListView() {
    return entityListView;
  }

  public void setEntityListView(String entityListView) {
    this.entityListView = entityListView;
  }

  public String getEntityImportView() {
    return entityImportView;
  }

  public void setEntityImportView(String entityImportView) {
    this.entityImportView = entityImportView;
  }
}
