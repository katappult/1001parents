package com.katappult.cloud.platform.generated.services.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.exceptions.BusinessRuleException;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.core.service.api.IPersistableService;
import com.katappult.core.service.api.foldered.IContainedService;
import com.katappult.core.utils.UIAttributes;
import org.apache.commons.lang.StringUtils;
import com.katappult.core.dao.api.IPersistableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.katappult.core.model.typed.ITypeManaged;
import com.katappult.core.service.api.typed.ITypeManagedService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import java.util.Map;
import com.katappult.cloud.platform.generated.model.*;
import com.katappult.cloud.platform.generated.services.api.ICategoryAgentsFacilitateurService;
import com.katappult.cloud.platform.generated.dao.api.ICategoryAgentsFacilitateurDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateCategoryAgentsFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PreDeleteCategoryAgentsFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PreUpdateCategoryAgentsFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PostCreateCategoryAgentsFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PostDeleteCategoryAgentsFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PostUpdateCategoryAgentsFacilitateur;
import java.util.List;
// IMPORT

@Component
public class CategoryAgentsFacilitateurService implements  ICategoryAgentsFacilitateurService {

    @Autowired
    private ICategoryAgentsFacilitateurDao dao;

    @Autowired
    private IPersistableService persistableService;

    @Autowired
    private IContainedService containedService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ITypeManagedService typeManagedService;

    @Autowired
    private IPersistableRepository persistableDao;

    @Override
    @Transactional
    public CategoryAgentsFacilitateur  create(UIAttributes uiAttributes, Container container) {
        CategoryAgentsFacilitateur entity = (CategoryAgentsFacilitateur) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateCategoryAgentsFacilitateur(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategoryAgentsFacilitateur(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final CategoryAgentsFacilitateur entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateCategoryAgentsFacilitateur(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategoryAgentsFacilitateur(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final CategoryAgentsFacilitateur transientEntity) {
        CategoryAgentsFacilitateur persistent = (CategoryAgentsFacilitateur) persistableService.findById(transientEntity.getOid(), CategoryAgentsFacilitateur.class);

        applicationContext.publishEvent(new PreUpdateCategoryAgentsFacilitateur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategoryAgentsFacilitateur(persistent));
    }


    @Override
    @Transactional
    public CategoryAgentsFacilitateur update(UIAttributes uiAttributes, Container container) {
        CategoryAgentsFacilitateur transientEntity = (CategoryAgentsFacilitateur) uiAttributes.getTarget();
        CategoryAgentsFacilitateur persistent = (CategoryAgentsFacilitateur) persistableService.findById(transientEntity.getOid(), CategoryAgentsFacilitateur.class);

        applicationContext.publishEvent(new PreUpdateCategoryAgentsFacilitateur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategoryAgentsFacilitateur(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(CategoryAgentsFacilitateur entity, Container container) {
        CategoryAgentsFacilitateur persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteCategoryAgentsFacilitateur(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteCategoryAgentsFacilitateur(persistent));
    }

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        return dao.list(pageRequest, container, params);
    }

    @Override
    public PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container) {
        return dao.searchByNamelike(searchTerm, pageRequest, container);
    }

    // SERVICES
}
