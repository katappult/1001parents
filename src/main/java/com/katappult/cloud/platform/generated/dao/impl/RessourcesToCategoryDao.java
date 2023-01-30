package com.katappult.cloud.platform.generated.dao.impl;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;
import com.katappult.core.utils.StringUtils;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.dao.api.IPersistableRepository;
import com.katappult.core.model.composite.Container;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.cloud.platform.generated.model.*;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.QCategory;
import com.katappult.cloud.platform.generated.dao.api.IRessourcesToCategoryDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

@Component
public class RessourcesToCategoryDao implements IRessourcesToCategoryDao {


    @Inject
    private IPersistableRepository persistableRepository;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createLink(final Ressources roleA, final Category roleB, final Container container) {
        if(!existLinkBetween(roleA, roleB, container)) {
            RessourcesToCategoryLink link = new RessourcesToCategoryLink(roleA, roleB, container);
            persistableRepository.saveWithoutEvent(link);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteLink(final Ressources roleA, final Category roleB, final Container container) {
        getLink(roleA, roleB, container).ifPresent(link -> {
            persistableRepository.delete(link);
        });
    }

    @Override
    public Optional<RessourcesToCategoryLink> getLink(final Ressources roleA, final Category roleB, final Container container) {
        QRessourcesToCategoryLink qLink = QRessourcesToCategoryLink.ressourcesLink;
        RessourcesToCategoryLink link = persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA)
                        .and(qLink.roleB().eq(roleB))
                        .and(qLink.containerInfo().container().eq(container))
                ).singleResult(qLink);
        return Optional.ofNullable(link);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeAllRoleBs(final Ressources roleA, final Container container) {
        QRessourcesToCategoryLink qLink = QRessourcesToCategoryLink.ressourcesLink;
        persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA).and(qLink.containerInfo().container().eq(container)))
                .list()
                .stream()
                .forEach(link -> persistableRepository.delete((Persistable) link));
    }

    @Override
    public List<Category> getAllRoleBs(final Ressources roleA, final Container container) {
        QRessourcesToCategoryLink qLink = QRessourcesToCategoryLink.ressourcesLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(qLink)
                .where(qLink.id().roleAId.eq(roleA._getOid())
                        .and(qLink.containerInfo().container().eq(container)));

        QCategory qRoleB = new QCategory("roleB");
        BooleanExpression whereClause = qRoleB.oid.in(linkedMembers.list(qLink.id().roleBId));

        List<Category> results = persistableRepository
                .from(qRoleB)
                .where(whereClause)
                .list(qRoleB);

        return results;
    }

    @Override
    public Map<Category, RessourcesToCategoryLink> getAllRoleBsWithLink(final Ressources roleA, final Container container) {
        Map<Category, RessourcesToCategoryLink> map = new HashMap<>();
        List<Category> roleBs = getAllRoleBs(roleA, container);
        roleBs.stream().forEach(roleB -> {
            getLink(roleA, roleB, container).ifPresent(link -> map.put(roleB, link));
        });

        return map;
    }

    private boolean existLinkBetween(Ressources roleA, Category roleB, Container container){
        QRessourcesToCategoryLink qLink = QRessourcesToCategoryLink.ressourcesLink;
        return persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA)
                        .and(qLink.roleB().eq(roleB))
                        .and(qLink.containerInfo().container().eq(container))
                ).exists();
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Ressources roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {

        // not linked
        QRessourcesToCategoryLink link = QRessourcesToCategoryLink.ressourcesLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(link)
                .where(link.id().roleAId.eq(roleA._getOid())
                        .and(link.containerInfo().container().eq(container)));

        QCategory qRoleB = new QCategory("entity");
        BooleanExpression whereClause = qRoleB.oid.notIn(linkedMembers.list(link.id().roleBId));

        if (StringUtils.isNotBlank(searchTerm)) {
            //whereClause = whereClause.and(searchTerm.);
        }

        //searchRoleBsNotLinkedToRoleA

        JPAQuery query = persistableRepository
                .from(qRoleB)
                .where(whereClause);

        return persistableRepository.readPage(query, qRoleB, pageRequest);
    }

    @Override
    public List<Ressources> getAllRessourcesInverseRoleBsManyToManyLinkToOfCategory(final Category roleB, final Container container) {
        // not linked
        QRessourcesToCategoryLink link = QRessourcesToCategoryLink.ressourcesLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(link)
                .where(link.id().roleBId.eq(roleB._getOid())
                        .and(link.containerInfo().container().eq(container)));

        QRessources qRoleA = new QRessources("entity");
        BooleanExpression whereClause = qRoleA.oid.in(linkedMembers.list(link.id().roleAId));

        JPAQuery query = persistableRepository
                .from(qRoleA)
                .where(whereClause);

        return query.list(qRoleA);
    }
}
