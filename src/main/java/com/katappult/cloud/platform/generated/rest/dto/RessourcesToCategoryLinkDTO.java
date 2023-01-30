package com.katappult.cloud.platform.generated.rest.dto;

import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.RessourcesToCategoryLink;
import java.util.*;

//IMPORT

public class RessourcesToCategoryLinkDTO {

    private Long roleAId;
    private Long roleBId;
    private String roleAFullId;
    private String roleBFullId;

    // ATTRIBUTES


    public RessourcesToCategoryLinkDTO(){

    }

    public RessourcesToCategoryLinkDTO(final Category roleB, final RessourcesToCategoryLink link){
        // UPDATE_ATTRIBUTES
    }

    public static Object from(final Category roleB, final RessourcesToCategoryLink link) {
        RessourcesToCategoryLinkDTO dto = new RessourcesToCategoryLinkDTO(roleB, link);
        return dto;
    }

    public Long getRoleAId() {
        return roleAId;
    }

    public void setRoleAId(final Long roleAId) {
        this.roleAId = roleAId;
    }

    public Long getRoleBId() {
        return roleBId;
    }

    public void setRoleBId(final Long roleBId) {
        this.roleBId = roleBId;
    }

    public String getRoleAFullId() {
        return roleAFullId;
    }

    public void setRoleAFullId(final String roleAFullId) {
        this.roleAFullId = roleAFullId;
    }

    public String getRoleBFullId() {
        return roleBFullId;
    }

    public void setRoleBFullId(final String roleBFullId) {
        this.roleBFullId = roleBFullId;
    }

    // GETTERS AND SETTERS
}
