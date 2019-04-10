package co.sistemcobro.yanbal.bean;

import java.sql.Timestamp;

public class TelefonoDatosAdicionales {

	private Integer idTelefono;
	private String identificacion;
	private String tipo;
	private String telefono;
	
	private Integer idUsuarioCrea;
	private Integer idUsuarioMod;
	private Timestamp fechaCrea;
	private Timestamp fechamMod;
	private Integer estado;
	public Integer getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getIdUsuarioCrea() {
		return idUsuarioCrea;
	}
	public void setIdUsuarioCrea(Integer idUsuarioCrea) {
		this.idUsuarioCrea = idUsuarioCrea;
	}
	public Integer getIdUsuarioMod() {
		return idUsuarioMod;
	}
	public void setIdUsuarioMod(Integer idUsuarioMod) {
		this.idUsuarioMod = idUsuarioMod;
	}
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Timestamp getFechamMod() {
		return fechamMod;
	}
	public void setFechamMod(Timestamp fechamMod) {
		this.fechamMod = fechamMod;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
	
}
