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
import com.katappult.core.model.numberable.INumberable;
// IMPORT


@javax.persistence.Entity
@Table(name = "gen_categoryambassadeur")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class CategoryAmbassadeur extends BusinessObject implements Serializable , INumberable{// KNOER

    private static final long serialVersionUID = 1L;

    private String nom;
    private String description;
    	private String number = "";
// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setNom(((CategoryAmbassadeur)entity).getNom());
        setNom(((CategoryAmbassadeur)entity).getNom());
        setDescription(((CategoryAmbassadeur)entity).getDescription());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return CategoryAmbassadeur.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_categoryambassadeur_oid_seq", sequenceName="gen_categoryambassadeur_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_categoryambassadeur_oid_seq")
    @Column(columnDefinition = "serial", updatable = false)
    public Long getOid() {
        return super._getOid();
    }

    	
@Override
    @Column(name = "number", nullable = true, length = 40, unique = true)
    public String getNumber() {
        return number;
    }


    @Override
    public void setNumber(final String number) {
        this.number = number;
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


}

