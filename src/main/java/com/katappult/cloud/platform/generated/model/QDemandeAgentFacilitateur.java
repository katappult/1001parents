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
 * QDemandeAgentFacilitateur is a Querydsl query type for DemandeAgentFacilitateur
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDemandeAgentFacilitateur extends EntityPathBase<DemandeAgentFacilitateur> {

    private static final long serialVersionUID = -118259594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDemandeAgentFacilitateur demandeAgentFacilitateur = new QDemandeAgentFacilitateur("demandeAgentFacilitateur");

    public final com.katappult.core.model.persistable.QBusinessObject _super;

    // inherited
    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;


    //inherited
    public final NumberPath<Long> version;

     public final com.mysema.query.types.path.StringPath titre = createString("titre");
 public final com.mysema.query.types.path.StringPath theme = createString("theme");
 public final com.mysema.query.types.path.StringPath description = createString("description");
 public final com.mysema.query.types.path.DatePath<java.util.Date> datePlanification = createDate("datePlanification", java.util.Date.class);
// ATTRIBUTES

    public QDemandeAgentFacilitateur(String variable) {
        this(DemandeAgentFacilitateur.class, forVariable(variable), INITS);

        // CONSTRUCTOR
    }

    public QDemandeAgentFacilitateur(Path<? extends DemandeAgentFacilitateur> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDemandeAgentFacilitateur(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDemandeAgentFacilitateur(PathMetadata<?> metadata, PathInits inits) {
        this(DemandeAgentFacilitateur.class, metadata, inits);
    }

    public QDemandeAgentFacilitateur(Class<? extends DemandeAgentFacilitateur> type, PathMetadata<?> metadata, PathInits inits) {
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

