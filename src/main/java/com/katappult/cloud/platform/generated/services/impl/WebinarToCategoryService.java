package com.katappult.cloud.platform.generated.services.impl;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.dao.api.IWebinarToCategoryDao;
import com.katappult.cloud.platform.generated.services.api.IWebinarToCategoryService;
import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.Webinar;
import com.katappult.cloud.platform.generated.model.QCategory;
import com.katappult.cloud.platform.generated.model.WebinarToCategoryLink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//IMPORT

@Component
public class WebinarToCategoryService implements IWebinarToCategoryService {

    @Inject
    private IWebinarToCategoryDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createLink(final Webinar roleA, final Category roleB, final Container container) {
        dao.createLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteLink(final Webinar roleA, final Category roleB, final Container container) {
        dao.deleteLink(roleA, roleB, container);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void moveFromRoleA(final Webinar roleA, final Webinar targetRoleA, final Category roleB, final Container container) {
        deleteLink(roleA, roleB, container);
        createLink(targetRoleA, roleB, container);
    }

    @Override
    public Optional<WebinarToCategoryLink> getLink(final Webinar roleA, final Category roleB, final Container container) {
        return dao.getLink(roleA, roleB, container);
    }

    @Override
    public void removeAllRoleBs(final Webinar roleA, final Container container) {
        dao.removeAllRoleBs(roleA, container);
    }

    @Override
    public List<Category> getAllRoleBs(final Webinar roleA, final Container container) {
        return dao.getAllRoleBs(roleA, container);
    }

    @Override
    public Map<Category, WebinarToCategoryLink> getAllRoleBsWithLink(final Webinar roleA, final Container container) {
        return dao.getAllRoleBsWithLink(roleA, container);
    }

    @Override
    public PageResult searchRoleBsNotLinkedToRoleA(final Webinar roleA, final String searchTerm, final PageRequest pageRequest, final Container container) {
        return dao.searchRoleBsNotLinkedToRoleA(roleA, searchTerm, pageRequest, container);
    }

    @Override
    public List<Webinar> getAllWebinarInverseRoleBsManyToManyLinkToOfCategory(final Category roleB, final Container container) {
        return dao.getAllWebinarInverseRoleBsManyToManyLinkToOfCategory(roleB, container);
    }
}
