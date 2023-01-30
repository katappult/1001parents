package com.katappult.cloud.platform.generated.dao.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Replay;
import com.katappult.cloud.platform.generated.model.ReplayToCategoryLink;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

public interface IReplayToCategoryDao {

    void createLink(Replay roleA, Category roleB, Container container);

    void deleteLink(Replay roleA, Category roleB, Container container);

    Optional<ReplayToCategoryLink> getLink(Replay roleA, Category roleB, Container container);

    void removeAllRoleBs(Replay roleA, Container container);

    List<Category> getAllRoleBs(Replay roleA, Container container);

    Map<Category, ReplayToCategoryLink> getAllRoleBsWithLink(Replay roleA, Container container);

    PageResult searchRoleBsNotLinkedToRoleA(Replay roleA, String searchTerm, PageRequest pageRequest, Container container);

    List<Replay> getAllReplayInverseRoleBsManyToManyLinkToOfCategory(Category roleB, Container container);
}
