package com.hr.core.ikea.vista;

import com.hr.core.ikea.modelo.JornadaEmpleado;
import com.hr.core.ikea.vista.util.JsfUtil;
import com.hr.core.ikea.vista.util.JsfUtil.PersistAction;
import com.hr.core.ikea.controlador.JornadaEmpleadoFacade;
import com.hr.core.ikea.modelo.Empleado;
import com.hr.core.ikea.modelo.Usuario;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("jornadaEmpleadoController")
@SessionScoped
public class JornadaEmpleadoController implements Serializable {

    @EJB
    private com.hr.core.ikea.controlador.JornadaEmpleadoFacade ejbFacade;
    @EJB
    private com.hr.core.ikea.controlador.EmpleadoFacade empleadoFacade;
    private List<JornadaEmpleado> items = null;
    private JornadaEmpleado selected;

    public JornadaEmpleadoController() {
    }

    public JornadaEmpleado getSelected() {
        return selected;
    }

    public void setSelected(JornadaEmpleado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getJornadaEmpleadoPK().setJoemEmpl(selected.getEmpleado().getEmplEmpl());
        selected.getJornadaEmpleadoPK().setJoemJorn(selected.getJornada().getJornJorn());
    }

    protected void initializeEmbeddableKey() {
        selected.setJornadaEmpleadoPK(new com.hr.core.ikea.modelo.JornadaEmpleadoPK());
    }

    private JornadaEmpleadoFacade getFacade() {
        return ejbFacade;
    }
    
    private Empleado getEmpleadoByUsuario(){
        Usuario usua = (Usuario) JsfUtil.getObject(JsfUtil.OBJ_IKEAWEB_USER);
        Empleado busqueda = empleadoFacade.findByUsername(usua.getUsuaUser());
        return busqueda;
    }

    public JornadaEmpleado prepareCreate() {
        selected = new JornadaEmpleado();
        selected.setEmpleado(getEmpleadoByUsuario());
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("JornadaEmpleadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("JornadaEmpleadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("JornadaEmpleadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<JornadaEmpleado> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                switch(persistAction){
                    case CREATE: getFacade().create(selected); break;
                    case UPDATE: getFacade().edit(selected); break;
                    case DELETE: getFacade().remove(selected); break;
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public JornadaEmpleado getJornadaEmpleado(com.hr.core.ikea.modelo.JornadaEmpleadoPK id) {
        return getFacade().find(id);
    }

    public List<JornadaEmpleado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<JornadaEmpleado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = JornadaEmpleado.class)
    public static class JornadaEmpleadoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            JornadaEmpleadoController controller = (JornadaEmpleadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "jornadaEmpleadoController");
            return controller.getJornadaEmpleado(getKey(value));
        }

        com.hr.core.ikea.modelo.JornadaEmpleadoPK getKey(String value) {
            com.hr.core.ikea.modelo.JornadaEmpleadoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.hr.core.ikea.modelo.JornadaEmpleadoPK();
            key.setJoemJorn(Integer.parseInt(values[0]));
            key.setJoemEmpl(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.hr.core.ikea.modelo.JornadaEmpleadoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getJoemJorn());
            sb.append(SEPARATOR);
            sb.append(value.getJoemEmpl());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof JornadaEmpleado) {
                JornadaEmpleado o = (JornadaEmpleado) object;
                return getStringKey(o.getJornadaEmpleadoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), JornadaEmpleado.class.getName()});
                return null;
            }
        }

    }

}
