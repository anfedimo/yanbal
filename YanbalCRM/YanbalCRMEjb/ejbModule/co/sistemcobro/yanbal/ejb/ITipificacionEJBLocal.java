package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.faces.model.SelectItem;

import co.sistemcobro.yanbal.bean.Tipificacion;

@Local
public interface ITipificacionEJBLocal {
	
	public List<SelectItem> buscarTipificaciones(int categoriaPadre) throws Exception;
	
	public List<Tipificacion> buscarTipificacionesPorNivel(Integer idNivelTipificacion) throws Exception;
	
	public Integer buscarIdTipificacionPorCodigo(String codigo) throws Exception;

}
