package com.katappult.cloud.platform.generated.rest.dto;

import com.katappult.core.model.account.UserAccount;
import com.katappult.cloud.platform.generated.model.WebinarToUserAccountLink;
import java.util.*;

//IMPORT

public class WebinarToUserAccountLinkDTO {

    private Long roleAId;
    private Long roleBId;
    private String roleAFullId;
    private String roleBFullId;

    // ATTRIBUTES


    public WebinarToUserAccountLinkDTO(){

    }

    public WebinarToUserAccountLinkDTO(final UserAccount roleB, final WebinarToUserAccountLink link){
        // UPDATE_ATTRIBUTES
    }

    public static Object from(final UserAccount roleB, final WebinarToUserAccountLink link) {
        WebinarToUserAccountLinkDTO dto = new WebinarToUserAccountLinkDTO(roleB, link);
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
