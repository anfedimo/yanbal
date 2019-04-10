package co.sistemcobro.yanbal.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ObligacionYanbal {
	
	private Integer idobligacion; 
	private Integer idcargue; 
	private Integer iddeudor; 
	private String documento; 
	private String cartera; 
	private String tipoCartera; 
	private String codCredito; 
	private Timestamp fecDesembolso; 
	private String producto; 
	private String subProducto; 
	private String moneda; 
	private String tipCambio; 
	private Timestamp fecOtorgCred; 
	private Double mtoDesembOrig; 
	private Double mtoDesembSol; 
	private Double salCapOrg; 
	private Double salCapSol; 
	private Double mtoTotalOrg; 
	private Double mtoTotalSol; 
	private Double sldComercial; 
	private Double sldConsumo; 
	private Double sldHipotecario; 
	private Double sldOtros; 
	private Double sldLinea; 
	private String linFinan; 
	private Timestamp fecUltmPag; 
	private String impUltPago; 
	private String mtoPagado; 
	private Timestamp fecUltContacto; 
	private String resultUltContacto; 
	private Integer numCuotas; 
	private String deuSistemaFinan; 
	private Timestamp fecCastigo; 
	private Integer diasMora; 
	private String antiguedad; 
	private String rangoDeuda; 
	private String canal; 
	private String esJudicial; 
	private String marcaAntiguExpertis; 
	private String marcaCarteraCli; 
	private String convenios; 
	private String observacion; 
	private String agenObtCredito; 
	private String modCredito; 
	private String sectorista; 
	private String zonaObtCredito; 
	private String regionObtCredito; 
	private String responPago; 
	private String periordicidadPago; 
	private String credReestructurado; 
	private Timestamp fecCorte; 
	private String tipoGarantia; 
	private String reportCentrRiesgo; 
	private String tipVivienda; 
	private String locCliente; 
	private String numVisitCampoCastigo; 
	private String ubicInfoFisica; 
	private String docCustodiados; 
	private String tipGarantia; 
	private String tipAvaluo; 
	private String codGarantia; 
	private String mtoAvaluoFisico; 
	private Timestamp fecAvaluoFisico; 
	private Double valAvaluoAuto; 
	private Timestamp fecAvaluoAuto; 
	private Timestamp fecConstEmpresa; 
	private String patrimonio; 
	private String utilidadOperativa; 
	private String ventasContado; 
	private Integer numProdCrediticiosFinan; 
	private Integer numProdCrediticiosEnt; 
	private Timestamp fecCatigoExpertis; 
	private String indiRef;
	private String castigo;
	private String marcCartCuenta; 
	private String califFinal; 
	private String ultCampOfrecida; 
	private String valorCuota; 
	private String origRecursosFin; 
	private Timestamp fechacrea; 
	private Integer estado;
	public Integer getIdobligacion() {
		return idobligacion;
	}
	public void setIdobligacion(Integer idobligacion) {
		this.idobligacion = idobligacion;
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
	public String getTipoCartera() {
		return tipoCartera;
	}
	public void setTipoCartera(String tipoCartera) {
		this.tipoCartera = tipoCartera;
	}
	public String getCodCredito() {
		return codCredito;
	}
	public void setCodCredito(String codCredito) {
		this.codCredito = codCredito;
	}
	public Timestamp getFecDesembolso() {
		return fecDesembolso;
	}
	public void setFecDesembolso(Timestamp fecDesembolso) {
		this.fecDesembolso = fecDesembolso;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
	public String getSubProducto() {
		return subProducto;
	}
	public void setSubProducto(String subProducto) {
		this.subProducto = subProducto;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getTipCambio() {
		return tipCambio;
	}
	public void setTipCambio(String tipCambio) {
		this.tipCambio = tipCambio;
	}
	public Timestamp getFecOtorgCred() {
		return fecOtorgCred;
	}
	public void setFecOtorgCred(Timestamp fecOtorgCred) {
		this.fecOtorgCred = fecOtorgCred;
	}
	public Double getMtoDesembOrig() {
		return mtoDesembOrig;
	}
	public void setMtoDesembOrig(Double mtoDesembOrig) {
		this.mtoDesembOrig = mtoDesembOrig;
	}
	public Double getMtoDesembSol() {
		return mtoDesembSol;
	}
	public void setMtoDesembSol(Double mtoDesembSol) {
		this.mtoDesembSol = mtoDesembSol;
	}
	public Double getSalCapOrg() {
		return salCapOrg;
	}
	public void setSalCapOrg(Double salCapOrg) {
		this.salCapOrg = salCapOrg;
	}
	public Double getSalCapSol() {
		return salCapSol;
	}
	public void setSalCapSol(Double salCapSol) {
		this.salCapSol = salCapSol;
	}
	public Double getMtoTotalOrg() {
		return mtoTotalOrg;
	}
	public void setMtoTotalOrg(Double mtoTotalOrg) {
		this.mtoTotalOrg = mtoTotalOrg;
	}
	public Double getMtoTotalSol() {
		return mtoTotalSol;
	}
	public void setMtoTotalSol(Double mtoTotalSol) {
		this.mtoTotalSol = mtoTotalSol;
	}
	public Double getSldComercial() {
		return sldComercial;
	}
	public void setSldComercial(Double sldComercial) {
		this.sldComercial = sldComercial;
	}
	public Double getSldConsumo() {
		return sldConsumo;
	}
	public void setSldConsumo(Double sldConsumo) {
		this.sldConsumo = sldConsumo;
	}
	public Double getSldHipotecario() {
		return sldHipotecario;
	}
	public void setSldHipotecario(Double sldHipotecario) {
		this.sldHipotecario = sldHipotecario;
	}
	public Double getSldOtros() {
		return sldOtros;
	}
	public void setSldOtros(Double sldOtros) {
		this.sldOtros = sldOtros;
	}
	public Double getSldLinea() {
		return sldLinea;
	}
	public void setSldLinea(Double sldLinea) {
		this.sldLinea = sldLinea;
	}
	public String getLinFinan() {
		return linFinan;
	}
	public void setLinFinan(String linFinan) {
		this.linFinan = linFinan;
	}
	public Timestamp getFecUltmPag() {
		return fecUltmPag;
	}
	public void setFecUltmPag(Timestamp fecUltmPag) {
		this.fecUltmPag = fecUltmPag;
	}
	public String getImpUltPago() {
		return impUltPago;
	}
	public void setImpUltPago(String impUltPago) {
		this.impUltPago = impUltPago;
	}
	public String getMtoPagado() {
		return mtoPagado;
	}
	public void setMtoPagado(String mtoPagado) {
		this.mtoPagado = mtoPagado;
	}
	public Timestamp getFecUltContacto() {
		return fecUltContacto;
	}
	public void setFecUltContacto(Timestamp fecUltContacto) {
		this.fecUltContacto = fecUltContacto;
	}
	public String getResultUltContacto() {
		return resultUltContacto;
	}
	public void setResultUltContacto(String resultUltContacto) {
		this.resultUltContacto = resultUltContacto;
	}
	public Integer getNumCuotas() {
		return numCuotas;
	}
	public void setNumCuotas(Integer numCuotas) {
		this.numCuotas = numCuotas;
	}
	public String getDeuSistemaFinan() {
		return deuSistemaFinan;
	}
	public void setDeuSistemaFinan(String deuSistemaFinan) {
		this.deuSistemaFinan = deuSistemaFinan;
	}
	public Timestamp getFecCastigo() {
		return fecCastigo;
	}
	public void setFecCastigo(Timestamp fecCastigo) {
		this.fecCastigo = fecCastigo;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getRangoDeuda() {
		return rangoDeuda;
	}
	public void setRangoDeuda(String rangoDeuda) {
		this.rangoDeuda = rangoDeuda;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getEsJudicial() {
		return esJudicial;
	}
	public void setEsJudicial(String esJudicial) {
		this.esJudicial = esJudicial;
	}
	public String getMarcaAntiguExpertis() {
		return marcaAntiguExpertis;
	}
	public void setMarcaAntiguExpertis(String marcaAntiguExpertis) {
		this.marcaAntiguExpertis = marcaAntiguExpertis;
	}
	public String getMarcaCarteraCli() {
		return marcaCarteraCli;
	}
	public void setMarcaCarteraCli(String marcaCarteraCli) {
		this.marcaCarteraCli = marcaCarteraCli;
	}
	public String getConvenios() {
		return convenios;
	}
	public void setConvenios(String convenios) {
		this.convenios = convenios;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getAgenObtCredito() {
		return agenObtCredito;
	}
	public void setAgenObtCredito(String agenObtCredito) {
		this.agenObtCredito = agenObtCredito;
	}
	public String getModCredito() {
		return modCredito;
	}
	public void setModCredito(String modCredito) {
		this.modCredito = modCredito;
	}
	public String getSectorista() {
		return sectorista;
	}
	public void setSectorista(String sectorista) {
		this.sectorista = sectorista;
	}
	public String getZonaObtCredito() {
		return zonaObtCredito;
	}
	public void setZonaObtCredito(String zonaObtCredito) {
		this.zonaObtCredito = zonaObtCredito;
	}
	public String getRegionObtCredito() {
		return regionObtCredito;
	}
	public void setRegionObtCredito(String regionObtCredito) {
		this.regionObtCredito = regionObtCredito;
	}
	public String getResponPago() {
		return responPago;
	}
	public void setResponPago(String responPago) {
		this.responPago = responPago;
	}
	public String getPeriordicidadPago() {
		return periordicidadPago;
	}
	public void setPeriordicidadPago(String periordicidadPago) {
		this.periordicidadPago = periordicidadPago;
	}
	public String getCredReestructurado() {
		return credReestructurado;
	}
	public void setCredReestructurado(String credReestructurado) {
		this.credReestructurado = credReestructurado;
	}
	public Timestamp getFecCorte() {
		return fecCorte;
	}
	public void setFecCorte(Timestamp fecCorte) {
		this.fecCorte = fecCorte;
	}
	public String getTipoGarantia() {
		return tipoGarantia;
	}
	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}
	public String getReportCentrRiesgo() {
		return reportCentrRiesgo;
	}
	public void setReportCentrRiesgo(String reportCentrRiesgo) {
		this.reportCentrRiesgo = reportCentrRiesgo;
	}
	public String getTipVivienda() {
		return tipVivienda;
	}
	public void setTipVivienda(String tipVivienda) {
		this.tipVivienda = tipVivienda;
	}
	public String getLocCliente() {
		return locCliente;
	}
	public void setLocCliente(String locCliente) {
		this.locCliente = locCliente;
	}
	public String getNumVisitCampoCastigo() {
		return numVisitCampoCastigo;
	}
	public void setNumVisitCampoCastigo(String numVisitCampoCastigo) {
		this.numVisitCampoCastigo = numVisitCampoCastigo;
	}
	public String getUbicInfoFisica() {
		return ubicInfoFisica;
	}
	public void setUbicInfoFisica(String ubicInfoFisica) {
		this.ubicInfoFisica = ubicInfoFisica;
	}
	public String getDocCustodiados() {
		return docCustodiados;
	}
	public void setDocCustodiados(String docCustodiados) {
		this.docCustodiados = docCustodiados;
	}
	public String getTipGarantia() {
		return tipGarantia;
	}
	public void setTipGarantia(String tipGarantia) {
		this.tipGarantia = tipGarantia;
	}
	public String getTipAvaluo() {
		return tipAvaluo;
	}
	public void setTipAvaluo(String tipAvaluo) {
		this.tipAvaluo = tipAvaluo;
	}
	public String getCodGarantia() {
		return codGarantia;
	}
	public void setCodGarantia(String codGarantia) {
		this.codGarantia = codGarantia;
	}
	public String getMtoAvaluoFisico() {
		return mtoAvaluoFisico;
	}
	public void setMtoAvaluoFisico(String mtoAvaluoFisico) {
		this.mtoAvaluoFisico = mtoAvaluoFisico;
	}
	public Timestamp getFecAvaluoFisico() {
		return fecAvaluoFisico;
	}
	public void setFecAvaluoFisico(Timestamp fecAvaluoFisico) {
		this.fecAvaluoFisico = fecAvaluoFisico;
	}
	public Double getValAvaluoAuto() {
		return valAvaluoAuto;
	}
	public void setValAvaluoAuto(Double valAvaluoAuto) {
		this.valAvaluoAuto = valAvaluoAuto;
	}
	public Timestamp getFecAvaluoAuto() {
		return fecAvaluoAuto;
	}
	public void setFecAvaluoAuto(Timestamp fecAvaluoAuto) {
		this.fecAvaluoAuto = fecAvaluoAuto;
	}
	public Timestamp getFecConstEmpresa() {
		return fecConstEmpresa;
	}
	public void setFecConstEmpresa(Timestamp fecConstEmpresa) {
		this.fecConstEmpresa = fecConstEmpresa;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public String getUtilidadOperativa() {
		return utilidadOperativa;
	}
	public void setUtilidadOperativa(String utilidadOperativa) {
		this.utilidadOperativa = utilidadOperativa;
	}
	public String getVentasContado() {
		return ventasContado;
	}
	public void setVentasContado(String ventasContado) {
		this.ventasContado = ventasContado;
	}
	public Integer getNumProdCrediticiosFinan() {
		return numProdCrediticiosFinan;
	}
	public void setNumProdCrediticiosFinan(Integer numProdCrediticiosFinan) {
		this.numProdCrediticiosFinan = numProdCrediticiosFinan;
	}
	public Integer getNumProdCrediticiosEnt() {
		return numProdCrediticiosEnt;
	}
	public void setNumProdCrediticiosEnt(Integer numProdCrediticiosEnt) {
		this.numProdCrediticiosEnt = numProdCrediticiosEnt;
	}
	public Timestamp getFecCatigoExpertis() {
		return fecCatigoExpertis;
	}
	public void setFecCatigoExpertis(Timestamp fecCatigoExpertis) {
		this.fecCatigoExpertis = fecCatigoExpertis;
	}
	public String getIndiRef() {
		return indiRef;
	}
	public void setIndiRef(String indiRef) {
		this.indiRef = indiRef;
	}
	public String getCastigo() {
		return castigo;
	}
	public void setCastigo(String castigo) {
		this.castigo = castigo;
	}
	public String getMarcCartCuenta() {
		return marcCartCuenta;
	}
	public void setMarcCartCuenta(String marcCartCuenta) {
		this.marcCartCuenta = marcCartCuenta;
	}
	public String getCalifFinal() {
		return califFinal;
	}
	public void setCalifFinal(String califFinal) {
		this.califFinal = califFinal;
	}
	public String getUltCampOfrecida() {
		return ultCampOfrecida;
	}
	public void setUltCampOfrecida(String ultCampOfrecida) {
		this.ultCampOfrecida = ultCampOfrecida;
	}
	public String getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(String valorCuota) {
		this.valorCuota = valorCuota;
	}
	public String getOrigRecursosFin() {
		return origRecursosFin;
	}
	public void setOrigRecursosFin(String origRecursosFin) {
		this.origRecursosFin = origRecursosFin;
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
	
	
	
	
	
}
