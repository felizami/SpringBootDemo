/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anuz
 */
@Entity
@Table(name = "contents")
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "content_id")
    private Integer contentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "content_type")
    private String contentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "content_location")
    private String contentLocation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valid_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validDate;

    public Content() {
    }

    public Content(Integer contentId) {
        this.contentId = contentId;
    }

    public Content(Integer contentId, String title, String description, String contentType, String contentLocation, Date validDate) {
        this.contentId = contentId;
        this.title = title;
        this.description = description;
        this.contentType = contentType;
        this.contentLocation = contentLocation;
        this.validDate = validDate;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLocation() {
        return contentLocation;
    }

    public void setContentLocation(String contentLocation) {
        this.contentLocation = contentLocation;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contentId != null ? contentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content)) {
            return false;
        }
        Content other = (Content) object;
        if ((this.contentId == null && other.contentId != null) || (this.contentId != null && !this.contentId.equals(other.contentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anuz.dummyapi.entity.Content[ contentId=" + contentId + " ]";
    }
    
}
