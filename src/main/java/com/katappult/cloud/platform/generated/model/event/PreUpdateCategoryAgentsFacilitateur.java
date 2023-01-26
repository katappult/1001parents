package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateCategoryAgentsFacilitateur extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateCategoryAgentsFacilitateur() {
        super();
    }

    public PreUpdateCategoryAgentsFacilitateur(Persistable subject) {
        super(subject);
    }

     public PreUpdateCategoryAgentsFacilitateur(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
