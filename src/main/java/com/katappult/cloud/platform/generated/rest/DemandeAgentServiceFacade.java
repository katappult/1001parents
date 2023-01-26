package com.katappult.cloud.platform.generated.rest;

import com.katappult.core.bridge.operation.IOperationResult;
import com.katappult.core.bridge.result.MultipleResult;
import com.katappult.core.bridge.result.OperationData;
import com.katappult.core.bridge.result.SingleResult;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.service.api.IPersistableService;
import org.hibernate.Hibernate;
import com.katappult.core.utils.RestObjectFullId;
import com.katappult.core.utils.common.TransferUtils;
import com.katappult.core.utils.common.ValidationErrorTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.hibernate.Hibernate;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.katappult.core.utils.UIAttributes;
import javax.inject.Provider;
import com.katappult.core.dao.api.IPersistableRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.katappult.cloud.platform.generated.services.api.IDemandeAgentService;
import com.katappult.cloud.platform.generated.model.*;
import com.katappult.cloud.platform.generated.model.AgentFacilitateurCategory;
import com.katappult.core.model.account.UserAccount;
// IMPORT

@RestController
@RequestMapping("/katappult/cloud/app/v1/secured/api/demandeagent")
public class DemandeAgentServiceFacade {

  @Autowired
  @Qualifier("ValidationErrorTranslator")
  private ValidationErrorTranslator et;

  @Autowired
  private IDemandeAgentService service;

  @Autowired
  private IPersistableService persistableService;

  @Autowired
  private IPersistableRepository persistableRepository;

  @Autowired
  private Provider<UIAttributes> uiAttributesProvider;


  @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable create(@RequestBody String request) {
    IOperationResult result = new SingleResult();

    UIAttributes uiAttributes = uiAttributesProvider.get();
    uiAttributes.from(request, DemandeAgent.class);
    uiAttributes.validateAttributes(result);

    Container container = uiAttributes.validateContainer(result);
    service.create(uiAttributes, container);

    OperationData operationData = TransferUtils.toOperationData(uiAttributes.getTarget());
    result.setData(operationData);
    return result;
  }

