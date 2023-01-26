package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateRessources extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateRessources() {
        super();
    }

    public PreUpdateRessources(Persistable subject) {
        super(subject);
    }

     public PreUpdateRessources(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
