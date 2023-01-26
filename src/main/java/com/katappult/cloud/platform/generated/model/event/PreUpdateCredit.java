package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateCredit extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateCredit() {
        super();
    }

    public PreUpdateCredit(Persistable subject) {
        super(subject);
    }

     public PreUpdateCredit(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
