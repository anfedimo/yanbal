package co.sistemcobro.yanbal.ejb;

import java.util.List;
import javax.ejb.Local;
import co.sistemcobro.yanbal.bean.Cuota;

@Local
public interface ICuotaEJBLocal {

	public List<Cuota> cuotaPorCliente(String idCliente) throws Exception;

}
