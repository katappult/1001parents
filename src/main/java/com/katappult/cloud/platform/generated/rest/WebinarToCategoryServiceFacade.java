package com.katappult.cloud.platform.generated.rest;

import com.katappult.core.bridge.operation.IOperationResult;
import com.katappult.core.bridge.result.MultipleResult;
import com.katappult.core.bridge.result.OperationData;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.core.utils.RestObjectFullId;
import com.katappult.core.utils.common.TransferUtils;
import com.katappult.core.utils.common.ValidationErrorTranslator;
import com.katappult.cloud.platform.generated.services.api.IWebinarToCategoryService;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.cloud.platform.generated.model.WebinarToCategoryLink;
import com.katappult.cloud.platform.generated.rest.dto.WebinarToCategoryLinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//IMPORT

@RestController
@RequestMapping("/katappult/cloud/app/v1/secured/api/webinar/manytomany/Category")
public class WebinarToCategoryServiceFacade {

    @Autowired
    @Qualifier("ValidationErrorTranslator")
    private ValidationErrorTranslator et;

    @Autowired
    private IWebinarToCategoryService service;

    @PostMapping(path = "/createLink", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable createLink(@RequestParam("roleAId") RestObjectFullId roleAId,
                                   @RequestParam("roleBId") RestObjectFullId roleBId,
                                   @RequestParam("containerId") Container container){
        IOperationResult result = IOperationResult.basicSuccess();
        service.createLink((Webinar) roleAId.getPersistable(), (Category) roleBId.getPersistable(), container);
        return result;
    }

    @DeleteMapping(path = "/deleteLink", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable deleteLink(@RequestParam("roleAId") RestObjectFullId roleAId,
                                   @RequestParam("roleBId") RestObjectFullId roleBId,
                                   @RequestParam("containerId") Container container){

        IOperationResult result = IOperationResult.basicSuccess();

        Webinar roleA = (Webinar) roleAId.getPersistable();
        Category roleB = (Category) roleBId.getPersistable();
        service.deleteLink(roleA, roleB, container);

        return result;
    }

    @PutMapping(path = "/moveFromRoleA", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable moveFromRoleA(@RequestParam("roleAId") RestObjectFullId roleAId,
                                      @RequestParam("targetRoleAId") RestObjectFullId targetRoleAId,
                                      @RequestParam("roleBId") RestObjectFullId roleBId,
                                      @RequestParam("containerId") Container container){
        IOperationResult result = IOperationResult.basicSuccess();

        Webinar roleA = (Webinar) roleAId.getPersistable();
        Webinar targetRoleA = (Webinar) targetRoleAId.getPersistable();
        Category roleB = (Category) roleBId.getPersistable();
        service.moveFromRoleA(roleA, targetRoleA, roleB, container);

        return result;
    }

    @GetMapping(path = "/getLink", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable getLink(@RequestParam("roleAId") RestObjectFullId roleAId,
                                @RequestParam("roleBId") RestObjectFullId roleBId,
                                @RequestParam("containerId") Container container){
        IOperationResult result = IOperationResult.basicSuccess();

        Webinar roleA = (Webinar) roleAId.getPersistable();
        Category roleB = (Category) roleBId.getPersistable();
        Optional<WebinarToCategoryLink> linkAsOptional = service.getLink(roleA, roleB, container);

        linkAsOptional.ifPresent(link -> {
            OperationData operationData = TransferUtils.toOperationData(link);
            result.setData(operationData);
        });

        return result;
    }

    @DeleteMapping(path = "/removeAllRoleBs", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable removeAllRoleBs(@RequestParam("roleAId") RestObjectFullId roleAId,
                                        @RequestParam("containerId") Container container){
        IOperationResult result = IOperationResult.basicSuccess();

        Webinar roleA = (Webinar) roleAId.getPersistable();
        service.removeAllRoleBs(roleA, container);
        return result;
    }

    @GetMapping(path = "/getAllRoleBs", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable getAllRoleBs(@RequestParam("roleAId") RestObjectFullId roleAId,
                                     @RequestParam("containerId") Container container){

        Webinar roleA = (Webinar) roleAId.getPersistable();
        List<Category> roleBs = service.getAllRoleBs(roleA, container);

        return TransferUtils.toUniquePageResult(roleBs);
    }

    @GetMapping(path = "/getAllRoleBs/inverse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable getAllWebinarInverseRoleBsManyToManyLinkToOfCategory(
                                     @RequestParam("roleBId") RestObjectFullId roleBId,
                                     @RequestParam("containerId") Container container){

        Category roleB = (Category) roleBId.getPersistable();
        List<Webinar> roleAs = service.getAllWebinarInverseRoleBsManyToManyLinkToOfCategory(roleB, container);

        return TransferUtils.toUniquePageResult(roleAs);
    }

    @GetMapping(path = "/getAllRoleBsWithLink", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable getAllRoleBsWithLink(@RequestParam("roleAId") RestObjectFullId roleAId,
                                             @RequestParam("containerId") Container container){
        IOperationResult result = IOperationResult.listSuccess();

        Webinar roleA = (Webinar) roleAId.getPersistable();
        Map<Category, WebinarToCategoryLink> links = service.getAllRoleBsWithLink(roleA, container);
        List dtos = links.keySet().stream().map(key -> WebinarToCategoryLinkDTO.from(key, links.get(key))).collect(Collectors.toList());
        result.setData(dtos);
        return result;
    }

    @GetMapping(path = "/searchRoleBsNotLinkedToRoleA", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable searchRoleBsNotLinkedToRoleA(@RequestParam("roleAId") RestObjectFullId roleAId,
                                                     @RequestParam(name = "searchTerm", defaultValue = "") String searchTerm,
                                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                                     @RequestParam("containerId") Container container){
        IOperationResult result = IOperationResult.listSuccess();
        Webinar roleA = (Webinar) roleAId.getPersistable();
        PageRequest pageRequest = new PageRequest(page, pageSize);
        PageResult pageResult = service.searchRoleBsNotLinkedToRoleA(roleA, searchTerm, pageRequest, container);
        TransferUtils.toOperationData(pageResult, (MultipleResult) result);
        return result;
    }
}
