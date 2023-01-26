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
import com.katappult.cloud.platform.generated.model.AgentFacilitateurCategory;
import com.katappult.core.model.account.UserAccount;
// IMPORT


@Entity
@Table(name = "gen_demandeagent")
@Access(AccessType.PROPERTY)
@TypeManaged(rootType = "com.katappult.online.types.DemandeAgentType")
// ANNOTATIONS
public class DemandeAgent extends BusinessObject implements Serializable , ITypeManaged, ILifecycleManaged{// KNOER

    private static final long serialVersionUID = 1L;

    private String titre;
    private String description;
    	private TypeInfo typeInfo;
private LifecycleInfo lifecycleInfo;
	private AgentFacilitateurCategory onetooneAgentFacilitateurCategory;
	private UserAccount userAccount;
// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTitre(((DemandeAgent)entity).getTitre());
        setTitre(((DemandeAgent)entity).getTitre());
        setDescription(((DemandeAgent)entity).getDescription());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return DemandeAgent.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_demandeagent_oid_seq", sequenceName="gen_demandeagent_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_demandeagent_oid_seq")
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

		@TransferIgnore
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "one_toone_agentfacilitateurcategory_fk_oid", nullable = true)
    public AgentFacilitateurCategory getAgentFacilitateurCategory() {
        return onetooneAgentFacilitateurCategory;
    }

    public void setAgentFacilitateurCategory(final AgentFacilitateurCategory onetooneAgentFacilitateurCategory) {
        this.onetooneAgentFacilitateurCategory = onetooneAgentFacilitateurCategory;
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


}

