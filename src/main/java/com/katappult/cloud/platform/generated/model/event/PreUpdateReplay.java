package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateReplay extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateReplay() {
        super();
    }

    public PreUpdateReplay(Persistable subject) {
        super(subject);
    }

     public PreUpdateReplay(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
