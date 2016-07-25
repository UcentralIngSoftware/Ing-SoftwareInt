/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByEmplEmpl", query = "SELECT e FROM Empleado e WHERE e.emplEmpl = :emplEmpl"),
    @NamedQuery(name = "Empleado.findByEmplInicia", query = "SELECT e FROM Empleado e WHERE e.emplInicia = :emplInicia"),
    @NamedQuery(name = "Empleado.findByEmplFinal", query = "SELECT e FROM Empleado e WHERE e.emplFinal = :emplFinal"),
    @NamedQuery(name = "Empleado.findByEmplSalario", query = "SELECT e FROM Empleado e WHERE e.emplSalario = :emplSalario")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empl_empl", nullable = false)
    private Integer emplEmpl;
    @Column(name = "empl_inicia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emplInicia;
    @Column(name = "empl_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emplFinal;
    @Column(name = "empl_salario")
    private BigInteger emplSalario;
    @JoinColumn(name = "empl_pers", referencedColumnName = "pers_pers", nullable = false)
    @ManyToOne(optional = false)
    private Persona emplPers;
    @JoinColumn(name = "empl_carg", referencedColumnName = "carg_carg", nullable = false)
    @ManyToOne(optional = false)
    private Cargo emplCarg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<JornadaEmpleado> jornadaEmpleadoList;

    public Empleado() {
    }

    public Empleado(Integer emplEmpl) {
        this.emplEmpl = emplEmpl;
    }

    public Integer getEmplEmpl() {
        return emplEmpl;
    }

    public void setEmplEmpl(Integer emplEmpl) {
        this.emplEmpl = emplEmpl;
    }

    public Date getEmplInicia() {
        return emplInicia;
    }

    public void setEmplInicia(Date emplInicia) {
        this.emplInicia = emplInicia;
    }

    public Date getEmplFinal() {
        return emplFinal;
    }

    public void setEmplFinal(Date emplFinal) {
        this.emplFinal = emplFinal;
    }

    public BigInteger getEmplSalario() {
        return emplSalario;
    }

    public void setEmplSalario(BigInteger emplSalario) {
        this.emplSalario = emplSalario;
    }

    public Persona getEmplPers() {
        return emplPers;
    }

    public void setEmplPers(Persona emplPers) {
        this.emplPers = emplPers;
    }

    public Cargo getEmplCarg() {
        return emplCarg;
    }

    public void setEmplCarg(Cargo emplCarg) {
        this.emplCarg = emplCarg;
    }

    @XmlTransient
    public List<JornadaEmpleado> getJornadaEmpleadoList() {
        return jornadaEmpleadoList;
    }

    public void setJornadaEmpleadoList(List<JornadaEmpleado> jornadaEmpleadoList) {
        this.jornadaEmpleadoList = jornadaEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emplEmpl != null ? emplEmpl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.emplEmpl == null && other.emplEmpl != null) || (this.emplEmpl != null && !this.emplEmpl.equals(other.emplEmpl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Empleado[ emplEmpl=" + emplEmpl + " ]";
    }
    
}
