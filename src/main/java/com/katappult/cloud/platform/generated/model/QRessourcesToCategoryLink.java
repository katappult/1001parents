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
public class QRessourcesToCategoryLink extends EntityPathBase<RessourcesToCategoryLink> {

    private static final long serialVersionUID = -1888300761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRessourcesToCategoryLink ressourcesLink = new QRessourcesToCategoryLink("ressourcesLink");

    public final com.katappult.core.model.persistable.QPersistable _super;

    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    protected QRessourcesToCategoryLinkId id;

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;

    protected QRessources roleA;

    protected QCategory roleB;

    //inherited
    public final NumberPath<Long> version;

    public QRessourcesToCategoryLink(String variable) {
        this(RessourcesToCategoryLink.class, forVariable(variable), INITS);
    }

    public QRessourcesToCategoryLink(Path<? extends RessourcesToCategoryLink> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRessourcesToCategoryLink(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRessourcesToCategoryLink(PathMetadata<?> metadata, PathInits inits) {
        this(RessourcesToCategoryLink.class, metadata, inits);
    }

    public QRessourcesToCategoryLink(Class<? extends RessourcesToCategoryLink> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.katappult.core.model.persistable.QPersistable(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QRessourcesToCategoryLinkId(forProperty("id")) : null;
        this.roleA = inits.isInitialized("roleA") ? new QRessources(forProperty("roleA"), inits.get("roleA")) : null;
        this.roleB = inits.isInitialized("roleB") ? new QCategory(forProperty("roleB"), inits.get("roleB")) : null;
        this.version = _super.version;
    }

    public QRessourcesToCategoryLinkId id() {
        if (id == null) {
            id = new QRessourcesToCategoryLinkId(forProperty("id"));
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

    public QRessources roleA() {
        if (roleA == null) {
            roleA = new QRessources(forProperty("roleA"));
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
