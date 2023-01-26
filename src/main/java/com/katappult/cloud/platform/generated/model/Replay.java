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
@Table(name = "gen_replay")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class Replay extends BusinessObject implements Serializable {// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String mediaType;
    private String category;
    private String description;
    private String externalLink;
    // ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((Replay)entity).getTitre());
        setTitre(((Replay)entity).getTitre());
        setMediaType(((Replay)entity).getMediaType());
        setTitre(((Replay)entity).getTitre());
        setMediaType(((Replay)entity).getMediaType());
        setCategory(((Replay)entity).getCategory());
        setTitre(((Replay)entity).getTitre());
        setMediaType(((Replay)entity).getMediaType());
        setCategory(((Replay)entity).getCategory());
        setDescription(((Replay)entity).getDescription());
        setTitre(((Replay)entity).getTitre());
        setMediaType(((Replay)entity).getMediaType());
        setCategory(((Replay)entity).getCategory());
        setDescription(((Replay)entity).getDescription());
        setExternalLink(((Replay)entity).getExternalLink());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return Replay.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_replay_oid_seq", sequenceName="gen_replay_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_replay_oid_seq")
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

    @UIAttribute(fieldName = "description", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @UIAttribute(fieldName = "externalLink", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "externallink")
    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }


}

