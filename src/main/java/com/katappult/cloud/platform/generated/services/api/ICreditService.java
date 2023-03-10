package com.katappult.cloud.platform.generated.services.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.core.utils.UIAttributes;
import java.util.List;
import java.util.Map;
import com.katappult.cloud.platform.generated.model.*;
import com.katappult.core.model.account.UserAccount;
// IMPORT

public interface ICreditService {

    Credit create(UIAttributes uiAttributes, Container container) ;

    Credit update(UIAttributes uiAttributes, Container container) ;

    void delete(Credit entity, Container container);

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container);

    void batchCreateFromImport(Credit entity, Container container);

    void batchUpdateFromImport(Credit transientEntity);

    
    void setUserAccount(Credit entity, UserAccount roleB, Container container);

    UserAccount getUserAccount(Credit entity, Container container);

    void removeUserAccount(Credit entity, UserAccount roleB, Container container);

    Credit getInverseOneToOneUserAccount(UserAccount entity, Container container);

// SERVICES
}
