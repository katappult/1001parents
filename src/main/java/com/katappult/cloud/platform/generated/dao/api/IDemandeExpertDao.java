package com.katappult.cloud.platform.generated.dao.api;

import com.katappult.core.utils.pagination.PageRequest;
import com.katappult.core.utils.pagination.PageResult;
import com.katappult.core.model.composite.Container;
import com.katappult.cloud.platform.generated.model.DemandeExpert;
import java.util.Map;
import com.katappult.cloud.platform.generated.model.*;
import com.katappult.cloud.platform.generated.model.Category;
// IMPORT

public interface IDemandeExpertDao {

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    boolean existWithName(String name, Container container);

    PageResult searchByNamelike(String searchTerm, PageRequest pageRequest, Container container);


    PageResult searchCategoryEntity(final DemandeExpert roleA, final String searchTerm, PageRequest pageRequest, Container container);

// DAO
}
