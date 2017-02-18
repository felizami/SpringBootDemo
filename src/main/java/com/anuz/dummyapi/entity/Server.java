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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anuz
 */
@Entity
@Table(name = "servers")
public class Server implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "server_id")
    private Integer serverId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "server_name")
    private String serverName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IP")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;
     

    public Server() {
    }

    public Server(Integer serverId) {
        this.serverId = serverId;
    }

    public Server(Integer serverId, String serverName, String ip, String location) {
        this.serverId = serverId;
        this.serverName = serverName;
        this.ip = ip;
        this.location = location;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serverId != null ? serverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Server)) {
            return false;
        }
        Server other = (Server) object;
        if ((this.serverId == null && other.serverId != null) || (this.serverId != null && !this.serverId.equals(other.serverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anuz.dummyapi.entity.Server[ serverId=" + serverId + " ]";
    }
    
}
