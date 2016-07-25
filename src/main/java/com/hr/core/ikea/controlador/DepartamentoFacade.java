/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.controlador;

import com.hr.core.ikea.modelo.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rm-rf
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    @PersistenceContext(unitName = "IKEA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
}
