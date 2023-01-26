package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateCredit extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateCredit() {
        super();
    }

    public PostUpdateCredit(Persistable subject) {
        super(subject);
    }

    public PostUpdateCredit(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
