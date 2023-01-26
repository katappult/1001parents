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
import com.katappult.core.model.typed.ITypeManaged;
import com.katappult.core.model.typed.TypeInfo;
import com.katappult.core.model.typed.TypeManaged;

import com.katappult.core.model.lifecyclemanaged.ILifecycleManaged;
import com.katappult.core.model.lifecyclemanaged.LifecycleInfo;
// IMPORT


@Entity
@Table(name = "gen_webinar")
@Access(AccessType.PROPERTY)
@TypeManaged(rootType = "com.katappult.online.types.WebinarType")
// ANNOTATIONS
public class Webinar extends BusinessObject implements Serializable , ITypeManaged, ILifecycleManaged{// KNOER

    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private String category;
    private Date dateDePlanification;
    	private TypeInfo typeInfo;
private LifecycleInfo lifecycleInfo;
// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitle(((Webinar)entity).getTitle());
        setTitle(((Webinar)entity).getTitle());
        setDescription(((Webinar)entity).getDescription());
        setTitle(((Webinar)entity).getTitle());
        setDescription(((Webinar)entity).getDescription());
        setCategory(((Webinar)entity).getCategory());
        setTitle(((Webinar)entity).getTitle());
        setDescription(((Webinar)entity).getDescription());
        setCategory(((Webinar)entity).getCategory());
        setDateDePlanification(((Webinar)entity).getDateDePlanification());
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

    @UIAttribute(fieldName = "category", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

