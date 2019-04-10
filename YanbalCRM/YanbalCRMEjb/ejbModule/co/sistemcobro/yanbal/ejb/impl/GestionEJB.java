package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.ComiteEstado;
import co.sistemcobro.yanbal.bean.Cuota;
import co.sistemcobro.yanbal.bean.FacturaGestion;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.bean.ObligacionGestion;
import co.sistemcobro.yanbal.dao.CuotaDAO;
import co.sistemcobro.yanbal.dao.FacturaGestionDAO;
import co.sistemcobro.yanbal.dao.GestionDAO;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;

@Stateless
public class GestionEJB extends BaseEJB implements IGestionEJBLocal {

	@Override
	public Integer insertarGestion(Gestion gestion) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dg_yanbal);
		return gestionDAO.insertarGestion(gestion);
		
	}

//	@Override
//	public Integer buscarUltimaGestion() throws Exception {
//		GestionDAO gestionDAO = new GestionDAO(dc_yanbal);
//		return gestionDAO.buscarUltimaGestion();
//	}

	
	@Override
	public Integer insertarAcuerdoGestion(List<FacturaGestion> facturaGestion, Gestion gestion, Integer idGestion) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dg_yanbal);
		return gestionDAO.insertarObligacionGestion(facturaGestion, gestion, idGestion);
	}

//@Override
//public Integer buscarUltimaGestion() throws Exception {
//	// TODO Auto-generated method stub
//	return null;
//}

	

}
