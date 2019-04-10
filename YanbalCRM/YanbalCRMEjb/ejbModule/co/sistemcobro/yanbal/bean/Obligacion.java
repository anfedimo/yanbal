package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class Obligacion {
	
	private Integer idObligacion;
	private String factura;
	private BigDecimal valorInicial;
	private Date fechaVencimiento;
	private BigDecimal saldoCapitalInicial;
	private BigDecimal saldoInteresInicial;
	private BigDecimal salgoGastoAdminInicial;
	private BigDecimal valorTotalInicial;
	private Integer diaMoraInicial;
	private String edadMoraInicial;
	private String indPrimerPedido;
	private BigDecimal saldoCapitalActual;
	private BigDecimal saldoInteresesActual;
	private BigDecimal saldoGastoAdminActual;
	private BigDecimal valorTotalActual;
	private Integer diaMoraActual;
	private String edadMoraActual;
	private String retribucion;
	
	private String saldoCapitalActualS;
	private String saldoInteresesActualS;
	private String saldoGastoAdminActualS;
	private String valorTotalActualS;
	
	private boolean saldoCapitalActualB;
	private boolean saldoInteresesActualB;
	private boolean saldoGastoAdminActualB;
	private boolean valorTotalActualB;
	private String mombreCargue;
	
	
	
	public Integer getIdObligacion() {
		return idObligacion;
	}
	public void setIdObligacion(Integer idObligacion) {
		this.idObligacion = idObligacion;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public BigDecimal getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public BigDecimal getSaldoCapitalInicial() {
		return saldoCapitalInicial;
	}
	public void setSaldoCapitalInicial(BigDecimal saldoCapitalInicial) {
		this.saldoCapitalInicial = saldoCapitalInicial;
	}
	public BigDecimal getSaldoInteresInicial() {
		return saldoInteresInicial;
	}
	public void setSaldoInteresInicial(BigDecimal saldoInteresInicial) {
		this.saldoInteresInicial = saldoInteresInicial;
	}
	public BigDecimal getSalgoGastoAdminInicial() {
		return salgoGastoAdminInicial;
	}
	public void setSaldoGastoAdminInicial(BigDecimal salgoGastoAdminInicial) {
		this.salgoGastoAdminInicial = salgoGastoAdminInicial;
	}
	public BigDecimal getvalorTotalInicial() {
		return valorTotalInicial;
	}
	public void setvalorTotalInicial(BigDecimal valorTotalInicial) {
		this.valorTotalInicial = valorTotalInicial;
	}
	public Integer getDiaMoraInicial() {
		return diaMoraInicial;
	}
	public void setDiaMoraInicial(Integer diaMoraInicial) {
		this.diaMoraInicial = diaMoraInicial;
	}
	public String getEdadMoraInicial() {
		return edadMoraInicial;
	}
	public void setEdadMoraInicial(String edadMoraInicial) {
		this.edadMoraInicial = edadMoraInicial;
	}
	public String getIndPrimerPedido() {
		return indPrimerPedido;
	}
	public void setIndPrimerPedido(String indPrimerPedido) {
		this.indPrimerPedido = indPrimerPedido;
	}
	public BigDecimal getSaldoCapitalActual() {
		return saldoCapitalActual;
	}
	public void setSaldoCapitalActual(BigDecimal saldoCapitalActual) {
		this.saldoCapitalActual = saldoCapitalActual;
	}
	public BigDecimal getSaldoInteresesActual() {
		return saldoInteresesActual;
	}
	public void setSaldoInteresesActual(BigDecimal saldoInteresesActual) {
		this.saldoInteresesActual = saldoInteresesActual;
	}
	public BigDecimal getSaldoGastoAdminActual() {
		return saldoGastoAdminActual;
	}
	public void setSaldoGastoAdminActual(BigDecimal saldoGastoAdminActual) {
		this.saldoGastoAdminActual = saldoGastoAdminActual;
	}
	public BigDecimal getValorTotalActual() {
		return valorTotalActual;
	}
	public void setValorTotalActual(BigDecimal valorTotalActual) {
		this.valorTotalActual = valorTotalActual;
	}
	public Integer getDiaMoraActual() {
		return diaMoraActual;
	}
	public void setDiaMoraActual(Integer diaMoraActual) {
		this.diaMoraActual = diaMoraActual;
	}
	public String getEdadMoraActual() {
		return edadMoraActual;
	}
	public void setEdadMoraActual(String edadMoraActual) {
		this.edadMoraActual = edadMoraActual;
	}
	
	public String getRetribucion() {
		return retribucion;
	}
	public void setRetribucion(String retribucion) {
		this.retribucion = retribucion;
	}

	public String getSaldoCapitalActualS() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		return format.format(saldoCapitalActual);
	}
	public void setSaldoCapitalActualS(String saldoCapitalActualS) {
		this.saldoCapitalActualS = saldoCapitalActualS;
	}
	public String getSaldoInteresesActualS() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		return format.format(saldoInteresesActual);
	}
	public void setSaldoInteresesActualS(String saldoInteresesActualS) {
		this.saldoInteresesActualS = saldoInteresesActualS;
	}
	public String getSaldoGastoAdminActualS() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		return format.format(saldoGastoAdminActual);
	}
	public void setSaldoGastoAdminActualS(String saldoGastoAdminActualS) {
		this.saldoGastoAdminActualS = saldoGastoAdminActualS;
	}
	public String getValorTotalActualS() {
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		return format.format(valorTotalActual);
	}
	public void setValorTotalActualS(String valorTotalActualS) {
		this.valorTotalActualS = valorTotalActualS;
	}
	public boolean isSaldoCapitalActualB() {
		return saldoCapitalActualB;
	}
	public void setSaldoCapitalActualB(boolean saldoCapitalActualB) {
		this.saldoCapitalActualB = saldoCapitalActualB;
	}
	public boolean isSaldoInteresesActualB() {
		return saldoInteresesActualB;
	}
	public void setSaldoInteresesActualB(boolean saldoInteresesActualB) {
		this.saldoInteresesActualB = saldoInteresesActualB;
	}
	public boolean isSaldoGastoAdminActualB() {
		return saldoGastoAdminActualB;
	}
	public void setSaldoGastoAdminActualB(boolean saldoGastoAdminActualB) {
		this.saldoGastoAdminActualB = saldoGastoAdminActualB;
	}
	public boolean isValorTotalActualB() {
		return valorTotalActualB;
	}
	public void setValorTotalActualB(boolean valorTotalActualB) {
		this.valorTotalActualB = valorTotalActualB;
	}
	public BigDecimal getValorTotalInicial() {
		return valorTotalInicial;
	}
	public void setValorTotalInicial(BigDecimal valorTotalInicial) {
		this.valorTotalInicial = valorTotalInicial;
	}
	public String getMombreCargue() {
		return mombreCargue;
	}
	public void setMombreCargue(String mombreCargue) {
		this.mombreCargue = mombreCargue;
	}
	public void setSalgoGastoAdminInicial(BigDecimal salgoGastoAdminInicial) {
		this.salgoGastoAdminInicial = salgoGastoAdminInicial;
	}
	
	
	
	
	
	
	
	
}
