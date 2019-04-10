package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.TelefonoDatosAdicionales;
import co.sistemcobro.yanbal.dao.DatosAdicionalesDAO;
import co.sistemcobro.yanbal.ejb.IDatosAdicionalesEJBLocal;

@Stateless
public class DatosAdicionalesEJB extends BaseEJB implements	IDatosAdicionalesEJBLocal {
	
	@Override
	public List<DatosAdicionales> listaDatosAdicionales(String idcliente) {
		List<DatosAdicionales> listaDatosAdicional = null;
		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dc_yanbal);
		try {
		listaDatosAdicional = datosAdicionalesDAO.buscarDatosAdicionales(idcliente);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listaDatosAdicional;
	}

	@Override
	public int actualizarDatos(DatosAdicionales dato) throws Exception {
		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dg_yanbal);
		return datosAdicionalesDAO.actualizarDatos(dato);
	}

	@Override
	public int insertarTelefono(TelefonoDatosAdicionales telefono) throws Exception {
		DatosAdicionalesDAO datosAdicionalesDAO = new DatosAdicionalesDAO(dg_yanbal);
		return datosAdicionalesDAO.insertarTelefono(telefono);
	}

	
	

	
	

	

}
