package com.katappult.cloud.platform.generated.model;

import com.katappult.core.model.composite.Container;
import com.katappult.core.model.composite.ContainerInfoFactory;
import com.katappult.core.model.persistable.BusinessObject;

import java.util.*;

import javax.persistence.*;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.katappult.core.model.account.UserAccount;
//IMPORT

@Entity
@Table(name = "MANY_TO_MANY_WEBINAR_USERACCOUNT_LINK")
@Cacheable(true)
@Access(AccessType.FIELD)
public class WebinarToUserAccountLink extends BusinessObject {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WebinarToUserAccountLinkId id;

    @ManyToOne
    @JoinColumn(name = "roleAid", insertable = false, updatable = false)
    private Webinar roleA;

    @ManyToOne
    @JoinColumn(name = "roleBid", insertable = false, updatable = false)
    private UserAccount roleB;

    // ATTRIBUTES

    public WebinarToUserAccountLink(){
    }

    public WebinarToUserAccountLink(Webinar roleA, UserAccount roleB, Container container) {
        setRoleA(roleA);
        setRoleB(roleB);
        setContainerInfo(ContainerInfoFactory.createContainerInfo(container));
        id = new WebinarToUserAccountLinkId(roleA, roleB, container);
    }

    public Webinar getRoleA() {
        return roleA;
    }

    public Class<Webinar> getRoleADomainClass() {
        return Webinar.class;
    }

    public void setRoleA(final Webinar Webinar) {
        this.roleA = roleA;
    }

    public UserAccount getRoleB() {
        return roleB;
    }

    public Class<UserAccount> getRoleBDomainClass() {
        return UserAccount.class;
    }

    public void setRoleB(final UserAccount UserAccount) {
        this.roleB = roleB;
    }

    public Class getDomainClass() {
        return WebinarToUserAccountLink.class;
    }

    public WebinarToUserAccountLinkId getId() {
        return id;
    }

    public void setId(final WebinarToUserAccountLinkId id) {
        this.id = id;
    }

    // GETTERS AND SETTERS


}

