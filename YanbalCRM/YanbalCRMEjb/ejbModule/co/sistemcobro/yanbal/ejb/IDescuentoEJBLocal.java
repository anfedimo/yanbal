package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.Descuento;

@Local
public interface IDescuentoEJBLocal {

	public List<Descuento> descuentosClientePorCuota(String idCliente, Integer numeroCuota) throws Exception;

}
