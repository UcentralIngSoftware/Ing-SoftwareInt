/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rm-rf
 */
@Embeddable
public class JornadaEmpleadoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "joem_jorn", nullable = false)
    private int joemJorn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "joem_empl", nullable = false)
    private int joemEmpl;

    public JornadaEmpleadoPK() {
    }

    public JornadaEmpleadoPK(int joemJorn, int joemEmpl) {
        this.joemJorn = joemJorn;
        this.joemEmpl = joemEmpl;
    }

    public int getJoemJorn() {
        return joemJorn;
    }

    public void setJoemJorn(int joemJorn) {
        this.joemJorn = joemJorn;
    }

    public int getJoemEmpl() {
        return joemEmpl;
    }

    public void setJoemEmpl(int joemEmpl) {
        this.joemEmpl = joemEmpl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) joemJorn;
        hash += (int) joemEmpl;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JornadaEmpleadoPK)) {
            return false;
        }
        JornadaEmpleadoPK other = (JornadaEmpleadoPK) object;
        if (this.joemJorn != other.joemJorn) {
            return false;
        }
        if (this.joemEmpl != other.joemEmpl) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.JornadaEmpleadoPK[ joemJorn=" + joemJorn + ", joemEmpl=" + joemEmpl + " ]";
    }
    
}
