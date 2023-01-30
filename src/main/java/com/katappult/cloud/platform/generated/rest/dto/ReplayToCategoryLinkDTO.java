package com.katappult.cloud.platform.generated.rest.dto;

import com.katappult.cloud.platform.generated.model.Category;
import com.katappult.cloud.platform.generated.model.ReplayToCategoryLink;
import java.util.*;

//IMPORT

public class ReplayToCategoryLinkDTO {

    private Long roleAId;
    private Long roleBId;
    private String roleAFullId;
    private String roleBFullId;

    // ATTRIBUTES


    public ReplayToCategoryLinkDTO(){

    }

    public ReplayToCategoryLinkDTO(final Category roleB, final ReplayToCategoryLink link){
        // UPDATE_ATTRIBUTES
    }

    public static Object from(final Category roleB, final ReplayToCategoryLink link) {
        ReplayToCategoryLinkDTO dto = new ReplayToCategoryLinkDTO(roleB, link);
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
