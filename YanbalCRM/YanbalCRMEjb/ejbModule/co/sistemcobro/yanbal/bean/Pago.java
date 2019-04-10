package co.sistemcobro.yanbal.bean;

import java.sql.Time;
import java.sql.Timestamp;

public class Pago {
	
	private Integer idpago; 
	private Integer idcargue; 
	private String tipoReg; 
	private String numCta; 
	private String codUser; 
	private String descripcionUser; 
	private String descripcionPago; 
	private Timestamp fechaVencimiento; 
	private Double numItem; 
	private Double importePagado; 
	private Double importeMora; 
	private Double motoPagado; 
	private Timestamp fechaPago; 
	private Time horaPago; 
	private String numOp; 
	private String idUser; 
	private String idAg; 
	private String numLiquidacion; 
	private String codigoIdc; 
	private String observacion; 
	private Integer idusuarioCrea; 
	private Timestamp fechaCrea; 
	private Integer estado;
	
	public Integer getIdpago() {
		return idpago;
	}
	public void setIdpago(Integer idpago) {
		this.idpago = idpago;
	}
	public Integer getIdcargue() {
		return idcargue;
	}
	public void setIdcargue(Integer idcargue) {
		this.idcargue = idcargue;
	}
	public String getTipoReg() {
		return tipoReg;
	}
	public void setTipoReg(String tipoReg) {
		this.tipoReg = tipoReg;
	}
	public String getNumCta() {
		return numCta;
	}
	public void setNumCta(String numCta) {
		this.numCta = numCta;
	}
	public String getCodUser() {
		return codUser;
	}
	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
	public String getDescripcionUser() {
		return descripcionUser;
	}
	public void setDescripcionUser(String descripcionUser) {
		this.descripcionUser = descripcionUser;
	}
	public String getDescripcionPago() {
		return descripcionPago;
	}
	public void setDescripcionPago(String descripcionPago) {
		this.descripcionPago = descripcionPago;
	}
	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Double getNumItem() {
		return numItem;
	}
	public void setNumItem(Double numItem) {
		this.numItem = numItem;
	}
	public Double getImportePagado() {
		return importePagado;
	}
	public void setImportePagado(Double importePagado) {
		this.importePagado = importePagado;
	}
	public Double getImporteMora() {
		return importeMora;
	}
	public void setImporteMora(Double importeMora) {
		this.importeMora = importeMora;
	}
	public Double getMotoPagado() {
		return motoPagado;
	}
	public void setMotoPagado(Double motoPagado) {
		this.motoPagado = motoPagado;
	}
	public Timestamp getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Timestamp fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Time getHoraPago() {
		return horaPago;
	}
	public void setHoraPago(Time horaPago) {
		this.horaPago = horaPago;
	}
	public String getNumOp() {
		return numOp;
	}
	public void setNumOp(String numOp) {
		this.numOp = numOp;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdAg() {
		return idAg;
	}
	public void setIdAg(String idAg) {
		this.idAg = idAg;
	}
	public String getNumLiquidacion() {
		return numLiquidacion;
	}
	public void setNumLiquidacion(String numLiquidacion) {
		this.numLiquidacion = numLiquidacion;
	}
	public String getCodigoIdc() {
		return codigoIdc;
	}
	public void setCodigoIdc(String codigoIdc) {
		this.codigoIdc = codigoIdc;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getIdusuarioCrea() {
		return idusuarioCrea;
	}
	public void setIdusuarioCrea(Integer idusuarioCrea) {
		this.idusuarioCrea = idusuarioCrea;
	}
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
