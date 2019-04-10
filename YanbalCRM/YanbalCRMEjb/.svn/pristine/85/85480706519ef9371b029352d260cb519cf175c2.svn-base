package co.sistemcobro.yanbal.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Memo;
import co.sistemcobro.yanbal.bean.ObligacionYanbal;
import co.sistemcobro.yanbal.bean.Pago;
import co.sistemcobro.yanbal.dao.MemoDAO;

import co.sistemcobro.yanbal.dao.PagoDAO;
import co.sistemcobro.yanbal.ejb.IMemoEJBLocal;
import co.sistemcobro.yanbal.ejb.IPagoEJBLocal;

@Stateless
public class PagoEJB extends BaseEJB implements IPagoEJBLocal {

	@Override
	public List<Pago> buscarPago(String idcliente) throws Exception {
		PagoDAO pagoDAO = new PagoDAO(dc_yanbal);
		return pagoDAO.buscarPago(idcliente);
	}

	

}
