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
@Table(name = "gen_replay")
@Access(AccessType.PROPERTY)
@TypeManaged(rootType = "com.katappult.online.types.ReplayType")
// ANNOTATIONS
public class Replay extends BusinessObject implements Serializable , IContentHolder, ITypeManaged, ILifecycleManaged{// KNOER

    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private String mediaType;
    private String externalLink;
    private String webinarSource;
    private Integer stars;
    private ContentInfo contentInfo;
	private TypeInfo typeInfo;
private LifecycleInfo lifecycleInfo;
// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitle(((Replay)entity).getTitle());
        setTitle(((Replay)entity).getTitle());
        setDescription(((Replay)entity).getDescription());
        setTitle(((Replay)entity).getTitle());
        setDescription(((Replay)entity).getDescription());
        setMediaType(((Replay)entity).getMediaType());
        setTitle(((Replay)entity).getTitle());
        setDescription(((Replay)entity).getDescription());
        setMediaType(((Replay)entity).getMediaType());
        setExternalLink(((Replay)entity).getExternalLink());
        setTitle(((Replay)entity).getTitle());
        setDescription(((Replay)entity).getDescription());
        setMediaType(((Replay)entity).getMediaType());
        setExternalLink(((Replay)entity).getExternalLink());
        setWebinarSource(((Replay)entity).getWebinarSource());
        setTitle(((Replay)entity).getTitle());
        setDescription(((Replay)entity).getDescription());
        setMediaType(((Replay)entity).getMediaType());
        setExternalLink(((Replay)entity).getExternalLink());
        setWebinarSource(((Replay)entity).getWebinarSource());
        setStars(((Replay)entity).getStars());
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
    @UIAttribute(fieldName = "title", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @UIAttribute(fieldName = "externalLink", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "externallink")
    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    @UIAttribute(fieldName = "webinarSource", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "webinarsource")
    public String getWebinarSource() {
        return webinarSource;
    }

    public void setWebinarSource(String webinarSource) {
        this.webinarSource = webinarSource;
    }

    @UIAttribute(fieldName = "stars", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "stars")
    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }


}

