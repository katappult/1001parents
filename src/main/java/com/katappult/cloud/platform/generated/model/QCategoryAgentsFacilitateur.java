package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;
import com.mysema.query.types.path.StringPath;

// IMPORT
import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QCategoryAgentsFacilitateur is a Querydsl query type for CategoryAgentsFacilitateur
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCategoryAgentsFacilitateur extends EntityPathBase<CategoryAgentsFacilitateur> {

    private static final long serialVersionUID = -118259594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoryAgentsFacilitateur categoryAgentsFacilitateur = new QCategoryAgentsFacilitateur("categoryAgentsFacilitateur");

    public final com.katappult.core.model.persistable.QBusinessObject _super;

    // inherited
    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;


    //inherited
    public final NumberPath<Long> version;

     public final com.mysema.query.types.path.StringPath nom = createString("nom");
 public final com.mysema.query.types.path.StringPath description = createString("description");
public final StringPath number = createString("number");
// ATTRIBUTES

    public QCategoryAgentsFacilitateur(String variable) {
        this(CategoryAgentsFacilitateur.class, forVariable(variable), INITS);

        // CONSTRUCTOR
    }

    public QCategoryAgentsFacilitateur(Path<? extends CategoryAgentsFacilitateur> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCategoryAgentsFacilitateur(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCategoryAgentsFacilitateur(PathMetadata<?> metadata, PathInits inits) {
        this(CategoryAgentsFacilitateur.class, metadata, inits);
    }

    public QCategoryAgentsFacilitateur(Class<? extends CategoryAgentsFacilitateur> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.katappult.core.model.persistable.QBusinessObject(type, metadata, inits);
        this.version = _super.version;
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

    // METHODS
}

