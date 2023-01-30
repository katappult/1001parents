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
import com.katappult.cloud.platform.generated.services.api.IDemandeAgentService;
import com.katappult.cloud.platform.generated.dao.api.IDemandeAgentDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateDemandeAgent;
import com.katappult.cloud.platform.generated.model.event.PreDeleteDemandeAgent;
import com.katappult.cloud.platform.generated.model.event.PreUpdateDemandeAgent;
import com.katappult.cloud.platform.generated.model.event.PostCreateDemandeAgent;
import com.katappult.cloud.platform.generated.model.event.PostDeleteDemandeAgent;
import com.katappult.cloud.platform.generated.model.event.PostUpdateDemandeAgent;
import java.util.List;
import com.katappult.core.model.account.UserAccount;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
// IMPORT

@Component
public class DemandeAgentService implements  IDemandeAgentService {

    @Autowired
    private IDemandeAgentDao dao;

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
    public DemandeAgent  create(UIAttributes uiAttributes, Container container) {
        DemandeAgent entity = (DemandeAgent) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateDemandeAgent(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeAgent(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final DemandeAgent entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateDemandeAgent(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeAgent(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final DemandeAgent transientEntity) {
        DemandeAgent persistent = (DemandeAgent) persistableService.findById(transientEntity.getOid(), DemandeAgent.class);

        applicationContext.publishEvent(new PreUpdateDemandeAgent(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeAgent(persistent));
    }


    @Override
    @Transactional
    public DemandeAgent update(UIAttributes uiAttributes, Container container) {
        DemandeAgent transientEntity = (DemandeAgent) uiAttributes.getTarget();
        DemandeAgent persistent = (DemandeAgent) persistableService.findById(transientEntity.getOid(), DemandeAgent.class);

        applicationContext.publishEvent(new PreUpdateDemandeAgent(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeAgent(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(DemandeAgent entity, Container container) {
        DemandeAgent persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteDemandeAgent(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteDemandeAgent(persistent));
    }

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        return dao.list(pageRequest, container, params);
    }

    @Override
    public PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container) {
        return dao.searchByNamelike(searchTerm, pageRequest, container);
    }

    
    @Override
    public UserAccount getUserAccount(final DemandeAgent entity, final Container container) {
        DemandeAgent refreshed = persistableService.refresh(entity);
        return refreshed.getUserAccount();
    }


    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public void setUserAccount(final DemandeAgent entity, final UserAccount roleb, final Container container) {
        DemandeAgent refreshed = persistableService.refresh(entity);
        UserAccount refreshedToOne = persistableService.refresh(roleb);
        refreshed.setUserAccount(refreshedToOne);

        persistableService.mergeWithoutEvent(refreshed);
    }

    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public void removeUserAccount(final DemandeAgent entity, final UserAccount roleb, final Container container) {
        DemandeAgent refreshed = persistableService.refresh(entity);
        refreshed.setUserAccount(null);
        persistableService.mergeWithoutEvent(refreshed);
    }

    @Override
    public DemandeAgent getInverseOneToOneUserAccount(final UserAccount entity, final Container container) {
        QDemandeAgent qDemandeAgent = new QDemandeAgent("entity");
        return persistableDao.from(qDemandeAgent).where(qDemandeAgent.userAccount().eq(entity)).singleResult(qDemandeAgent);
    }




    @Override
    public PageResult searchCategoryEntity(final DemandeAgent roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {
        return dao.searchCategoryEntity(roleA, searchTerm, pageRequest, container);
    }

// SERVICES
}
