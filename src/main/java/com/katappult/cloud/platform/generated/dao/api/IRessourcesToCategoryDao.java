package com.katappult.cloud.platform.generated.dao.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Ressources;
import com.katappult.cloud.platform.generated.model.RessourcesToCategoryLink;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

public interface IRessourcesToCategoryDao {

    void createLink(Ressources roleA, Category roleB, Container container);

    void deleteLink(Ressources roleA, Category roleB, Container container);

    Optional<RessourcesToCategoryLink> getLink(Ressources roleA, Category roleB, Container container);

    void removeAllRoleBs(Ressources roleA, Container container);

    List<Category> getAllRoleBs(Ressources roleA, Container container);

    Map<Category, RessourcesToCategoryLink> getAllRoleBsWithLink(Ressources roleA, Container container);

    PageResult searchRoleBsNotLinkedToRoleA(Ressources roleA, String searchTerm, PageRequest pageRequest, Container container);

    List<Ressources> getAllRessourcesInverseRoleBsManyToManyLinkToOfCategory(Category roleB, Container container);
}
