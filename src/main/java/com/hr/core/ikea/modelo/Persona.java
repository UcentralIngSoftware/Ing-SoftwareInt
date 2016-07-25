/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPersPers", query = "SELECT p FROM Persona p WHERE p.persPers = :persPers"),
    @NamedQuery(name = "Persona.findByPersNombre", query = "SELECT p FROM Persona p WHERE p.persNombre = :persNombre"),
    @NamedQuery(name = "Persona.findByPersApellido", query = "SELECT p FROM Persona p WHERE p.persApellido = :persApellido"),
    @NamedQuery(name = "Persona.findByPersTelefono", query = "SELECT p FROM Persona p WHERE p.persTelefono = :persTelefono"),
    @NamedQuery(name = "Persona.findByPersCelular", query = "SELECT p FROM Persona p WHERE p.persCelular = :persCelular"),
    @NamedQuery(name = "Persona.findByPersDireccion", query = "SELECT p FROM Persona p WHERE p.persDireccion = :persDireccion"),
    @NamedQuery(name = "Persona.findByPersEstado", query = "SELECT p FROM Persona p WHERE p.persEstado = :persEstado")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pers_pers", nullable = false)
    private Integer persPers;
    @Size(max = 45)
    @Column(name = "pers_nombre", length = 45)
    private String persNombre;
    @Size(max = 45)
    @Column(name = "pers_apellido", length = 45)
    private String persApellido;
    @Size(max = 45)
    @Column(name = "pers_telefono", length = 45)
    private String persTelefono;
    @Size(max = 45)
    @Column(name = "pers_celular", length = 45)
    private String persCelular;
    @Size(max = 45)
    @Column(name = "pers_direccion", length = 45)
    private String persDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pers_estado", nullable = false, length = 45)
    private String persEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emplPers")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuaPers")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargPersJefe")
    private List<Cargo> cargoList;

    public Persona() {
    }

    public Persona(Integer persPers) {
        this.persPers = persPers;
    }

    public Persona(Integer persPers, String persEstado) {
        this.persPers = persPers;
        this.persEstado = persEstado;
    }

    public Integer getPersPers() {
        return persPers;
    }

    public void setPersPers(Integer persPers) {
        this.persPers = persPers;
    }

    public String getPersNombre() {
        return persNombre;
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
    }

    public String getPersApellido() {
        return persApellido;
    }

    public void setPersApellido(String persApellido) {
        this.persApellido = persApellido;
    }

    public String getPersTelefono() {
        return persTelefono;
    }

    public void setPersTelefono(String persTelefono) {
        this.persTelefono = persTelefono;
    }

    public String getPersCelular() {
        return persCelular;
    }

    public void setPersCelular(String persCelular) {
        this.persCelular = persCelular;
    }

    public String getPersDireccion() {
        return persDireccion;
    }

    public void setPersDireccion(String persDireccion) {
        this.persDireccion = persDireccion;
    }

    public String getPersEstado() {
        return persEstado;
    }

    public void setPersEstado(String persEstado) {
        this.persEstado = persEstado;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persPers != null ? persPers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.persPers == null && other.persPers != null) || (this.persPers != null && !this.persPers.equals(other.persPers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Persona[ persPers=" + persPers + " ]";
    }
    
}
