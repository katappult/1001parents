package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IDemandeAgentFacilitateurDao;
import com.katappult.cloud.platform.generated.model.QDemandeAgentFacilitateur;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class DemandeAgentFacilitateurDao implements  IDemandeAgentFacilitateurDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QDemandeAgentFacilitateur qDemandeAgentFacilitateur = new QDemandeAgentFacilitateur("entity");
        BooleanExpression whereClause =  qDemandeAgentFacilitateur.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qDemandeAgentFacilitateur).where(whereClause);
        return dao.readPage(jpqlQuery, qDemandeAgentFacilitateur, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QDemandeAgentFacilitateur qDemandeAgentFacilitateur = new QDemandeAgentFacilitateur("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QDemandeAgentFacilitateur qDemandeAgentFacilitateur = new QDemandeAgentFacilitateur("entity");

        BooleanExpression whereClause = qDemandeAgentFacilitateur.titre.likeIgnoreCase("%" + searchTerm + "%");
whereClause = whereClause.or(qDemandeAgentFacilitateur.theme.likeIgnoreCase("%" + searchTerm + "%"));
whereClause = whereClause.or(qDemandeAgentFacilitateur.description.likeIgnoreCase("%" + searchTerm + "%"));
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qDemandeAgentFacilitateur)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qDemandeAgentFacilitateur, pageRequest);
    }

    // DAO
}
