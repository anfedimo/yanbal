package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.FacturaGestion;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.ObligacionGestion;
@Local
public interface IGestionEJBLocal {
	
	public Integer insertarGestion(Gestion gestion) throws Exception;
	
//	public Integer buscarUltimaGestion() throws Exception;
	
	public Integer insertarAcuerdoGestion(List<FacturaGestion> facturaGestion, Gestion gestion, Integer idGestion) throws Exception;

}
