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
import com.katappult.cloud.platform.generated.dao.api.IReplayToCategoryDao;
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
public class ReplayToCategoryDao implements IReplayToCategoryDao {


    @Inject
    private IPersistableRepository persistableRepository;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createLink(final Replay roleA, final Category roleB, final Container container) {
        if(!existLinkBetween(roleA, roleB, container)) {
            ReplayToCategoryLink link = new ReplayToCategoryLink(roleA, roleB, container);
            persistableRepository.saveWithoutEvent(link);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteLink(final Replay roleA, final Category roleB, final Container container) {
        getLink(roleA, roleB, container).ifPresent(link -> {
            persistableRepository.delete(link);
        });
    }

    @Override
    public Optional<ReplayToCategoryLink> getLink(final Replay roleA, final Category roleB, final Container container) {
        QReplayToCategoryLink qLink = QReplayToCategoryLink.replayLink;
        ReplayToCategoryLink link = persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA)
                        .and(qLink.roleB().eq(roleB))
                        .and(qLink.containerInfo().container().eq(container))
                ).singleResult(qLink);
        return Optional.ofNullable(link);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeAllRoleBs(final Replay roleA, final Container container) {
        QReplayToCategoryLink qLink = QReplayToCategoryLink.replayLink;
        persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA).and(qLink.containerInfo().container().eq(container)))
                .list()
                .stream()
                .forEach(link -> persistableRepository.delete((Persistable) link));
    }

    @Override
    public List<Category> getAllRoleBs(final Replay roleA, final Container container) {
        QReplayToCategoryLink qLink = QReplayToCategoryLink.replayLink;
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
    public Map<Category, ReplayToCategoryLink> getAllRoleBsWithLink(final Replay roleA, final Container container) {
        Map<Category, ReplayToCategoryLink> map = new HashMap<>();
        List<Category> roleBs = getAllRoleBs(roleA, container);
        roleBs.stream().forEach(roleB -> {
            getLink(roleA, roleB, container).ifPresent(link -> map.put(roleB, link));
        });

        return map;
    }

    private boolean existLinkBetween(Replay roleA, Category roleB, Container container){
        QReplayToCategoryLink qLink = QReplayToCategoryLink.replayLink;
        return persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA)
                        .and(qLink.roleB().eq(roleB))
                        .and(qLink.containerInfo().container().eq(container))
                ).exists();
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Replay roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {

        // not linked
        QReplayToCategoryLink link = QReplayToCategoryLink.replayLink;
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
    public List<Replay> getAllReplayInverseRoleBsManyToManyLinkToOfCategory(final Category roleB, final Container container) {
        // not linked
        QReplayToCategoryLink link = QReplayToCategoryLink.replayLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(link)
                .where(link.id().roleBId.eq(roleB._getOid())
                        .and(link.containerInfo().container().eq(container)));

        QReplay qRoleA = new QReplay("entity");
        BooleanExpression whereClause = qRoleA.oid.in(linkedMembers.list(link.id().roleAId));

        JPAQuery query = persistableRepository
                .from(qRoleA)
                .where(whereClause);

        return query.list(qRoleA);
    }
}
