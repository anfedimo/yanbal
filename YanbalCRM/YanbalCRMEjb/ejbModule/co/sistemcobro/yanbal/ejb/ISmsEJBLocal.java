package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.sms;

/**
 * @author garaque
 *
 */
@Local
public interface ISmsEJBLocal  {
	public List<sms> buscarMensajes(String segmento)  throws Exception;
	public void insertarSMS(sms mensaje)  throws Exception;
	

}
