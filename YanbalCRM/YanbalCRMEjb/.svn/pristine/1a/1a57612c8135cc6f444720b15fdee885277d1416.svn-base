package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Descuento;
import co.sistemcobro.yanbal.dao.DescuentoDAO;
import co.sistemcobro.yanbal.ejb.IDescuentoEJBLocal;

@Stateless(name = "DescuentoEJB")
public class DescuentoEJB extends BaseEJB implements IDescuentoEJBLocal {

	public DescuentoEJB() {
		
	}

	@Override
	public List<Descuento> descuentosClientePorCuota(String idCliente, Integer numeroCuota) throws Exception {
		DescuentoDAO descuentoDAO = new DescuentoDAO(dc_yanbal);
		return descuentoDAO.descuentosClientePorCuota(idCliente, numeroCuota);
	}

}
