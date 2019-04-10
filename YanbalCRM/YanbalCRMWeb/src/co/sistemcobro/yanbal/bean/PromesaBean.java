package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
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

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import com.sun.istack.internal.logging.Logger;

import co.sistemcobro.yanbal.bean.Cuota;
import co.sistemcobro.yanbal.bean.FacturaGestion;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.constante.GrupoTIpificacionEnum;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;

import co.sistemcobro.yanbal.ejb.ITipificacionEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "promesaBean")
@ViewScoped
public class PromesaBean {

	private static Logger logger = Logger.getLogger(PromesaBean.class);

	@EJB
	private ITipificacionEJBLocal tipificacionEJB;



	@EJB
	private IGestionEJBLocal gestionEJB;

	private LoginBean loginBean;
	private List<SelectItem> tipificaciones;
	private Integer idTipificacion;
	private List<SelectItem> razones;
	private Integer idRazon;
	private NavegacionBean navegacionBean;
	private ClienteBean clienteBean;
	private List<FacturaGestion> facturasCobro;
	private List<Obligacion> obligaciones;
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
	private BigDecimal porcentajeDescuento;

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
			facturasCobro = clienteBean.getFacturasGestion();
			// obligaciones = clienteBean.getCliente().getObligaciones();
			// generarTabla();
			inicio = true;
			fin = false;
			setTipificaciones(tipificacionEJB.buscarTipificaciones(GrupoTIpificacionEnum.DIRECTO.getIndex()));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	public void onBlurAdicional() {

	}

	public void onChangeTipificacion() throws Exception {

		try {
			if (idTipificacion != null) {
				
					RequestContext.getCurrentInstance().update("frmPromesa:pnlPromesa");
				
				//razones = razonNoPagoEJB.buscarRazonesPorTipificacion(idTipificacion);
			}
		} catch (Exception e) {
			logger.info("Error SQL al tratar de leer  las razones", e);
			throw new Exception("Error SQL al tratar de leer  las razones", e);
		}

	}

