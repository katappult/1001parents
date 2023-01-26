package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateDemandeAmbassadeur extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateDemandeAmbassadeur() {
        super();
    }

    public PostUpdateDemandeAmbassadeur(Persistable subject) {
        super(subject);
    }

    public PostUpdateDemandeAmbassadeur(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
