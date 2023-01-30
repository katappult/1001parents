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
import com.katappult.cloud.platform.generated.services.api.ICategoryService;
import com.katappult.cloud.platform.generated.dao.api.ICategoryDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateCategory;
import com.katappult.cloud.platform.generated.model.event.PreDeleteCategory;
import com.katappult.cloud.platform.generated.model.event.PreUpdateCategory;
import com.katappult.cloud.platform.generated.model.event.PostCreateCategory;
import com.katappult.cloud.platform.generated.model.event.PostDeleteCategory;
import com.katappult.cloud.platform.generated.model.event.PostUpdateCategory;
import java.util.List;
// IMPORT

@Component
public class CategoryService implements  ICategoryService {

    @Autowired
    private ICategoryDao dao;

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
    public Category  create(UIAttributes uiAttributes, Container container) {
        Category entity = (Category) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateCategory(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategory(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final Category entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateCategory(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategory(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final Category transientEntity) {
        Category persistent = (Category) persistableService.findById(transientEntity.getOid(), Category.class);

        applicationContext.publishEvent(new PreUpdateCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategory(persistent));
    }


    @Override
    @Transactional
    public Category update(UIAttributes uiAttributes, Container container) {
        Category transientEntity = (Category) uiAttributes.getTarget();
        Category persistent = (Category) persistableService.findById(transientEntity.getOid(), Category.class);

        applicationContext.publishEvent(new PreUpdateCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategory(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(Category entity, Container container) {
        Category persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteCategory(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteCategory(persistent));
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
