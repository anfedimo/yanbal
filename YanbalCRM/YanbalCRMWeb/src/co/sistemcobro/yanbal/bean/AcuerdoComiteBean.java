package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
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

import co.sistemcobro.yanbal.bean.Comite;
import co.sistemcobro.yanbal.bean.Cuota;
import co.sistemcobro.yanbal.bean.FacturaGestion;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.constante.GrupoTIpificacionEnum;
import co.sistemcobro.yanbal.ejb.IClienteEJBLocal;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;

import co.sistemcobro.yanbal.ejb.ITipificacionEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "acuerdoComiteBean")
@ViewScoped
public class AcuerdoComiteBean {

	private static Logger logger = Logger.getLogger(AcuerdoComiteBean.class);

	@EJB
	private ITipificacionEJBLocal tipificacionEJB;



	@EJB
	private IGestionEJBLocal gestionEJB;

	@EJB
	private IClienteEJBLocal clienteEJB;

	
	
	private LoginBean loginBean;
	private List<SelectItem> tipificaciones;
	private Integer idTipificacion;
	private List<SelectItem> razones;
	private Integer idRazon;
	private NavegacionBean navegacionBean;
	private ClienteBean clienteBean;
	private List<FacturaGestion> facturasCobro;
	private Comite comiteAprobado;
	private List<Obligacion> obligacionesCobro;
	private BigDecimal totalPromesa;
	private String mensajeError;
	private BigDecimal montoFraccion;
	private BigDecimal saldoPromesa;
	private Integer cantCuotas;
	private Date fechaPromesa;
	private List<Cuota> cuotas;
	private boolean inicio;
	private boolean fin;
	private String observacion;
	private BigDecimal cobroFacturaAdicional;

