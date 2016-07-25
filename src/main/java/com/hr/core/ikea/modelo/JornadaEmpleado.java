/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "jornada_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JornadaEmpleado.findAll", query = "SELECT j FROM JornadaEmpleado j"),
    @NamedQuery(name = "JornadaEmpleado.findByJoemJorn", query = "SELECT j FROM JornadaEmpleado j WHERE j.jornadaEmpleadoPK.joemJorn = :joemJorn"),
    @NamedQuery(name = "JornadaEmpleado.findByJoemEmpl", query = "SELECT j FROM JornadaEmpleado j WHERE j.jornadaEmpleadoPK.joemEmpl = :joemEmpl"),
    @NamedQuery(name = "JornadaEmpleado.findByJoemHora", query = "SELECT j FROM JornadaEmpleado j WHERE j.joemHora = :joemHora")})
public class JornadaEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JornadaEmpleadoPK jornadaEmpleadoPK;
    @Column(name = "joem_hora")
    private Integer joemHora;
    @JoinColumn(name = "joem_jorn", referencedColumnName = "jorn_jorn", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jornada jornada;
    @JoinColumn(name = "joem_empl", referencedColumnName = "empl_empl", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public JornadaEmpleado() {
    }

    public JornadaEmpleado(JornadaEmpleadoPK jornadaEmpleadoPK) {
        this.jornadaEmpleadoPK = jornadaEmpleadoPK;
    }

    public JornadaEmpleado(int joemJorn, int joemEmpl) {
        this.jornadaEmpleadoPK = new JornadaEmpleadoPK(joemJorn, joemEmpl);
    }

    public JornadaEmpleadoPK getJornadaEmpleadoPK() {
        return jornadaEmpleadoPK;
    }

    public void setJornadaEmpleadoPK(JornadaEmpleadoPK jornadaEmpleadoPK) {
        this.jornadaEmpleadoPK = jornadaEmpleadoPK;
    }

    public Integer getJoemHora() {
        return joemHora;
    }

    public void setJoemHora(Integer joemHora) {
        this.joemHora = joemHora;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jornadaEmpleadoPK != null ? jornadaEmpleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JornadaEmpleado)) {
            return false;
        }
        JornadaEmpleado other = (JornadaEmpleado) object;
        if ((this.jornadaEmpleadoPK == null && other.jornadaEmpleadoPK != null) || (this.jornadaEmpleadoPK != null && !this.jornadaEmpleadoPK.equals(other.jornadaEmpleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.JornadaEmpleado[ jornadaEmpleadoPK=" + jornadaEmpleadoPK + " ]";
    }
    
}
