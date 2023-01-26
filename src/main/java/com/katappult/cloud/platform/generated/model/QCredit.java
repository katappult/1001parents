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
 * QCredit is a Querydsl query type for Credit
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCredit extends EntityPathBase<Credit> {

    private static final long serialVersionUID = -118259594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCredit credit = new QCredit("credit");

    public final com.katappult.core.model.persistable.QBusinessObject _super;

    // inherited
    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;


    //inherited
    public final NumberPath<Long> version;

     public final NumberPath<Integer> total = createNumber("total", Integer.class);
 public final NumberPath<Integer> consumed = createNumber("consumed", Integer.class);
protected com.katappult.core.model.typed.QTypeInfo typeInfo;
	protected com.katappult.core.model.lifecyclemanaged.QLifecycleInfo lifecycleInfo;

protected QUserAccount userAccount;
// ATTRIBUTES

    public QCredit(String variable) {
        this(Credit.class, forVariable(variable), INITS);

        this.typeInfo = INITS.isInitialized("typeInfo") ? new com.katappult.core.model.typed.QTypeInfo(forProperty("typeInfo"), INITS.get("typeInfo")) : null;
	this.lifecycleInfo = INITS.isInitialized("lifecycleInfo") ? new com.katappult.core.model.lifecyclemanaged.QLifecycleInfo(forProperty("lifecycleInfo"), INITS.get("lifecycleInfo")) : null;
// CONSTRUCTOR
    }

    public QCredit(Path<? extends Credit> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCredit(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCredit(PathMetadata<?> metadata, PathInits inits) {
        this(Credit.class, metadata, inits);
    }

    public QCredit(Class<? extends Credit> type, PathMetadata<?> metadata, PathInits inits) {
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


public QUserAccount userAccount() {
        if (userAccount == null) {
            userAccount = new QUserAccount(forProperty("userAccount"));
        }
        return userAccount;
    }
// METHODS
}

