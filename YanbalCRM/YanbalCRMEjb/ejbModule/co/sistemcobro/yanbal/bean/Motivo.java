package co.sistemcobro.yanbal.bean;

import java.sql.Timestamp;

public class Motivo {
	  private Integer idmotivonopago; 
	  private String codigomotivo; 
	  private String nombre; 
	  private Integer idusuariocrea; 
	  private Timestamp fechacrea; 
	  private Integer idusuariomod; 
	  private Timestamp fechamod; 
	  private Timestamp fechafin; 
	  private Integer estado;
	public Integer getIdmotivonopago() {
		return idmotivonopago;
	}
	public void setIdmotivonopago(Integer idmotivonopago) {
		this.idmotivonopago = idmotivonopago;
	}
	public String getCodigomotivo() {
		return codigomotivo;
	}
	public void setCodigomotivo(String codigomotivo) {
		this.codigomotivo = codigomotivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdusuariocrea() {
		return idusuariocrea;
	}
	public void setIdusuariocrea(Integer idusuariocrea) {
		this.idusuariocrea = idusuariocrea;
	}
	public Timestamp getFechacrea() {
		return fechacrea;
	}
	public void setFechacrea(Timestamp fechacrea) {
		this.fechacrea = fechacrea;
	}
	public Integer getIdusuariomod() {
		return idusuariomod;
	}
	public void setIdusuariomod(Integer idusuariomod) {
		this.idusuariomod = idusuariomod;
	}
	public Timestamp getFechamod() {
		return fechamod;
	}
	public void setFechamod(Timestamp fechamod) {
		this.fechamod = fechamod;
	}
	public Timestamp getFechafin() {
		return fechafin;
	}
	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	  
	  
}
