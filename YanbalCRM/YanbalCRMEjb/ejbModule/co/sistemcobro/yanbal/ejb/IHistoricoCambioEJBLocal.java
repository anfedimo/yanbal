package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.Cliente;
import co.sistemcobro.yanbal.bean.HistoricoCambio;
import co.sistemcobro.yanbal.bean.Telefono;

@Local
public interface IHistoricoCambioEJBLocal {
	
	public List<HistoricoCambio> buscarHistoricoCambios(String documento) throws Exception;
	
}
