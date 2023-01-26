package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateReplay extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateReplay() {
        super();
    }

    public PostUpdateReplay(Persistable subject) {
        super(subject);
    }

    public PostUpdateReplay(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
