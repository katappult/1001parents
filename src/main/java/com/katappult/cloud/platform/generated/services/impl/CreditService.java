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
import com.katappult.cloud.platform.generated.services.api.ICreditService;
import com.katappult.cloud.platform.generated.dao.api.ICreditDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateCredit;
import com.katappult.cloud.platform.generated.model.event.PreDeleteCredit;
import com.katappult.cloud.platform.generated.model.event.PreUpdateCredit;
import com.katappult.cloud.platform.generated.model.event.PostCreateCredit;
import com.katappult.cloud.platform.generated.model.event.PostDeleteCredit;
import com.katappult.cloud.platform.generated.model.event.PostUpdateCredit;
import java.util.List;
import com.katappult.core.model.account.UserAccount;
// IMPORT

@Component
public class CreditService implements  ICreditService {

    @Autowired
    private ICreditDao dao;

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
    public Credit  create(UIAttributes uiAttributes, Container container) {
        Credit entity = (Credit) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateCredit(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCredit(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final Credit entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateCredit(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateCredit(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final Credit transientEntity) {
        Credit persistent = (Credit) persistableService.findById(transientEntity.getOid(), Credit.class);

        applicationContext.publishEvent(new PreUpdateCredit(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCredit(persistent));
    }


    @Override
    @Transactional
    public Credit update(UIAttributes uiAttributes, Container container) {
        Credit transientEntity = (Credit) uiAttributes.getTarget();
        Credit persistent = (Credit) persistableService.findById(transientEntity.getOid(), Credit.class);

        applicationContext.publishEvent(new PreUpdateCredit(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateCredit(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(Credit entity, Container container) {
        Credit persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteCredit(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteCredit(persistent));
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
    public UserAccount getUserAccount(final Credit entity, final Container container) {
        Credit refreshed = persistableService.refresh(entity);
        return refreshed.getUserAccount();
    }


    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public void setUserAccount(final Credit entity, final UserAccount roleb, final Container container) {
        Credit refreshed = persistableService.refresh(entity);
        UserAccount refreshedToOne = persistableService.refresh(roleb);
        refreshed.setUserAccount(refreshedToOne);

        persistableService.mergeWithoutEvent(refreshed);
    }

    @Override
    @Transactional(propagation =  Propagation.REQUIRED)
    public void removeUserAccount(final Credit entity, final UserAccount roleb, final Container container) {
        Credit refreshed = persistableService.refresh(entity);
        refreshed.setUserAccount(null);
        persistableService.mergeWithoutEvent(refreshed);
    }

    @Override
    public Credit getInverseOneToOneUserAccount(final UserAccount entity, final Container container) {
        QCredit qCredit = new QCredit("entity");
        return persistableDao.from(qCredit).where(qCredit.userAccount().eq(entity)).singleResult(qCredit);
    }

// SERVICES
}
