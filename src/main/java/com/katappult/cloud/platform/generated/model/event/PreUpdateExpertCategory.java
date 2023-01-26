package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateExpertCategory extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateExpertCategory() {
        super();
    }

    public PreUpdateExpertCategory(Persistable subject) {
        super(subject);
    }

     public PreUpdateExpertCategory(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
