package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateDemandeAmbassadeur extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateDemandeAmbassadeur() {
        super();
    }

    public PreUpdateDemandeAmbassadeur(Persistable subject) {
        super(subject);
    }

     public PreUpdateDemandeAmbassadeur(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
