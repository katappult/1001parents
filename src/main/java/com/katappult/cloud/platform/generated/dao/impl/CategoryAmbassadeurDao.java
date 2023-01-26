package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.ICategoryAmbassadeurDao;
import com.katappult.cloud.platform.generated.model.QCategoryAmbassadeur;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class CategoryAmbassadeurDao implements  ICategoryAmbassadeurDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QCategoryAmbassadeur qCategoryAmbassadeur = new QCategoryAmbassadeur("entity");
        BooleanExpression whereClause =  qCategoryAmbassadeur.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategoryAmbassadeur).where(whereClause);
        return dao.readPage(jpqlQuery, qCategoryAmbassadeur, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QCategoryAmbassadeur qCategoryAmbassadeur = new QCategoryAmbassadeur("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QCategoryAmbassadeur qCategoryAmbassadeur = new QCategoryAmbassadeur("entity");

        BooleanExpression whereClause = qCategoryAmbassadeur.nom.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qCategoryAmbassadeur.description.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategoryAmbassadeur)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qCategoryAmbassadeur, pageRequest);
    }

    // DAO
}
