package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IExpertCategoryDao;
import com.katappult.cloud.platform.generated.model.QExpertCategory;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class ExpertCategoryDao implements  IExpertCategoryDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QExpertCategory qExpertCategory = new QExpertCategory("entity");
        BooleanExpression whereClause =  qExpertCategory.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qExpertCategory).where(whereClause);
        return dao.readPage(jpqlQuery, qExpertCategory, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QExpertCategory qExpertCategory = new QExpertCategory("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QExpertCategory qExpertCategory = new QExpertCategory("entity");

        BooleanExpression whereClause = qExpertCategory.nom.likeIgnoreCase("%" + searchTerm + "%");
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qExpertCategory)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qExpertCategory, pageRequest);
    }

    // DAO
}
