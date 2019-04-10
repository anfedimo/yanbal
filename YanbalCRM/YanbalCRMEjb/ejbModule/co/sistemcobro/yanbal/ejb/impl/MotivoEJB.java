package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Motivo;
import co.sistemcobro.yanbal.dao.MotivoDAO;
import co.sistemcobro.yanbal.ejb.IMotivoEJBLocal;

@Stateless
public class MotivoEJB extends BaseEJB implements IMotivoEJBLocal {

	@Override
	public List<Motivo> buscarMotivos() throws Exception {
		MotivoDAO motivoDAO = new MotivoDAO(dc_yanbal);
		return motivoDAO.buscarMotivos();
	}

}
