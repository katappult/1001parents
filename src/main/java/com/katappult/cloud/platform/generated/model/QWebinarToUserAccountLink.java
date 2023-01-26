package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;

import java.util.*;
import com.katappult.core.model.account.UserAccount;
import com.katappult.core.model.account.QUserAccount;
import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

//IMPORT

@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWebinarToUserAccountLink extends EntityPathBase<WebinarToUserAccountLink> {

    private static final long serialVersionUID = -1888300761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebinarToUserAccountLink webinarLink = new QWebinarToUserAccountLink("webinarLink");

    public final com.katappult.core.model.persistable.QPersistable _super;

    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    protected QWebinarToUserAccountLinkId id;

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;

    protected QWebinar roleA;

    protected QUserAccount roleB;

    //inherited
    public final NumberPath<Long> version;

    public QWebinarToUserAccountLink(String variable) {
        this(WebinarToUserAccountLink.class, forVariable(variable), INITS);
    }

    public QWebinarToUserAccountLink(Path<? extends WebinarToUserAccountLink> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebinarToUserAccountLink(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebinarToUserAccountLink(PathMetadata<?> metadata, PathInits inits) {
        this(WebinarToUserAccountLink.class, metadata, inits);
    }

    public QWebinarToUserAccountLink(Class<? extends WebinarToUserAccountLink> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.katappult.core.model.persistable.QPersistable(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QWebinarToUserAccountLinkId(forProperty("id")) : null;
        this.roleA = inits.isInitialized("roleA") ? new QWebinar(forProperty("roleA"), inits.get("roleA")) : null;
        this.roleB = inits.isInitialized("roleB") ? new QUserAccount(forProperty("roleB"), inits.get("roleB")) : null;
        this.version = _super.version;
    }

    public QWebinarToUserAccountLinkId id() {
        if (id == null) {
            id = new QWebinarToUserAccountLinkId(forProperty("id"));
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

    public QUserAccount roleB() {
        if (roleB == null) {
            roleB = new QUserAccount(forProperty("roleB"));
        }
        return roleB;
    }
}
