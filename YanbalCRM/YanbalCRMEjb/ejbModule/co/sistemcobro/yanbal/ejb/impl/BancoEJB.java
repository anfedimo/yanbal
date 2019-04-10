package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import co.sistemcobro.yanbal.dao.BancoDAO;
import co.sistemcobro.yanbal.ejb.IBancoEJBLocal;

@Stateless
public class BancoEJB extends BaseEJB implements IBancoEJBLocal {

	@Override
	public List<SelectItem> buscarBancos() throws Exception {
		BancoDAO bancoDAO = new BancoDAO(dc_yanbal);
		return bancoDAO.buscarTipificacionesPorGrupo();
	}

}
