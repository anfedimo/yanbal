package co.sistemcobro.yanbal.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "configBean")
@ViewScoped
public class ConfigBean {

	private boolean descuentoIndividual;

	public boolean isDescuentoIndividual() {
		return descuentoIndividual;
	}

	public void setDescuentoIndividual(boolean descuentoIndividual) {
		this.descuentoIndividual = descuentoIndividual;
	}

	
	 public void addMessage() {
	        String summary = descuentoIndividual ? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
}
