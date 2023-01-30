package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;
import com.mysema.query.types.path.StringPath;

import com.katappult.core.model.account.QUserAccount;
// IMPORT
import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QDemandeAgent is a Querydsl query type for DemandeAgent
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDemandeAgent extends EntityPathBase<DemandeAgent> {

    private static final long serialVersionUID = -118259594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDemandeAgent demandeAgent = new QDemandeAgent("demandeAgent");

    public final com.katappult.core.model.persistable.QBusinessObject _super;

    // inherited
    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;


    //inherited
    public final NumberPath<Long> version;

     public final StringPath titre = createString("titre");
 public final StringPath description = createString("description");
 public final com.mysema.query.types.path.DatePath<java.util.Date> planificationDate = createDate("planificationDate", java.util.Date.class);
protected com.katappult.core.model.typed.QTypeInfo typeInfo;
	protected com.katappult.core.model.lifecyclemanaged.QLifecycleInfo lifecycleInfo;
    protected QCategory category;


protected QUserAccount userAccount;
// ATTRIBUTES

    public QDemandeAgent(String variable) {
        this(DemandeAgent.class, forVariable(variable), INITS);

        this.typeInfo = INITS.isInitialized("typeInfo") ? new com.katappult.core.model.typed.QTypeInfo(forProperty("typeInfo"), INITS.get("typeInfo")) : null;
	this.lifecycleInfo = INITS.isInitialized("lifecycleInfo") ? new com.katappult.core.model.lifecyclemanaged.QLifecycleInfo(forProperty("lifecycleInfo"), INITS.get("lifecycleInfo")) : null;
// CONSTRUCTOR
    }

    public QDemandeAgent(Path<? extends DemandeAgent> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDemandeAgent(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDemandeAgent(PathMetadata<?> metadata, PathInits inits) {
        this(DemandeAgent.class, metadata, inits);
    }

    public QDemandeAgent(Class<? extends DemandeAgent> type, PathMetadata<?> metadata, PathInits inits) {
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

    
public com.katappult.core.model.typed.QTypeInfo typeInfo() {
        if (typeInfo == null) {
            typeInfo = new com.katappult.core.model.typed.QTypeInfo(forProperty("typeInfo"));
        }
        return typeInfo;
    }

	public com.katappult.core.model.lifecyclemanaged.QLifecycleInfo lifecycleInfo() {
        if (lifecycleInfo == null) {
            lifecycleInfo = new com.katappult.core.model.lifecyclemanaged.QLifecycleInfo(forProperty("lifecycleInfo"));
        }
        return lifecycleInfo;
    }

 public QCategory category() {
        if (category == null) {
            category = new QCategory(forProperty("category"));
        }
        return category;
    }


public QUserAccount userAccount() {
        if (userAccount == null) {
            userAccount = new QUserAccount(forProperty("userAccount"));
        }
        return userAccount;
    }
// METHODS
}

