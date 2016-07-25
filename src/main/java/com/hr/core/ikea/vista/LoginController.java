/*
* LoginController.java
*
* Version 1.0
*
* 16 julio 2016
*
* Este archivo es confidencial de la aplicacion rockflowers y no se puede distribuir de manera comercial dado que es de uso estudiantil
*/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.vista;

import com.hr.core.ikea.modelo.Usuario;
import com.hr.core.ikea.vista.util.JsfUtil;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String uname;
    private String password;
    @EJB
    private com.hr.core.ikea.controlador.UsuarioFacade usuarioFacade;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String logout() {
        JsfUtil.invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }
    
    public Usuario login(){
        Usuario u = usuarioFacade.login(uname);
        if (u != null){
            if ( u.getUsuaPass().equals(password) ){
                return u;
            }
        }
        return null;
    }

    public String loginProject() {
        try{
            Usuario result = login();
            if (result != null) {
                JsfUtil.putObjectSession(JsfUtil.OBJ_IKEAWEB_USER, result);
                if (result.getUsuaPerfil().indexOf("A") == 0) {
                    return "admin";
                }else if (result.getUsuaPerfil().indexOf("E") == 0) {
                    return "emple";
                }
            }
            JsfUtil.addErrorMessage("Login Invalido!", "Intente nuevamente!");
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return "login";
    }
}
