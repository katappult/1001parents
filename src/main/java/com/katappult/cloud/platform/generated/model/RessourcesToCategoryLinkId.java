package com.katappult.cloud.platform.generated.model;

import com.katappult.core.model.composite.Container;

import javax.persistence.Embeddable;
import java.io.Serializable;

import com.katappult.cloud.platform.generated.model.Category;
//IMPORT

@Embeddable
public class RessourcesToCategoryLinkId implements Serializable {

    private Long roleAId;
    private Long roleBId;

    public RessourcesToCategoryLinkId(){

    }

    public RessourcesToCategoryLinkId(Ressources roleA, Category roleB, Container container) {
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
