package co.sistemcobro.yanbal.bean;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.primefaces.context.RequestContext;

import co.sistemcobro.yanbal.bean.Telefono;
import co.sistemcobro.yanbal.bean.sms;
import co.sistemcobro.yanbal.ejb.ISmsEJBLocal;
import co.sistemcobro.yanbal.ejb.ITelefonoEJBLocal;
import co.sistemcobro.yanbal.session.LoginBean;
import sun.misc.BASE64Encoder;

@ManagedBean(name = "smsBean")
@ViewScoped
public class smsBean {

	Logger logger = Logger.getLogger(smsBean.class);
	@EJB
	private ISmsEJBLocal smsEJB;
	@EJB
	private ITelefonoEJBLocal telefono;
	private List<sms> mensajes;
	private ClienteBean clienteBean;
	private LoginBean loginBean;
	private List<Telefono> telefonos;
	private Integer idSms;
	private String tel;
	private boolean inicio;
	private boolean fin;
	private sms sms;
	private String error;

	@PostConstruct
	public void init() {
		try {
			inicio = true;
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			setClienteBean(application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			setLoginBean(application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			//String[] segmentos = clienteBean.getCliente().getTramo().split(":");
			//String segmento = segmentos[0].replace(" ", "");
			//mensajes = smsEJB.buscarMensajes(segmento);
			for (sms s : mensajes) {
				s.setTexto(s.getTexto().replace("$P(ASESOR)", loginBean.getUsuarioHermes().getNombre()));
			}
			setTelefonos(telefono.listaTelefono(clienteBean.getCliente().getCedulaCliente()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actualizarTels(){
		setTelefonos(telefono.listaTelefono(clienteBean.getCliente().getCedulaCliente()));
		RequestContext.getCurrentInstance().update("frmSMS:pnlSMS");
	}

	public void enviarOtro() {
		inicio = true;
		fin = false;
		tel = "";
		sms = null;
	}

	public void enviar() {
		try {
			if(StringUtils.isBlank(tel)){
				error = "No se puede enviar el sms si no selecciona un n&uacute;mero celular";
				RequestContext.getCurrentInstance().update("frmSMS:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlinfoSMS').show();");
				return;
				//dlinfoSMS
			}
			if(sms==null){
				error = "No se puede enviar el sms si no selecciona un Mensaje";
				RequestContext.getCurrentInstance().update("frmSMS:pnlDlMensaje");
				RequestContext.getCurrentInstance().execute("PF('dlinfoSMS').show();");
				return;
			}
			inicio = false;
			fin = true;
			sms.setCelular("51"+tel);
			sms.setRepuesta(enviarSMS(sms));
			sms.setCliente(clienteBean.getCliente().getCedulaCliente());
			sms.setAsesor(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			smsEJB.insertarSMS(sms);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String enviarSMS(sms mensaje) {
		URL url = null;
		HttpURLConnection conn = null;
		String output = null;
		try {
			JSONObject data = new JSONObject();
			data.put("text", mensaje.getTexto());
			data.put("to", mensaje.getCelular());
			url = new URL("http://api.infobip.com/sms/1/text/single");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			String authString = "WS-SISTEMCOBRO" + ":" + "wsmi_Bogot@2018";
			BASE64Encoder encoder = new BASE64Encoder();
			String authStringEnc = encoder.encode(authString.getBytes());
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(data.toString().getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String response;
			while ((response = br.readLine()) != null) {
				output = response;
			}
		} catch (Exception e) {
			logger.error("Error enviando SMS:", e);
		} finally {
			conn.disconnect();
		}
		return output;
	}

	public List<sms> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<sms> mensajes) {
		this.mensajes = mensajes;
	}

	public ISmsEJBLocal getSmsEJB() {
		return smsEJB;
	}

	public void setSmsEJB(ISmsEJBLocal smsEJB) {
		this.smsEJB = smsEJB;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Integer getIdSms() {
		return idSms;
	}

	public void setIdSms(Integer idSms) {
		this.idSms = idSms;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public sms getSms() {
		return sms;
	}

	public void setSms(sms sms) {
		this.sms = sms;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
