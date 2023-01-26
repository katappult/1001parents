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
@Table(name = "gen_credit")
@Access(AccessType.PROPERTY)
// ANNOTATIONS
public class Credit extends BusinessObject implements Serializable , INumberable{// KNOER

    private static final long serialVersionUID = 1L;

    private Integer total;
    private Integer consommed;
    private String category;
    	private String number = "";
// ATTRIBUTES


    @Override
    public void updateFrom(Persistable entity) {
        super.updateFrom(entity);
        setTotal(((Credit)entity).getTotal());
        setTotal(((Credit)entity).getTotal());
        setConsommed(((Credit)entity).getConsommed());
        setTotal(((Credit)entity).getTotal());
        setConsommed(((Credit)entity).getConsommed());
        setCategory(((Credit)entity).getCategory());
        // UPDATE_ATTRIBUTES
    }

    @Override
    @Transient
    public Class<?> getDomainClass() {
        return Credit.class;
    }


    @Id
    @Override
    @SequenceGenerator(name="gen_credit_oid_seq", sequenceName="gen_credit_oid_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_credit_oid_seq")
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
    @UIAttribute(fieldName = "total", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "total")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @UIAttribute(fieldName = "consommed", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "consommed")
    public Integer getConsommed() {
        return consommed;
    }

    public void setConsommed(Integer consommed) {
        this.consommed = consommed;
    }

    @UIAttribute(fieldName = "category", required = false, blankAllowed = false, fieldEditor = UIFieldEditor.TEXT_FIELD)
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}

