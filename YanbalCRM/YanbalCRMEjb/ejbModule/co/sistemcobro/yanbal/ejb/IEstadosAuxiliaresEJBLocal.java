package co.sistemcobro.yanbal.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.EstadoAuxiliar;

@Local
public interface IEstadosAuxiliaresEJBLocal {

	public ArrayList<EstadoAuxiliar> buscarEstadosAux() throws Exception;

	public Integer insertarAux(Integer idestado, Integer Idcliente) throws Exception;

	public Integer updateAux(Integer llave) throws Exception;
}
