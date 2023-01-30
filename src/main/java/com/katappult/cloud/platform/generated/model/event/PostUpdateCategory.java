package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateCategory extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateCategory() {
        super();
    }

    public PostUpdateCategory(Persistable subject) {
        super(subject);
    }

    public PostUpdateCategory(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
