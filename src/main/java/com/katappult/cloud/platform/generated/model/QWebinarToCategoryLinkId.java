package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BeanPath;
import com.mysema.query.types.path.NumberPath;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
//IMPORT

public class QWebinarToCategoryLinkId extends BeanPath<WebinarToCategoryLinkId> {

    private static final long serialVersionUID = 1L;

    public static final QWebinarToCategoryLinkId webinarId = new QWebinarToCategoryLinkId("webinarId");

    public final NumberPath<Long> roleAId = createNumber("roleAId", Long.class);

    public final NumberPath<Long> roleBId = createNumber("roleBId", Long.class);

    public QWebinarToCategoryLinkId(String variable) {
        super(WebinarToCategoryLinkId.class, forVariable(variable));
    }

    public QWebinarToCategoryLinkId(Path<? extends WebinarToCategoryLinkId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWebinarToCategoryLinkId(PathMetadata<?> metadata) {
        super(WebinarToCategoryLinkId.class, metadata);
    }

}
