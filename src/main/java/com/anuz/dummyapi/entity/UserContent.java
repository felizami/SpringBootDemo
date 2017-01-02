/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anuz
 */
@Entity
@Table(name = "user_content_status")

public class UserContent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "content_status_id")
    private Integer userContentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_content_id")
    private int lastContentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public UserContent() {
    }

    public UserContent(Integer ucId) {
        this.userContentId = ucId;
    }

    public UserContent(Integer ucId, int lastContentId, boolean status) {
        this.userContentId = ucId;
        this.lastContentId = lastContentId;
        this.status = status;
    }

    public Integer getUserContentId() {
        return userContentId;
    }

    public void setUserContentId(Integer userContentId) {
        this.userContentId = userContentId;
    }

    public int getLastContentId() {
        return lastContentId;
    }

    public void setLastContentId(int lastContentId) {
        this.lastContentId = lastContentId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userContentId != null ? userContentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserContent)) {
            return false;
        }
        UserContent other = (UserContent) object;
        if ((this.userContentId == null && other.userContentId != null) || (this.userContentId != null && !this.userContentId.equals(other.userContentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anuz.dummyapi.entity.UserContentStatus[ ucId=" + userContentId + " ]";
    }
    
}
