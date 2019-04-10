package co.sistemcobro.yanbal.ejb.impl;

import java.util.ArrayList;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.EstadoAuxiliar;
import co.sistemcobro.yanbal.dao.EstadoAuxiliarDAO;
import co.sistemcobro.yanbal.ejb.IEstadosAuxiliaresEJBLocal;

@Stateless
public class EstadosAuxiliaresEJB extends BaseEJB implements IEstadosAuxiliaresEJBLocal {

	@Override
	public ArrayList<EstadoAuxiliar> buscarEstadosAux() throws Exception {
		EstadoAuxiliarDAO estadoAuxiliarDAO = new EstadoAuxiliarDAO(dc_yanbal);
		return estadoAuxiliarDAO.buscarEstadosAux();
	}

	@Override
	public Integer insertarAux(Integer idestado, Integer Idcliente) throws Exception {
		EstadoAuxiliarDAO estadoAuxiliarDAO = new EstadoAuxiliarDAO(dg_yanbal);
		return estadoAuxiliarDAO.insertarAux(idestado, Idcliente);
	}

	@Override
	public Integer updateAux(Integer llave) throws Exception {
		EstadoAuxiliarDAO estadoAuxiliarDAO = new EstadoAuxiliarDAO(dg_yanbal);
		return estadoAuxiliarDAO.actualizarAux(llave);
	}

}
