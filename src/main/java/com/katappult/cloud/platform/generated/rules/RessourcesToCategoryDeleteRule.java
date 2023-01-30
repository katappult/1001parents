package com.katappult.cloud.platform.generated.rules;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.rules.api.IVetoableBusinessRule;
import com.katappult.cloud.platform.generated.model.Ressources;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.event.PreDeleteRessources;
import com.katappult.cloud.platform.generated.services.api.IRessourcesToCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//IMPORT

@Component("RessourcesToCategoryDeleteRule")
public class RessourcesToCategoryDeleteRule implements IVetoableBusinessRule {

    @Autowired
    private IRessourcesToCategoryService service;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void apply(KatappultEvent event) {
        PreDeleteRessources preDeleteRoleAEvent = (PreDeleteRessources) event;
        Ressources roleA = (Ressources) preDeleteRoleAEvent.getSubject();
        service.removeAllRoleBs(roleA, event.getContainer());
    }

}