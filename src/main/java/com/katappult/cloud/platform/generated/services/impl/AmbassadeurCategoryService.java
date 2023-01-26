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
import com.katappult.cloud.platform.generated.services.api.IAmbassadeurCategoryService;
import com.katappult.cloud.platform.generated.dao.api.IAmbassadeurCategoryDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateAmbassadeurCategory;
import com.katappult.cloud.platform.generated.model.event.PreDeleteAmbassadeurCategory;
import com.katappult.cloud.platform.generated.model.event.PreUpdateAmbassadeurCategory;
import com.katappult.cloud.platform.generated.model.event.PostCreateAmbassadeurCategory;
import com.katappult.cloud.platform.generated.model.event.PostDeleteAmbassadeurCategory;
import com.katappult.cloud.platform.generated.model.event.PostUpdateAmbassadeurCategory;
import java.util.List;
// IMPORT

@Component
public class AmbassadeurCategoryService implements  IAmbassadeurCategoryService {

    @Autowired
    private IAmbassadeurCategoryDao dao;

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
    public AmbassadeurCategory  create(UIAttributes uiAttributes, Container container) {
        AmbassadeurCategory entity = (AmbassadeurCategory) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateAmbassadeurCategory(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateAmbassadeurCategory(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final AmbassadeurCategory entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateAmbassadeurCategory(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateAmbassadeurCategory(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final AmbassadeurCategory transientEntity) {
        AmbassadeurCategory persistent = (AmbassadeurCategory) persistableService.findById(transientEntity.getOid(), AmbassadeurCategory.class);

        applicationContext.publishEvent(new PreUpdateAmbassadeurCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateAmbassadeurCategory(persistent));
    }


    @Override
    @Transactional
    public AmbassadeurCategory update(UIAttributes uiAttributes, Container container) {
        AmbassadeurCategory transientEntity = (AmbassadeurCategory) uiAttributes.getTarget();
        AmbassadeurCategory persistent = (AmbassadeurCategory) persistableService.findById(transientEntity.getOid(), AmbassadeurCategory.class);

        applicationContext.publishEvent(new PreUpdateAmbassadeurCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateAmbassadeurCategory(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(AmbassadeurCategory entity, Container container) {
        AmbassadeurCategory persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteAmbassadeurCategory(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteAmbassadeurCategory(persistent));
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
