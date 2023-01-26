package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateAmbassadeurCategory extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateAmbassadeurCategory() {
        super();
    }

    public PostUpdateAmbassadeurCategory(Persistable subject) {
        super(subject);
    }

    public PostUpdateAmbassadeurCategory(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
