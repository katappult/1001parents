package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IDemandeAmbassadeurDao;
import com.katappult.cloud.platform.generated.model.QDemandeAmbassadeur;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class DemandeAmbassadeurDao implements  IDemandeAmbassadeurDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QDemandeAmbassadeur qDemandeAmbassadeur = new QDemandeAmbassadeur("entity");
        BooleanExpression whereClause =  qDemandeAmbassadeur.containerInfo().container().eq(container);

        if(Objects.nonNull(params) && params.size() > 0){
            String status = params.get("status");
            if(StringUtils.isNotBlank(status)){
                whereClause = whereClause.and(
                        qDemandeAmbassadeur.lifecycleInfo().currentState.eq(status)
                );
            }
        }
// WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qDemandeAmbassadeur).where(whereClause);
        return dao.readPage(jpqlQuery, qDemandeAmbassadeur, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QDemandeAmbassadeur qDemandeAmbassadeur = new QDemandeAmbassadeur("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QDemandeAmbassadeur qDemandeAmbassadeur = new QDemandeAmbassadeur("entity");

        BooleanExpression whereClause = qDemandeAmbassadeur.titre.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qDemandeAmbassadeur.description.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qDemandeAmbassadeur)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qDemandeAmbassadeur, pageRequest);
    }

    // DAO
}
