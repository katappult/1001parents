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
@Table(name = "MANY_TO_MANY_RESSOURCES_CATEGORY_LINK")
@Cacheable(true)
@Access(AccessType.FIELD)
public class RessourcesToCategoryLink extends BusinessObject {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RessourcesToCategoryLinkId id;

    @ManyToOne
    @JoinColumn(name = "roleAid", insertable = false, updatable = false)
    private Ressources roleA;

    @ManyToOne
    @JoinColumn(name = "roleBid", insertable = false, updatable = false)
    private Category roleB;

    // ATTRIBUTES

    public RessourcesToCategoryLink(){
    }

    public RessourcesToCategoryLink(Ressources roleA, Category roleB, Container container) {
        setRoleA(roleA);
        setRoleB(roleB);
        setContainerInfo(ContainerInfoFactory.createContainerInfo(container));
        id = new RessourcesToCategoryLinkId(roleA, roleB, container);
    }

    public Ressources getRoleA() {
        return roleA;
    }

    public Class<Ressources> getRoleADomainClass() {
        return Ressources.class;
    }

    public void setRoleA(final Ressources Ressources) {
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
        return RessourcesToCategoryLink.class;
    }

    public RessourcesToCategoryLinkId getId() {
        return id;
    }

    public void setId(final RessourcesToCategoryLinkId id) {
        this.id = id;
    }

    // GETTERS AND SETTERS


}

