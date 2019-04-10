package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.HistoricoCambio;
import co.sistemcobro.yanbal.bean.Telefono;
import co.sistemcobro.yanbal.dao.HistoricoCambioDAO;
import co.sistemcobro.yanbal.dao.TelefonoDAO;
import co.sistemcobro.yanbal.ejb.IHistoricoCambioEJBLocal;
import co.sistemcobro.yanbal.ejb.ITelefonoEJBLocal;

@Stateless
public class HistoricoCambioEJB extends BaseEJB implements IHistoricoCambioEJBLocal {

	@Override
	public List<HistoricoCambio> buscarHistoricoCambios(String documento) throws Exception {
		HistoricoCambioDAO historicoCambioDAO = new HistoricoCambioDAO(dc_yanbal);
		return historicoCambioDAO.buscarHistoricoCambios(documento);
	}

	
	
}
