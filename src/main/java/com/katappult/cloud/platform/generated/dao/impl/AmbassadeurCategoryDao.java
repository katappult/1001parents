package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IAmbassadeurCategoryDao;
import com.katappult.cloud.platform.generated.model.QAmbassadeurCategory;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class AmbassadeurCategoryDao implements  IAmbassadeurCategoryDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QAmbassadeurCategory qAmbassadeurCategory = new QAmbassadeurCategory("entity");
        BooleanExpression whereClause =  qAmbassadeurCategory.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qAmbassadeurCategory).where(whereClause);
        return dao.readPage(jpqlQuery, qAmbassadeurCategory, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QAmbassadeurCategory qAmbassadeurCategory = new QAmbassadeurCategory("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QAmbassadeurCategory qAmbassadeurCategory = new QAmbassadeurCategory("entity");

        BooleanExpression whereClause = qAmbassadeurCategory.nom.likeIgnoreCase("%" + searchTerm + "%");
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qAmbassadeurCategory)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qAmbassadeurCategory, pageRequest);
    }

    // DAO
}
