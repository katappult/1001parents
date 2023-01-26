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
import com.katappult.cloud.platform.generated.services.api.IAgentFacilitateurCategoryService;
import com.katappult.cloud.platform.generated.dao.api.IAgentFacilitateurCategoryDao;
import com.katappult.cloud.platform.generated.model.event.PreCreateAgentFacilitateurCategory;
import com.katappult.cloud.platform.generated.model.event.PreDeleteAgentFacilitateurCategory;
import com.katappult.cloud.platform.generated.model.event.PreUpdateAgentFacilitateurCategory;
import com.katappult.cloud.platform.generated.model.event.PostCreateAgentFacilitateurCategory;
import com.katappult.cloud.platform.generated.model.event.PostDeleteAgentFacilitateurCategory;
import com.katappult.cloud.platform.generated.model.event.PostUpdateAgentFacilitateurCategory;
import java.util.List;
// IMPORT

@Component
public class AgentFacilitateurCategoryService implements  IAgentFacilitateurCategoryService {

    @Autowired
    private IAgentFacilitateurCategoryDao dao;

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
    public AgentFacilitateurCategory  create(UIAttributes uiAttributes, Container container) {
        AgentFacilitateurCategory entity = (AgentFacilitateurCategory) uiAttributes.getTarget();
        containedService.setContainer(entity, container);

        String businessType = uiAttributes.getAllAttributesFromUI().optString("businessType");
        if(StringUtils.isNotBlank(businessType) && entity instanceof ITypeManaged){
            typeManagedService.setType((ITypeManaged) entity, businessType);
        }

        applicationContext.publishEvent(new PreCreateAgentFacilitateurCategory(entity, uiAttributes));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateAgentFacilitateurCategory(entity, uiAttributes));
        return entity;
    }

    @Override
    @Transactional
    public void batchCreateFromImport(final AgentFacilitateurCategory entity, final Container container) {
        containedService.setContainer(entity, container);

        applicationContext.publishEvent(new PreCreateAgentFacilitateurCategory(entity));
        persistableService.saveWithoutEvent(entity);
        applicationContext.publishEvent(new PostCreateAgentFacilitateurCategory(entity));
    }

    @Override
    @Transactional
    public void batchUpdateFromImport(final AgentFacilitateurCategory transientEntity) {
        AgentFacilitateurCategory persistent = (AgentFacilitateurCategory) persistableService.findById(transientEntity.getOid(), AgentFacilitateurCategory.class);

        applicationContext.publishEvent(new PreUpdateAgentFacilitateurCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateAgentFacilitateurCategory(persistent));
    }


    @Override
    @Transactional
    public AgentFacilitateurCategory update(UIAttributes uiAttributes, Container container) {
        AgentFacilitateurCategory transientEntity = (AgentFacilitateurCategory) uiAttributes.getTarget();
        AgentFacilitateurCategory persistent = (AgentFacilitateurCategory) persistableService.findById(transientEntity.getOid(), AgentFacilitateurCategory.class);

        applicationContext.publishEvent(new PreUpdateAgentFacilitateurCategory(persistent));
        persistent.updateFrom(transientEntity);
        persistableService.mergeWithoutEvent(persistent);
        applicationContext.publishEvent(new PostUpdateAgentFacilitateurCategory(persistent));

        return persistent;
    }

    @Override
    @Transactional
    public void delete(AgentFacilitateurCategory entity, Container container) {
        AgentFacilitateurCategory persistent  = persistableService.refresh(entity);
        applicationContext.publishEvent(new PreDeleteAgentFacilitateurCategory(persistent));
        persistableService.deleteWithoutEvent(persistent);
        applicationContext.publishEvent(new PostDeleteAgentFacilitateurCategory(persistent));
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
