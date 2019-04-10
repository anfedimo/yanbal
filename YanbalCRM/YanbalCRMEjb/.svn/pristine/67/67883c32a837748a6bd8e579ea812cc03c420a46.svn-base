package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.DireccionTipo;
import co.sistemcobro.yanbal.dao.DireccionTipoDAO;
import co.sistemcobro.yanbal.ejb.ITipoDireccionLocal;

@Stateless(name = "DireccionTipoEJB")
public class DireccionTipoEJB extends BaseEJB implements ITipoDireccionLocal {

	@Override
	public List<DireccionTipo> listaTipoDireccion() {
		
		DireccionTipoDAO direccionTipoDAO = new  DireccionTipoDAO(dc_yanbal);
		List<DireccionTipo> listadireccionestipo = null;
		try {
			listadireccionestipo =direccionTipoDAO.buscarDireccionTipo();
		} catch (Exception e) {

		}
		return listadireccionestipo;

	}



	

	
}
