package co.sistemcobro.yanbal.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean
public class MesajeBean {
	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se Insertaron Correctamente los Datos"));
        RequestContext.getCurrentInstance().update("frmDatosAdicion:messages");
        
	}
 
}
