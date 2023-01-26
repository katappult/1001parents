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
import com.katappult.cloud.platform.generated.services.api.IDemandeAgentFacilitateurService;
import com.katappult.cloud.platform.generated.dao.api.IDemandeAgentFacilitateurDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateDemandeAgentFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PreDeleteDemandeAgentFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PreUpdateDemandeAgentFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PostCreateDemandeAgentFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PostDeleteDemandeAgentFacilitateur;
import com.katappult.cloud.platform.generated.model.event.PostUpdateDemandeAgentFacilitateur;
import java.util.List;
// IMPORT

@Component
public class DemandeAgentFacilitateurService implements  IDemandeAgentFacilitateurService {

    @Autowired
    private IDemandeAgentFacilitateurDao dao;

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
    public DemandeAgentFacilitateur  create(UIAttributes uiAttributes, Container container) {
        DemandeAgentFacilitateur entity = (DemandeAgentFacilitateur) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateDemandeAgentFacilitateur(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeAgentFacilitateur(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final DemandeAgentFacilitateur entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateDemandeAgentFacilitateur(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeAgentFacilitateur(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final DemandeAgentFacilitateur transientEntity) {
        DemandeAgentFacilitateur persistent = (DemandeAgentFacilitateur) persistableService.findById(transientEntity.getOid(), DemandeAgentFacilitateur.class);

        applicationContext.publishEvent(new PreUpdateDemandeAgentFacilitateur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeAgentFacilitateur(persistent));
    }


    @Override
    @Transactional
    public DemandeAgentFacilitateur update(UIAttributes uiAttributes, Container container) {
        DemandeAgentFacilitateur transientEntity = (DemandeAgentFacilitateur) uiAttributes.getTarget();
        DemandeAgentFacilitateur persistent = (DemandeAgentFacilitateur) persistableService.findById(transientEntity.getOid(), DemandeAgentFacilitateur.class);

        applicationContext.publishEvent(new PreUpdateDemandeAgentFacilitateur(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeAgentFacilitateur(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(DemandeAgentFacilitateur entity, Container container) {
        DemandeAgentFacilitateur persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteDemandeAgentFacilitateur(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteDemandeAgentFacilitateur(persistent));
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
