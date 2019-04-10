package co.sistemcobro.yanbal.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.sistemcobro.yanbal.bean.Cliente;
import co.sistemcobro.yanbal.bean.ClienteBean;
import co.sistemcobro.yanbal.bean.Descuento;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.ObligacionYanbal;
import co.sistemcobro.yanbal.bean.ObligacionGestion;
import co.sistemcobro.yanbal.bean.TipificarBean;
import co.sistemcobro.yanbal.ejb.IClienteEJBLocal;
import co.sistemcobro.yanbal.ejb.IDescuentoEJBLocal;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;
import co.sistemcobro.yanbal.ejb.IObligacionGestionEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;

@ManagedBean(name = "gestionBean")
@ViewScoped
public class GestionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private IGestionEJBLocal gestionEJB;

	@EJB
	private IObligacionGestionEJBLocal obligacionGestionEJB;

	@EJB
	private IClienteEJBLocal clienteEJB;

	@EJB
	private IDescuentoEJBLocal descuentoEJB;

	private Gestion gestion;
	private ObligacionGestion obligacionGestion;

	private TipificarBean tipificarBean;
	private ClienteBean cliente;
	private LoginBean login;
	private boolean resultado;
	private Integer guardo;

	private List<Descuento> descuentos;

	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			guardo = 0;
			tipificarBean = application.evaluateExpressionGet(context, "#{tipificarBean}", TipificarBean.class);
			cliente = application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class);
			login = application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		} catch (Exception e) {

		}

	}

	public void guardarGestion() throws Exception {
		try {

			// idtipificacion// 1
			if (tipificarBean.getSelectedCodigoTipificacion() == 107) {
				gestion.setIdtipificacion(tipificarBean.getIdTipificacion());
			} else {

			}

			// Idmotivonopago// 2
			if (tipificarBean.getIdmotivonopago() == null) {
				gestion.setIdmotivonopago(tipificarBean.getSelectedMotivo());
			} else {

			}

			// idparentesco// 3
			if (tipificarBean.getSelectedParentesco() == null) {
				gestion.setIdparentesco(tipificarBean.getSelectedParentesco());
			} else {

			}

			// nombretercero// 4
			if (tipificarBean.getNombreTercero() == null) {
				gestion.setNombretercero(tipificarBean.getNombreTercero());
			} else {

			}

			// TelefonoAgendado// 5
			if (tipificarBean.getTelefonoAgendado() == null) {
				gestion.setTelefonoagendamiento(tipificarBean.getTelefonoAgendado());
			} else {

			}

			// // idcliente// 6
			// if (cliente.getCliente() == null) {
			// gestion.setIdcliente(cliente.getCliente());
			// } else {
			//
			// }

			// fechainiciollamada// 7
			// fechafinllamada// 8

			// Telefonomarcado// 9
			if (cliente.getTelefonoMarcado() == null) {
				gestion.setTelefonomarcado(cliente.getTelefonoMarcado());
			} else {

			}

			// Nombrerazonsocial// 10
			if (cliente.getCliente().getNombreCliente() == null) {
				gestion.setNombrerazonsocial(cliente.getCliente().getNombreCliente());
			} else {

			}

			// asesor// 11
			if (login.getUsuarioHermes() == null) {
				gestion.setAsesor(login.getUsuarioHermes().getNombre());
			} else {

			}

			// // Nombrerazonsocial// 12
			// if (cliente.getCliente().getNomCompleto() != null) {
			// gestion.setNombrerazonsocial(cliente.getCliente().getNomCompleto());
			// } else {
			//
			// }

			// fechapromesa//13
			// fechaagendamiento// 14

			// // Numerocuota// 15
			// if (tipificarBean.getSelectedCuota() != null) {
			// gestion.setNumerocuota(tipificarBean.getSelectedCuota());
			// } else {
			//
			// }

			// // Valorcuota// 16
			// if (tipificarBean.getMontoCuota() != null) {
			// gestion.setValorcuota(tipificarBean.getMontoCuota());
			// } else {
			// }

			// Observacion// 17
			if (tipificarBean.getObservacion() != null) {
				gestion.setObservacion(tipificarBean.getObservacion());
			} else {
			}

			// Tipollamada// 18
			// if (tipificarBean.getTipollamada() != null) {
			gestion.setTipollamada("O");
			// } else {
			// }

			// Idcall// 19
			if (cliente.getIdCall() != null) {
				gestion.setIdcall(cliente.getIdCall());
			} else {
			}

			// Tipodiscado// 20
			if (cliente.getIdCall() != null) {
				gestion.setTipodiscado("PREDICTIVO");
			} else {
			}

			// Idusuariocrea// 21
			if (login.getUsuarioHermes().getIdusuario() != null) {
				gestion.setIdusuariocrea(Integer.parseInt(login.getUsuarioHermes().getIdusuario()));
			} else {
			}

			// // fechacrea// 22
			// gestion.setFechacrea(new Timestamp(ahora.getTime()));

			// idusuariomod // 23
			// if (gestion.getIdusuariomod() != null) {

			// } else {
			// }
			// fechamod // 24
			// if (gestion.getFechamod() != null) {

			// } else {
			// }
			// estado // 25
			// if (gestion.getEstado() != null) {
			gestion.setEstado(2);
			// } else {
			// }

			//resultado = gestionEJB.insertarGestion(gestion);

			tipificarBean.setTelefonoAgendado(null);
			tipificarBean.setSelectedTipificacion(null);
			tipificarBean.setObservacion(null);
			tipificarBean.setSelectedMotivo(null);
			tipificarBean.setFechaAgendamiento(null);
			tipificarBean.setFechaPromesa(null);
			tipificarBean.setMontoCuota(null);
			tipificarBean.setNumeroCuota(null);
			tipificarBean.setMontoPromesa(null);
			tipificarBean.setSelectedParentesco(null);
			tipificarBean.setNombreTercero(null);

//			int ultimaIdGestion = gestionEJB.buscarUltimaGestion();

			if (!resultado) {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Gestion no guardada "));
				guardo = 0;

			} else {

				guardo = 1;
				obligacionGestion = new ObligacionGestion();

				for (Obligacion obligacion : cliente.getCliente().getObligaciones()) {

//					obligacionGestion.setIdGestion(ultimaIdGestion);
					obligacionGestion.setIdObligacion(obligacion.getIdObligacion());
					obligacionGestion.setIdUsuariocrea(Integer.parseInt(login.getUsuarioHermes().getIdusuario()));

				}

			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se produjo un error "));
		} finally {

		}
	}

	public TipificarBean getTipificarBean() {
		return tipificarBean;
	}

	public void setTipificarBean(TipificarBean tipificarBean) {
		this.tipificarBean = tipificarBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IGestionEJBLocal getGestionEJB() {
		return gestionEJB;
	}

	public void setGestionEJB(IGestionEJBLocal gestionEJB) {
		this.gestionEJB = gestionEJB;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
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

	public IObligacionGestionEJBLocal getObligacionGestionEJB() {
		return obligacionGestionEJB;
	}

	public void setObligacionGestionEJB(IObligacionGestionEJBLocal obligacionGestionEJB) {
		this.obligacionGestionEJB = obligacionGestionEJB;
	}

	public ObligacionGestion getObligacionGestion() {
		return obligacionGestion;
	}

	public void setObligacionGestion(ObligacionGestion obligacionGestion) {
		obligacionGestion = obligacionGestion;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public Integer getGuardo() {
		return guardo;
	}

	public void setGuardo(Integer guardo) {
		this.guardo = guardo;
	}

	public IClienteEJBLocal getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public List<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	public IDescuentoEJBLocal getDescuentoEJB() {
		return descuentoEJB;
	}

	public void setDescuentoEJB(IDescuentoEJBLocal descuentoEJB) {
		this.descuentoEJB = descuentoEJB;
	}

}
