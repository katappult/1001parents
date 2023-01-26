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

import com.katappult.core.model.contentHolder.IContentHolder;
import com.katappult.core.model.contentHolder.ContentInfo;
import com.katappult.core.model.typed.ITypeManaged;
import com.katappult.core.model.typed.TypeInfo;
import com.katappult.core.model.typed.TypeManaged;

import com.katappult.core.model.lifecyclemanaged.ILifecycleManaged;
import com.katappult.core.model.lifecyclemanaged.LifecycleInfo;
// IMPORT


@Entity
@Table(name = "gen_ressources")
@Access(AccessType.PROPERTY)
@TypeManaged(rootType = "com.katappult.online.types.RessourcesType")
// ANNOTATIONS
public class Ressources extends BusinessObject implements Serializable , IContentHolder, ITypeManaged, ILifecycleManaged{// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String description;
    private String url;
    private String mediaType;
    private ContentInfo contentInfo;
	private TypeInfo typeInfo;
private LifecycleInfo lifecycleInfo;
// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((Ressources)entity).getTitre());
        setTitre(((Ressources)entity).getTitre());
        setDescription(((Ressources)entity).getDescription());
        setTitre(((Ressources)entity).getTitre());
        setDescription(((Ressources)entity).getDescription());
        setUrl(((Ressources)entity).getUrl());
        setTitre(((Ressources)entity).getTitre());
        setDescription(((Ressources)entity).getDescription());
        setUrl(((Ressources)entity).getUrl());
        setMediaType(((Ressources)entity).getMediaType());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return Ressources.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_ressources_oid_seq", sequenceName="gen_ressources_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_ressources_oid_seq")
    @Column(columnDefinition = "serial", updatable = false)
    public Long getOid() {
        return super._getOid();
    }

    
	@Embedded
    @Override
    public ContentInfo getContentInfo() {
        return contentInfo;
    }

    @Override
    public void setContentInfo(ContentInfo contentInfo) {
        this.contentInfo = contentInfo;
    }

	@Embedded
    @Override
    public TypeInfo getTypeInfo() {
        return typeInfo;
    }

    @Override
    public void setTypeInfo(TypeInfo typeInfo) {
        this.typeInfo = typeInfo;
    }

	@Embedded
    @Override
    public LifecycleInfo getLifecycleInfo() {
        return lifecycleInfo;
    }

    @Override
    public void setLifecycleInfo(LifecycleInfo lifecycleInfo) {
        this.lifecycleInfo = lifecycleInfo;
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

    @UIAttribute(fieldName = "url", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @UIAttribute(fieldName = "mediaType", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "mediatype")
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }


}

