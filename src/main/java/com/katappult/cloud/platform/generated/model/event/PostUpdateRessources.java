package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateRessources extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateRessources() {
        super();
    }

    public PostUpdateRessources(Persistable subject) {
        super(subject);
    }

    public PostUpdateRessources(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
