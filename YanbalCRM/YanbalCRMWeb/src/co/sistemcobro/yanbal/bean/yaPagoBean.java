package co.sistemcobro.yanbal.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.sun.istack.internal.logging.Logger;

import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.constante.GrupoTIpificacionEnum;
import co.sistemcobro.yanbal.ejb.IBancoEJBLocal;
import co.sistemcobro.yanbal.ejb.IFormaPagoEJBLocal;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;
import co.sistemcobro.yanbal.ejb.IParentescoEJBLocal;

import co.sistemcobro.yanbal.ejb.ITipificacionEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "yaPagoBean")
@ViewScoped
public class yaPagoBean {

	private static Logger logger = Logger.getLogger(yaPagoBean.class);
	@EJB
	private ITipificacionEJBLocal tipificacionEJB;

	@EJB
	private IGestionEJBLocal gestionEJB;

	@EJB
	private IParentescoEJBLocal parentescoEJB;



	@EJB
	private IBancoEJBLocal bancoEJB;

	@EJB
	private IFormaPagoEJBLocal formaPagoEJB;
	private LoginBean loginBean;
	private List<SelectItem> tipificaciones;
	private List<SelectItem> parentescos;
	private List<SelectItem> razones;
	private List<SelectItem> bancos;
	private List<SelectItem> formaPago;
	private Integer idTipificacion;
	private Integer idParentesco;
	private Integer idRazon;
	private Integer idEntidad;
	private Integer idFormaPago;
	private String Observacion;
	private String mensaje;
	private String entidadOtro;
	private String formaOtro;
	private Date fechaPago;
	private String seccional;
	private String valor;
	private String codigo;
	private NavegacionBean navegacionBean;
	private boolean fin;
	private boolean inicio;
	private boolean otroBanco;
	private boolean otraForma;
	private ClienteBean clienteBean;

	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setNavegacionBean(application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class));
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			//tipificaciones = tipificacionEJB
			//		.buscarTipificaciones(GrupoTIpificacionEnum.GRUPO_PAGO_NO_APLICA.getIndex());
			//parentescos = parentescoEJB.parentescos();
			bancos = bancoEJB.buscarBancos();
			formaPago = formaPagoEJB.buscarFormasPago();
			fin = false;
			inicio = true;
			otraForma = false;
			otroBanco = false;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}


	public void guardarYaPago() {

		try {
			Gestion gestion = new Gestion();
			gestion.setObservacion(Observacion);
			//gestion.setIdtipificacion(idTipificacion);
			//gestion.setIdmotivo(idRazon);
			//gestion.setIdsucursal(Integer.parseInt(loginBean.getUsuarioHermes().getIdsucursal()));
			//gestion.setIdcliente(Long.parseLong(clienteBean.getCliente().getIdcliente()));
			//gestion.setId(clienteBean.getIdgestion() != null ? Integer.parseInt(clienteBean.getIdgestion()) : 0);
			gestion.setIdusuariocrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			//gestion.setPagolugar(seccional);
			//gestion.setPagovalor(valor);
			//gestion.setPagofecha(fechaPago);
			//gestion.setPagocodigo(codigo);
			//gestion.setIdentidad(idEntidad);
			//gestion.setFechainicio(clienteBean.getFechaInicio());
			//gestion.setTelefonomarcado(clienteBean.getTelefonoMarcado());
			//gestion.setIdformapago(idFormaPago);
			if (idEntidad == 99) {
				//gestion.setEntidad_otro(entidadOtro);
			}
			if (idFormaPago == 99) {
			//	gestion.setFormapago_otro(formaOtro);
			}
			//gestionEJB.actualizarGestion(gestion);
			fin = true;
			inicio = false;
			RequestContext.getCurrentInstance().update("frmYaPago:pnlYaPago");
			navegacionBean.redireccionFinGestion();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void onChangeBanco() {

		if (idEntidad == 99) {
			otroBanco = true;
		} else {
			otroBanco = false;
		}

	}

	public void onChangeForma() {

		if (idFormaPago == 99) {
			otraForma = true;
		} else {
			otraForma = false;
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

	public List<SelectItem> getParentescos() {
		return parentescos;
	}

	public void setParentescos(List<SelectItem> parentescos) {
		this.parentescos = parentescos;
	}

	public Integer getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public List<SelectItem> getRazones() {
		return razones;
	}

	public void setRazones(List<SelectItem> razones) {
		this.razones = razones;
	}

	public Integer getIdRazon() {
		return idRazon;
	}

	public void setIdRazon(Integer idRazon) {
		this.idRazon = idRazon;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<SelectItem> getBancos() {
		return bancos;
	}

	public void setBancos(List<SelectItem> bancos) {
		this.bancos = bancos;
	}

	public List<SelectItem> getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(List<SelectItem> formaPago) {
		this.formaPago = formaPago;
	}

	public Integer getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Integer getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getEntidadOtro() {
		return entidadOtro;
	}

	public void setEntidadOtro(String entidadOtro) {
		this.entidadOtro = entidadOtro;
	}

	public String getFormaOtro() {
		return formaOtro;
	}

	public void setFormaOtro(String formaOtro) {
		this.formaOtro = formaOtro;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getSeccional() {
		return seccional;
	}

	public void setSeccional(String seccional) {
		this.seccional = seccional;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isOtroBanco() {
		return otroBanco;
	}

	public void setOtroBanco(boolean otroBanco) {
		this.otroBanco = otroBanco;
	}

	public boolean isOtraForma() {
		return otraForma;
	}

	public void setOtraForma(boolean otraForma) {
		this.otraForma = otraForma;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
