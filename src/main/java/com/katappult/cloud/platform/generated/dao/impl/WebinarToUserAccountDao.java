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
import com.katappult.core.model.account.UserAccount;
import com.katappult.core.model.account.QUserAccount;
import com.katappult.cloud.platform.generated.dao.api.IWebinarToUserAccountDao;
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
public class WebinarToUserAccountDao implements IWebinarToUserAccountDao {


    @Inject
    private IPersistableRepository persistableRepository;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void createLink(final Webinar roleA, final UserAccount roleB, final Container container) {
        if(!existLinkBetween(roleA, roleB, container)) {
            WebinarToUserAccountLink link = new WebinarToUserAccountLink(roleA, roleB, container);
            persistableRepository.saveWithoutEvent(link);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteLink(final Webinar roleA, final UserAccount roleB, final Container container) {
        getLink(roleA, roleB, container).ifPresent(link -> {
            persistableRepository.delete(link);
        });
    }

    @Override
    public Optional<WebinarToUserAccountLink> getLink(final Webinar roleA, final UserAccount roleB, final Container container) {
        QWebinarToUserAccountLink qLink = QWebinarToUserAccountLink.webinarLink;
        WebinarToUserAccountLink link = persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA)
                        .and(qLink.roleB().eq(roleB))
                        .and(qLink.containerInfo().container().eq(container))
                ).singleResult(qLink);
        return Optional.ofNullable(link);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeAllRoleBs(final Webinar roleA, final Container container) {
        QWebinarToUserAccountLink qLink = QWebinarToUserAccountLink.webinarLink;
        persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA).and(qLink.containerInfo().container().eq(container)))
                .list()
                .stream()
                .forEach(link -> persistableRepository.delete((Persistable) link));
    }

    @Override
    public List<UserAccount> getAllRoleBs(final Webinar roleA, final Container container) {
        QWebinarToUserAccountLink qLink = QWebinarToUserAccountLink.webinarLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(qLink)
                .where(qLink.id().roleAId.eq(roleA._getOid())
                        .and(qLink.containerInfo().container().eq(container)));

        QUserAccount qRoleB = new QUserAccount("roleB");
        BooleanExpression whereClause = qRoleB.oid.in(linkedMembers.list(qLink.id().roleBId));

        List<UserAccount> results = persistableRepository
                .from(qRoleB)
                .where(whereClause)
                .list(qRoleB);

        return results;
    }

    @Override
    public Map<UserAccount, WebinarToUserAccountLink> getAllRoleBsWithLink(final Webinar roleA, final Container container) {
        Map<UserAccount, WebinarToUserAccountLink> map = new HashMap<>();
        List<UserAccount> roleBs = getAllRoleBs(roleA, container);
        roleBs.stream().forEach(roleB -> {
            getLink(roleA, roleB, container).ifPresent(link -> map.put(roleB, link));
        });

        return map;
    }

    private boolean existLinkBetween(Webinar roleA, UserAccount roleB, Container container){
        QWebinarToUserAccountLink qLink = QWebinarToUserAccountLink.webinarLink;
        return persistableRepository
                .from(qLink)
                .where(qLink.roleA().eq(roleA)
                        .and(qLink.roleB().eq(roleB))
                        .and(qLink.containerInfo().container().eq(container))
                ).exists();
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Webinar roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {

        // not linked
        QWebinarToUserAccountLink link = QWebinarToUserAccountLink.webinarLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(link)
                .where(link.id().roleAId.eq(roleA._getOid())
                        .and(link.containerInfo().container().eq(container)));

        QUserAccount qRoleB = new QUserAccount("entity");
        BooleanExpression whereClause = qRoleB.oid.notIn(linkedMembers.list(link.id().roleBId));

        if (StringUtils.isNotBlank(searchTerm)) {
            //whereClause = whereClause.and(searchTerm.);
        }

        whereClause = whereClause.and(qRoleB.nickName.notIn("epanon", "epadmin"));
//searchRoleBsNotLinkedToRoleA

        JPAQuery query = persistableRepository
                .from(qRoleB)
                .where(whereClause);

        return persistableRepository.readPage(query, qRoleB, pageRequest);
    }

    @Override
    public List<Webinar> getAllWebinarInverseRoleBsManyToManyLinkToOfUserAccount(final UserAccount roleB, final Container container) {
        // not linked
        QWebinarToUserAccountLink link = QWebinarToUserAccountLink.webinarLink;
        JPASubQuery linkedMembers = new JPASubQuery()
                .from(link)
                .where(link.id().roleBId.eq(roleB._getOid())
                        .and(link.containerInfo().container().eq(container)));

        QWebinar qRoleA = new QWebinar("entity");
        BooleanExpression whereClause = qRoleA.oid.in(linkedMembers.list(link.id().roleAId));

        JPAQuery query = persistableRepository
                .from(qRoleA)
                .where(whereClause);

        return query.list(qRoleA);
    }
}
