package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Descuento {

	private Integer idpolitica; 
	private Integer idcargue; 
	private Integer iddeudor; 
	private String documento; 
	private String cartera; 
	private String canal; 
	private String antiguedad; 
	private Double dk; 
	private Double dt;
	private Double min_1; 
	private Double max_1;
	private Double min_3; 
	private Double max_3;
	private Double min_6; 
	private Double max_6; 
	private Double min_12; 
	private Double max_12; 
	
	private Double minComodin; 
	private Double maxComodin;
	
	private Timestamp fechacrea; 
	private Integer estado;
	public Integer getIdpolitica() {
		return idpolitica;
	}
	public void setIdpolitica(Integer idpolitica) {
		this.idpolitica = idpolitica;
	}
	public Integer getIdcargue() {
		return idcargue;
	}
	public void setIdcargue(Integer idcargue) {
		this.idcargue = idcargue;
	}
	public Integer getIddeudor() {
		return iddeudor;
	}
	public void setIddeudor(Integer iddeudor) {
		this.iddeudor = iddeudor;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getCartera() {
		return cartera;
	}
	public void setCartera(String cartera) {
		this.cartera = cartera;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getDk() {
		return dk;
	}
	public void setDk(Double dk) {
		this.dk = dk;
	}
	public Double getDt() {
		return dt;
	}
	public void setDt(Double dt) {
		this.dt = dt;
	}
	public Double getMin_1() {
		return min_1;
	}
	public void setMin_1(Double min_1) {
		this.min_1 = min_1;
	}
	public Double getMax_1() {
		return max_1;
	}
	public void setMax_1(Double max_1) {
		this.max_1 = max_1;
	}
	public Double getMin_3() {
		return min_3;
	}
	public void setMin_3(Double min_3) {
		this.min_3 = min_3;
	}
	public Double getMax_3() {
		return max_3;
	}
	public void setMax_3(Double max_3) {
		this.max_3 = max_3;
	}
	public Double getMin_6() {
		return min_6;
	}
	public void setMin_6(Double min_6) {
		this.min_6 = min_6;
	}
	public Double getMax_6() {
		return max_6;
	}
	public void setMax_6(Double max_6) {
		this.max_6 = max_6;
	}
	public Double getMin_12() {
		return min_12;
	}
	public void setMin_12(Double min_12) {
		this.min_12 = min_12;
	}
	public Double getMax_12() {
		return max_12;
	}
	public void setMax_12(Double max_12) {
		this.max_12 = max_12;
	}
	public Timestamp getFechacrea() {
		return fechacrea;
	}
	public void setFechacrea(Timestamp fechacrea) {
		this.fechacrea = fechacrea;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Double getMinComodin() {
		return minComodin;
	}
	public void setMinComodin(Double minComodin) {
		this.minComodin = minComodin;
	}
	public Double getMaxComodin() {
		return maxComodin;
	}
	public void setMaxComodin(Double maxComodin) {
		this.maxComodin = maxComodin;
	}
	
	
	
	
}