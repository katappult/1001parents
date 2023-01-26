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
@Table(name = "gen_demandeagentfacilitateur")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class DemandeAgentFacilitateur extends BusinessObject implements Serializable {// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String theme;
    private String description;
    private Date datePlanification;
    // ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((DemandeAgentFacilitateur)entity).getTitre());
        setTitre(((DemandeAgentFacilitateur)entity).getTitre());
        setTheme(((DemandeAgentFacilitateur)entity).getTheme());
        setTitre(((DemandeAgentFacilitateur)entity).getTitre());
        setTheme(((DemandeAgentFacilitateur)entity).getTheme());
        setDescription(((DemandeAgentFacilitateur)entity).getDescription());
        setTitre(((DemandeAgentFacilitateur)entity).getTitre());
        setTheme(((DemandeAgentFacilitateur)entity).getTheme());
        setDescription(((DemandeAgentFacilitateur)entity).getDescription());
        setDatePlanification(((DemandeAgentFacilitateur)entity).getDatePlanification());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return DemandeAgentFacilitateur.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_demandeagentfacilitateur_oid_seq", sequenceName="gen_demandeagentfacilitateur_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_demandeagentfacilitateur_oid_seq")
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

    @UIAttribute(fieldName = "datePlanification", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "dateplanification")
    public Date getDatePlanification() {
        return datePlanification;
    }

    public void setDatePlanification(Date datePlanification) {
        this.datePlanification = datePlanification;
    }


}

