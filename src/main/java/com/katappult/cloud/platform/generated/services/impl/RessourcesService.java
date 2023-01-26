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
import com.katappult.cloud.platform.generated.services.api.IRessourcesService;
import com.katappult.cloud.platform.generated.dao.api.IRessourcesDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateRessources;
import com.katappult.cloud.platform.generated.model.event.PreDeleteRessources;
import com.katappult.cloud.platform.generated.model.event.PreUpdateRessources;
import com.katappult.cloud.platform.generated.model.event.PostCreateRessources;
import com.katappult.cloud.platform.generated.model.event.PostDeleteRessources;
import com.katappult.cloud.platform.generated.model.event.PostUpdateRessources;
import java.util.List;
// IMPORT

@Component
public class RessourcesService implements  IRessourcesService {

    @Autowired
    private IRessourcesDao dao;

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
    public Ressources  create(UIAttributes uiAttributes, Container container) {
        Ressources entity = (Ressources) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateRessources(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateRessources(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final Ressources entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateRessources(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateRessources(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final Ressources transientEntity) {
        Ressources persistent = (Ressources) persistableService.findById(transientEntity.getOid(), Ressources.class);

        applicationContext.publishEvent(new PreUpdateRessources(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateRessources(persistent));
    }


    @Override
    @Transactional
    public Ressources update(UIAttributes uiAttributes, Container container) {
        Ressources transientEntity = (Ressources) uiAttributes.getTarget();
        Ressources persistent = (Ressources) persistableService.findById(transientEntity.getOid(), Ressources.class);

        applicationContext.publishEvent(new PreUpdateRessources(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateRessources(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(Ressources entity, Container container) {
        Ressources persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteRessources(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteRessources(persistent));
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
