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
@Table(name = "gen_webinar")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class Webinar extends BusinessObject implements Serializable {// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String description;
    private String mediaType;
    private String category;
    private Date datePlanified;
    // ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((Webinar)entity).getTitre());
        setTitre(((Webinar)entity).getTitre());
        setDescription(((Webinar)entity).getDescription());
        setTitre(((Webinar)entity).getTitre());
        setDescription(((Webinar)entity).getDescription());
        setMediaType(((Webinar)entity).getMediaType());
        setTitre(((Webinar)entity).getTitre());
        setDescription(((Webinar)entity).getDescription());
        setMediaType(((Webinar)entity).getMediaType());
        setCategory(((Webinar)entity).getCategory());
        setTitre(((Webinar)entity).getTitre());
        setDescription(((Webinar)entity).getDescription());
        setMediaType(((Webinar)entity).getMediaType());
        setCategory(((Webinar)entity).getCategory());
        setDatePlanified(((Webinar)entity).getDatePlanified());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return Webinar.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_webinar_oid_seq", sequenceName="gen_webinar_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_webinar_oid_seq")
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

    @UIAttribute(fieldName = "description", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @UIAttribute(fieldName = "mediaType", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "mediatype")
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @UIAttribute(fieldName = "category", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @UIAttribute(fieldName = "datePlanified", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "dateplanified")
    public Date getDatePlanified() {
        return datePlanified;
    }

    public void setDatePlanified(Date datePlanified) {
        this.datePlanified = datePlanified;
    }


}

