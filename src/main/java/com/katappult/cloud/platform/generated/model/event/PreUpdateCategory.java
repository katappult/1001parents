package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateCategory extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateCategory() {
        super();
    }

    public PreUpdateCategory(Persistable subject) {
        super(subject);
    }

     public PreUpdateCategory(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
