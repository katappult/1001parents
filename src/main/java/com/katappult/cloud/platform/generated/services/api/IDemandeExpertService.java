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
import com.katappult.cloud.platform.generated.model.ExpertCategory;
import com.katappult.core.model.account.UserAccount;
// IMPORT

public interface IDemandeExpertService {

    DemandeExpert create(UIAttributes uiAttributes, Container container) ;

    DemandeExpert update(UIAttributes uiAttributes, Container container) ;

    void delete(DemandeExpert entity, Container container);

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container);

    void batchCreateFromImport(DemandeExpert entity, Container container);

    void batchUpdateFromImport(DemandeExpert transientEntity);

    
    void setExpertCategory(DemandeExpert entity, ExpertCategory roleB, Container container);

    ExpertCategory getExpertCategory(DemandeExpert entity, Container container);

    void removeExpertCategory(DemandeExpert entity, ExpertCategory roleB, Container container);

    DemandeExpert getInverseOneToOneExpertCategory(ExpertCategory entity, Container container);


    void setUserAccount(DemandeExpert entity, UserAccount roleB, Container container);

    UserAccount getUserAccount(DemandeExpert entity, Container container);

    void removeUserAccount(DemandeExpert entity, UserAccount roleB, Container container);

    DemandeExpert getInverseOneToOneUserAccount(UserAccount entity, Container container);

// SERVICES
}
