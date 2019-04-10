package co.sistemcobro.yanbal.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.dao.SolicitudFacturaDAO;
import co.sistemcobro.yanbal.ejb.ISolicitudFacturaEJBLocal;
@Stateless
public class SolicitudFacturaEJB extends BaseEJB implements ISolicitudFacturaEJBLocal{

	@Override
	public List<Obligacion> listaFacturas(String idcliente) {
		List<Obligacion> listaObligaciones = null;
		SolicitudFacturaDAO solicitudFacturaDAO  = new SolicitudFacturaDAO(dc_yanbal); 
		try {
			listaObligaciones = solicitudFacturaDAO.buscarObligacionesPorCliente(idcliente);
		} catch (Exception e) {

		}
		return listaObligaciones;
	}

	@Override
	public Integer insertarSolictudFactura(String idcliente, String correo,
			String observacion, String idusuarioCrea,List<Obligacion> listaFacturasSeleccionadas) {
		SolicitudFacturaDAO solicitudFacturaDAO  = new SolicitudFacturaDAO(dg_yanbal);
		Integer idgenerado = null;
		try {
			idgenerado =solicitudFacturaDAO.insertarSolicitudFactura(idcliente,correo,observacion,idusuarioCrea,listaFacturasSeleccionadas);
			solicitudFacturaDAO.radicacionPorFacturaSeleccionada(idgenerado, listaFacturasSeleccionadas, idcliente,idusuarioCrea );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idgenerado;

		
	}

public void radicacionPorFacturaSeleccionada(Integer idgenerado,List<Obligacion> listaFacturasSeleccionadas,String idcliente,String idusuarioCrea) throws Exception{
	try {
		SolicitudFacturaDAO solicitudFacturaDAO  = new SolicitudFacturaDAO(dg_yanbal);
		solicitudFacturaDAO.radicacionPorFacturaSeleccionada(idgenerado, listaFacturasSeleccionadas, idcliente, idusuarioCrea);	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

@Override
public Integer validarEstadoSolicitud(String idcliente){
	SolicitudFacturaDAO solicitudFacturaDAO  = new SolicitudFacturaDAO(dc_yanbal);
	Integer estado = null;
	try {
		estado=	solicitudFacturaDAO.validarEstadoSolicitud(idcliente);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return estado;
}

}
