package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;

import java.util.*;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

//IMPORT

@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWebinarToCategoryLink extends EntityPathBase<WebinarToCategoryLink> {

    private static final long serialVersionUID = -1888300761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebinarToCategoryLink webinarLink = new QWebinarToCategoryLink("webinarLink");

    public final com.katappult.core.model.persistable.QPersistable _super;

    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    protected QWebinarToCategoryLinkId id;

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;

    protected QWebinar roleA;

    protected QCategory roleB;

    //inherited
    public final NumberPath<Long> version;

    public QWebinarToCategoryLink(String variable) {
        this(WebinarToCategoryLink.class, forVariable(variable), INITS);
    }

    public QWebinarToCategoryLink(Path<? extends WebinarToCategoryLink> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebinarToCategoryLink(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebinarToCategoryLink(PathMetadata<?> metadata, PathInits inits) {
        this(WebinarToCategoryLink.class, metadata, inits);
    }

    public QWebinarToCategoryLink(Class<? extends WebinarToCategoryLink> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.katappult.core.model.persistable.QPersistable(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QWebinarToCategoryLinkId(forProperty("id")) : null;
        this.roleA = inits.isInitialized("roleA") ? new QWebinar(forProperty("roleA"), inits.get("roleA")) : null;
        this.roleB = inits.isInitialized("roleB") ? new QCategory(forProperty("roleB"), inits.get("roleB")) : null;
        this.version = _super.version;
    }

    public QWebinarToCategoryLinkId id() {
        if (id == null) {
            id = new QWebinarToCategoryLinkId(forProperty("id"));
        }
        return id;
    }

    public com.katappult.core.model.composite.QContainerInfo containerInfo() {
        if (containerInfo == null) {
            containerInfo = new com.katappult.core.model.composite.QContainerInfo(forProperty("containerInfo"));
        }
        return containerInfo;
    }

    public com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo() {
        if (persistenceInfo == null) {
            persistenceInfo = new com.katappult.core.model.persistable.QPersistenceInfo(forProperty("persistenceInfo"));
        }
        return persistenceInfo;
    }

    public QWebinar roleA() {
        if (roleA == null) {
            roleA = new QWebinar(forProperty("roleA"));
        }
        return roleA;
    }

    public QCategory roleB() {
        if (roleB == null) {
            roleB = new QCategory(forProperty("roleB"));
        }
        return roleB;
    }
}
