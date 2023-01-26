package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.katappult.cloud.platform.generated.dao.api.IAgentFacilitateurCategoryDao;
import com.katappult.cloud.platform.generated.model.QAgentFacilitateurCategory;
import java.util.Map;
import com.katappult.core.utils.StringUtils;
import java.util.Objects;
import com.katappult.cloud.platform.generated.model.*;
// IMPORT

@Component
public class AgentFacilitateurCategoryDao implements  IAgentFacilitateurCategoryDao{

    @Autowired
    private IPersistableRepository dao;

    @Override
    public PageResult list(PageRequest pageRequest, Container container, Map<String, String> params) {
        QAgentFacilitateurCategory qAgentFacilitateurCategory = new QAgentFacilitateurCategory("entity");
        BooleanExpression whereClause =  qAgentFacilitateurCategory.containerInfo().container().eq(container);

        // WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qAgentFacilitateurCategory).where(whereClause);
        return dao.readPage(jpqlQuery, qAgentFacilitateurCategory, pageRequest);
    }

    @Override
    public boolean existWithName(String name, Container container) {
        QAgentFacilitateurCategory qAgentFacilitateurCategory = new QAgentFacilitateurCategory("entity");
        return false;
    }

    @Override
    public PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container) {
        QAgentFacilitateurCategory qAgentFacilitateurCategory = new QAgentFacilitateurCategory("entity");

        BooleanExpression whereClause = qAgentFacilitateurCategory.nom.likeIgnoreCase("%" + searchTerm + "%");
// SEARCH ENTITY WHERE CLAUSE

        JPQLQuery jpqlQuery = dao.from(qAgentFacilitateurCategory)
                .where(whereClause);

        return dao.readPage(jpqlQuery, qAgentFacilitateurCategory, pageRequest);
    }

    // DAO
}
