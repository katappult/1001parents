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


@javax.persistence.Entity
@Table(name = "gen_demandeambassadeur")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class DemandeAmbassadeur extends BusinessObject implements Serializable {// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String theme;
    private String description;
    private Date dateDePlanification;
    // ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((DemandeAmbassadeur)entity).getTitre());
        setTitre(((DemandeAmbassadeur)entity).getTitre());
        setTheme(((DemandeAmbassadeur)entity).getTheme());
        setTitre(((DemandeAmbassadeur)entity).getTitre());
        setTheme(((DemandeAmbassadeur)entity).getTheme());
        setDescription(((DemandeAmbassadeur)entity).getDescription());
        setTitre(((DemandeAmbassadeur)entity).getTitre());
        setTheme(((DemandeAmbassadeur)entity).getTheme());
        setDescription(((DemandeAmbassadeur)entity).getDescription());
        setDateDePlanification(((DemandeAmbassadeur)entity).getDateDePlanification());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return DemandeAmbassadeur.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_demandeambassadeur_oid_seq", sequenceName="gen_demandeambassadeur_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_demandeambassadeur_oid_seq")
    @Column(columnDefinition = "serial", updatable = false)
    public Long getOid() {
        return super._getOid();
    }

    // GETTERS AND SETTERS
    @UIAttribute(fieldName = "titre", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @UIAttribute(fieldName = "theme", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "theme")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @UIAttribute(fieldName = "description", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @UIAttribute(fieldName = "dateDePlanification", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "datedeplanification")
    public Date getDateDePlanification() {
        return dateDePlanification;
    }

    public void setDateDePlanification(Date dateDePlanification) {
        this.dateDePlanification = dateDePlanification;
    }


}

