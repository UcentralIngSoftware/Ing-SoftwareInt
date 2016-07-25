/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuaUsua", query = "SELECT u FROM Usuario u WHERE u.usuaUsua = :usuaUsua"),
    @NamedQuery(name = "Usuario.findByUsuaUser", query = "SELECT u FROM Usuario u WHERE u.usuaUser = :usuaUser"),
    @NamedQuery(name = "Usuario.findByUsuaPass", query = "SELECT u FROM Usuario u WHERE u.usuaPass = :usuaPass"),
    @NamedQuery(name = "Usuario.findByUsuaPerfil", query = "SELECT u FROM Usuario u WHERE u.usuaPerfil = :usuaPerfil"),
    @NamedQuery(name = "Usuario.findByUsuaEstado", query = "SELECT u FROM Usuario u WHERE u.usuaEstado = :usuaEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usua_usua", nullable = false)
    private Integer usuaUsua;
    @Size(max = 45)
    @Column(name = "usua_user", length = 45)
    private String usuaUser;
    @Size(max = 45)
    @Column(name = "usua_pass", length = 45)
    private String usuaPass;
    @Size(max = 45)
    @Column(name = "usua_perfil", length = 45)
    private String usuaPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usua_estado", nullable = false, length = 45)
    private String usuaEstado;
    @JoinColumn(name = "usua_pers", referencedColumnName = "pers_pers", nullable = false)
    @ManyToOne(optional = false)
    private Persona usuaPers;

    public Usuario() {
    }

    public Usuario(Integer usuaUsua) {
        this.usuaUsua = usuaUsua;
    }

    public Usuario(Integer usuaUsua, String usuaEstado) {
        this.usuaUsua = usuaUsua;
        this.usuaEstado = usuaEstado;
    }

    public Integer getUsuaUsua() {
        return usuaUsua;
    }

    public void setUsuaUsua(Integer usuaUsua) {
        this.usuaUsua = usuaUsua;
    }

    public String getUsuaUser() {
        return usuaUser;
    }

    public void setUsuaUser(String usuaUser) {
        this.usuaUser = usuaUser;
    }

    public String getUsuaPass() {
        return usuaPass;
    }

    public void setUsuaPass(String usuaPass) {
        this.usuaPass = usuaPass;
    }

    public String getUsuaPerfil() {
        return usuaPerfil;
    }

    public void setUsuaPerfil(String usuaPerfil) {
        this.usuaPerfil = usuaPerfil;
    }

    public String getUsuaEstado() {
        return usuaEstado;
    }

    public void setUsuaEstado(String usuaEstado) {
        this.usuaEstado = usuaEstado;
    }

    public Persona getUsuaPers() {
        return usuaPers;
    }

    public void setUsuaPers(Persona usuaPers) {
        this.usuaPers = usuaPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuaUsua != null ? usuaUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuaUsua == null && other.usuaUsua != null) || (this.usuaUsua != null && !this.usuaUsua.equals(other.usuaUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Usuario[ usuaUsua=" + usuaUsua + " ]";
    }
    
}
