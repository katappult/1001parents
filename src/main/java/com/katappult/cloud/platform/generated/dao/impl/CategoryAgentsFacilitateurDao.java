package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.ICategoryAgentsFacilitateurDao;
import com.katappult.cloud.platform.generated.model.QCategoryAgentsFacilitateur;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class CategoryAgentsFacilitateurDao implements  ICategoryAgentsFacilitateurDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QCategoryAgentsFacilitateur qCategoryAgentsFacilitateur = new QCategoryAgentsFacilitateur("entity");
        BooleanExpression whereClause =  qCategoryAgentsFacilitateur.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategoryAgentsFacilitateur).where(whereClause);
        return dao.readPage(jpqlQuery, qCategoryAgentsFacilitateur, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QCategoryAgentsFacilitateur qCategoryAgentsFacilitateur = new QCategoryAgentsFacilitateur("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QCategoryAgentsFacilitateur qCategoryAgentsFacilitateur = new QCategoryAgentsFacilitateur("entity");

        BooleanExpression whereClause = qCategoryAgentsFacilitateur.nom.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qCategoryAgentsFacilitateur.description.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCategoryAgentsFacilitateur)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qCategoryAgentsFacilitateur, pageRequest);
    }

    // DAO
}
