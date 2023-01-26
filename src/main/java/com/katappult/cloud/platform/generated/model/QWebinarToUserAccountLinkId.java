package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BeanPath;
import com.mysema.query.types.path.NumberPath;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import com.katappult.core.model.account.UserAccount;
import com.katappult.core.model.account.QUserAccount;
//IMPORT

public class QWebinarToUserAccountLinkId extends BeanPath<WebinarToUserAccountLinkId> {

    private static final long serialVersionUID = 1L;

    public static final QWebinarToUserAccountLinkId webinarId = new QWebinarToUserAccountLinkId("webinarId");

    public final NumberPath<Long> roleAId = createNumber("roleAId", Long.class);

    public final NumberPath<Long> roleBId = createNumber("roleBId", Long.class);

    public QWebinarToUserAccountLinkId(String variable) {
        super(WebinarToUserAccountLinkId.class, forVariable(variable));
    }

    public QWebinarToUserAccountLinkId(Path<? extends WebinarToUserAccountLinkId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWebinarToUserAccountLinkId(PathMetadata<?> metadata) {
        super(WebinarToUserAccountLinkId.class, metadata);
    }

}
