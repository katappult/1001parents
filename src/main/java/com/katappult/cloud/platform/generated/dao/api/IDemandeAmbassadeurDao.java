package com.katappult.cloud.platform.generated.dao.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.model.DemandeAmbassadeur;
import java.util.Map;
import com.katappult.cloud.platform.generated.model.*;
import com.katappult.cloud.platform.generated.model.Category;
// IMPORT

public interface IDemandeAmbassadeurDao {

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    boolean existWithName(String name, Container container);

    PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container);


    PageResult searchCategoryEntity(final DemandeAmbassadeur roleA, final String searchTerm, PageRequest pageRequest, Container container);

// DAO
}
