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
 * QWebinar is a Querydsl query type for Webinar
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWebinar extends EntityPathBase<Webinar> {

    private static final long serialVersionUID = -118259594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebinar webinar = new QWebinar("webinar");

    public final com.katappult.core.model.persistable.QBusinessObject _super;

    // inherited
    protected com.katappult.core.model.composite.QContainerInfo containerInfo;

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    // inherited
    protected com.katappult.core.model.persistable.QPersistenceInfo persistenceInfo;


    //inherited
    public final NumberPath<Long> version;

     public final StringPath title = createString("title");
 public final StringPath description = createString("description");
 public final com.mysema.query.types.path.DatePath<java.util.Date> dateDePlanification = createDate("dateDePlanification", java.util.Date.class);
 public final StringPath meetingLink = createString("meetingLink");
protected com.katappult.core.model.typed.QTypeInfo typeInfo;
	protected com.katappult.core.model.lifecyclemanaged.QLifecycleInfo lifecycleInfo;
// ATTRIBUTES

    public QWebinar(String variable) {
        this(Webinar.class, forVariable(variable), INITS);

        this.typeInfo = INITS.isInitialized("typeInfo") ? new com.katappult.core.model.typed.QTypeInfo(forProperty("typeInfo"), INITS.get("typeInfo")) : null;
	this.lifecycleInfo = INITS.isInitialized("lifecycleInfo") ? new com.katappult.core.model.lifecyclemanaged.QLifecycleInfo(forProperty("lifecycleInfo"), INITS.get("lifecycleInfo")) : null;
// CONSTRUCTOR
    }

    public QWebinar(Path<? extends Webinar> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebinar(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebinar(PathMetadata<?> metadata, PathInits inits) {
        this(Webinar.class, metadata, inits);
    }

    public QWebinar(Class<? extends Webinar> type, PathMetadata<?> metadata, PathInits inits) {
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

// METHODS
}

