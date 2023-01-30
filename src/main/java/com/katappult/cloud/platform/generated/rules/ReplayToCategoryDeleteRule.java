package com.katappult.cloud.platform.generated.rules;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.rules.api.IVetoableBusinessRule;
import com.katappult.cloud.platform.generated.model.Replay;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.event.PreDeleteReplay;
import com.katappult.cloud.platform.generated.services.api.IReplayToCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//IMPORT

@Component("ReplayToCategoryDeleteRule")
public class ReplayToCategoryDeleteRule implements IVetoableBusinessRule {

    @Autowired
    private IReplayToCategoryService service;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void apply(KatappultEvent event) {
        PreDeleteReplay preDeleteRoleAEvent = (PreDeleteReplay) event;
        Replay roleA = (Replay) preDeleteRoleAEvent.getSubject();
        service.removeAllRoleBs(roleA, event.getContainer());
    }

}