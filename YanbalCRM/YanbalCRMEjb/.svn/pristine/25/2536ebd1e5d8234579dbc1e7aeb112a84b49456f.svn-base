package co.sistemcobro.yanbal.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.ComiteEstado;
import co.sistemcobro.yanbal.bean.Cuota;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.bean.ObligacionGestion;
import co.sistemcobro.yanbal.dao.CuotaDAO;
import co.sistemcobro.yanbal.dao.FacturaGestionDAO;
import co.sistemcobro.yanbal.dao.GestionDAO;
import co.sistemcobro.yanbal.dao.ObligacionGestionDAO;
import co.sistemcobro.yanbal.ejb.IGestionEJBLocal;
import co.sistemcobro.yanbal.ejb.IObligacionGestionEJBLocal;

@Stateless
public class ObligacionGestionEJB extends BaseEJB implements IObligacionGestionEJBLocal {

	@Override
	public boolean insertarObligacionGestion(ObligacionGestion obligacionGestion) throws Exception {
		ObligacionGestionDAO obligacionGestionDAO = new ObligacionGestionDAO(dg_yanbal);
		return obligacionGestionDAO.insertarObligacionGestion(obligacionGestion);
	}

	
	

}
