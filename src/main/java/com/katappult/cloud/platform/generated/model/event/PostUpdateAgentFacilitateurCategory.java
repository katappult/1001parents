package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateAgentFacilitateurCategory extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateAgentFacilitateurCategory() {
        super();
    }

    public PostUpdateAgentFacilitateurCategory(Persistable subject) {
        super(subject);
    }

    public PostUpdateAgentFacilitateurCategory(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
