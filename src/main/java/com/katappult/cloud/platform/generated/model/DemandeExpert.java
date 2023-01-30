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
import com.katappult.core.model.account.UserAccount;
// IMPORT


@Entity
@Table(name = "gen_demandeexpert")
@Access(AccessType.PROPERTY)
@TypeManaged(rootType = "com.katappult.online.types.DemandeExpertType")
// ANNOTATIONS
public class DemandeExpert extends BusinessObject implements Serializable , IContentHolder, ITypeManaged, ILifecycleManaged{// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String description;
    private Date planificationDate;
    private ContentInfo contentInfo;
	private TypeInfo typeInfo;
private LifecycleInfo lifecycleInfo;
	private UserAccount userAccount;
    private Category category;

// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((DemandeExpert)entity).getTitre());
        setTitre(((DemandeExpert)entity).getTitre());
        setDescription(((DemandeExpert)entity).getDescription());
        setTitre(((DemandeExpert)entity).getTitre());
        setDescription(((DemandeExpert)entity).getDescription());
        setPlanificationDate(((DemandeExpert)entity).getPlanificationDate());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return DemandeExpert.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_demandeexpert_oid_seq", sequenceName="gen_demandeexpert_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_demandeexpert_oid_seq")
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

		@TransferIgnore
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "one_toone_useraccount_fk_oid", nullable = true)
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(final UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    @TransferIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "manytoone_category_fk_oid", nullable = true)
    public Category getCategory() {
        return category;
    }


    public void setCategory(final Category category) {
        this.category = category;
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

    @UIAttribute(fieldName = "planificationDate", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "planificationdate")
    public Date getPlanificationDate() {
        return planificationDate;
    }

    public void setPlanificationDate(Date planificationDate) {
        this.planificationDate = planificationDate;
    }


}

