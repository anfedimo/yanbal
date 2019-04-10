package co.sistemcobro.yanbal.ejb;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.ObligacionGestion;
@Local
public interface IObligacionGestionEJBLocal {
	
	public boolean insertarObligacionGestion(ObligacionGestion obligacionGestion) throws Exception;

}
