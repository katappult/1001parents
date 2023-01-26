package com.katappult.cloud.platform.generated.services.impl;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.dao.api.IWebinarToUserAccountDao;
import com.katappult.cloud.platform.generated.services.api.IWebinarToUserAccountService;
import com.katappult.core.model.account.UserAccount;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.core.model.account.QUserAccount;
import com.katappult.cloud.platform.generated.model.WebinarToUserAccountLink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

@Component
public class WebinarToUserAccountService implements IWebinarToUserAccountService {

    @Inject
    private IWebinarToUserAccountDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createLink(final Webinar roleA, final UserAccount roleB, final Container container) {
        dao.createLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLink(final Webinar roleA, final UserAccount roleB, final Container container) {
        dao.deleteLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void moveFromRoleA(final Webinar roleA, final Webinar targetRoleA, final UserAccount roleB, final Container container) {
        deleteLink(roleA, roleB, container);
        createLink(targetRoleA, roleB, container);
    }

    @Override
    public Optional<WebinarToUserAccountLink> getLink(final Webinar roleA, final UserAccount roleB, final Container container) {
        return dao.getLink(roleA, roleB, container);
    }

    @Override
    public void removeAllRoleBs(final Webinar roleA, final Container container) {
        dao.removeAllRoleBs(roleA, container);
    }

    @Override
    public List<UserAccount> getAllRoleBs(final Webinar roleA, final Container container) {
        return dao.getAllRoleBs(roleA, container);
    }

    @Override
    public Map<UserAccount, WebinarToUserAccountLink> getAllRoleBsWithLink(final Webinar roleA, final Container container) {
        return dao.getAllRoleBsWithLink(roleA, container);
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Webinar roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {
        return dao.searchRoleBsNotLinkedToRoleA(roleA, searchTerm, pageRequest, container);
    }

    @Override
    public List<Webinar> getAllWebinarInverseRoleBsManyToManyLinkToOfUserAccount(final UserAccount roleB, final Container container) {
        return dao.getAllWebinarInverseRoleBsManyToManyLinkToOfUserAccount(roleB, container);
    }
}
