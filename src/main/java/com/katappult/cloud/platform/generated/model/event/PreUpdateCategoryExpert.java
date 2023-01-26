package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateCategoryExpert extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateCategoryExpert() {
        super();
    }

    public PreUpdateCategoryExpert(Persistable subject) {
        super(subject);
    }

     public PreUpdateCategoryExpert(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
