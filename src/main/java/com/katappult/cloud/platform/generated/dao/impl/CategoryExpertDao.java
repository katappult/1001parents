package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.ICategoryExpertDao;
import com.katappult.cloud.platform.generated.model.QCategoryExpert;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class CategoryExpertDao implements  ICategoryExpertDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QCategoryExpert qCategoryExpert = new QCategoryExpert("entity");
        BooleanExpression whereClause =  qCategoryExpert.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategoryExpert).where(whereClause);
        return dao.readPage(jpqlQuery, qCategoryExpert, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QCategoryExpert qCategoryExpert = new QCategoryExpert("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QCategoryExpert qCategoryExpert = new QCategoryExpert("entity");

        BooleanExpression whereClause = qCategoryExpert.nom.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qCategoryExpert.description.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategoryExpert)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qCategoryExpert, pageRequest);
    }

    // DAO
}
