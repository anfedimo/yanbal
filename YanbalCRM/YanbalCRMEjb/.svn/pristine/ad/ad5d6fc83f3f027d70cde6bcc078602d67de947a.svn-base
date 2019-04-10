package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import co.sistemcobro.yanbal.bean.Parentesco;
import co.sistemcobro.yanbal.dao.ParentescoDAO;
import co.sistemcobro.yanbal.ejb.IParentescoEJBLocal;

@Stateless
public class ParentescoEJB extends BaseEJB implements IParentescoEJBLocal {

	@Override
	public List<Parentesco> buscarPArentescos() throws Exception {
		ParentescoDAO parentescoDAO = new ParentescoDAO(dc_yanbal);
		return parentescoDAO.buscarPArentescos();
	}

}
