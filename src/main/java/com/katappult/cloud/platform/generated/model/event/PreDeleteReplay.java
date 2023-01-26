package com.katappult.cloud.platform.generated.model.event;

import com.katappult.core.model.KatappultEvent;
import com.katappult.core.model.persistable.Persistable;

public class PreDeleteReplay extends KatappultEvent {

    public PreDeleteReplay() {
            super();
    }

    public PreDeleteReplay(Persistable subject) {
        super(subject);
    }
}
