/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCargCarg", query = "SELECT c FROM Cargo c WHERE c.cargCarg = :cargCarg"),
    @NamedQuery(name = "Cargo.findByCargNombre", query = "SELECT c FROM Cargo c WHERE c.cargNombre = :cargNombre"),
    @NamedQuery(name = "Cargo.findByCargDescripcion", query = "SELECT c FROM Cargo c WHERE c.cargDescripcion = :cargDescripcion"),
    @NamedQuery(name = "Cargo.findByCargSalario", query = "SELECT c FROM Cargo c WHERE c.cargSalario = :cargSalario"),
    @NamedQuery(name = "Cargo.findByCargEstado", query = "SELECT c FROM Cargo c WHERE c.cargEstado = :cargEstado")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carg_carg", nullable = false)
    private Integer cargCarg;
    @Size(max = 45)
    @Column(name = "carg_nombre", length = 45)
    private String cargNombre;
    @Size(max = 255)
    @Column(name = "carg_descripcion", length = 255)
    private String cargDescripcion;
    @Column(name = "carg_salario")
    private BigInteger cargSalario;
    @Size(max = 45)
    @Column(name = "carg_estado", length = 45)
    private String cargEstado;
    @JoinTable(name = "departamento_cargo", joinColumns = {
        @JoinColumn(name = "deca_carg", referencedColumnName = "carg_carg", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "deca_depa", referencedColumnName = "depa_depa", nullable = false)})
    @ManyToMany
    private List<Departamento> departamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emplCarg")
    private List<Empleado> empleadoList;
    @JoinColumn(name = "carg_pers_jefe", referencedColumnName = "pers_pers", nullable = false)
    @ManyToOne(optional = false)
    private Persona cargPersJefe;

    public Cargo() {
    }

    public Cargo(Integer cargCarg) {
        this.cargCarg = cargCarg;
    }

    public Integer getCargCarg() {
        return cargCarg;
    }

    public void setCargCarg(Integer cargCarg) {
        this.cargCarg = cargCarg;
    }

    public String getCargNombre() {
        return cargNombre;
    }

    public void setCargNombre(String cargNombre) {
        this.cargNombre = cargNombre;
    }

    public String getCargDescripcion() {
        return cargDescripcion;
    }

    public void setCargDescripcion(String cargDescripcion) {
        this.cargDescripcion = cargDescripcion;
    }

    public BigInteger getCargSalario() {
        return cargSalario;
    }

    public void setCargSalario(BigInteger cargSalario) {
        this.cargSalario = cargSalario;
    }

    public String getCargEstado() {
        return cargEstado;
    }

    public void setCargEstado(String cargEstado) {
        this.cargEstado = cargEstado;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Persona getCargPersJefe() {
        return cargPersJefe;
    }

    public void setCargPersJefe(Persona cargPersJefe) {
        this.cargPersJefe = cargPersJefe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargCarg != null ? cargCarg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargCarg == null && other.cargCarg != null) || (this.cargCarg != null && !this.cargCarg.equals(other.cargCarg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Cargo[ cargCarg=" + cargCarg + " ]";
    }
    
}
