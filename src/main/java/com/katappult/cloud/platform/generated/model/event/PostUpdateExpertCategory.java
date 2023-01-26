package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateExpertCategory extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateExpertCategory() {
        super();
    }

    public PostUpdateExpertCategory(Persistable subject) {
        super(subject);
    }

    public PostUpdateExpertCategory(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