  @GetMapping(value = "/details", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
  @ResponseBody
  public Serializable details(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                            @RequestParam("containerId") Container container)  {

    IOperationResult result = new SingleResult();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();

    OperationData operationData = TransferUtils.toOperationData(entity);
    result.setData(operationData);
    return result;
  }

  @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable delete(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                           @RequestParam("containerId") Container container)  {

    IOperationResult result = new SingleResult();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();
    service.delete(entity, container);
    return result;
  }

  @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable update(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                           @RequestBody String request,
                           @RequestParam("containerId") Container container) {

    IOperationResult result = new SingleResult();

    UIAttributes uiAttributes = uiAttributesProvider.get();
    uiAttributes.from(request, DemandeAgent.class);
    uiAttributes.validateAttributes(result);

    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();
    uiAttributes.getTarget().setOid(entity.getOid());

    service.update(uiAttributes, container);
    return result;
  }

  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
  @ResponseBody
  public Serializable list(@RequestParam("containerId") Container container,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "status", defaultValue = "") String status,
                         @RequestParam(name = "pageSize", defaultValue = "10") int pagesize,
                         @RequestParam(name = "sort", required = false) String sort){

    IOperationResult result = new MultipleResult();
    PageRequest pageRequest = new PageRequest.Builder().page(page).size(pagesize).build();

    Map params = new HashMap();
    params.put("status", status);

    PageResult pageResult = service.list(pageRequest, container, params);
    TransferUtils.toOperationData(pageResult, (MultipleResult)result);

    return result;
  }

  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
  @ResponseBody
  public Serializable search(@RequestParam("containerId") Container container,
                           @RequestParam(name = "searchTerm") String searchTerm,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "pageSize", defaultValue = "10") int pagesize,
                           @RequestParam(name = "sort", required = false) String sort){

    IOperationResult result = new MultipleResult();
    PageRequest pageRequest = new PageRequest.Builder().page(page).size(pagesize).build();

    PageResult pageResult = service.searchByNameLike(searchTerm, pageRequest, container);
    TransferUtils.toOperationData(pageResult, (MultipleResult)result);

    return result;
  }

  

  @PostMapping(value = "/oneToOneAgentFacilitateurCategory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable setOneToOneAgentFacilitateurCategory(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                        @RequestParam(name = "rolebId") final RestObjectFullId rolebId,
                                        @RequestParam("containerId") Container container)  {

    IOperationResult result = IOperationResult.basicSuccess();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();
    AgentFacilitateurCategory roleb = (AgentFacilitateurCategory) rolebId.getPersistable();

    service.setAgentFacilitateurCategory(entity, roleb, container);

    OperationData operationData = TransferUtils.toOperationData(entity);
    result.setData(operationData);
    return result;
  }

  @DeleteMapping(value = "/oneToOneAgentFacilitateurCategory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable removeOneToOneAgentFacilitateurCategory(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                            @RequestParam(name = "rolebId") final RestObjectFullId rolebId,
                                            @RequestParam("containerId") Container container)  {

    IOperationResult result = IOperationResult.basicSuccess();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();
    AgentFacilitateurCategory roleb = (AgentFacilitateurCategory) rolebId.getPersistable();

    service.removeAgentFacilitateurCategory(entity, roleb, container);

    OperationData operationData = TransferUtils.toOperationData(entity);
    result.setData(operationData);
    return result;
  }

  @GetMapping(value = "/oneToOneAgentFacilitateurCategory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Serializable getOneToOneAgentFacilitateurCategory(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                        @RequestParam("containerId") Container container)  {

    IOperationResult result = IOperationResult.basicSuccess();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();

    AgentFacilitateurCategory roleb = service.getAgentFacilitateurCategory(entity, container);
    if(roleb != null){
      OperationData operationData = TransferUtils.toOperationData(roleb);
      result.setData(operationData);
    }

    return result;
  }


  @GetMapping(value = "/oneToOneAgentFacilitateurCategory/inverse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
  @ResponseBody
  public Serializable inverseOneToOneAgentFacilitateurCategory(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                                  @RequestParam("containerId") Container container)  {

        IOperationResult result = new SingleResult();
        AgentFacilitateurCategory entity = (AgentFacilitateurCategory) entityId.getPersistable();

        DemandeAgent roleA = service.getInverseOneToOneAgentFacilitateurCategory(entity, container);

        OperationData operationData = TransferUtils.toOperationData(roleA);
        result.setData(operationData);
        return result;
  }



  @PostMapping(value = "/oneToOneUserAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable setOneToOneUserAccount(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                        @RequestParam(name = "rolebId") final RestObjectFullId rolebId,
                                        @RequestParam("containerId") Container container)  {

    IOperationResult result = IOperationResult.basicSuccess();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();
    UserAccount roleb = (UserAccount) rolebId.getPersistable();

    service.setUserAccount(entity, roleb, container);

    OperationData operationData = TransferUtils.toOperationData(entity);
    result.setData(operationData);
    return result;
  }

  @DeleteMapping(value = "/oneToOneUserAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @ResponseBody
  public Serializable removeOneToOneUserAccount(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                            @RequestParam(name = "rolebId") final RestObjectFullId rolebId,
                                            @RequestParam("containerId") Container container)  {

    IOperationResult result = IOperationResult.basicSuccess();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();
    UserAccount roleb = (UserAccount) rolebId.getPersistable();

    service.removeUserAccount(entity, roleb, container);

    OperationData operationData = TransferUtils.toOperationData(entity);
    result.setData(operationData);
    return result;
  }

  @GetMapping(value = "/oneToOneUserAccount", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Serializable getOneToOneUserAccount(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                        @RequestParam("containerId") Container container)  {

    IOperationResult result = IOperationResult.basicSuccess();
    DemandeAgent entity = (DemandeAgent) entityId.getPersistable();

    UserAccount roleb = service.getUserAccount(entity, container);
    if(roleb != null){
      OperationData operationData = TransferUtils.toOperationData(roleb);
      result.setData(operationData);
    }

    return result;
  }


  @GetMapping(value = "/oneToOneUserAccount/inverse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
  @ResponseBody
  public Serializable inverseOneToOneUserAccount(@RequestParam(name = "entityId") final RestObjectFullId entityId,
                                                  @RequestParam("containerId") Container container)  {

        IOperationResult result = new SingleResult();
        UserAccount entity = (UserAccount) entityId.getPersistable();

        DemandeAgent roleA = service.getInverseOneToOneUserAccount(entity, container);

        OperationData operationData = TransferUtils.toOperationData(roleA);
        result.setData(operationData);
        return result;
  }

// SERVICES
}