package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateDemandeExpert extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateDemandeExpert() {
        super();
    }

    public PostUpdateDemandeExpert(Persistable subject) {
        super(subject);
    }

    public PostUpdateDemandeExpert(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
