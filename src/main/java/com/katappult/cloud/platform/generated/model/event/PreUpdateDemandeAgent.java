package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateDemandeAgent extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateDemandeAgent() {
        super();
    }

    public PreUpdateDemandeAgent(Persistable subject) {
        super(subject);
    }

     public PreUpdateDemandeAgent(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
