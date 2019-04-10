package co.sistemcobro.yanbal.bean;

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
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.Telefono;
import co.sistemcobro.yanbal.bean.UsuarioAplicacion;
import co.sistemcobro.yanbal.ejb.IClienteEJBLocal;
import co.sistemcobro.yanbal.ejb.IDatosAdicionalesEJBLocal;
import co.sistemcobro.yanbal.ejb.ITelefonoEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "datosAdicionalesBean")
@ViewScoped
public class DatosAdicionalesBean {

	private List<DatosAdicionales> datosAdicionales;
	private List<Telefono> telefonos;
	private List<TelefonoDatosAdicionales> telefonosNuevos;
	private DatosAdicionales datoAdicional;
	private TelefonoDatosAdicionales telefonoDatosAdicionales;

	private ClienteBean clienteBean;
	private LoginBean loginBean;
	
	private String nuevoTipoTelefono;
	private String nuevoTelefono;

	private UsuarioAplicacion usuarioAplicacion;

	@EJB
	private IClienteEJBLocal clienteEJB;

	@EJB
	private IDatosAdicionalesEJBLocal datosAdicionalesEJB;

	@EJB
	private ITelefonoEJBLocal telefono;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));

			try {
				telefonos = new ArrayList<>();
				telefonosNuevos = new ArrayList<>();
				datosAdicionales = new ArrayList<>();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	
	public void guardarTelefono(){
		telefonoDatosAdicionales = new TelefonoDatosAdicionales();
		try {
			Integer idUsuario = Integer.parseInt(loginBean.getUsuarioHermes().getIdusuario());
			
			telefonoDatosAdicionales.setIdentificacion(clienteBean.getCliente().getCedulaCliente());
			telefonoDatosAdicionales.setTipo(nuevoTipoTelefono);
			telefonoDatosAdicionales.setTelefono(nuevoTelefono);
			telefonoDatosAdicionales.setIdUsuarioCrea(idUsuario);
			
			if(datosAdicionalesEJB.insertarTelefono(telefonoDatosAdicionales) >=0 ){
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se guardo "));
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Ocurrio un error "));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void datosAdicionales() {
		try {
			datosAdicionales = datosAdicionalesEJB.listaDatosAdicionales(clienteBean.getCliente().getCedulaCliente());
			RequestContext.getCurrentInstance().update("frmDatosAdicionales:pnlDatosAdicionales");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void telefonos() {
		try {
			telefonos = telefono.listaTelefono(clienteBean.getCliente().getCedulaCliente());
			telefonosNuevos = telefono.telefonosNuevos(clienteBean.getCliente().getCedulaCliente());
			RequestContext.getCurrentInstance().update("pnlTelefonos");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Editando", ((DatosAdicionales) event.getObject()).getIdentificacion());

		datoAdicional = new DatosAdicionales();
		try {
			datoAdicional.setNombre(((DatosAdicionales) event.getObject()).getNombre());
			datoAdicional.setApellido(((DatosAdicionales) event.getObject()).getApellido());
			datoAdicional.setDireccion(((DatosAdicionales) event.getObject()).getDireccion());
			datoAdicional.setEmail(((DatosAdicionales) event.getObject()).getEmail());
			datoAdicional.setTelefono(((DatosAdicionales) event.getObject()).getTelefono());
			datoAdicional.setCelular(((DatosAdicionales) event.getObject()).getCelular());
			datoAdicional.setNumeroAdicional(((DatosAdicionales) event.getObject()).getNumeroAdicional());

			datoAdicional.setIdentificacion(((DatosAdicionales) event.getObject()).getIdentificacion());
			datoAdicional.setIdCargue(((DatosAdicionales) event.getObject()).getIdCargue());

			if(datosAdicionalesEJB.actualizarDatos(datoAdicional) >=0 ){
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se actualizo "));
			}else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Ocurrio un error "));
			}

			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelando", ((DatosAdicionales) event.getObject()).getIdentificacion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio",
					"Anterior: " + oldValue + ", Nuevo:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public ITelefonoEJBLocal getTelefono() {
		return telefono;
	}

	public void setTelefono(ITelefonoEJBLocal telefono) {
		this.telefono = telefono;
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

	public UsuarioAplicacion getUsuarioAplicacion() {
		return usuarioAplicacion;
	}

	public void setUsuarioAplicacion(UsuarioAplicacion usuarioAplicacion) {
		this.usuarioAplicacion = usuarioAplicacion;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public IClienteEJBLocal getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public IDatosAdicionalesEJBLocal getDatosAdicionalesEJB() {
		return datosAdicionalesEJB;
	}

	public void setDatosAdicionalesEJB(IDatosAdicionalesEJBLocal datosAdicionalesEJB) {
		this.datosAdicionalesEJB = datosAdicionalesEJB;
	}

	public List<DatosAdicionales> getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(List<DatosAdicionales> datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public DatosAdicionales getDatoAdicional() {
		return datoAdicional;
	}

	public void setDatoAdicional(DatosAdicionales datoAdicional) {
		this.datoAdicional = datoAdicional;
	}

	public String getNuevoTipoTelefono() {
		return nuevoTipoTelefono;
	}

	public void setNuevoTipoTelefono(String nuevoTipoTelefono) {
		this.nuevoTipoTelefono = nuevoTipoTelefono;
	}

	public String getNuevoTelefono() {
		return nuevoTelefono;
	}

	public void setNuevoTelefono(String nuevoTelefono) {
		this.nuevoTelefono = nuevoTelefono;
	}

	public TelefonoDatosAdicionales getTelefonoDatosAdicionales() {
		return telefonoDatosAdicionales;
	}

	public void setTelefonoDatosAdicionales(TelefonoDatosAdicionales telefonoDatosAdicionales) {
		this.telefonoDatosAdicionales = telefonoDatosAdicionales;
	}

	public List<TelefonoDatosAdicionales> getTelefonosNuevos() {
		return telefonosNuevos;
	}

	public void setTelefonosNuevos(List<TelefonoDatosAdicionales> telefonosNuevos) {
		this.telefonosNuevos = telefonosNuevos;
	}
	
	
	
	

}
