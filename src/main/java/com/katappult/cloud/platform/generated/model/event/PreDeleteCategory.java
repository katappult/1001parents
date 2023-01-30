package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;

public class PreDeleteCategory extends KatappultEvent {

    public PreDeleteCategory() {
            super();
    }

    public PreDeleteCategory(Persistable subject) {
        super(subject);
    }
}
