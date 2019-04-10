package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;

public class FacturaGestion {

	private int id;
	private String factura;
	private Integer idcolumna;
	private BigDecimal Valor;
	private String material;


	public BigDecimal getValor() {
		return Valor;
	}

	public void setValor(BigDecimal valor) {
		Valor = valor;
	}

	public Integer getIdcolumna() {
		return idcolumna;
	}

	public void setIdcolumna(Integer idcolumna) {
		this.idcolumna = idcolumna;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getMaterial() {
		return material != null ? material : "";
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
