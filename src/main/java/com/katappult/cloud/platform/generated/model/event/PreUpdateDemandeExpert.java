package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateDemandeExpert extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateDemandeExpert() {
        super();
    }

    public PreUpdateDemandeExpert(Persistable subject) {
        super(subject);
    }

     public PreUpdateDemandeExpert(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
