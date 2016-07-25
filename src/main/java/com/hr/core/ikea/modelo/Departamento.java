/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rm-rf
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByDepaDepa", query = "SELECT d FROM Departamento d WHERE d.depaDepa = :depaDepa"),
    @NamedQuery(name = "Departamento.findByDepaNombre", query = "SELECT d FROM Departamento d WHERE d.depaNombre = :depaNombre"),
    @NamedQuery(name = "Departamento.findByDepaDescripcion", query = "SELECT d FROM Departamento d WHERE d.depaDescripcion = :depaDescripcion")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depa_depa", nullable = false)
    private Integer depaDepa;
    @Size(max = 45)
    @Column(name = "depa_nombre", length = 45)
    private String depaNombre;
    @Size(max = 45)
    @Column(name = "depa_descripcion", length = 45)
    private String depaDescripcion;
    @ManyToMany(mappedBy = "departamentoList")
    private List<Area> areaList;
    @ManyToMany(mappedBy = "departamentoList")
    private List<Cargo> cargoList;

    public Departamento() {
    }

    public Departamento(Integer depaDepa) {
        this.depaDepa = depaDepa;
    }

    public Integer getDepaDepa() {
        return depaDepa;
    }

    public void setDepaDepa(Integer depaDepa) {
        this.depaDepa = depaDepa;
    }

    public String getDepaNombre() {
        return depaNombre;
    }

    public void setDepaNombre(String depaNombre) {
        this.depaNombre = depaNombre;
    }

    public String getDepaDescripcion() {
        return depaDescripcion;
    }

    public void setDepaDescripcion(String depaDescripcion) {
        this.depaDescripcion = depaDescripcion;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
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
        hash += (depaDepa != null ? depaDepa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.depaDepa == null && other.depaDepa != null) || (this.depaDepa != null && !this.depaDepa.equals(other.depaDepa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Departamento[ depaDepa=" + depaDepa + " ]";
    }
    
}
