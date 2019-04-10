package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Cuota;
import co.sistemcobro.yanbal.dao.CuotaDAO;
import co.sistemcobro.yanbal.ejb.ICuotaEJBLocal;

@Stateless(name = "CuotaEJB")
public class CuotaEJB extends BaseEJB implements ICuotaEJBLocal {

	public CuotaEJB() {
		
	}

	@Override
	public List<Cuota> cuotaPorCliente(String idCliente) throws Exception {
		CuotaDAO cuotaDAO = new CuotaDAO(dc_yanbal);
		return cuotaDAO.cuotaPorCliente(idCliente);
	}

}
