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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByAreaArea", query = "SELECT a FROM Area a WHERE a.areaArea = :areaArea"),
    @NamedQuery(name = "Area.findByAreaNombre", query = "SELECT a FROM Area a WHERE a.areaNombre = :areaNombre"),
    @NamedQuery(name = "Area.findByAreaDescripcion", query = "SELECT a FROM Area a WHERE a.areaDescripcion = :areaDescripcion")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_area", nullable = false)
    private Integer areaArea;
    @Size(max = 45)
    @Column(name = "area_nombre", length = 45)
    private String areaNombre;
    @Size(max = 255)
    @Column(name = "area_descripcion", length = 255)
    private String areaDescripcion;
    @JoinTable(name = "area_departamento", joinColumns = {
        @JoinColumn(name = "arde_area", referencedColumnName = "area_area", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "arde_depa", referencedColumnName = "depa_depa", nullable = false)})
    @ManyToMany
    private List<Departamento> departamentoList;

    public Area() {
    }

    public Area(Integer areaArea) {
        this.areaArea = areaArea;
    }

    public Integer getAreaArea() {
        return areaArea;
    }

    public void setAreaArea(Integer areaArea) {
        this.areaArea = areaArea;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    public String getAreaDescripcion() {
        return areaDescripcion;
    }

    public void setAreaDescripcion(String areaDescripcion) {
        this.areaDescripcion = areaDescripcion;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaArea != null ? areaArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaArea == null && other.areaArea != null) || (this.areaArea != null && !this.areaArea.equals(other.areaArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hr.core.ikea.modelo.Area[ areaArea=" + areaArea + " ]";
    }
    
}
