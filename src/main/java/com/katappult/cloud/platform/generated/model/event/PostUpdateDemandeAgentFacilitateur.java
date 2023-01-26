package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateDemandeAgentFacilitateur extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateDemandeAgentFacilitateur() {
        super();
    }

    public PostUpdateDemandeAgentFacilitateur(Persistable subject) {
        super(subject);
    }

    public PostUpdateDemandeAgentFacilitateur(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
