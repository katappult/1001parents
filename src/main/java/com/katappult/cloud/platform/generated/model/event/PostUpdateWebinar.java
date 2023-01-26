package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateWebinar extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateWebinar() {
        super();
    }

    public PostUpdateWebinar(Persistable subject) {
        super(subject);
    }

    public PostUpdateWebinar(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
