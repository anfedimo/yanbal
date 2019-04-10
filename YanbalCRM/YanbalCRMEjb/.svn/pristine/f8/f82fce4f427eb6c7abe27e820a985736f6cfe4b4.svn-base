package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.sms;
import co.sistemcobro.yanbal.dao.SmsDAO;
import co.sistemcobro.yanbal.ejb.ISmsEJBLocal;

@Stateless
public class SmsEJB extends BaseEJB implements ISmsEJBLocal {

	@Override
	public List<sms> buscarMensajes(String segmento) throws Exception {
		SmsDAO smsDao = new SmsDAO(dc_yanbal);
		return smsDao.buscarMensajes(segmento);
	}

	@Override
	public void insertarSMS(sms mensaje) throws Exception {
		SmsDAO smsDao = new SmsDAO(dg_yanbal);
		smsDao.insertarMensajeEnviado(mensaje);

	}

}
