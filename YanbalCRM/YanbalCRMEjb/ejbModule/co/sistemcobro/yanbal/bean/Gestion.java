package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Gestion {

	private Integer idgestion;
	private Integer idtipificacion;
	private Integer idmotivonopago;
	private Integer idparentesco;
	private String nombretercero;
	private String telefonoagendamiento;
	private String idcliente;
	private Timestamp fechainiciollamada;
	private Timestamp fechafinllamada;
	private String telefonomarcado;
	private String nombrerazonsocial;
	private String asesor;
	private BigDecimal valorpromesa;
	private Timestamp fechapromesa;
	private Timestamp fechaagendamiento;
	private Integer numerocuota;
	private BigDecimal valorcuota;
	private String observacion;
	private String tipollamada;
	private String idcall;
	private String tipodiscado;
	private Integer idusuariocrea;
	private Timestamp fechacrea;
	private Integer idusuariomod;
	private Timestamp fechamod;
	private Integer estado;

	public Integer getIdgestion() {
		return idgestion;
	}

	public void setIdgestion(Integer idgestion) {
		this.idgestion = idgestion;
	}

	public Integer getIdtipificacion() {
		return idtipificacion;
	}

	public void setIdtipificacion(Integer idtipificacion) {
		this.idtipificacion = idtipificacion;
	}


	public Integer getIdmotivonopago() {
		return idmotivonopago;
	}

	public void setIdmotivonopago(Integer idmotivonopago) {
		this.idmotivonopago = idmotivonopago;
	}

	public Integer getIdparentesco() {
		return idparentesco;
	}

	public void setIdparentesco(Integer idparentesco) {
		this.idparentesco = idparentesco;
	}

	public String getNombretercero() {
		return nombretercero;
	}

	public void setNombretercero(String nombretercero) {
		this.nombretercero = nombretercero;
	}

	public String getTelefonoagendamiento() {
		return telefonoagendamiento;
	}

	public void setTelefonoagendamiento(String telefonoagendamiento) {
		this.telefonoagendamiento = telefonoagendamiento;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public Timestamp getFechainiciollamada() {
		return fechainiciollamada;
	}

	public void setFechainiciollamada(Timestamp fechainiciollamada) {
		this.fechainiciollamada = fechainiciollamada;
	}

	public Timestamp getFechafinllamada() {
		return fechafinllamada;
	}

	public void setFechafinllamada(Timestamp fechafinllamada) {
		this.fechafinllamada = fechafinllamada;
	}

	public String getTelefonomarcado() {
		return telefonomarcado;
	}

	public void setTelefonomarcado(String telefonomarcado) {
		this.telefonomarcado = telefonomarcado;
	}


	public String getNombrerazonsocial() {
		return nombrerazonsocial;
	}

	public void setNombrerazonsocial(String nombrerazonsocial) {
		this.nombrerazonsocial = nombrerazonsocial;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public BigDecimal getValorpromesa() {
		return valorpromesa;
	}

	public void setValorpromesa(BigDecimal valorpromesa) {
		this.valorpromesa = valorpromesa;
	}

	public Timestamp getFechapromesa() {
		return fechapromesa;
	}

	public void setFechapromesa(Timestamp fechapromesa) {
		this.fechapromesa = fechapromesa;
	}

	public Timestamp getFechaagendamiento() {
		return fechaagendamiento;
	}

	public void setFechaagendamiento(Timestamp fechaagendamiento) {
		this.fechaagendamiento = fechaagendamiento;
	}

	public Integer getNumerocuota() {
		return numerocuota;
	}

	public void setNumerocuota(Integer numerocuota) {
		this.numerocuota = numerocuota;
	}

	public BigDecimal getValorcuota() {
		return valorcuota;
	}

	public void setValorcuota(BigDecimal valorcuota) {
		this.valorcuota = valorcuota;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipollamada() {
		return tipollamada;
	}

	public void setTipollamada(String tipollamada) {
		this.tipollamada = tipollamada;
	}


	public String getIdcall() {
		return idcall;
	}

	public void setIdcall(String idcall) {
		this.idcall = idcall;
	}

	public String getTipodiscado() {
		return tipodiscado;
	}

	public void setTipodiscado(String tipodiscado) {
		this.tipodiscado = tipodiscado;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
