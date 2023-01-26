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

import java.lang.String;
// IMPORT


@Entity
@Table(name = "gen_ambassadeurcategory")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class AmbassadeurCategory extends BusinessObject implements Serializable {// KNOER

    private static final long serialVersionUID = 1L;

    private String nom;
    // ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setNom(((AmbassadeurCategory)entity).getNom());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return AmbassadeurCategory.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_ambassadeurcategory_oid_seq", sequenceName="gen_ambassadeurcategory_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_ambassadeurcategory_oid_seq")
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


}