	@PostConstruct
	public void init() {
		try {
			obligacionesCobro = new ArrayList<>();
			cuotas = new ArrayList<>();
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setNavegacionBean(application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class));
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			comiteAprobado = clienteEJB.comiteAprobadoInfo(Integer.parseInt(clienteBean.getCliente().getCedulaCliente()));
			obligacionesCobro = clienteEJB.obligacionesComite(comiteAprobado.getId());
			facturasCobro = clienteBean.getFacturasGestion();
			//calcularValorPromesa();
			inicio = true;
			fin = false;
		//	setTipificaciones(tipificacionEJB.buscarTipificaciones(GrupoTIpificacionEnum.GRUPO_COMITE_ACUERDO.getIndex()));
			fechaPromesa = comiteAprobado.getFechaPago();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	

	public void limpiarCuotas() {
		montoFraccion = null;
		saldoPromesa = totalPromesa;
		cantCuotas = null;
		cuotas = new ArrayList<>();
		fechaPromesa = null;
		RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlAcuerdoComite");

	}

	public void generarCuotas() {
		
		if (montoFraccion==null) {
			mensajeError = "El monto a fraccionar no puede estar vacio";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}


		if (montoFraccion.compareTo(new BigDecimal(0)) == 0) {
			mensajeError = "El monto a fraccionar no puede ser 0";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (montoFraccion.equals(null)) {
			mensajeError = "El monto a fraccionar no puede estar vacio";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (montoFraccion.compareTo(new BigDecimal(0)) == -1) {
			mensajeError = "El monto a fraccionar no puede ser negativo";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (montoFraccion.compareTo(totalPromesa) == 1) {
			mensajeError = "El monto a fraccionar no puede ser mayor al total del acuerdo";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (montoFraccion.compareTo(saldoPromesa) == 1) {
			mensajeError = "El monto a fraccionar no puede ser mayor al saldo del acuerdo";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (cantCuotas > 3) {
			mensajeError = "No se puede generar mas de 3 cuotas";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (cantCuotas == null) {
			mensajeError = "La cantidad de cuotas no puede estar vacia";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (cantCuotas == 0) {
			mensajeError = "La cantidad de cuotas no puede ser 0";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (cantCuotas + cuotas.size() > 3) {
			mensajeError = "No se puede generar mas de 3 cuotas";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(comiteAprobado.getFechaPago());

		if (fechaPromesa != null && fechaPromesa.before(now.getTime())) {
			mensajeError = "La fecha promesa no puede ser antes de la fecha promesa aprobada";
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
			return;
		}

		if (!cuotas.isEmpty()) {
		//	fechaPromesa = cuotas.get(cuotas.size() - 1).getFechaCuota();
		}

		BigDecimal cantidad = montoFraccion.divide(new BigDecimal(cantCuotas), 2, RoundingMode.HALF_UP);
		Cuota cuota = new Cuota();
		Date fechaTmp = new Date();
		int cantTmp = cuotas.size() + cantCuotas;
		for (int j = cuotas.size(); j < cantTmp; j++) {
			cuota = new Cuota();
		//	cuota.setIdusuariocrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
		//	cuota.setValor(cantidad);
			cuota.setNumeroCuota(j + 1);
			if (fechaPromesa == null) {
				now.add(Calendar.MONTH, 1);
				fechaTmp = now.getTime();
		//		cuota.setFechaCuota(fechaTmp);
			}
			if (fechaPromesa != null && !cuotas.isEmpty()) {
				now.setTime(fechaPromesa);
				now.add(Calendar.MONTH, 1);
				fechaTmp = now.getTime();
		//		cuota.setFechaCuota(fechaTmp);
				fechaPromesa = null;
			}

			if (fechaPromesa != null && cuotas.isEmpty()) {
				now.setTime(fechaPromesa);
				fechaTmp = now.getTime();
	//			cuota.setFechaCuota(fechaTmp);
				fechaPromesa = null;
			}
			cuotas.add(cuota);
		}
		saldoPromesa = saldoPromesa.subtract(montoFraccion);
		montoFraccion = null;
		cantCuotas = null;
		fechaPromesa = null;
		RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlAcuerdoComite");

	}

	/*public void calcularValorPromesa() {
		totalPromesa = new BigDecimal(0);
		for (Obligacion ob : obligacionesCobro) {
			System.out.println(ob.getTotalCobro());
			totalPromesa = totalPromesa.add(ob.getTotalCobro());
			System.out.println(totalPromesa);
		}
		if (cobroFacturaAdicional != null && cobroFacturaAdicional.compareTo(new BigDecimal(0)) == 1) {

			totalPromesa = totalPromesa.add(cobroFacturaAdicional);
		}
		saldoPromesa = totalPromesa;
	}*/

	public void guardarPromesa() {
		try {
			if (saldoPromesa.compareTo(new BigDecimal(0)) == 1) {
				mensajeError = "No se puede guardar la promesa si el saldo de la promesa no es igual a $0,00";
				RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
				return;

			}

			if (idTipificacion == null || idTipificacion == 0) {
				mensajeError = "No se puede guardar la promesa debe seleccionar la tipificacion";
				RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
				return;

			}

			if (idRazon == null || idRazon == 0) {
				mensajeError = "No se puede guardar la promesa debe seleccionar la Razon de no pago";
				RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
				return;

			}

			if (cuotas.isEmpty()) {
				mensajeError = "No se puede generar promesas sin cuotas";
				RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
				return;
			}

			if (observacion == null || observacion == "") {
				mensajeError = "La observación no puede estar vacia";
				RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlAcuerdoComite').show();");
				return;
			}

			Gestion gestion = new Gestion();
			gestion.setObservacion(observacion);
			//gestion.setIdtipificacion(idTipificacion);
			//gestion.setIdmotivo(idRazon);
			//gestion.setFechainicio(clienteBean.getFechaInicio());
			gestion.setTelefonomarcado(clienteBean.getTelefonoMarcado());
			//gestion.setId(clienteBean.getIdgestion() != null ? Integer.parseInt(clienteBean.getIdgestion()) : 0);
			//gestion.setFechapromesa(comiteAprobado.getFechaPago());
			//gestion.setValorpromesa(totalPromesa);
			//gestion.setCuotas(cuotas);
			//gestion.setId(clienteBean.getIdgestion() != null ? Integer.parseInt(clienteBean.getIdgestion()) : 0);
			//gestion.setIdcomite(comiteAprobado.getId());
			gestion.setIdusuariocrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			//gestion.setIdsucursal(Integer.parseInt(loginBean.getUsuarioHermes().getIdsucursal()));
			//gestion.setDocumento(Long.parseLong(clienteBean.getCliente().getDocumento()));
			//gestionEJB.actualizarGestion(gestion);
			fin = true;
			inicio = false;
			RequestContext.getCurrentInstance().update("frmAcuerdoComite:pnlAcuerdoComite");
			navegacionBean.redireccionFinGestion();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<FacturaGestion> getFacturasCobro() {
		return facturasCobro;
	}

	public void setFacturasCobro(List<FacturaGestion> facturasCobro) {
		this.facturasCobro = facturasCobro;
	}

	public List<Obligacion> getObligacionesCobro() {
		return obligacionesCobro;
	}

	public void setObligacionesCobro(List<Obligacion> obligacionesCobro) {
		this.obligacionesCobro = obligacionesCobro;
	}

	public BigDecimal getTotalPromesa() {
		return totalPromesa;
	}

	public void setTotalPromesa(BigDecimal totalPromesa) {
		this.totalPromesa = totalPromesa;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public BigDecimal getMontoFraccion() {
		return montoFraccion;
	}

	public void setMontoFraccion(BigDecimal montoFraccion) {
		this.montoFraccion = montoFraccion;
	}

	public BigDecimal getSaldoPromesa() {
		return saldoPromesa;
	}

	public void setSaldoPromesa(BigDecimal saldoPromesa) {
		this.saldoPromesa = saldoPromesa;
	}

	public Integer getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(Integer cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Date getFechaPromesa() {
		return fechaPromesa;
	}

	public void setFechaPromesa(Date fechaPromesa) {
		this.fechaPromesa = fechaPromesa;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<SelectItem> getTipificaciones() {
		return tipificaciones;
	}

	public void setTipificaciones(List<SelectItem> tipificaciones) {
		this.tipificaciones = tipificaciones;
	}

	public List<SelectItem> getRazones() {
		return razones;
	}

	public void setRazones(List<SelectItem> razones) {
		this.razones = razones;
	}

	public Integer getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(Integer idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public Integer getIdRazon() {
		return idRazon;
	}

	public void setIdRazon(Integer idRazon) {
		this.idRazon = idRazon;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public BigDecimal getCobroFacturaAdicional() {
		return cobroFacturaAdicional;
	}

	public void setCobroFacturaAdicional(BigDecimal cobroFacturaAdicional) {
		this.cobroFacturaAdicional = cobroFacturaAdicional;
	}

	public Comite getComiteAprobado() {
		return comiteAprobado;
	}

	public void setComiteAprobado(Comite comiteAprobado) {
		this.comiteAprobado = comiteAprobado;
	}

}