	/*
	 * public void generarTabla() {
	 * 
	 * Obligacion obligacionTMP = new Obligacion(); for (Obligacion ob :
	 * obligaciones) { obligacionTMP = new Obligacion(); innerloop: for
	 * (FacturaGestion fg : facturasCobro) {
	 * if(fg.getFactura().equals(ob.getFactura())&&
	 * fg.getMaterial().equals(ob.getMaterial())) {
	 * obligacionTMP.setFactura(ob.getFactura());
	 * obligacionTMP.setDesc_capital(ob.getDesc_capital() .multiply(new
	 * BigDecimal(100))); obligacionTMP.setDesc_interes(ob.getDesc_interes()
	 * .multiply(new BigDecimal(100))); if (obligacionTMP.getTotalCartera() ==
	 * null) { obligacionTMP.setTotalCartera(new BigDecimal(0)); } if
	 * (obligacionTMP.getInteresesMora() == null) {
	 * obligacionTMP.setInteresesMora(new BigDecimal(0)); } if
	 * (obligacionTMP.getHonorariosCobrados() == null) {
	 * obligacionTMP.setHonorariosCobrados(new BigDecimal(0)); } if
	 * (obligacionTMP.getCarteraCorriente() == null) {
	 * obligacionTMP.setCarteraCorriente(new BigDecimal(0)); } if
	 * (obligacionTMP.getCarteraVencida() == null) {
	 * obligacionTMP.setCarteraVencida(new BigDecimal(0)); } switch
	 * (fg.getIdcolumna()) {
	 * 
	 * case 1: obligacionTMP = ob;
	 * obligacionTMP.setInteresesMora(ob.getInteresesMora()
	 * .add(ob.getHonorariosCobrados()));
	 * 
	 * break innerloop; case 2: obligacionTMP.setCarteraCorriente(ob
	 * .getCarteraCorriente()); break; case 3:
	 * obligacionTMP.setCarteraVencida(ob.getCarteraVencida()); break; case 4:
	 * obligacionTMP.setTotalCartera(ob.getTotalCartera()); break; case 7:
	 * obligacionTMP.setInteresesMora(ob.getInteresesMora()); break; case 8:
	 * obligacionTMP.setHonorariosCobrados(ob .getHonorariosCobrados()); break;
	 * case 9: if (ob.getTotalCartera() == ob.getInteresesMora()
	 * .add(ob.getHonorariosCobrados()) .add(ob.getCarteraCorriente())
	 * .add(ob.getCarteraVencida())) {
	 * obligacionTMP.setTotalCartera(ob.getTotalCartera()); } else {
	 * obligacionTMP.setTotalCartera(ob .getCarteraVencida()); }
	 * 
	 * obligacionTMP.setInteresesMora(ob.getInteresesMora()
	 * .add(ob.getHonorariosCobrados())); break innerloop; case 10:
	 * obligacionTMP = ob; obligacionTMP.setInteresesMora(ob.getInteresesMora()
	 * .add(ob.getHonorariosCobrados())); break innerloop;
	 * 
	 * }
	 * 
	 * } } if (obligacionTMP.getFactura() != null) {
	 * obligacionesCobro.add(obligacionTMP); }
	 * 
	 * }
	 * 
	 * for (Obligacion ob : obligacionesCobro) {
	 * 
	 * if (!ob.getCarteraVencida().equals(new BigDecimal(0)) &&
	 * ob.getTotalCartera().equals(new BigDecimal(0))) {
	 * ob.setTotalCartera(ob.getTotalCartera().add( ob.getCarteraVencida())); }
	 * if (!ob.getCarteraCorriente().equals(new BigDecimal(0)) &&
	 * ob.getTotalCartera().equals(new BigDecimal(0))) {
	 * ob.setTotalCartera(ob.getTotalCartera().add( ob.getCarteraCorriente()));
	 * }
	 * 
	 * if (!ob.getInteresesMora().equals(new BigDecimal(0)) &&
	 * ob.getTotalCartera().equals(new BigDecimal(0))) {
	 * ob.setInteresesMora(ob.getInteresesMora().add( ob.getInteresesMora())); }
	 * if (!ob.getHonorariosCobrados().equals(new BigDecimal(0)) &&
	 * ob.getTotalCartera().equals(new BigDecimal(0))) {
	 * ob.setInteresesMora(ob.getInteresesMora().add(
	 * ob.getHonorariosCobrados())); }
	 * 
	 * if (ob.getInteresesMora().equals(new BigDecimal(0))) {
	 * ob.setInteresDescuento(new BigDecimal(100)); } else {
	 * ob.setInteresDescuento(new BigDecimal(0)); } if
	 * (ob.getTotalCartera().equals(new BigDecimal(0))) {
	 * ob.setCapitalDescuento(new BigDecimal(100)); } else {
	 * ob.setCapitalDescuento(new BigDecimal(0)); }
	 * 
	 * ob.setTotalCobro(ob.getTotalCartera().add(ob.getInteresesMora()));
	 * 
	 * ob.setTotalCapDesc(ob.getTotalCartera().subtract(
	 * ob.getTotalCartera().multiply( ob.getCapitalDescuento() .divide(new
	 * BigDecimal(100))))); ob.setTotalIntDesc(ob.getInteresesMora().subtract(
	 * ob.getInteresesMora().multiply( ob.getInteresDescuento() .divide(new
	 * BigDecimal(100)))));
	 * ob.setTotalCobro(ob.getTotalCapDesc().add(ob.getTotalIntDesc()));
	 * 
	 * } calcularValorPromesa();
	 * 
	 * }
	 */

	public void recalcularTabla() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
		facturasCobro = clienteBean.getFacturasGestion();
		obligacionesCobro.clear();
		// generarTabla();

