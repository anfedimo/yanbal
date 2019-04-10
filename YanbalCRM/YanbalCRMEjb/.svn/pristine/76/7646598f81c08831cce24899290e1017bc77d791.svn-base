package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Telefono;
import co.sistemcobro.yanbal.bean.TelefonoDatosAdicionales;
import co.sistemcobro.yanbal.dao.TelefonoDAO;
import co.sistemcobro.yanbal.ejb.ITelefonoEJBLocal;

@Stateless(name = "TelefonoEJB")
public class TelefonoEJB extends BaseEJB implements ITelefonoEJBLocal {

	@Override
	public List<Telefono> listaTelefono(String cliente) {
	
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_yanbal);
		List<Telefono> telefonos = null;
		
		try {
		telefonos = telefonoDAO.buscarTelefonos(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefonos;
	}

	@Override
	public List<TelefonoDatosAdicionales> telefonosNuevos(String cliente) throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_yanbal);
		List<TelefonoDatosAdicionales> telefonos = null;
		
		try {
		telefonos = telefonoDAO.telefonos(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefonos;
	}

	
	
	

	
}
