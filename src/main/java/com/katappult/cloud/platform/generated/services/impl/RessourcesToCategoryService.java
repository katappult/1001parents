package com.katappult.cloud.platform.generated.services.impl;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.dao.api.IRessourcesToCategoryDao;
import com.katappult.cloud.platform.generated.services.api.IRessourcesToCategoryService;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Ressources;
import com.katappult.cloud.platform.generated.model.QCategory;
import com.katappult.cloud.platform.generated.model.RessourcesToCategoryLink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

@Component
public class RessourcesToCategoryService implements IRessourcesToCategoryService {

    @Inject
    private IRessourcesToCategoryDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createLink(final Ressources roleA, final Category roleB, final Container container) {
        dao.createLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLink(final Ressources roleA, final Category roleB, final Container container) {
        dao.deleteLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void moveFromRoleA(final Ressources roleA, final Ressources targetRoleA, final Category roleB, final Container container) {
        deleteLink(roleA, roleB, container);
        createLink(targetRoleA, roleB, container);
    }

    @Override
    public Optional<RessourcesToCategoryLink> getLink(final Ressources roleA, final Category roleB, final Container container) {
        return dao.getLink(roleA, roleB, container);
    }

    @Override
    public void removeAllRoleBs(final Ressources roleA, final Container container) {
        dao.removeAllRoleBs(roleA, container);
    }

    @Override
    public List<Category> getAllRoleBs(final Ressources roleA, final Container container) {
        return dao.getAllRoleBs(roleA, container);
    }

    @Override
    public Map<Category, RessourcesToCategoryLink> getAllRoleBsWithLink(final Ressources roleA, final Container container) {
        return dao.getAllRoleBsWithLink(roleA, container);
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Ressources roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {
        return dao.searchRoleBsNotLinkedToRoleA(roleA, searchTerm, pageRequest, container);
    }

    @Override
    public List<Ressources> getAllRessourcesInverseRoleBsManyToManyLinkToOfCategory(final Category roleB, final Container container) {
        return dao.getAllRessourcesInverseRoleBsManyToManyLinkToOfCategory(roleB, container);
    }
}
