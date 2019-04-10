package co.sistemcobro.yanbal.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.EstadoAuxiliar;
import co.sistemcobro.yanbal.ejb.IEstadosAuxiliaresEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "estadosAuxiliaresBean")
@ViewScoped
public class EstadosAuxiliaresBean {
	private static Logger logger = Logger.getLogger(EstadosAuxiliaresBean.class);

	@EJB
	private IEstadosAuxiliaresEJBLocal auxiliarEJB;
	private ArrayList<EstadoAuxiliar> estados = new ArrayList<>();
	private Integer idestado;
	private Integer llave;
	private LoginBean loginBean;
	private boolean ini;
	private boolean fin;

	@PostConstruct
	public void init() {
		try {
			fin = true;
			estados = auxiliarEJB.buscarEstadosAux();
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
		} catch (Exception e) {
			logger.error("Error postconstructor auxiliares", e);
		}
	}

	public void guardarAux() {
		try {
			if (idestado == null) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Debe seleccionar un estado"));
				return;
			} else if (idestado == 0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Debe seleccionar un estado"));
				return;
			}
			llave = auxiliarEJB.insertarAux(idestado, Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Auxiliar Activado"));
			fin = false;
			ini = true;
			idestado = 0;
		} catch (Exception e) {
			logger.error("Error postconstructor auxiliares", e);
		}

	}

	public void actualizarAux() {
		try {
			auxiliarEJB.updateAux(llave);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Auxiliar Desactivado"));
			fin = true;
			ini = false;
			idestado = 0;
		} catch (Exception e) {
			logger.error("Error postconstructor auxiliares", e);
		}

	}

	public ArrayList<EstadoAuxiliar> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<EstadoAuxiliar> estados) {
		this.estados = estados;
	}

	public Integer getIdestado() {
		return idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	public Integer getLlave() {
		return llave;
	}

	public void setLlave(Integer llave) {
		this.llave = llave;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public boolean isIni() {
		return ini;
	}

	public void setIni(boolean ini) {
		this.ini = ini;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}
}
