package co.sistemcobro.yanbal.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Cliente;

import co.sistemcobro.yanbal.bean.Obligacion;


public class ClienteDAOImpl extends BaseDAO {

	public ClienteDAOImpl(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(ClienteDAOImpl.class);


	public List<Cliente> buscarClientes(String filtro) throws SQLException {

	logger.info("Iniciar Consulta Buscar Clientes");
	ArrayList<Cliente> clienteD = new ArrayList<>();
		
	StringBuilder  query = new StringBuilder();
	query.append("SELECT distinct d.deud_id, d.deud_idcargue, d.deud_identificacion, d.deud_codigo, ");
	query.append("d.deud_nombre, d.deud_primerapellido, d.deud_segundoapellido, d.deud_ciudad,  d.deud_departamento ");
	query.append("  FROM [yanbal].[deudor] d with (nolock) ");
	query.append("  inner join yanbal.cargue c with (nolock) on c.carg_id = d.deud_idcargue ");
	query.append("  inner join yanbal.base b with (nolock) on b.base_id = c.carg_idbase ");
	query.append("  where c.carg_estado = 2 and b.base_estado = 2 and (deud_identificacion = ? or d.deud_codigo = ?) ");

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, filtro);
			ps.setString(2, filtro);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				
				Cliente cl = new Cliente();
				
				cl.setIdCliente(rs.getInt(t++));
				cl.setIdCargue(rs.getInt(t++));
				cl.setCedulaCliente(rs.getString(t++));
				cl.setCodigoCliente(rs.getString(t++));
				cl.setNombreCliente(rs.getString(t++));
				cl.setPrimerApellidoCliente(rs.getString(t++));
				cl.setSegundoApellidoCliente(rs.getString(t++));
				cl.setCiudadDireccionCliente(rs.getString(t++));
				cl.setDepartamentoDireccionCliente(rs.getString(t++));
				
							
				clienteD.add(cl);
			}

		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
			throw new SQLException("Error SQL al tratar de leer  los Clientes ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return clienteD;
	}

	

	public Cliente buscarDetalleClientes(Cliente cliente) throws SQLException {

		logger.info("Iniciar Consulta Buscar Detalle Clientes");
		
		StringBuilder  sqlDetalleCliente = new StringBuilder();
		sqlDetalleCliente.append("SELECT distinct d.deud_id, d.deud_idcargue, d.deud_identificacion, d.deud_codigo, ");
		sqlDetalleCliente.append("d.deud_nombre, d.deud_primerapellido, d.deud_segundoapellido, d.deud_direccion, ");
		sqlDetalleCliente.append("d.deud_barrio, d.deud_ciudad, deud_departamento,  d.deud_directoracodigo, d.deud_coordinadoranombre, d.deud_email, d.deud_despachodireccion  ");
		sqlDetalleCliente.append("FROM [yanbal].[deudor] d with (nolock) ");
		sqlDetalleCliente.append("inner join yanbal.cargue c with (nolock) on c.carg_id = d.deud_idcargue ");
		sqlDetalleCliente.append("inner join yanbal.base b with (nolock) on b.base_id = c.carg_idbase ");
		sqlDetalleCliente.append("where c.carg_estado = 2 and b.base_estado = 2 and d.deud_codigo = ?");
		
		Cliente cl = cliente;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sqlDetalleCliente.toString());
			ps.setString(1, cliente.getCedulaCliente());

			rs = ps.executeQuery();
			int t = 1;

