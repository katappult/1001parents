package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PreCreateAmbassadeurCategory extends KatappultEvent {

    private UIAttributes uiAttributes;

    public PreCreateAmbassadeurCategory() {
        super();
    }

    public PreCreateAmbassadeurCategory(Persistable subject) {
        super(subject);
    }

    public PreCreateAmbassadeurCategory(Persistable subject, UIAttributes uiAttributes) {
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
