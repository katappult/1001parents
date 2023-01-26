package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateCategoryExpert extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateCategoryExpert() {
        super();
    }

    public PostUpdateCategoryExpert(Persistable subject) {
        super(subject);
    }

    public PostUpdateCategoryExpert(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
