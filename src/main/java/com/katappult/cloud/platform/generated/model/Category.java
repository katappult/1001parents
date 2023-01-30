package com.katappult.cloud.platform.generated.model;

import com.katappult.core.model.persistable.BusinessObject;
import com.katappult.core.model.persistable.Persistable;
import com.katappult.core.utils.UIAttribute;
import com.katappult.core.utils.UIFieldEditor;
import com.katappult.core.utils.common.TransferIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.*;
import java.io.Serializable;

import com.katappult.core.model.Boolean01Converter;
import java.lang.String;
// IMPORT


@Entity
@Table(name = "gen_category")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class Category extends BusinessObject implements Serializable {// KNOER

    private static final long serialVersionUID = 1L;

    private String nom;
    private String description;
    private String internalKey;
    private String groupKey;
    private Boolean active;
    private Integer displayOrder;
    // ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setNom(((Category)entity).getNom());
        setNom(((Category)entity).getNom());
        setDescription(((Category)entity).getDescription());
        setNom(((Category)entity).getNom());
        setDescription(((Category)entity).getDescription());
        setInternalKey(((Category)entity).getInternalKey());
        setNom(((Category)entity).getNom());
        setDescription(((Category)entity).getDescription());
        setInternalKey(((Category)entity).getInternalKey());
        setGroupKey(((Category)entity).getGroupKey());
        setNom(((Category)entity).getNom());
        setDescription(((Category)entity).getDescription());
        setInternalKey(((Category)entity).getInternalKey());
        setGroupKey(((Category)entity).getGroupKey());
        setActive(((Category)entity).getActive());
        setNom(((Category)entity).getNom());
        setDescription(((Category)entity).getDescription());
        setInternalKey(((Category)entity).getInternalKey());
        setGroupKey(((Category)entity).getGroupKey());
        setActive(((Category)entity).getActive());
        setDisplayOrder(((Category)entity).getDisplayOrder());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return Category.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_category_oid_seq", sequenceName="gen_category_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_category_oid_seq")
    @Column(columnDefinition = "serial", updatable = false)
    public Long getOid() {
        return super._getOid();
    }

    // GETTERS AND SETTERS
    @UIAttribute(fieldName = "nom", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @UIAttribute(fieldName = "description", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @UIAttribute(fieldName = "internalKey", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "internalkey")
    public String getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(String internalKey) {
        this.internalKey = internalKey;
    }

    @UIAttribute(fieldName = "groupKey", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "groupkey")
    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    @Convert(converter = Boolean01Converter.class)
    @UIAttribute(fieldName = "active", required = false, blankAllowed = true, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @UIAttribute(fieldName = "displayOrder", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "displayorder")
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }


}

