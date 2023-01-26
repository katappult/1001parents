package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateAgentFacilitateurCategory extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateAgentFacilitateurCategory() {
        super();
    }

    public PreUpdateAgentFacilitateurCategory(Persistable subject) {
        super(subject);
    }

     public PreUpdateAgentFacilitateurCategory(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
