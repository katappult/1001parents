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
import com.katappult.cloud.platform.generated.services.api.IReplayService;
import com.katappult.cloud.platform.generated.dao.api.IReplayDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateReplay;
import com.katappult.cloud.platform.generated.model.event.PreDeleteReplay;
import com.katappult.cloud.platform.generated.model.event.PreUpdateReplay;
import com.katappult.cloud.platform.generated.model.event.PostCreateReplay;
import com.katappult.cloud.platform.generated.model.event.PostDeleteReplay;
import com.katappult.cloud.platform.generated.model.event.PostUpdateReplay;
import java.util.List;
// IMPORT

@Component
public class ReplayService implements  IReplayService {

    @Autowired
    private IReplayDao dao;

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
    public Replay  create(UIAttributes uiAttributes, Container container) {
        Replay entity = (Replay) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateReplay(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateReplay(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final Replay entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateReplay(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateReplay(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final Replay transientEntity) {
        Replay persistent = (Replay) persistableService.findById(transientEntity.getOid(), Replay.class);

        applicationContext.publishEvent(new PreUpdateReplay(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateReplay(persistent));
    }


    @Override
    @Transactional
    public Replay update(UIAttributes uiAttributes, Container container) {
        Replay transientEntity = (Replay) uiAttributes.getTarget();
        Replay persistent = (Replay) persistableService.findById(transientEntity.getOid(), Replay.class);

        applicationContext.publishEvent(new PreUpdateReplay(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateReplay(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(Replay entity, Container container) {
        Replay persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteReplay(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteReplay(persistent));
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
