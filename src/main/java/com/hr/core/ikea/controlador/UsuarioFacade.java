/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.controlador;

import com.hr.core.ikea.modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rm-rf
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "IKEA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    /**
    * Metodo para consultar un usuario por su username de la aplicacion
    *
    * @param    usuario    Usuario a consultar
    * @return   Usuario     Usuario consultado en la base de datos 
    */
    public Usuario login (String usuario){
        Query q = em.createNamedQuery("Usuario.findByUsuaUser");
        q.setParameter("usuaUser", usuario);
//        q.setParameter("usuaEstado", "A");
        java.util.List<Usuario> lista = q.getResultList();
        if (lista != null && !lista.isEmpty()){
            return lista.get(0);
        }
        
        return null;
    }
    
}
