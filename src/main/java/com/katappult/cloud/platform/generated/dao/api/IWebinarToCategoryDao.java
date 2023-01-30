package com.katappult.cloud.platform.generated.dao.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.cloud.platform.generated.model.WebinarToCategoryLink;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

public interface IWebinarToCategoryDao {

    void createLink(Webinar roleA, Category roleB, Container container);

    void deleteLink(Webinar roleA, Category roleB, Container container);

    Optional<WebinarToCategoryLink> getLink(Webinar roleA, Category roleB, Container container);

    void removeAllRoleBs(Webinar roleA, Container container);

    List<Category> getAllRoleBs(Webinar roleA, Container container);

    Map<Category, WebinarToCategoryLink> getAllRoleBsWithLink(Webinar roleA, Container container);

    PageResult searchRoleBsNotLinkedToRoleA(Webinar roleA, String searchTerm, PageRequest pageRequest, Container container);

    List<Webinar> getAllWebinarInverseRoleBsManyToManyLinkToOfCategory(Category roleB, Container container);
}
