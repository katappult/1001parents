package com.katappult.cloud.platform.generated.dao.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.core.model.account.UserAccount;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.cloud.platform.generated.model.WebinarToUserAccountLink;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

public interface IWebinarToUserAccountDao {

    void createLink(Webinar roleA, UserAccount roleB, Container container);

    void deleteLink(Webinar roleA, UserAccount roleB, Container container);

    Optional<WebinarToUserAccountLink> getLink(Webinar roleA, UserAccount roleB, Container container);

    void removeAllRoleBs(Webinar roleA, Container container);

    List<UserAccount> getAllRoleBs(Webinar roleA, Container container);

    Map<UserAccount, WebinarToUserAccountLink> getAllRoleBsWithLink(Webinar roleA, Container container);

    PageResult searchRoleBsNotLinkedToRoleA(Webinar roleA, String searchTerm, PageRequest pageRequest, Container container);

    List<Webinar> getAllWebinarInverseRoleBsManyToManyLinkToOfUserAccount(UserAccount roleB, Container container);
}
