package co.sistemcobro.yanbal.bean;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import com.sun.istack.internal.logging.Logger;

import co.sistemcobro.yanbal.bean.Descuento;
import co.sistemcobro.yanbal.bean.Motivo;
import co.sistemcobro.yanbal.bean.Parentesco;
import co.sistemcobro.yanbal.bean.Tipificacion;
import co.sistemcobro.yanbal.ejb.ICuotaEJBLocal;
import co.sistemcobro.yanbal.ejb.IDescuentoEJBLocal;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;
import co.sistemcobro.yanbal.ejb.IMotivoEJBLocal;
import co.sistemcobro.yanbal.ejb.IParentescoEJBLocal;
import co.sistemcobro.yanbal.ejb.ITipificacionEJBLocal;
import co.sistemcobro.yanbal.ejb.impl.MotivoEJB;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "tipificarBean")
@ViewScoped
public class TipificarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ITipificacionEJBLocal tipificacionEJB;

	@EJB
	private IParentescoEJBLocal parentescoEJB;

	@EJB
	private IMotivoEJBLocal motivoEJB;

	@EJB
	private ICuotaEJBLocal cuotaEJB;

	@EJB
	private IDescuentoEJBLocal descuentoEJB;

	@EJB
	private IGestionEJBLocal gestionEJB;

	private ClienteBean clienteBean;

	private List<Tipificacion> tipificaciones;
	private Integer selectedTipificacion;

	private List<Descuento> descuentos;
	private Integer selectedDescuento;

	private List<Motivo> motivos;
	private Integer selectedMotivo;

	private List<Parentesco> parentescos;
	private Integer selectedParentesco;

	private List<Integer> cuotas;
	private Integer selectedCuota;

	private String mensajeValorCuota;
	private String nombreTercero;
	private String telefonoAgendado;
	private Integer selectedCodigoTipificacion;
	private String Observacion;
	private NavegacionBean navegacionBean;
	private boolean fin;
	private boolean inicio;
	private String mensajeError;
	private LoginBean loginBean;
	private Integer idNivelTipificacion;

	private Integer mostrarMensaje;
	private Integer idTipificacion;

	private Integer opcionTipificar;
	private Integer opcionAgendamiento;
	private Integer opcionPromesa;
	private Integer opcionPromesaMultiple;
	private Integer opcionComboTipificacion;
	private Integer opcionContactoNoEfectivo;

	private String codigoTipificacion;

	private Date fechaPromesa;
	private Date fechaAgendamiento;
	private Double montoPromesa;
	private Double montoCuota;
	private Integer numeroCuota;
	private String nombreTipificacion;

	private String mensajeCuota;
	private Integer idmotivonopago;

	private ClienteBean cliente;
	private LoginBean login;
	
	private Integer i;
	
	private boolean renderPromesa;

	@PostConstruct
	public void init() {
		try {
			
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setNavegacionBean(application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class));

			cliente = application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class);
			login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
			fin = false;
			inicio = true;
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void metodoAgendar(int opcion) throws Exception {
		try {

			opcionAgendamiento = opcion;

			//RequestContext.getCurrentInstance().update("panelTipificaciones");
//			RequestContext.getCurrentInstance().update("panelCamposTipificacion");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*public void onChangeTipificacion() throws Exception {

		try {
			if(idTipificacion != null){
			if (idTipificacion == 102) {
				renderPromesa = true;
			}else
				renderPromesa = false;
			}renderPromesa = false;
			
			RequestContext.getCurrentInstance().update("frmTipificar");
		} catch (Exception e) {
			//logger.info("Error SQL al tratar de leer  las razones", e);
			throw new Exception("Error SQL al tratar de leer  las razones", e);
		}

	}*/

	public void onChangeValorCuota() throws Exception {
		mensajeCuota = "";
		descuentos = descuentoEJB.descuentosClientePorCuota(cliente.getCliente().getCedulaCliente(), selectedCuota);
		BigDecimal valorMin = null;
		BigDecimal valorMax = null;
		for (Descuento d : descuentos) {
			
			montoCuota = d.getMaxComodin();
			
			valorMax = new BigDecimal(d.getMaxComodin());
			valorMax = valorMax.setScale(2, RoundingMode.UP);
			
			valorMin = new BigDecimal(d.getMinComodin());
			valorMin = valorMin.setScale(2, RoundingMode.UP);
		}

		mensajeValorCuota = "Para la cuota " + selectedCuota + " el valor minimo es " + valorMin
				+ " el valor maximo es " + valorMax;

	}

	public void validarCuota() throws Exception {
		descuentos = descuentoEJB.descuentosClientePorCuota(cliente.getCliente().getCedulaCliente(), selectedCuota);

		if (descuentos.isEmpty()) {
			mensajeCuota = "Por favor seleccione la cuota ";
		} else {
			mensajeCuota = "";
			for (Descuento d : descuentos) {

				Double valorJSF = montoCuota;

				if (valorJSF <= d.getMinComodin()) {
					mostrarMensaje = 1;
					mensajeCuota = "el monto debe ser mayor o igual a " + d.getMinComodin();
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensajeCuota));

				} else {

				}

				if (valorJSF >= d.getMaxComodin()) {
					mostrarMensaje = 1;
					mensajeCuota = "el monto debe ser menor o igual a " + d.getMaxComodin();
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensajeCuota));
				} else {
				}
			}
		}
	}

	

	public void consultarTipificacion(Integer idNivel, String nombre, Integer index) throws Exception {
		idNivelTipificacion = idNivel;
		tipificaciones = tipificacionEJB.buscarTipificacionesPorNivel(idNivelTipificacion);
		this.setearValores();
		opcionComboTipificacion = 1;
		if (idNivel == 1) {
		//	motivos = motivoEJB.buscarMotivos();
		}
		nombreTipificacion = nombre;
		i = index;
		//RequestContext.getCurrentInstance().update("tipificacionesNivel");
		//RequestContext.getCurrentInstance().update("panelTipificaciones");
		
	}

	public void setearValores() {
		opcionTipificar = 0;
		opcionAgendamiento = 0;
		opcionPromesa = 0;
		opcionPromesaMultiple = 0;
		opcionComboTipificacion = 0;
		opcionContactoNoEfectivo = 0;
		mostrarMensaje = 0;
		mensajeCuota = "";
	}

	public void colgar() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("http://localhost/apiagentbox?action=chur&cod=LE&comm=FIN_LLAMADA");
		FacesContext.getCurrentInstance().responseComplete();
	}

	public List<Tipificacion> getTipificaciones() {
		return tipificaciones;
	}

	public void setTipificaciones(List<Tipificacion> tipificaciones) {
		this.tipificaciones = tipificaciones;
	}

	public Integer getSelectedTipificacion() {
		return selectedTipificacion;
	}

	public void setSelectedTipificacion(Integer selectedTipificacion) {
		this.selectedTipificacion = selectedTipificacion;
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

	public Integer getIdNivelTipificacion() {
		return idNivelTipificacion;
	}

	public void setIdNivelTipificacion(Integer idNivelTipificacion) {
		this.idNivelTipificacion = idNivelTipificacion;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public ITipificacionEJBLocal getTipificacionEJB() {
		return tipificacionEJB;
	}

	public void setTipificacionEJB(ITipificacionEJBLocal tipificacionEJB) {
		this.tipificacionEJB = tipificacionEJB;
	}

	public IGestionEJBLocal getGestionEJB() {
		return gestionEJB;
	}

	public void setGestionEJB(IGestionEJBLocal gestionEJB) {
		this.gestionEJB = gestionEJB;
	}

	public Integer getOpcionTipificar() {
		return opcionTipificar;
	}

	public void setOpcionTipificar(Integer opcionTipificar) {
		this.opcionTipificar = opcionTipificar;
	}

	public Integer getOpcionAgendamiento() {
		return opcionAgendamiento;
	}

	public void setOpcionAgendamiento(Integer opcionAgendamiento) {
		this.opcionAgendamiento = opcionAgendamiento;
	}

	public Integer getOpcionPromesa() {
		return opcionPromesa;
	}

	public void setOpcionPromesa(Integer opcionPromesa) {
		this.opcionPromesa = opcionPromesa;
	}

	public Integer getOpcionPromesaMultiple() {
		return opcionPromesaMultiple;
	}

	public void setOpcionPromesaMultiple(Integer opcionPromesaMultiple) {
		this.opcionPromesaMultiple = opcionPromesaMultiple;
	}

	public String getCodigoTipificacion() {
		return codigoTipificacion;
	}

	public void setCodigoTipificacion(String codigoTipificacion) {
		this.codigoTipificacion = codigoTipificacion;
	}

	public Date getFechaPromesa() {
		return fechaPromesa;
	}

	public void setFechaPromesa(Date fechaPromesa) {
		this.fechaPromesa = fechaPromesa;
	}

	public Double getMontoPromesa() {
		return montoPromesa;
	}

	public void setMontoPromesa(Double montoPromesa) {
		this.montoPromesa = montoPromesa;
	}

	public Double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Integer getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public Integer getSelectedCodigoTipificacion() {
		return selectedCodigoTipificacion;
	}

	public void setSelectedCodigoTipificacion(Integer selectedCodigoTipificacion) {
		this.selectedCodigoTipificacion = selectedCodigoTipificacion;
	}

	public Integer getOpcionComboTipificacion() {
		return opcionComboTipificacion;
	}

	public void setOpcionComboTipificacion(Integer opcionComboTipificacion) {
		this.opcionComboTipificacion = opcionComboTipificacion;
	}

	public Date getFechaAgendamiento() {
		return fechaAgendamiento;
	}

	public void setFechaAgendamiento(Date fechaAgendamiento) {
		this.fechaAgendamiento = fechaAgendamiento;
	}

	public String getNombreTipificacion() {
		return nombreTipificacion;
	}

	public void setNombreTipificacion(String nombreTipificacion) {
		this.nombreTipificacion = nombreTipificacion;
	}

	public List<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	public Integer getSelectedDescuento() {
		return selectedDescuento;
	}

	public void setSelectedDescuento(Integer selectedDescuento) {
		this.selectedDescuento = selectedDescuento;
	}

	public IDescuentoEJBLocal getDescuentoEJB() {
		return descuentoEJB;
	}

	public void setDescuentoEJB(IDescuentoEJBLocal descuentoEJB) {
		this.descuentoEJB = descuentoEJB;
	}

	public ICuotaEJBLocal getCuotaEJB() {
		return cuotaEJB;
	}

	public void setCuotaEJB(ICuotaEJBLocal cuotaEJB) {
		this.cuotaEJB = cuotaEJB;
	}

	public List<Integer> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Integer> cuotas) {
		this.cuotas = cuotas;
	}

	public Integer getSelectedCuota() {
		return selectedCuota;
	}

	public void setSelectedCuota(Integer selectedCuota) {
		this.selectedCuota = selectedCuota;
	}

	public String getMensajeCuota() {
		return mensajeCuota;
	}

	public void setMensajeCuota(String mensajeCuota) {
		this.mensajeCuota = mensajeCuota;
	}

	public Integer getMostrarMensaje() {
		return mostrarMensaje;
	}

	public void setMostrarMensaje(Integer mostrarMensaje) {
		this.mostrarMensaje = mostrarMensaje;
	}

	public IParentescoEJBLocal getParentescoEJB() {
		return parentescoEJB;
	}

	public void setParentescoEJB(IParentescoEJBLocal parentescoEJB) {
		this.parentescoEJB = parentescoEJB;
	}

	public List<Parentesco> getParentescos() {
		return parentescos;
	}

	public void setParentescos(List<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}

	public Integer getSelectedParentesco() {
		return selectedParentesco;
	}

	public void setSelectedParentesco(Integer selectedParentesco) {
		this.selectedParentesco = selectedParentesco;
	}

	public List<Motivo> getMotivos() {
		return motivos;
	}

	public void setMotivos(List<Motivo> motivos) {
		this.motivos = motivos;
	}

	public Integer getSelectedMotivo() {
		return selectedMotivo;
	}

	public void setSelectedMotivo(Integer selectedMotivo) {
		this.selectedMotivo = selectedMotivo;
	}

	public IMotivoEJBLocal getMotivoEJB() {
		return motivoEJB;
	}

	public void setMotivoEJB(IMotivoEJBLocal motivoEJB) {
		this.motivoEJB = motivoEJB;
	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(Integer idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public Integer getOpcionContactoNoEfectivo() {
		return opcionContactoNoEfectivo;
	}

	public void setOpcionContactoNoEfectivo(Integer opcionContactoNoEfectivo) {
		this.opcionContactoNoEfectivo = opcionContactoNoEfectivo;
	}

	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public String getTelefonoAgendado() {
		return telefonoAgendado;
	}

	public void setTelefonoAgendado(String telefonoAgendado) {
		this.telefonoAgendado = telefonoAgendado;
	}

	public String getMensajeValorCuota() {
		return mensajeValorCuota;
	}

	public void setMensajeValorCuota(String mensajeValorCuota) {
		this.mensajeValorCuota = mensajeValorCuota;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public Integer getIdmotivonopago() {
		return idmotivonopago;
	}

	public void setIdmotivonopago(Integer idmotivonopago) {
		this.idmotivonopago = idmotivonopago;
	}

	public boolean isRenderPromesa() {
		return renderPromesa;
	}

	public void setRenderPromesa(boolean renderPromesa) {
		this.renderPromesa = renderPromesa;
	}
	
	
	
}
