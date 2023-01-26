package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IReplayDao;
import com.katappult.cloud.platform.generated.model.QReplay;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class ReplayDao implements  IReplayDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QReplay qReplay = new QReplay("entity");
        BooleanExpression whereClause =  qReplay.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qReplay).where(whereClause);
        return dao.readPage(jpqlQuery, qReplay, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QReplay qReplay = new QReplay("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QReplay qReplay = new QReplay("entity");

        BooleanExpression whereClause = qReplay.titre.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qReplay.mediaType.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qReplay.category.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qReplay.description.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qReplay.externalLink.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qReplay)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qReplay, pageRequest);
    }

    // DAO
}
