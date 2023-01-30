package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BeanPath;
import com.mysema.query.types.path.NumberPath;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
//IMPORT

public class QReplayToCategoryLinkId extends BeanPath<ReplayToCategoryLinkId> {

    private static final long serialVersionUID = 1L;

    public static final QReplayToCategoryLinkId replayId = new QReplayToCategoryLinkId("replayId");

    public final NumberPath<Long> roleAId = createNumber("roleAId", Long.class);

    public final NumberPath<Long> roleBId = createNumber("roleBId", Long.class);

    public QReplayToCategoryLinkId(String variable) {
        super(ReplayToCategoryLinkId.class, forVariable(variable));
    }

    public QReplayToCategoryLinkId(Path<? extends ReplayToCategoryLinkId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReplayToCategoryLinkId(PathMetadata<?> metadata) {
        super(ReplayToCategoryLinkId.class, metadata);
    }

}
