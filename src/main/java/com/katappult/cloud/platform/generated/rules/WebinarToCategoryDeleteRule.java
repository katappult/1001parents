package com.katappult.cloud.platform.generated.rules;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.rules.api.IVetoableBusinessRule;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.event.PreDeleteWebinar;
import com.katappult.cloud.platform.generated.services.api.IWebinarToCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//IMPORT

@Component("WebinarToCategoryDeleteRule")
public class WebinarToCategoryDeleteRule implements IVetoableBusinessRule {

    @Autowired
    private IWebinarToCategoryService service;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void apply(KatappultEvent event) {
        PreDeleteWebinar preDeleteRoleAEvent = (PreDeleteWebinar) event;
        Webinar roleA = (Webinar) preDeleteRoleAEvent.getSubject();
        service.removeAllRoleBs(roleA, event.getContainer());
    }

}