			if (rs.next()) {
				t = 1;
				
				cl.setIdCliente(rs.getInt(t++));
				cl.setIdCargue(rs.getInt(t++));
				cl.setCedulaCliente(rs.getString(t++));
				cl.setCodigoCliente(rs.getString(t++));
				cl.setNombreCliente(rs.getString(t++));
				cl.setPrimerApellidoCliente(rs.getString(t++));
				cl.setSegundoApellidoCliente(rs.getString(t++));
				cl.setDireccionCliente(rs.getString(t++));
				cl.setBarrioDireccionCliente(rs.getString(t++));
				cl.setCiudadDireccionCliente(rs.getString(t++));
				cl.setDepartamentoDireccionCliente(rs.getString(t++));
				cl.setDirectoraCodigo(rs.getString(t++));
				cl.setNombreCoordinador(rs.getString(t++));
				cl.setEmail(rs.getString(t++));
				cl.setDespachoDireccion(rs.getString(t++));
				
				
				
			}

		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  el detalle del cliente ", e);
			throw new SQLException("Error SQL al tratar de leer el detalle del cliente ", e);
		}  finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return cl;
	}

	


	public Cliente buscarObligacionesCLiente(Cliente cliente) throws SQLException {
		
		logger.info("Iniciar Consulta Buscar Obligaciones Cliente");

		StringBuilder  query = new StringBuilder();
		query.append("SELECT [obli_id] ");
		query.append("      ,[obli_factura] ");
		query.append("      ,[obli_valorinicial] ");
		query.append("      ,[obli_fechavencimiento] ");
		query.append("      ,[obli_saldocapitalinicial] ");
		query.append("      ,[obli_saldointeresinicial] ");
		query.append("      ,[obli_saldogastoadmininicial] ");
		query.append("      ,[obli_valortotalinicial] ");
		query.append("      ,[obli_diamorainicial] ");
		query.append("      ,[obli_edadinicial] ");
		query.append("      ,[obli_indprimerpedido] ");
		query.append("      ,[obli_saldocapitaldia] ");
		query.append("      ,[obli_saldointeredia] ");
		query.append("      ,[obli_saldogastoadmindia] ");
		query.append("      ,[obli_valortotaldia] ");
		query.append("      ,[obli_diamoradia] ");
		query.append("      ,[obli_edadmoradia] ");
		query.append("      ,[obli_valortotalretribucion],  base_nombrebase");
		query.append("  FROM [yanbal].[obligacion] o with(nolock) ");
		query.append("  inner join yanbal.deudor d with(nolock) on d.deud_id = o.obli_iddeudor ");
		query.append("  inner join yanbal.cargue c with (nolock) on c.carg_id = d.deud_idcargue and c.carg_id = o.obli_idcargue ");
		query.append("  inner join yanbal.base b with (nolock) on b.base_id = c.carg_idbase  ");
		query.append("  where c.carg_estado = 2 and b.base_estado =2 and d.deud_codigo = ?");
		
		ArrayList<Obligacion> obligaciones = new ArrayList<>();
		
		Obligacion obligacion;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, cliente.getCodigoCliente());

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				obligacion = new Obligacion();
				obligacion.setIdObligacion(rs.getInt(t++));
				obligacion.setFactura(rs.getString(t++));
				obligacion.setValorInicial(rs.getBigDecimal(t++));
				obligacion.setFechaVencimiento(rs.getDate(t++));
				obligacion.setSaldoCapitalInicial(rs.getBigDecimal(t++));
				obligacion.setSaldoInteresInicial(rs.getBigDecimal(t++));
				obligacion.setSaldoGastoAdminInicial(rs.getBigDecimal(t++));
				obligacion.setvalorTotalInicial(rs.getBigDecimal(t++));
				obligacion.setDiaMoraInicial(rs.getInt(t++));
				obligacion.setEdadMoraInicial(rs.getString(t++));
				obligacion.setIndPrimerPedido(rs.getString(t++));
				//Valores actuales
				obligacion.setSaldoCapitalActual(rs.getBigDecimal(t++));
				obligacion.setSaldoInteresesActual(rs.getBigDecimal(t++));
				obligacion.setSaldoGastoAdminActual(rs.getBigDecimal(t++));
				obligacion.setValorTotalActual(rs.getBigDecimal(t++));
				obligacion.setDiaMoraActual(rs.getInt(t++));
				obligacion.setEdadMoraActual(rs.getString(t++));
				obligacion.setRetribucion(rs.getString(t++));
				obligacion.setMombreCargue(rs.getString(t++));
				
				obligaciones.add(obligacion);
			}
			
			cliente.setObligaciones(obligaciones);
			
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Clientes ", e);
			throw new SQLException("Error SQL al tratar de leer  los Clientes ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return cliente;
	}
	
	/*
	private String SQL_ACTUALIZAR_DIRECCION = "  update expertis.deudor set direccion = ?, idusuariomod = ?, fechamod = GETDATE() "
			+ " where  "
			+ " documento = ?  and  idcargue = (SELECT max(idcargue) from expertis.deudor)  ";

	public boolean actualizarDireccion(String direccion, Integer idUsuario, String documento) throws Exception {
		boolean bandera = false;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_DIRECCION);
			
			ps.setString(1, direccion);
			ps.setInt(2, idUsuario);
			ps.setString(3, documento);
			
			ps.executeUpdate();
			
			bandera = true;
			
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de consultar telefonos ", e);
			e.printStackTrace();
			throw new Exception("Error SQL al tratar de consultar telefonos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de consultar telefonos", e);
			throw new Exception("Error al tratar de consultar telefonos : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao telefonos!");
		}
		return bandera;
	}
	
	private String SQL_ACTUALIZAR_CORREO = "  update expertis.deudor set correo = ?, idusuariomod = ?, fechamod = GETDATE() "
			+ " where  "
			+ " documento = ?  and  idcargue = (SELECT max(idcargue) from expertis.deudor)  ";

	public boolean actualizarCorreo(String correo, Integer idUsuario, String documento) throws Exception {
		boolean bandera = false;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_CORREO);
			
			ps.setString(1, correo);
			ps.setInt(2, idUsuario);
			ps.setString(3, documento);
			
			ps.executeUpdate();
			
			bandera = true;
			
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de consultar telefonos ", e);
			e.printStackTrace();
			throw new Exception("Error SQL al tratar de consultar telefonos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de consultar telefonos", e);
			throw new Exception("Error al tratar de consultar telefonos : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao telefonos!");
		}
		return bandera;
	}

	
*/
}
