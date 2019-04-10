package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.Ciudad;
import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.Departamento;
import co.sistemcobro.yanbal.bean.InformacionComplementaria;
import co.sistemcobro.yanbal.bean.TelefonoDatosAdicionales;

@Local
public interface IDatosAdicionalesEJBLocal {
	
	public List<DatosAdicionales> listaDatosAdicionales(String idcliente);
	
	public int actualizarDatos(DatosAdicionales dato) throws Exception;
	
	public int insertarTelefono(TelefonoDatosAdicionales telefono) throws Exception;
	

}
