package com.katappult.demoapp.controller;

import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.cloud.platform.generated.services.api.IWebinarService;
import com.katappult.core.bridge.operation.IOperationResult;
import com.katappult.core.jsf.controller.BaseCRUDController;
import com.katappult.core.jsf.dto.ElementsDetailsDTO;
import com.katappult.core.jsf.utils.CRUDMessageType;
import com.katappult.core.jsf.utils.JSFAuthUtils;
import com.katappult.core.model.composite.Container;
import com.katappult.core.model.lifecyclemanaged.ILifecycleManaged;
import com.katappult.core.model.lifecyclemanaged.LifecycleHistory;
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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Lazy
@ManagedBean
@ViewScoped
public class WebinarController extends BaseCRUDController<Webinar> implements Serializable {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebinarController.class);

  private String entityName = "Webinar";
  private String entityNameLower = "webinar";
  private String entityDetailsView = String.format("/secured/%s/%sDetails.xhtml", entityName, entityNameLower);
  private String entityAddView = String.format("/secured/%s/add%s.xhtml", entityName, entityName);
  private String entityImportView = String.format("/secured/%s/import%s.xhtml", entityName, entityName);
  private String entityListView = String.format("/secured/%s/%sList.xhtml", entityName, entityNameLower);

  private ElementsDetailsDTO selectedElementForDetails;
  private Webinar newElement = new Webinar();

  @Inject
  private IWebinarService entityService;

  @PostConstruct
  public void initController(){
    super.initialiseBean();
  }

  protected void loadReachableStates() {
    if (getIsTypeOrLifecycleManaged() && selectedElementForDetails != null) {

      Container container = services.containerService().getApplicationContainer();

      List<String> reachableStates = services.lifecycleManagedService()
              .getStatesBySetState((ILifecycleManaged) selectedElementForDetails.getElement(), container);

      selectedElementForDetails.setReachableStates(reachableStates);

      List<LifecycleHistory> lifecycleHistories = services.lifecycleManagedService()
              .lifecycleHistory((ILifecycleManaged) selectedElementForDetails.getElement(), container);

      selectedElementForDetails.setLifecycleHistories(lifecycleHistories);
    }
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

    IPersistable elementToDelete = services.persistableService().findById(oid, Webinar.class);
    if (Objects.isNull(elementToDelete)) {
      addDefaultErrorMessage(CRUDMessageType.ELEMENT_TO_DELETE_NOT_FOUND);
      return;
    }

    try {
      entityService.delete((Webinar) elementToDelete, getWorkingContainer());
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
      addLegacyType(uiAttributes);
      Webinar createdElement = entityService.create(uiAttributes, getWorkingContainer());

      newElement = new Webinar();
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
      uiAttributes.setTarget(selectedElementForDetails.getElement());

      uiAttributes.validateAttributes(IOperationResult.basicSuccess());

      Webinar element = entityService.update(uiAttributes, getWorkingContainer());
      selectedElementForDetails.setElement(element);

      addDefaultSuccessMessage(CRUDMessageType.ELEMENT_HAVE_BEEN_UPDATED);
    } catch (Exception e) {
      JSFAuthUtils.addErrorMessage(e.getMessage());
    }
  }

  public void _doUpdateElementBySetState(String state) {
    Container container = services.containerService().getApplicationContainer();
    services.lifecycleManagedService()
            .updateStatusBySetState((ILifecycleManaged) selectedElementForDetails.getElement(), state, container);

    loadDetails(true);
  }

  private void loadDetails(boolean refresh) {
    String id =
            FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    Long previousId = Optional.ofNullable(selectedElementForDetails)
            .map(element -> element.getElement())
            .map(element -> element.getOid())
            .orElse(null);

    if(Objects.isNull(previousId) && StringUtils.isEmpty(id)) {
      return;
    }

    boolean shouldReLoadDatas = !refresh;
    Long targetId = Optional.ofNullable(id).map(Long::valueOf).orElse(previousId);
    if (shouldReLoadDatas || refresh) {

      selectedElementForDetails = new ElementsDetailsDTO();
      if (shouldReLoadDatas) {
        Webinar element =
            (Webinar) services.persistableService().findById(targetId, Webinar.class);
        selectedElementForDetails.setElement(element);
      }

      if (refresh && previousId != null) {
        Webinar element =
            (Webinar)
                services
                    .persistableService()
                    .findByIdFetchType(previousId, Webinar.class);
        selectedElementForDetails.setElement(element);
      }

      loadReachableStates();
    }
  }

  public void _doRefreshListAction() {
    loadDataModelPaginatedList(new PageRequest(0, 10));
  }

  @Override
  public Class<Webinar> getTargetEntityClass() {
    return Webinar.class;
  }

  @Override
  protected String getJobType() {
    return "manage" + getEntityName();
  }

  public ElementsDetailsDTO getSelectedElementForDetails() {
    loadDetails(false);
    return selectedElementForDetails;
  }

  public Webinar getNewElement() {
    return newElement;
  }

  public void setNewElement(Webinar newElement) {
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

  public List<String> getReachableStates() {
    return selectedElementForDetails.getReachableStates();
  }
}
