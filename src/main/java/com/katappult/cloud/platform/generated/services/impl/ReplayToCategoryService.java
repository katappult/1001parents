package com.katappult.cloud.platform.generated.services.impl;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.dao.api.IReplayToCategoryDao;
import com.katappult.cloud.platform.generated.services.api.IReplayToCategoryService;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Replay;
import com.katappult.cloud.platform.generated.model.QCategory;
import com.katappult.cloud.platform.generated.model.ReplayToCategoryLink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

@Component
public class ReplayToCategoryService implements IReplayToCategoryService {

    @Inject
    private IReplayToCategoryDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createLink(final Replay roleA, final Category roleB, final Container container) {
        dao.createLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLink(final Replay roleA, final Category roleB, final Container container) {
        dao.deleteLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void moveFromRoleA(final Replay roleA, final Replay targetRoleA, final Category roleB, final Container container) {
        deleteLink(roleA, roleB, container);
        createLink(targetRoleA, roleB, container);
    }

    @Override
    public Optional<ReplayToCategoryLink> getLink(final Replay roleA, final Category roleB, final Container container) {
        return dao.getLink(roleA, roleB, container);
    }

    @Override
    public void removeAllRoleBs(final Replay roleA, final Container container) {
        dao.removeAllRoleBs(roleA, container);
    }

    @Override
    public List<Category> getAllRoleBs(final Replay roleA, final Container container) {
        return dao.getAllRoleBs(roleA, container);
    }

    @Override
    public Map<Category, ReplayToCategoryLink> getAllRoleBsWithLink(final Replay roleA, final Container container) {
        return dao.getAllRoleBsWithLink(roleA, container);
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Replay roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {
        return dao.searchRoleBsNotLinkedToRoleA(roleA, searchTerm, pageRequest, container);
    }

    @Override
    public List<Replay> getAllReplayInverseRoleBsManyToManyLinkToOfCategory(final Category roleB, final Container container) {
        return dao.getAllReplayInverseRoleBsManyToManyLinkToOfCategory(roleB, container);
    }
}
