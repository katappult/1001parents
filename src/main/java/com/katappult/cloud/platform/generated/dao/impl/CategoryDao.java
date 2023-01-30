package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.ICategoryDao;
import com.katappult.cloud.platform.generated.model.QCategory;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class CategoryDao implements  ICategoryDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QCategory qCategory = new QCategory("entity");
        BooleanExpression whereClause =  qCategory.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategory).where(whereClause);
        return dao.readPage(jpqlQuery, qCategory, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QCategory qCategory = new QCategory("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QCategory qCategory = new QCategory("entity");

        BooleanExpression whereClause = qCategory.nom.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qCategory.description.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qCategory.internalKey.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qCategory.groupKey.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategory)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qCategory, pageRequest);
    }

    // DAO
}
