package com.katappult.cloud.platform.generated.model;

import com.katappult.core.model.composite.Container;
import com.katappult.core.model.composite.ContainerInfoFactory;
import com.katappult.core.model.persistable.BusinessObject;

import java.util.*;

import javax.persistence.*;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.katappult.cloud.platform.generated.model.Category;
//IMPORT

@Entity
@Table(name = "MANY_TO_MANY_WEBINAR_CATEGORY_LINK")
@Cacheable(true)
@Access(AccessType.FIELD)
public class WebinarToCategoryLink extends BusinessObject {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WebinarToCategoryLinkId id;

    @ManyToOne
    @JoinColumn(name = "roleAid", insertable = false, updatable = false)
    private Webinar roleA;

    @ManyToOne
    @JoinColumn(name = "roleBid", insertable = false, updatable = false)
    private Category roleB;

    // ATTRIBUTES

    public WebinarToCategoryLink(){
    }

    public WebinarToCategoryLink(Webinar roleA, Category roleB, Container container) {
        setRoleA(roleA);
        setRoleB(roleB);
        setContainerInfo(ContainerInfoFactory.createContainerInfo(container));
        id = new WebinarToCategoryLinkId(roleA, roleB, container);
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

    public Category getRoleB() {
        return roleB;
    }

    public Class<Category> getRoleBDomainClass() {
        return Category.class;
    }

    public void setRoleB(final Category Category) {
        this.roleB = roleB;
    }

    public Class getDomainClass() {
        return WebinarToCategoryLink.class;
    }

    public WebinarToCategoryLinkId getId() {
        return id;
    }

    public void setId(final WebinarToCategoryLinkId id) {
        this.id = id;
    }

    // GETTERS AND SETTERS


}

