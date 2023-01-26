package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IRessourcesDao;
import com.katappult.cloud.platform.generated.model.QRessources;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class RessourcesDao implements  IRessourcesDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QRessources qRessources = new QRessources("entity");
        BooleanExpression whereClause =  qRessources.containerInfo().container().eq(container);

        if(Objects.nonNull(params) && params.size() > 0){
            String status = params.get("status");
            if(StringUtils.isNotBlank(status)){
                whereClause = whereClause.and(
                        qRessources.lifecycleInfo().currentState.eq(status)
                );
            }
        }
// WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qRessources).where(whereClause);
        return dao.readPage(jpqlQuery, qRessources, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QRessources qRessources = new QRessources("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QRessources qRessources = new QRessources("entity");

        BooleanExpression whereClause = qRessources.titre.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qRessources.description.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qRessources.url.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qRessources.mediaType.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qRessources)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qRessources, pageRequest);
    }

    // DAO
}
