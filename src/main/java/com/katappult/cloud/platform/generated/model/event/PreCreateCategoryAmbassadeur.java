package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreCreateCategoryAmbassadeur extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreCreateCategoryAmbassadeur() {
        super();
    }

    public PreCreateCategoryAmbassadeur(Persistable subject) {
        super(subject);
    }

    public PreCreateCategoryAmbassadeur(Persistable subject, UIAttributes uiAttributes) {
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
