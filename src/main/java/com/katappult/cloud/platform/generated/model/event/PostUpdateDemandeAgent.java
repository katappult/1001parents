package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateDemandeAgent extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateDemandeAgent() {
        super();
    }

    public PostUpdateDemandeAgent(Persistable subject) {
        super(subject);
    }

    public PostUpdateDemandeAgent(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
