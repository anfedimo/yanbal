package co.sistemcobro.yanbal.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import co.sistemcobro.yanbal.bean.Ciudad;
import co.sistemcobro.yanbal.bean.Cliente;
import co.sistemcobro.yanbal.bean.Departamento;
import co.sistemcobro.yanbal.bean.DireccionTipo;
import co.sistemcobro.yanbal.bean.FacturaGestion;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.Memo;
import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.bean.ObligacionYanbal;
import co.sistemcobro.yanbal.bean.Pago;
import co.sistemcobro.yanbal.constante.ColumnaValorEnum;
import co.sistemcobro.yanbal.ejb.IClienteEJBLocal;
import co.sistemcobro.yanbal.ejb.IDatosAdicionalesEJBLocal;
import co.sistemcobro.yanbal.ejb.IMemoEJBLocal;
import co.sistemcobro.yanbal.ejb.IPagoEJBLocal;
import co.sistemcobro.yanbal.ejb.ITelefonoEJBLocal;
import co.sistemcobro.yanbal.ejb.ITipoDireccionLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1250355351622573445L;

	private Cliente cliente;
	private Gestion gestion;
	private List<Memo> gestiones;
	private List<Departamento> departamentos;
	private List<Ciudad> ciudades;
	private String idDepartamento;
	private String idCiudad;
	private String idTipoDireccion;
	private List<DireccionTipo> tipodireccion;
	private BigDecimal cobroAcuerdo;
	private String valorAnadir;
	private List<String> facturas;
	private BigDecimal valorCobro;
	private List<FacturaGestion> facturasGestion;
	private String idgestion;
	private String Documento;
	private String mesajeError;
	private boolean comiteAbierto;
	private boolean comiteAprobado;
	private String telefonoMarcado;
	private Date fechaInicio;
	private boolean noExiste;
	private String idCall;
	private String connected_call;
	private List<Pago> pagos;

	@EJB
	private IClienteEJBLocal clienteEJB;

	@EJB
	private IMemoEJBLocal memoEJB;	
	@EJB
	private IPagoEJBLocal pagoEJB;
	@EJB
	private ITelefonoEJBLocal telefono;
	@EJB
	private IDatosAdicionalesEJBLocal datosAdicionalesEJB;
	@EJB
	private ITipoDireccionLocal tipoDireccionLocalEJB;
	private ExternalContext context;
	
	private NavegacionBean navegacionBean;
	private String idC;

	@PostConstruct
	public void init() {		
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			navegacionBean = application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class);			
			comiteAbierto = false;
			comiteAprobado = false;
			facturasGestion = new ArrayList<>();
			valorCobro = new BigDecimal(0);
			fechaInicio = new Date();
			telefonoMarcado = null;
			cliente = new Cliente();
			gestion = new Gestion();
			this.datosCliente();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	

	public void datosCliente() {
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String idCliente = (String) request.getParameter("idcliente");
		idgestion = (String) request.getParameter("idgestion");
		idCall = (String) request.getParameter("id_call");
		connected_call = (String) request.getParameter("connected_call");
		gestion.setIdcall(idCall);
		cliente.setIdCall(idCall);
		
		String id = this.getIdC();
		try {
			
			if(idCliente.isEmpty()){
				cliente.setCedulaCliente(id);
				
			}else{
				cliente.setCedulaCliente(idCliente);
			}
			
			if (connected_call != null) {
				if (!connected_call.isEmpty()) {
					setTelefonoMarcado(connected_call);
				}
			}
			fechaInicio = new Date();
			Cliente tmp = new Cliente();
			tmp = clienteEJB.detalleCliente(cliente);
			
			clienteEJB.obligacionesCliente(cliente);
			//pagos = pagoEJB.buscarPago(cliente.getDocumento());
			
			comiteAbierto = clienteEJB.comiteAbierto(cliente);
			comiteAprobado = clienteEJB.comiteAprobado(cliente);
			valorCobro = new BigDecimal(0);
			for (Obligacion obligacion : cliente.getObligaciones()) {
				obligacion.setValorTotalActualB(true);
				FacturaGestion fc = new FacturaGestion();
				fc.setId(obligacion.getIdObligacion());
				fc.setFactura(obligacion.getFactura());
				fc.setIdcolumna(ColumnaValorEnum.VALOR_TOTAL.getIndex());
				fc.setValor(obligacion.getValorTotalActual());
				facturasGestion.add(fc);
				valorCobro = valorCobro.add(obligacion.getValorTotalActual());
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		//return navegacionBean.redireccionUrl;
	}

	public void calcularCobro() {
		valorCobro = new BigDecimal(0);

		for (String fac : facturas) {
			valorCobro = valorCobro.add(new BigDecimal(fac));

		}

	}

	/*
	 * public void anadirTel(String tel) { if
	 * (StringUtils.isEmpty(telefonoMarcado)) { telefonoMarcado = tel; } else {
	 * telefonoMarcado = telefonoMarcado + "-" + tel; }
	 * 
	 * }
	 */

	public void error() {
		RequestContext.getCurrentInstance().execute("PF('dlg1').show();");
	}

	public void errorTotalCartera() {
		RequestContext.getCurrentInstance().execute("PF('dlg1').show();");
	}
	
	public void cambioValor1(Obligacion obligacion) {
		mesajeError = null;

		if (obligacion.isValorTotalActualB()) {
			mesajeError = "No puede generar este cobro porque Total Cartera esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setSaldoCapitalActualB(false);
			return;
		}
		
		
		if (obligacion.isSaldoCapitalActualB()) {
			valorCobro = valorCobro.add(obligacion.getSaldoCapitalActual());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.SALDO_CAPITAL.getIndex());
			fc.setValor(obligacion.getSaldoCapitalActual());
			//fc.setMaterial(obligacion.getMaterial());// agregue esta linea a
														// todos los cambio
														// valor porfavor
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getSaldoCapitalActual());
			int remove = -1, count = 0;
			
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.SALDO_CAPITAL.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}
	
	public void cambioValor2(Obligacion obligacion) {
		mesajeError = null;

		if (obligacion.isValorTotalActualB()) {
			mesajeError = "No puede generar este cobro porque Total Cartera esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setSaldoInteresesActualB(false);
			return;
		}
		
		
		if (obligacion.isSaldoInteresesActualB()) {
			valorCobro = valorCobro.add(obligacion.getSaldoInteresesActual());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.SALDO_INTERESES.getIndex());
			fc.setValor(obligacion.getSaldoInteresesActual());
			//fc.setMaterial(obligacion.getMaterial());// agregue esta linea a
														// todos los cambio
														// valor porfavor
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getSaldoInteresesActual());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.SALDO_CAPITAL.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}
	
	public void cambioValor3(Obligacion obligacion) {
		mesajeError = null;

		if (obligacion.isValorTotalActualB()) {
			mesajeError = "No puede generar este cobro porque Total Cartera esta cobrado!";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setSaldoGastoAdminActualB(false);
			return;
		}
		
		
		if (obligacion.isSaldoGastoAdminActualB()) {
			valorCobro = valorCobro.add(obligacion.getSaldoGastoAdminActual());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.SALDO_GASTO_ADMINISTRACION.getIndex());
			fc.setValor(obligacion.getSaldoGastoAdminActual());
			//fc.setMaterial(obligacion.getMaterial());// agregue esta linea a
														// todos los cambio
														// valor porfavor
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getSaldoGastoAdminActual());
			int remove = -1;
			int count = 0;
			
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.SALDO_CAPITAL.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}
	
	public void cambioValor4(Obligacion obligacion) {
		mesajeError = null;

		if (obligacion.isSaldoCapitalActualB()) {
			mesajeError = "No puede generar este cobro porque Saldo Capital esta seleccionado";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setValorTotalActualB(false);
			return;
		}
		
		if (obligacion.isSaldoInteresesActualB()) {
			mesajeError = "No puede generar este cobro porque Saldo Intereses esta seleccionado";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setValorTotalActualB(false);
			return;
		}
		
		if (obligacion.isSaldoGastoAdminActualB()) {
			mesajeError = "No puede generar este cobro porque Saldo Gasto Administracion esta seleccionado";
			error();
			RequestContext.getCurrentInstance().update("obligaciones");
			obligacion.setValorTotalActualB(false);
			return;
		}
		
		
		if (obligacion.isValorTotalActualB()) {
			valorCobro = valorCobro.add(obligacion.getValorTotalActual());
			FacturaGestion fc = new FacturaGestion();
			fc.setFactura(obligacion.getFactura());
			fc.setIdcolumna(ColumnaValorEnum.VALOR_TOTAL.getIndex());
			fc.setValor(obligacion.getValorTotalActual());
			//fc.setMaterial(obligacion.getMaterial());// agregue esta linea a
														// todos los cambio
														// valor porfavor
			facturasGestion.add(fc);

		} else {
			valorCobro = valorCobro.subtract(obligacion.getValorTotalActual());
			int remove = -1, count = 0;
			;
			for (FacturaGestion fc : facturasGestion) {

				if (fc.getFactura() == obligacion.getFactura()
						&& fc.getIdcolumna() == ColumnaValorEnum.SALDO_CAPITAL.getIndex()) {
					remove = count;
				}
				count++;
			}
			if (remove != -1) {
				facturasGestion.remove(remove);
			}
		}

	}
	

	
	public void memo() throws Exception {
		gestiones = new ArrayList<>();
		memoEJB.listaGestion(cliente.getCedulaCliente(), gestiones);
		RequestContext.getCurrentInstance().update("frmMemo:pnlMemo");
	}
	
	public void mostrarPago() throws Exception {
		pagos = pagoEJB.buscarPago(cliente.getCedulaCliente());
		RequestContext.getCurrentInstance().update("frmPago:pnlPago");
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public List<Memo> getGestiones() {
		return gestiones;
	}

	public void setGestiones(List<Memo> gestiones) {
		this.gestiones = gestiones;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public List<DireccionTipo> getTipodireccion() {
		return tipodireccion;
	}

	public void setTipodireccion(List<DireccionTipo> tipodireccion) {
		this.tipodireccion = tipodireccion;
	}

	public String getIdTipoDireccion() {
		return idTipoDireccion;
	}

	public void setIdTipoDireccion(String idTipoDireccion) {
		this.idTipoDireccion = idTipoDireccion;
	}

	public BigDecimal getCobroAcuerdo() {
		return cobroAcuerdo;
	}

	public void setCobroAcuerdo(BigDecimal cobroAcuerdo) {
		this.cobroAcuerdo = cobroAcuerdo;
	}

	public String getValorAnadir() {
		return valorAnadir;
	}

	public void setValorAnadir(String valorAnadir) {
		this.valorAnadir = valorAnadir;
	}

	public List<String> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<String> facturas) {
		this.facturas = facturas;
	}

	public BigDecimal getValorCobro() {
		return valorCobro;
	}

	public void setValorCobro(BigDecimal valorCobro) {
		this.valorCobro = valorCobro;
	}

	public List<FacturaGestion> getFacturasGestion() {
		return facturasGestion;
	}

	public void setFacturasGestion(List<FacturaGestion> facturasGestion) {
		this.facturasGestion = facturasGestion;
	}

	public String getIdgestion() {
		return idgestion;
	}

	public void setIdgestion(String idgestion) {
		this.idgestion = idgestion;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String Documento) {
		this.Documento = Documento;
	}

	public ITelefonoEJBLocal getTelefono() {
		return telefono;
	}

	public void setTelefono(ITelefonoEJBLocal telefono) {
		this.telefono = telefono;
	}

	public String getMesajeError() {
		return mesajeError;
	}

	public void setMesajeError(String mesajeError) {
		this.mesajeError = mesajeError;
	}

	public boolean isComiteAprobado() {
		return comiteAprobado;
	}

	public void setComiteAprobado(boolean comiteAprobado) {
		this.comiteAprobado = comiteAprobado;
	}

	public boolean isComiteAbierto() {
		return comiteAbierto;
	}

	public void setComiteAbierto(boolean comiteAbierto) {
		this.comiteAbierto = comiteAbierto;
	}

	public String getTelefonoMarcado() {
		return telefonoMarcado;
	}

	public void setTelefonoMarcado(String telefonoMarcado) {
		this.telefonoMarcado = telefonoMarcado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public ExternalContext getContext() {
		return context;
	}

	public void setContext(ExternalContext context) {
		this.context = context;
	}

	public boolean isNoExiste() {
		return noExiste;
	}

	public void setNoExiste(boolean noExiste) {
		this.noExiste = noExiste;
	}

	public String getIdCall() {
		return idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	public IClienteEJBLocal getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public IMemoEJBLocal getMemoEJB() {
		return memoEJB;
	}

	public void setMemoEJB(IMemoEJBLocal memoEJB) {
		this.memoEJB = memoEJB;
	}

	public IDatosAdicionalesEJBLocal getDatosAdicionalesEJB() {
		return datosAdicionalesEJB;
	}

	public void setDatosAdicionalesEJB(IDatosAdicionalesEJBLocal datosAdicionalesEJB) {
		this.datosAdicionalesEJB = datosAdicionalesEJB;
	}

	public ITipoDireccionLocal getTipoDireccionLocalEJB() {
		return tipoDireccionLocalEJB;
	}

	public void setTipoDireccionLocalEJB(ITipoDireccionLocal tipoDireccionLocalEJB) {
		this.tipoDireccionLocalEJB = tipoDireccionLocalEJB;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getConnected_call() {
		return connected_call;
	}

	public void setConnected_call(String connected_call) {
		this.connected_call = connected_call;
	}



	public String getIdC() {
		return idC;
	}



	public void setIdC(String idC) {
		this.idC = idC;
	}



	public Gestion getGestion() {
		return gestion;
	}


	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}



	public List<Pago> getPagos() {
		return pagos;
	}



	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
	

	
}