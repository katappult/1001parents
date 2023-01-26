package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IWebinarDao;
import com.katappult.cloud.platform.generated.model.QWebinar;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class WebinarDao implements  IWebinarDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QWebinar qWebinar = new QWebinar("entity");
        BooleanExpression whereClause =  qWebinar.containerInfo().container().eq(container);

        if(Objects.nonNull(params) && params.size() > 0){
            String status = params.get("status");
            if(StringUtils.isNotBlank(status)){
                whereClause = whereClause.and(
                        qWebinar.lifecycleInfo().currentState.eq(status)
                );
            }
        }
// WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qWebinar).where(whereClause);
        return dao.readPage(jpqlQuery, qWebinar, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QWebinar qWebinar = new QWebinar("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QWebinar qWebinar = new QWebinar("entity");

        BooleanExpression whereClause = qWebinar.title.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qWebinar.description.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qWebinar.category.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qWebinar)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qWebinar, pageRequest);
    }

    // DAO
}
