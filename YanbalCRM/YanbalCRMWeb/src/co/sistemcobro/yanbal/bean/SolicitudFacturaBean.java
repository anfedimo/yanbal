package co.sistemcobro.yanbal.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.ejb.ISolicitudFacturaEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "SolicitudFacturaBean")
@ViewScoped
public class SolicitudFacturaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4859543190445001027L;

	private String observacionAsesor;
	private String correoDestino;
	private int estado_solicitud;

	@EJB
	private ISolicitudFacturaEJBLocal SolicitudFacturaEJB;
	private List<Obligacion> listObligaciones;
	private Obligacion obligacion;
	private List<Obligacion> listFacturasSeleccionadas;
	private ClienteBean clienteBean;
	private LoginBean loginBean;

	@PostConstruct
	public void init() {
		estado_solicitud = 0;
		if (FacesContext.getCurrentInstance() != null) {

			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			if (clienteBean != null) {
				if (clienteBean.getCliente() != null) {
					//correoDestino = getClienteBean().getCliente().getCorreo();
				}
			}
			mostrarFacturasCliente();
			verificarEstadoSolicitud();

		}
	}

	public void verificarEstadoSolicitud() {

		try {
			if (clienteBean.getCliente() != null) {
				estado_solicitud = SolicitudFacturaEJB.validarEstadoSolicitud(clienteBean.getCliente().getCedulaCliente());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertarsolicitudfactura() {

		for (Obligacion obligacion : listFacturasSeleccionadas) {

			/*for (Obligacion contratos : clienteBean.getCliente().getObligaciones()) {
				if (contratos.getFactura().equals(obligacion.getFactura())) {
					obligacion.setContrato(contratos.getContrato());

				}
			}*/
		}

		SolicitudFacturaEJB.insertarSolictudFactura(clienteBean.getCliente().getCedulaCliente(), correoDestino,
				observacionAsesor, loginBean.getUsuarioHermes().getCodusuario(), listFacturasSeleccionadas);
		estado_solicitud = 1;
		RequestContext.getCurrentInstance().update("frmDatosCliente");

	}

	public void mostrarFacturasCliente() {
		if (clienteBean.getCliente() != null) {
			listObligaciones = new ArrayList<>();
			listObligaciones = SolicitudFacturaEJB.listaFacturas(clienteBean.getCliente().getCedulaCliente());
			RequestContext.getCurrentInstance().update("frmTablaFacturas:facturasDetalle");
		}
	}

	public ISolicitudFacturaEJBLocal getSolicitudFacturaEJB() {
		return SolicitudFacturaEJB;
	}

	public void setSolicitudFacturaEJB(ISolicitudFacturaEJBLocal solicitudFacturaEJB) {
		SolicitudFacturaEJB = solicitudFacturaEJB;
	}

	public List<Obligacion> getListObligaciones() {

		return listObligaciones;
	}

	public void setListObligaciones(List<Obligacion> listObligaciones) {
		this.listObligaciones = listObligaciones;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<Obligacion> getListFacturasSeleccionadas() {
		return listFacturasSeleccionadas;

	}

	public Obligacion getObligacion() {
		return obligacion;
	}

	public void setObligacion(Obligacion obligacion) {
		this.obligacion = obligacion;
	}

	public void setListFacturasSeleccionadas(List<Obligacion> listFacturasSeleccionadas) {
		this.listFacturasSeleccionadas = listFacturasSeleccionadas;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", ((Obligacion) event.getObject()).getFactura());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected", ((Obligacion) event.getObject()).getFactura());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getObservacionAsesor() {
		return observacionAsesor;
	}

	public void setObservacionAsesor(String observacionAsesor) {
		this.observacionAsesor = observacionAsesor;
	}

	public String getCorreoDestino() {
		return correoDestino;
	}

	public void setCorreoDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public int getEstado_solicitud() {
		return estado_solicitud;
	}

	public void setEstado_solicitud(int estado_solicitud) {
		this.estado_solicitud = estado_solicitud;
	}

}
