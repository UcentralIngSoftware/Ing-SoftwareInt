/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "jornada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jornada.findAll", query = "SELECT j FROM Jornada j"),
    @NamedQuery(name = "Jornada.findByJornJorn", query = "SELECT j FROM Jornada j WHERE j.jornJorn = :jornJorn"),
    @NamedQuery(name = "Jornada.findByJornFecha", query = "SELECT j FROM Jornada j WHERE j.jornFecha = :jornFecha"),
    @NamedQuery(name = "Jornada.findByJornHoras", query = "SELECT j FROM Jornada j WHERE j.jornHoras = :jornHoras")})
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jorn_jorn", nullable = false)
    private Integer jornJorn;
    @Column(name = "jorn_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jornFecha;
    @Column(name = "jorn_horas")
    private Integer jornHoras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jornada")
    private List<JornadaEmpleado> jornadaEmpleadoList;

    public Jornada() {
    }

    public Jornada(Integer jornJorn) {
        this.jornJorn = jornJorn;
    }

    public Integer getJornJorn() {
        return jornJorn;
    }

    public void setJornJorn(Integer jornJorn) {
        this.jornJorn = jornJorn;
    }

    public Date getJornFecha() {
        return jornFecha;
    }

    public void setJornFecha(Date jornFecha) {
        this.jornFecha = jornFecha;
    }

    public Integer getJornHoras() {
        return jornHoras;
    }

    public void setJornHoras(Integer jornHoras) {
        this.jornHoras = jornHoras;
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
        hash += (jornJorn != null ? jornJorn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        if ((this.jornJorn == null && other.jornJorn != null) || (this.jornJorn != null && !this.jornJorn.equals(other.jornJorn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Jornada[ jornJorn=" + jornJorn + " ]";
    }
    
}
