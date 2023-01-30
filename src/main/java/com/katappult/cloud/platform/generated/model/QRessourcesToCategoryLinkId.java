package com.katappult.cloud.platform.generated.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BeanPath;
import com.mysema.query.types.path.NumberPath;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
//IMPORT

public class QRessourcesToCategoryLinkId extends BeanPath<RessourcesToCategoryLinkId> {

    private static final long serialVersionUID = 1L;

    public static final QRessourcesToCategoryLinkId ressourcesId = new QRessourcesToCategoryLinkId("ressourcesId");

    public final NumberPath<Long> roleAId = createNumber("roleAId", Long.class);

    public final NumberPath<Long> roleBId = createNumber("roleBId", Long.class);

    public QRessourcesToCategoryLinkId(String variable) {
        super(RessourcesToCategoryLinkId.class, forVariable(variable));
    }

    public QRessourcesToCategoryLinkId(Path<? extends RessourcesToCategoryLinkId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRessourcesToCategoryLinkId(PathMetadata<?> metadata) {
        super(RessourcesToCategoryLinkId.class, metadata);
    }

}
