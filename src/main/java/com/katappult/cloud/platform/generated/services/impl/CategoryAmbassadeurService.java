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
import com.katappult.cloud.platform.generated.services.api.ICategoryAmbassadeurService;
import com.katappult.cloud.platform.generated.dao.api.ICategoryAmbassadeurDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateCategoryAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PreDeleteCategoryAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PreUpdateCategoryAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PostCreateCategoryAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PostDeleteCategoryAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PostUpdateCategoryAmbassadeur;
import java.util.List;
// IMPORT

@Component
public class CategoryAmbassadeurService implements  ICategoryAmbassadeurService {

    @Autowired
    private ICategoryAmbassadeurDao dao;

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
    public CategoryAmbassadeur  create(UIAttributes uiAttributes, Container container) {
        CategoryAmbassadeur entity = (CategoryAmbassadeur) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateCategoryAmbassadeur(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategoryAmbassadeur(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final CategoryAmbassadeur entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateCategoryAmbassadeur(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategoryAmbassadeur(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final CategoryAmbassadeur transientEntity) {
        CategoryAmbassadeur persistent = (CategoryAmbassadeur) persistableService.findById(transientEntity.getOid(), CategoryAmbassadeur.class);

        applicationContext.publishEvent(new PreUpdateCategoryAmbassadeur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategoryAmbassadeur(persistent));
    }


    @Override
    @Transactional
    public CategoryAmbassadeur update(UIAttributes uiAttributes, Container container) {
        CategoryAmbassadeur transientEntity = (CategoryAmbassadeur) uiAttributes.getTarget();
        CategoryAmbassadeur persistent = (CategoryAmbassadeur) persistableService.findById(transientEntity.getOid(), CategoryAmbassadeur.class);

        applicationContext.publishEvent(new PreUpdateCategoryAmbassadeur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategoryAmbassadeur(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(CategoryAmbassadeur entity, Container container) {
        CategoryAmbassadeur persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteCategoryAmbassadeur(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteCategoryAmbassadeur(persistent));
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
