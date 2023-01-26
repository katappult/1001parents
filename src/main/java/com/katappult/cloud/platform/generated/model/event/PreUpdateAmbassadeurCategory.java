package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateAmbassadeurCategory extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateAmbassadeurCategory() {
        super();
    }

    public PreUpdateAmbassadeurCategory(Persistable subject) {
        super(subject);
    }

     public PreUpdateAmbassadeurCategory(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
