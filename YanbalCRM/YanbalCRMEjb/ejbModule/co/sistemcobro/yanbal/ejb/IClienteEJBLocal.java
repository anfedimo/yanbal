package co.sistemcobro.yanbal.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.yanbal.bean.Cliente;
import co.sistemcobro.yanbal.bean.Comite;
import co.sistemcobro.yanbal.bean.Obligacion;


@Local
public interface IClienteEJBLocal {
	public List<Cliente> listaClientes(String filtro);

	public Cliente detalleCliente(Cliente cliente) throws SQLException;

	public Cliente obligacionesCliente(Cliente cliente) throws SQLException;

	public Cliente getClienteById(int id);

	public boolean comiteAbierto(Cliente cliente) throws SQLException;

	public boolean comiteAprobado(Cliente cliente) throws SQLException;
	
	public Comite comiteAprobadoInfo(Integer cliente) throws SQLException;
	
	public List<Obligacion> obligacionesComite(Integer comite) throws SQLException;
	
/*	public boolean actualizarDireccion(String direccion, Integer idUsuario, String documento) throws Exception;
	
	public boolean actualizarCorreo(String correo, Integer idUsuario, String documento) throws Exception;*/
}
