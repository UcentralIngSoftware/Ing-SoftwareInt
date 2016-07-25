/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.controlador;

import com.hr.core.ikea.modelo.Empleado;
import com.hr.core.ikea.modelo.JornadaEmpleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rm-rf
 */
@Stateless
public class JornadaEmpleadoFacade extends AbstractFacade<JornadaEmpleado> {

    @PersistenceContext(unitName = "IKEA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JornadaEmpleadoFacade() {
        super(JornadaEmpleado.class);
    }

}
