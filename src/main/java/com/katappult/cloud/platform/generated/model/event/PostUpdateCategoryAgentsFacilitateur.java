package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateCategoryAgentsFacilitateur extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateCategoryAgentsFacilitateur() {
        super();
    }

    public PostUpdateCategoryAgentsFacilitateur(Persistable subject) {
        super(subject);
    }

    public PostUpdateCategoryAgentsFacilitateur(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
