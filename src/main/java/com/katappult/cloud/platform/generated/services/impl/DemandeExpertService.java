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
import com.katappult.cloud.platform.generated.services.api.IDemandeExpertService;
import com.katappult.cloud.platform.generated.dao.api.IDemandeExpertDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateDemandeExpert;
import com.katappult.cloud.platform.generated.model.event.PreDeleteDemandeExpert;
import com.katappult.cloud.platform.generated.model.event.PreUpdateDemandeExpert;
import com.katappult.cloud.platform.generated.model.event.PostCreateDemandeExpert;
import com.katappult.cloud.platform.generated.model.event.PostDeleteDemandeExpert;
import com.katappult.cloud.platform.generated.model.event.PostUpdateDemandeExpert;
import java.util.List;
import com.katappult.core.model.account.UserAccount;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
// IMPORT

@Component
public class DemandeExpertService implements  IDemandeExpertService {

    @Autowired
    private IDemandeExpertDao dao;

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
    public DemandeExpert  create(UIAttributes uiAttributes, Container container) {
        DemandeExpert entity = (DemandeExpert) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateDemandeExpert(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeExpert(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final DemandeExpert entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateDemandeExpert(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateDemandeExpert(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final DemandeExpert transientEntity) {
        DemandeExpert persistent = (DemandeExpert) persistableService.findById(transientEntity.getOid(), DemandeExpert.class);

        applicationContext.publishEvent(new PreUpdateDemandeExpert(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeExpert(persistent));
    }


    @Override
    @Transactional
    public DemandeExpert update(UIAttributes uiAttributes, Container container) {
        DemandeExpert transientEntity = (DemandeExpert) uiAttributes.getTarget();
        DemandeExpert persistent = (DemandeExpert) persistableService.findById(transientEntity.getOid(), DemandeExpert.class);

        applicationContext.publishEvent(new PreUpdateDemandeExpert(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateDemandeExpert(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(DemandeExpert entity, Container container) {
        DemandeExpert persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteDemandeExpert(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteDemandeExpert(persistent));
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
    public UserAccount getUserAccount(final DemandeExpert entity, final Container container) {
        DemandeExpert refreshed = persistableService.refresh(entity);
        return refreshed.getUserAccount();
    }


    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public void setUserAccount(final DemandeExpert entity, final UserAccount roleb, final Container container) {
        DemandeExpert refreshed = persistableService.refresh(entity);
        UserAccount refreshedToOne = persistableService.refresh(roleb);
        refreshed.setUserAccount(refreshedToOne);

        persistableService.mergeWithoutEvent(refreshed);
    }

    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public void removeUserAccount(final DemandeExpert entity, final UserAccount roleb, final Container container) {
        DemandeExpert refreshed = persistableService.refresh(entity);
        refreshed.setUserAccount(null);
        persistableService.mergeWithoutEvent(refreshed);
    }

    @Override
    public DemandeExpert getInverseOneToOneUserAccount(final UserAccount entity, final Container container) {
        QDemandeExpert qDemandeExpert = new QDemandeExpert("entity");
        return persistableDao.from(qDemandeExpert).where(qDemandeExpert.userAccount().eq(entity)).singleResult(qDemandeExpert);
    }




    @Override
    public PageResult searchCategoryEntity(final DemandeExpert roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {
        return dao.searchCategoryEntity(roleA, searchTerm, pageRequest, container);
    }

// SERVICES
}
