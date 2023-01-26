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
// IMPORT

public interface IAmbassadeurCategoryService {

    AmbassadeurCategory create(UIAttributes uiAttributes, Container container) ;

    AmbassadeurCategory update(UIAttributes uiAttributes, Container container) ;

    void delete(AmbassadeurCategory entity, Container container);

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container);

    void batchCreateFromImport(AmbassadeurCategory entity, Container container);

    void batchUpdateFromImport(AmbassadeurCategory transientEntity);

    // SERVICES
}
