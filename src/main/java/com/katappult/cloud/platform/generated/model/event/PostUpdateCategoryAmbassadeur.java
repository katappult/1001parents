package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttributes;

public class PostUpdateCategoryAmbassadeur extends KatappultEvent {

   private UIAttributes uiAttributes;

    public PostUpdateCategoryAmbassadeur() {
        super();
    }

    public PostUpdateCategoryAmbassadeur(Persistable subject) {
        super(subject);
    }

    public PostUpdateCategoryAmbassadeur(Persistable subject, UIAttributes uiAttributes) {
        super(subject);
        this.uiAttributes = uiAttributes;
        setAdditionnalAtributes(uiAttributes.getAllAttributesFromUI());
    }
}
