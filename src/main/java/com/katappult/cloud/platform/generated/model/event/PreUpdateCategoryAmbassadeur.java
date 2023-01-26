package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreUpdateCategoryAmbassadeur extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreUpdateCategoryAmbassadeur() {
        super();
    }

    public PreUpdateCategoryAmbassadeur(Persistable subject) {
        super(subject);
    }

     public PreUpdateCategoryAmbassadeur(Persistable subject, UIAttributes uiAttributes) {
            super(subject);
            this.uiAttributes = uiAttributes;
            setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
        }
}
