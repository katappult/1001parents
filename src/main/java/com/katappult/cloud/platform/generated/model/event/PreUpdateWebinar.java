package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateWebinar extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateWebinar() {
        super();
    }

    public PreUpdateWebinar(Persistable subject) {
        super(subject);
    }

     public PreUpdateWebinar(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
