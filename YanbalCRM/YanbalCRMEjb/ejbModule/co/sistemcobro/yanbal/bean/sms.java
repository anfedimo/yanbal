package co.sistemcobro.yanbal.bean;

public class sms {

	private Integer id;
	private String segmento;
	private String texto;
	private Integer asesor;
	private String celular;
	private String cliente;
	private String repuesta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getAsesor() {
		return asesor;
	}

	public void setAsesor(Integer asesor) {
		this.asesor = asesor;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getRepuesta() {
		return repuesta;
	}

	public void setRepuesta(String repuesta) {
		this.repuesta = repuesta;
	}

}
