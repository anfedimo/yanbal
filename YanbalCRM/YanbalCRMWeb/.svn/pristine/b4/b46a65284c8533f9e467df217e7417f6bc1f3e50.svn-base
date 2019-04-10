package co.sistemcobro.yanbal.bean;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import com.sun.istack.internal.logging.Logger;

import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.constante.GrupoTIpificacionEnum;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;
import co.sistemcobro.yanbal.ejb.ITipificacionEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean
@ViewScoped
public class NoContactoBean {
	private static Logger logger = Logger.getLogger(NoContactoBean.class);
	@EJB
	private ITipificacionEJBLocal tipificacionEJB;

	@EJB
	private IGestionEJBLocal gestionEJB;
	private ClienteBean clienteBean;
	private List<SelectItem> tipificaciones;
	private Integer idTipificacion;
	private String Observacion;
	private NavegacionBean navegacionBean;
	private boolean fin;
	private boolean inicio;
	private String mensajeError;
	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setNavegacionBean(application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class));
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			tipificaciones = tipificacionEJB.buscarTipificaciones(GrupoTIpificacionEnum.NO_CONTACTO.getIndex());
			System.out.println();
			fin = false;
			inicio = true;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	public void colgar() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("http://localhost/apiagentbox?action=chur&cod=LE&comm=FIN_LLAMADA");
		FacesContext.getCurrentInstance().responseComplete();
	}

	public void guardarNoContacto() {

		if (idTipificacion == null || idTipificacion == 0 || StringUtils.isBlank(Observacion)) {
			mensajeError = "No se puede guardar la gestión seleccione la tipificación y documente la observación";
			RequestContext.getCurrentInstance().update("frmNoContacto:dlNocontacto");
			RequestContext.getCurrentInstance().execute("PF('dlNocontacto').show();");
			return;

		}

		try {
			Gestion gestion = new Gestion();
			//gestion.setId(1);
			gestion.setObservacion(Observacion);
			gestion.setIdtipificacion(idTipificacion);
			gestion.setIdcliente(String.valueOf((clienteBean.getCliente().getIdCliente())));
			//gestion.setId(clienteBean.getIdgestion() != null ? Integer.parseInt(clienteBean.getIdgestion()) : 0);
			gestion.setTelefonomarcado(clienteBean.getTelefonoMarcado());
			gestion.setIdusuariocrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			gestion.setIdcall(clienteBean.getCliente().getIdCall());
			gestion.setFechainiciollamada(new Timestamp(clienteBean.getFechaInicio().getTime()));
			gestion.setAsesor(loginBean.getUsuarioHermes().getNombre());
			gestion.setFechafinllamada(new Timestamp(new Date().getTime()));
			gestion.setEstado(2);
			gestionEJB.insertarGestion(gestion);
			fin = true;
			inicio = false;
			RequestContext.getCurrentInstance().update("frmNoContacto:pnlNoContacto");
			navegacionBean.redireccionFinGestion();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<SelectItem> getTipificaciones() {
		return tipificaciones;
	}

	public void setTipificaciones(List<SelectItem> tipificaciones) {
		this.tipificaciones = tipificaciones;
	}

	public Integer getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(Integer idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
