package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateDemandeAgentFacilitateur extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateDemandeAgentFacilitateur() {
        super();
    }

    public PreUpdateDemandeAgentFacilitateur(Persistable subject) {
        super(subject);
    }

     public PreUpdateDemandeAgentFacilitateur(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
