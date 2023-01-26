package com.katappult.cloud.platform.generated.model;

import com.katappult.core.model.composite.Container;

import javax.persistence.Embeddable;
import java.io.Serializable;

import com.katappult.core.model.account.UserAccount;
//IMPORT

@Embeddable
public class WebinarToUserAccountLinkId implements Serializable {

    private Long roleAId;
    private Long roleBId;

    public WebinarToUserAccountLinkId(){

    }

    public WebinarToUserAccountLinkId(Webinar roleA, UserAccount roleB, Container container) {
        setRoleAId(roleA.getOid());
        setRoleBId(roleB.getOid());
    }

    public Long getRoleAId() {
        return roleAId;
    }

    public void setRoleAId(Long roleAId) {
        this.roleAId = roleAId;
    }

    public Long getRoleBId() {
        return roleBId;
    }

    public void setRoleBId(Long roleBId) {
        this.roleBId = roleBId;
    }
}
