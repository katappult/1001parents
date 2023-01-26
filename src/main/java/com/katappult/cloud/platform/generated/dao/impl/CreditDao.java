package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.ICreditDao;
import com.katappult.cloud.platform.generated.model.QCredit;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class CreditDao implements  ICreditDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QCredit qCredit = new QCredit("entity");
        BooleanExpression whereClause =  qCredit.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCredit).where(whereClause);
        return dao.readPage(jpqlQuery, qCredit, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QCredit qCredit = new QCredit("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QCredit qCredit = new QCredit("entity");

        BooleanExpression whereClause = qCredit.category.likeIgnoreCase("%" + searchTerm + "%");
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qCredit)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qCredit, pageRequest);
    }

    // DAO
}
