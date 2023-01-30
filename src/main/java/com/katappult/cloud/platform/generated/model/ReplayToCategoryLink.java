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
@Table(name = "MANY_TO_MANY_REPLAY_CATEGORY_LINK")
@Cacheable(true)
@Access(AccessType.FIELD)
public class ReplayToCategoryLink extends BusinessObject {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ReplayToCategoryLinkId id;

    @ManyToOne
    @JoinColumn(name = "roleAid", insertable = false, updatable = false)
    private Replay roleA;

    @ManyToOne
    @JoinColumn(name = "roleBid", insertable = false, updatable = false)
    private Category roleB;

    // ATTRIBUTES

    public ReplayToCategoryLink(){
    }

    public ReplayToCategoryLink(Replay roleA, Category roleB, Container container) {
        setRoleA(roleA);
        setRoleB(roleB);
        setContainerInfo(ContainerInfoFactory.createContainerInfo(container));
        id = new ReplayToCategoryLinkId(roleA, roleB, container);
    }

    public Replay getRoleA() {
        return roleA;
    }

    public Class<Replay> getRoleADomainClass() {
        return Replay.class;
    }

    public void setRoleA(final Replay Replay) {
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
        return ReplayToCategoryLink.class;
    }

    public ReplayToCategoryLinkId getId() {
        return id;
    }

    public void setId(final ReplayToCategoryLinkId id) {
        this.id = id;
    }

    // GETTERS AND SETTERS


}

