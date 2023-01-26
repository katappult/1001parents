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
import com.katappult.cloud.platform.generated.services.api.IWebinarService;
import com.katappult.cloud.platform.generated.dao.api.IWebinarDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateWebinar;
import com.katappult.cloud.platform.generated.model.event.PreDeleteWebinar;
import com.katappult.cloud.platform.generated.model.event.PreUpdateWebinar;
import com.katappult.cloud.platform.generated.model.event.PostCreateWebinar;
import com.katappult.cloud.platform.generated.model.event.PostDeleteWebinar;
import com.katappult.cloud.platform.generated.model.event.PostUpdateWebinar;
import java.util.List;
// IMPORT

@Component
public class WebinarService implements  IWebinarService {

    @Autowired
    private IWebinarDao dao;

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
    public Webinar  create(UIAttributes uiAttributes, Container container) {
        Webinar entity = (Webinar) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateWebinar(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateWebinar(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final Webinar entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateWebinar(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateWebinar(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final Webinar transientEntity) {
        Webinar persistent = (Webinar) persistableService.findById(transientEntity.getOid(), Webinar.class);

        applicationContext.publishEvent(new PreUpdateWebinar(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateWebinar(persistent));
    }


    @Override
    @Transactional
    public Webinar update(UIAttributes uiAttributes, Container container) {
        Webinar transientEntity = (Webinar) uiAttributes.getTarget();
        Webinar persistent = (Webinar) persistableService.findById(transientEntity.getOid(), Webinar.class);

        applicationContext.publishEvent(new PreUpdateWebinar(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateWebinar(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(Webinar entity, Container container) {
        Webinar persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteWebinar(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteWebinar(persistent));
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
