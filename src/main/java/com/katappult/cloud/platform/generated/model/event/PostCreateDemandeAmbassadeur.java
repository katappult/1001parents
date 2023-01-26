package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostCreateDemandeAmbassadeur extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PostCreateDemandeAmbassadeur() {
        super();
    }

    public PostCreateDemandeAmbassadeur(Persistable subject) {
        super(subject);
    }

    public PostCreateDemandeAmbassadeur(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }

    public UIAttributes getUiAttributes() {
        return uiAttributes;
    }

    public void setUiAttributes(final UIAttributes uiAttributes) {
        this.uiAttributes = uiAttributes;
    }
}
