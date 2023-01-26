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
import com.katappult.cloud.platform.generated.services.api.IDemandeAmbassadeurService;
import com.katappult.cloud.platform.generated.dao.api.IDemandeAmbassadeurDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateDemandeAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PreDeleteDemandeAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PreUpdateDemandeAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PostCreateDemandeAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PostDeleteDemandeAmbassadeur;
import com.katappult.cloud.platform.generated.model.event.PostUpdateDemandeAmbassadeur;
import java.util.List;
// IMPORT

@Component
public class DemandeAmbassadeurService implements  IDemandeAmbassadeurService {

    @Autowired
    private IDemandeAmbassadeurDao dao;

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
    public DemandeAmbassadeur  create(UIAttributes uiAttributes, Container container) {
        DemandeAmbassadeur entity = (DemandeAmbassadeur) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateDemandeAmbassadeur(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeAmbassadeur(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final DemandeAmbassadeur entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateDemandeAmbassadeur(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeAmbassadeur(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final DemandeAmbassadeur transientEntity) {
        DemandeAmbassadeur persistent = (DemandeAmbassadeur) persistableService.findById(transientEntity.getOid(), DemandeAmbassadeur.class);

        applicationContext.publishEvent(new PreUpdateDemandeAmbassadeur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeAmbassadeur(persistent));
    }


    @Override
    @Transactional
    public DemandeAmbassadeur update(UIAttributes uiAttributes, Container container) {
        DemandeAmbassadeur transientEntity = (DemandeAmbassadeur) uiAttributes.getTarget();
        DemandeAmbassadeur persistent = (DemandeAmbassadeur) persistableService.findById(transientEntity.getOid(), DemandeAmbassadeur.class);

        applicationContext.publishEvent(new PreUpdateDemandeAmbassadeur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeAmbassadeur(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(DemandeAmbassadeur entity, Container container) {
        DemandeAmbassadeur persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteDemandeAmbassadeur(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteDemandeAmbassadeur(persistent));
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
