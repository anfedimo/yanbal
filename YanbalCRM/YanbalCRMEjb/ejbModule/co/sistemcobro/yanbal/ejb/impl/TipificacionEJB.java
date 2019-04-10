package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import co.sistemcobro.yanbal.bean.Tipificacion;
import co.sistemcobro.yanbal.dao.TipificacionDAO;
import co.sistemcobro.yanbal.ejb.ITipificacionEJBLocal;

@Stateless
public class TipificacionEJB extends BaseEJB implements ITipificacionEJBLocal {

	@Override
	public List<Tipificacion> buscarTipificacionesPorNivel(Integer idNivelTipificacion) throws Exception {
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_yanbal);
		return tipificacionDAO.buscarTipificacionesPorNivel(idNivelTipificacion);
	}

	@Override
	public Integer buscarIdTipificacionPorCodigo(String codigo) throws Exception {
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_yanbal);
		return tipificacionDAO.buscarIdTipificacionPorCodigo(codigo);
	}

	@Override
	public List<SelectItem> buscarTipificaciones(int categoriaPadre) throws Exception {
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_yanbal);
		return tipificacionDAO.buscarTipificaciones(categoriaPadre);
		
	}
	
	

}
