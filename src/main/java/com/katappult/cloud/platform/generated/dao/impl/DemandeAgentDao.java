package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IDemandeAgentDao;
import com.katappult.cloud.platform.generated.model.QDemandeAgent;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class DemandeAgentDao implements  IDemandeAgentDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QDemandeAgent qDemandeAgent = new QDemandeAgent("entity");
        BooleanExpression whereClause =  qDemandeAgent.containerInfo().container().eq(container);

        if(Objects.nonNull(params) && params.size() > 0){
            String status = params.get("status");
            if(StringUtils.isNotBlank(status)){
                whereClause = whereClause.and(
                        qDemandeAgent.lifecycleInfo().currentState.eq(status)
                );
            }
        }
// WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qDemandeAgent).where(whereClause);
        return dao.readPage(jpqlQuery, qDemandeAgent, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QDemandeAgent qDemandeAgent = new QDemandeAgent("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QDemandeAgent qDemandeAgent = new QDemandeAgent("entity");

        BooleanExpression whereClause = qDemandeAgent.titre.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qDemandeAgent.description.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qDemandeAgent)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qDemandeAgent, pageRequest);
    }

    // DAO
}
