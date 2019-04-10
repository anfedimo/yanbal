package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.Obligacion;
@Local
public interface ISolicitudFacturaEJBLocal {

	public List<Obligacion> listaFacturas(String idcliente);
	public Integer insertarSolictudFactura(String idcliente, String correo, String observacion, String idusuarioCrea, List<Obligacion> listaFacturasSeleccionadas);
	public Integer validarEstadoSolicitud(String idcliente);

}