		RequestContext.getCurrentInstance().update("frmPromesa:pnlPromesa");

	}

	public void actualizarCobro(Obligacion ob) {
		List<Obligacion> listaTempora = new ArrayList<>();

		/*
		 * if ((ob.getCapitalDescuento().compareTo(new BigDecimal(0))) == -1) {
		 * mensajeError = "No se puede Aplicar descuentos negativos";
		 * RequestContext.getCurrentInstance().update(
		 * "frmPromesa:pnlDlMensaje");
		 * RequestContext.getCurrentInstance().execute(
		 * "PF('dlPromesa').show();"); return; }
		 * 
		 * if ((ob.getInteresDescuento().compareTo(new BigDecimal(0))) == -1) {
		 * mensajeError = "No se puede Aplicar descuentos negativos";
		 * RequestContext.getCurrentInstance().update(
		 * "frmPromesa:pnlDlMensaje");
		 * RequestContext.getCurrentInstance().execute(
		 * "PF('dlPromesa').show();"); return; }
		 * 
		 * if ((ob.getCapitalDescuento().compareTo(ob.getDesc_capital())) == 1)
		 * { mensajeError = "No se puede Aplicar ese descuento a esta factura";
		 * RequestContext.getCurrentInstance().update(
		 * "frmPromesa:pnlDlMensaje");
		 * RequestContext.getCurrentInstance().execute(
		 * "PF('dlPromesa').show();"); return; }
		 * 
		 * if ((ob.getInteresDescuento().compareTo(ob.getDesc_interes())) == 1)
		 * { mensajeError = "No se puede Aplicar ese descuento a esta factura";
		 * RequestContext.getCurrentInstance().update(
		 * "frmPromesa:pnlDlMensaje");
		 * RequestContext.getCurrentInstance().execute(
		 * "PF('dlPromesa').show();"); return; }
		 * 
		 * ob.setTotalCapDesc(ob.getTotalCartera().subtract(
		 * ob.getTotalCartera().multiply( ob.getCapitalDescuento().divide(new
		 * BigDecimal(100)))));
		 * ob.setTotalIntDesc(ob.getInteresesMora().subtract(
		 * ob.getInteresesMora().multiply( ob.getInteresDescuento().divide(new
		 * BigDecimal(100)))));
		 * ob.setTotalCobro(ob.getTotalCapDesc().add(ob.getTotalIntDesc()));
		 * 
		 * for (Obligacion tmp : obligacionesCobro) { if
		 * (tmp.getFactura().equals(ob.getFactura())) { listaTempora.add(ob); }
		 * else { listaTempora.add(tmp); }
		 * 
		 * } obligacionesCobro.clear(); obligacionesCobro.addAll(listaTempora);
		 * calcularValorPromesa(); montoFraccion = null; cantCuotas = null;
		 * cuotas = new ArrayList<>(); fechaPromesa = null;
		 * RequestContext.getCurrentInstance().update("frmPromesa:pnlPromesa");
		 */
	}

	public void limpiarCuotas() {
		montoFraccion = null;
		saldoPromesa = totalPromesa;
		cantCuotas = null;
		cuotas = new ArrayList<>();
		fechaPromesa = null;
		RequestContext.getCurrentInstance().update("frmPromesa:pnlPromesa");

	}

	public void calcularValorPromesa() {
		totalPromesa = new BigDecimal(0);
		for (Obligacion ob : obligacionesCobro) {

			// totalPromesa = totalPromesa.add(ob.getTotalCobro());

		}
		if (porcentajeDescuento != null && porcentajeDescuento.compareTo(new BigDecimal(0)) == 1) {
			if ((porcentajeDescuento.compareTo(new BigDecimal(0))) == -1) {
				mensajeError = "No se puede Aplicar descuentos negativos";
				RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
				return;
			} else {
				totalPromesa = totalPromesa
						.subtract(totalPromesa.multiply(porcentajeDescuento.divide(new BigDecimal(100))));
			}
		}
		saldoPromesa = totalPromesa;
	}

	public void generarCuotas() {

		if (montoFraccion.compareTo(new BigDecimal(0)) == 0) {
			mensajeError = "El monto a fraccionar no puede ser 0";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (montoFraccion.equals(null)) {
			mensajeError = "El monto a fraccionar no puede estar vacio";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (montoFraccion.compareTo(new BigDecimal(0)) == -1) {
			mensajeError = "El monto a fraccionar no puede ser negativo";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (montoFraccion.compareTo(totalPromesa) == 1) {
			mensajeError = "El monto a fraccionar no puede ser mayor al total del acuerdo";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (montoFraccion.compareTo(saldoPromesa) == 1) {
			mensajeError = "El monto a fraccionar no puede ser mayor al saldo del acuerdo";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (cantCuotas > 3) {
			mensajeError = "No se puede generar mas de 3 cuotas";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (cantCuotas == null) {
			mensajeError = "La cantidad de cuotas no puede estar vacia";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (cantCuotas == 0) {
			mensajeError = "La cantidad de cuotas no puede ser 0";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (cantCuotas + cuotas.size() > 3) {
			mensajeError = "No se puede generar mas de 3 cuotas";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_MONTH, -1);

		if (fechaPromesa != null && fechaPromesa.before(now.getTime())) {
			mensajeError = "La fecha promesa no puede ser antes del dia actual";
			RequestContext.getCurrentInstance().update("frmPromesa:pnlDlMensaje");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;
		}

		if (!cuotas.isEmpty()) {
			// fechaPromesa = cuotas.get(cuotas.size() - 1).getFechaCuota();
		}

		BigDecimal cantidad = montoFraccion.divide(new BigDecimal(cantCuotas), 2, RoundingMode.HALF_UP);
		Cuota cuota = new Cuota();
		Date fechaTmp = new Date();
		int cantTmp = cuotas.size() + cantCuotas;
		for (int j = cuotas.size(); j < cantTmp; j++) {
			cuota = new Cuota();
			// cuota.setIdusuariocrea(Integer.parseInt(loginBean
			// .getUsuarioHermes().getCodusuario()));
			// cuota.setValor(cantidad);
			cuota.setNumeroCuota(j + 1);
			if (fechaPromesa == null) {
				now.add(Calendar.MONTH, 1);
				fechaTmp = now.getTime();
				// cuota.setFechaCuota(fechaTmp);
			}
			if (fechaPromesa != null && !cuotas.isEmpty()) {
				now.setTime(fechaPromesa);
				now.add(Calendar.MONTH, 1);
				fechaTmp = now.getTime();
				// cuota.setFechaCuota(fechaTmp);
				fechaPromesa = null;
			}

			if (fechaPromesa != null && cuotas.isEmpty()) {
				now.setTime(fechaPromesa);
				fechaTmp = now.getTime();
				// cuota.setFechaCuota(fechaTmp);
				fechaPromesa = null;
			}
			cuotas.add(cuota);
		}
		saldoPromesa = saldoPromesa.subtract(montoFraccion);
		montoFraccion = null;
		cantCuotas = null;
		fechaPromesa = null;
		RequestContext.getCurrentInstance().update("frmPromesa:pnlPromesa");

	}
	
	

	public void guardarPromesa() {
		if (idTipificacion == null || idTipificacion == 0 || StringUtils.isBlank(observacion)) {
			mensajeError = "No se puede guardar la gestión seleccione la tipificación y documente la observación";
			RequestContext.getCurrentInstance().update("frmPromesa:dlPromesa");
			RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
			return;

		}

		try {
			Gestion gestion = new Gestion();
			gestion.setObservacion(observacion);
			gestion.setIdtipificacion(idTipificacion);
			gestion.setIdcliente(String.valueOf((clienteBean.getCliente().getIdCliente())));
			gestion.setTelefonomarcado(clienteBean.getTelefonoMarcado());
			gestion.setIdusuariocrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			gestion.setIdcall(clienteBean.getCliente().getIdCall());
			gestion.setFechainiciollamada(new Timestamp(clienteBean.getFechaInicio().getTime()));
			gestion.setAsesor(loginBean.getUsuarioHermes().getNombre());
			gestion.setFechafinllamada(new Timestamp(new Date().getTime()));
			gestion.setEstado(2);
			
			
			Integer idGestion = 0;
			if (idTipificacion == 102){
				
				if (fechaPromesa == null ) {
					mensajeError = "No se puede guardar la gestión seleccione una fecha";
					RequestContext.getCurrentInstance().update("frmPromesa:dlPromesa");
					RequestContext.getCurrentInstance().execute("PF('dlPromesa').show();");
					return;

				}
				
				gestion.setFechapromesa(new Timestamp(fechaPromesa.getTime()));
				gestion.setValorpromesa(clienteBean.getValorCobro());
				 idGestion = gestionEJB.insertarGestion(gestion);
				List<FacturaGestion> facturaGestion =  clienteBean.getFacturasGestion();
				gestionEJB.insertarAcuerdoGestion(facturaGestion, gestion, idGestion);
			}
			else{
				 idGestion = gestionEJB.insertarGestion(gestion);
			}
			fin = true;
			inicio = false;
			RequestContext.getCurrentInstance().update("frmNoContacto:pnlNoContacto");
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

	public List<Obligacion> getObligaciones() {
		return obligaciones;
	}

	public void setObligaciones(List<Obligacion> obligaciones) {
		this.obligaciones = obligaciones;
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

	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}
