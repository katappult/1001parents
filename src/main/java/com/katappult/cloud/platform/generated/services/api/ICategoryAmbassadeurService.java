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

public interface ICategoryAmbassadeurService {

    CategoryAmbassadeur create(UIAttributes uiAttributes, Container container) ;

    CategoryAmbassadeur update(UIAttributes uiAttributes, Container container) ;

    void delete(CategoryAmbassadeur entity, Container container);

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container);

    void batchCreateFromImport(CategoryAmbassadeur entity, Container container);

    void batchUpdateFromImport(CategoryAmbassadeur transientEntity);

    // SERVICES
}
