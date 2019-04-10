package co.sistemcobro.yanbal.ejb.impl;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.yanbal.bean.Cliente;
import co.sistemcobro.yanbal.bean.Comite;
import co.sistemcobro.yanbal.bean.Obligacion;
import co.sistemcobro.yanbal.dao.ClienteDAOImpl;
import co.sistemcobro.yanbal.ejb.IClienteEJBLocal;

@Stateless(name = "ClienteEJB")
public class ClienteEJB extends BaseEJB implements IClienteEJBLocal {

	public ClienteEJB() {

	}
	@Override
	public List<Cliente> listaClientes(String filtro) {
		List<Cliente> listaClienteDTO = null;
		ClienteDAOImpl clienteDao = new ClienteDAOImpl(dc_yanbal);
		try {
			listaClienteDTO = clienteDao.buscarClientes(filtro);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaClienteDTO;
	}

	@Override
	public Cliente getClienteById(int id) {

		return null;
	}

	@Override
	public Cliente detalleCliente(Cliente cliente) throws SQLException {

		ClienteDAOImpl clienteDao = new ClienteDAOImpl(dc_yanbal);

		return clienteDao.buscarDetalleClientes(cliente);
	}

	@Override
	public Cliente obligacionesCliente(Cliente cliente) throws SQLException {
		ClienteDAOImpl clienteDao = new ClienteDAOImpl(dc_yanbal);

		return clienteDao.buscarObligacionesCLiente(cliente);
	}

	@Override
	public boolean comiteAbierto(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean comiteAprobado(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comite comiteAprobadoInfo(Integer cliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Obligacion> obligacionesComite(Integer comite) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public boolean actualizarDireccion(String direccion, Integer idUsuario, String documento) throws Exception {
		ClienteDAOImpl ClienteDAO = new ClienteDAOImpl(dg_yanbal);
		return ClienteDAO.actualizarDireccion(direccion, idUsuario, documento);
	}

	@Override
	public boolean actualizarCorreo(String correo, Integer idUsuario, String documento) throws Exception {
		ClienteDAOImpl ClienteDAO = new ClienteDAOImpl(dg_yanbal);
		return ClienteDAO.actualizarCorreo(correo, idUsuario, documento);
	}*/
	

}
