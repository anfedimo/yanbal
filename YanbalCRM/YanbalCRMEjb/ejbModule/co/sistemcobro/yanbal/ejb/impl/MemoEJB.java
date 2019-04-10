package co.sistemcobro.yanbal.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Memo;
import co.sistemcobro.yanbal.bean.ObligacionYanbal;
import co.sistemcobro.yanbal.dao.MemoDAO;

import co.sistemcobro.yanbal.ejb.IMemoEJBLocal;

@Stateless(name = "MemoEJB")
public class MemoEJB extends BaseEJB implements IMemoEJBLocal {

	@Override
	public List<Memo> listaGestion(String idcliente, List<Memo> gestion) {
		List<Memo> listaGestionDTO = null;
		List<ObligacionYanbal> listaObligaciones = new ArrayList<>();

		MemoDAO memoDao = new MemoDAO(dc_yanbal);


		try {

			listaGestionDTO = memoDao.buscarMemo(idcliente, gestion, listaObligaciones);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaGestionDTO;
	}

}
