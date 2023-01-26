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
import com.katappult.cloud.platform.generated.services.api.ICategoryExpertService;
import com.katappult.cloud.platform.generated.dao.api.ICategoryExpertDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateCategoryExpert;
import com.katappult.cloud.platform.generated.model.event.PreDeleteCategoryExpert;
import com.katappult.cloud.platform.generated.model.event.PreUpdateCategoryExpert;
import com.katappult.cloud.platform.generated.model.event.PostCreateCategoryExpert;
import com.katappult.cloud.platform.generated.model.event.PostDeleteCategoryExpert;
import com.katappult.cloud.platform.generated.model.event.PostUpdateCategoryExpert;
import java.util.List;
// IMPORT

@Component
public class CategoryExpertService implements  ICategoryExpertService {

    @Autowired
    private ICategoryExpertDao dao;

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
    public CategoryExpert  create(UIAttributes uiAttributes, Container container) {
        CategoryExpert entity = (CategoryExpert) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateCategoryExpert(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategoryExpert(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final CategoryExpert entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateCategoryExpert(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCategoryExpert(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final CategoryExpert transientEntity) {
        CategoryExpert persistent = (CategoryExpert) persistableService.findById(transientEntity.getOid(), CategoryExpert.class);

        applicationContext.publishEvent(new PreUpdateCategoryExpert(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategoryExpert(persistent));
    }


    @Override
    @Transactional
    public CategoryExpert update(UIAttributes uiAttributes, Container container) {
        CategoryExpert transientEntity = (CategoryExpert) uiAttributes.getTarget();
        CategoryExpert persistent = (CategoryExpert) persistableService.findById(transientEntity.getOid(), CategoryExpert.class);

        applicationContext.publishEvent(new PreUpdateCategoryExpert(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCategoryExpert(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(CategoryExpert entity, Container container) {
        CategoryExpert persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteCategoryExpert(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteCategoryExpert(persistent));
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
