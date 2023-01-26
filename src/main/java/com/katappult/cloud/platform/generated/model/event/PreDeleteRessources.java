package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;

public class PreDeleteRessources extends KatappultEvent {

    public PreDeleteRessources() {
            super();
    }

    public PreDeleteRessources(Persistable subject) {
        super(subject);
    }
}
