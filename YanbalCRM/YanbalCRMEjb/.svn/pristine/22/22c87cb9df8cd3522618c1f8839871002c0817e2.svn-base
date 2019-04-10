package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import co.sistemcobro.yanbal.dao.FormaPagoDAO;
import co.sistemcobro.yanbal.ejb.IFormaPagoEJBLocal;

@Stateless
public class FormaPagoEJB extends BaseEJB implements IFormaPagoEJBLocal {

	@Override
	public List<SelectItem> buscarFormasPago() throws Exception {
		FormaPagoDAO formaPagoDAO = new FormaPagoDAO(dc_yanbal);
		return formaPagoDAO.buscarTipificacionesPorGrupo();
	}

}
