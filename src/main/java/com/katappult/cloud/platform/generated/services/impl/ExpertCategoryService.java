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
import com.katappult.cloud.platform.generated.services.api.IExpertCategoryService;
import com.katappult.cloud.platform.generated.dao.api.IExpertCategoryDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateExpertCategory;
import com.katappult.cloud.platform.generated.model.event.PreDeleteExpertCategory;
import com.katappult.cloud.platform.generated.model.event.PreUpdateExpertCategory;
import com.katappult.cloud.platform.generated.model.event.PostCreateExpertCategory;
import com.katappult.cloud.platform.generated.model.event.PostDeleteExpertCategory;
import com.katappult.cloud.platform.generated.model.event.PostUpdateExpertCategory;
import java.util.List;
// IMPORT

@Component
public class ExpertCategoryService implements  IExpertCategoryService {

    @Autowired
    private IExpertCategoryDao dao;

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
    public ExpertCategory  create(UIAttributes uiAttributes, Container container) {
        ExpertCategory entity = (ExpertCategory) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateExpertCategory(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateExpertCategory(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final ExpertCategory entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateExpertCategory(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateExpertCategory(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final ExpertCategory transientEntity) {
        ExpertCategory persistent = (ExpertCategory) persistableService.findById(transientEntity.getOid(), ExpertCategory.class);

        applicationContext.publishEvent(new PreUpdateExpertCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateExpertCategory(persistent));
    }


    @Override
    @Transactional
    public ExpertCategory update(UIAttributes uiAttributes, Container container) {
        ExpertCategory transientEntity = (ExpertCategory) uiAttributes.getTarget();
        ExpertCategory persistent = (ExpertCategory) persistableService.findById(transientEntity.getOid(), ExpertCategory.class);

        applicationContext.publishEvent(new PreUpdateExpertCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateExpertCategory(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(ExpertCategory entity, Container container) {
        ExpertCategory persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteExpertCategory(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteExpertCategory(persistent));
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
