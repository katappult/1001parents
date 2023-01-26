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
import com.katappult.cloud.platform.generated.model.AgentFacilitateurCategory;
import com.katappult.core.model.account.UserAccount;
// IMPORT

public interface IDemandeAgentService {

    DemandeAgent create(UIAttributes uiAttributes, Container container) ;

    DemandeAgent update(UIAttributes uiAttributes, Container container) ;

    void delete(DemandeAgent entity, Container container);

    PageResult list(PageRequest pageRequest, Container container, Map<String, String> params);

    PageResult searchByNameLike(String searchTerm, PageRequest pageRequest, Container container);

    void batchCreateFromImport(DemandeAgent entity, Container container);

    void batchUpdateFromImport(DemandeAgent transientEntity);

    
    void setAgentFacilitateurCategory(DemandeAgent entity, AgentFacilitateurCategory roleB, Container container);

    AgentFacilitateurCategory getAgentFacilitateurCategory(DemandeAgent entity, Container container);

    void removeAgentFacilitateurCategory(DemandeAgent entity, AgentFacilitateurCategory roleB, Container container);

    DemandeAgent getInverseOneToOneAgentFacilitateurCategory(AgentFacilitateurCategory entity, Container container);


    void setUserAccount(DemandeAgent entity, UserAccount roleB, Container container);

    UserAccount getUserAccount(DemandeAgent entity, Container container);

    void removeUserAccount(DemandeAgent entity, UserAccount roleB, Container container);

    DemandeAgent getInverseOneToOneUserAccount(UserAccount entity, Container container);

// SERVICES
}
