package com.katappult.cloud.platform.generated.rules;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.rules.api.IVetoableBusinessRule;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.core.model.account.UserAccount;
import com.katappult.cloud.platform.generated.model.event.PreDeleteWebinar;
import com.katappult.cloud.platform.generated.services.api.IWebinarToUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//IMPORT

@Component("WebinarToUserAccountDeleteRule")
public class WebinarToUserAccountDeleteRule implements IVetoableBusinessRule {

    @Autowired
    private IWebinarToUserAccountService service;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void apply(KatappultEvent event) {
        PreDeleteWebinar preDeleteRoleAEvent = (PreDeleteWebinar) event;
        Webinar roleA = (Webinar) preDeleteRoleAEvent.getSubject();
        service.removeAllRoleBs(roleA, event.getContainer());
    }

}