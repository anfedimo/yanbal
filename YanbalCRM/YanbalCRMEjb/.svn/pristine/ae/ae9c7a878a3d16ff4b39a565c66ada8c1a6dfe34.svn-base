package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.Obligacion;

public class SolicitudFacturaDAO extends BaseDAO {

	public SolicitudFacturaDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(SolicitudFacturaDAO.class);
	private String SQL_BUSCAR_FACTURAS_POR_CLIENTE = ""
			+ "SELECT  Numero_Fiscal,fecha_venc_cuota,dias_mora,valor_factura_iva "
			+ "FROM [publicar].[asignacion_peru] a "
			+ "inner join [publicar].[cargue] c on a.idcargue=c.idcargue "
			+ "inner join publicar.base b on b.idbase=c.idbase "
			+ "where cuc = ? " + "and c.estado=2 "
			+ "and b.estado=2 and a.material is not null and Numero_Fiscal is not null ";

	public List<Obligacion> buscarObligacionesPorCliente(String idcliente)
			throws Exception {

		ArrayList<Obligacion> Obligaciones = new ArrayList<Obligacion>();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_FACTURAS_POR_CLIENTE);
			ps.setString(1, idcliente);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				/*Obligacion obligacion = new Obligacion();
				obligacion.setFactura(rs.getString(t++));
				obligacion.setFechaVencimiento(rs.getString(t++));
				obligacion.setDiasMora(rs.getInt(t++));
				obligacion.setValorFacturaIva(rs.getBigDecimal(t++));
				Obligaciones.add(obligacion);*/

			}

		} catch (SQLException e) {
			logger.error(
					"Error SQL al tratar de mostrar las facturas por cliente ",
					e);
			throw new Exception("Error SQL al tratar de facturas por cliente ",
					e);
		} catch (Exception e) {
			logger.error("Error al tratar demostrar facturas por cliente ", e);
			throw new Exception(
					"Error al tratar de mostrar facturas por cliente : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao SolicitudFacturas !");

		}

		return Obligaciones;

	}

	private String SQL_INSERTAR_SOLICITUD_FACTURA = ""
			+ " INSERT INTO [publicar].[solicitud]([idcliente],[idpais] ,[correo],[observacion_asesor],[estado_solicitud],[idusuariocrea], "
			+ " [fechacrea],[estado])  "
			+ " VALUES ( ?,2,?,?,1,?, getdate(),2) ";

	public Integer insertarSolicitudFactura(String idcliente, String correo,
			String observacion, String idusuarioCrea,
			List<Obligacion> listaFacturasSeleccionadas) throws Exception {
		Integer resultado;
		Integer idgenerado;

		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(SQL_INSERTAR_SOLICITUD_FACTURA,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, idcliente);
			ps.setString(2, correo);
			ps.setString(3, observacion);
			ps.setString(4, idusuarioCrea);
			resultado = ps.executeUpdate();
			con.commit();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				idgenerado = rs.getInt(1);
				System.out.println("se radico la solicitud" + idgenerado);
			} else {
				throw new SQLException("No se pudo radicar la solicitud.");
			}

		} catch (SQLException e) {
			con.rollback();
			logger.error(
					"Error SQL al tratar de mostrar las facturas por cliente ",
					e);
			throw new Exception("Error SQL al tratar de facturas por cliente ",
					e);
		} catch (Exception e) {
			logger.error("Error al tratar demostrar facturas por cliente ", e);
			throw new Exception(
					"Error al tratar de mostrar facturas por cliente : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao SolicitudFacturas !");

		}
		return idgenerado;
	}

	private String SQL_INSERTAR_SOLICITUD_FACTURA_SELECCIONADA = ""
			+ " INSERT INTO [publicar].[solicitud_factura] (idsolicitud,clave,contrato,idusuariocrea,fechacrea,estado) VALUES(?,?,?,?, GETDATE(),2) ";

	public void radicacionPorFacturaSeleccionada(Integer idsolicitud,
			List<Obligacion> listafacturasSeleccionadas, String idCliente,
			String idUusarioCrea) throws Exception {
		int total = 0;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_INSERTAR_SOLICITUD_FACTURA_SELECCIONADA);
			int bloques = 1000;
			int c = 1;
			int insertados = 0;

			for (Obligacion obligacion : listafacturasSeleccionadas) {
				ps.setInt(1, idsolicitud);
				ps.setString(2, obligacion.getFactura());
				//ps.setString(3, obligacion.getContrato());
				ps.setString(4, idUusarioCrea);

				ps.addBatch();
				insertados++;
				c++;
				if ((c % bloques) == 0	|| insertados == (listafacturasSeleccionadas.size())) {

					ps.executeBatch();
					logger.info("insertaron estas facturas seleccionadas" + c);
					c = 0;

				}
			}

			con.commit();

		} catch (SQLException e) {
			logger.error("Error SQL insertando los datos Adicionales ", e);
			throw new Exception("Error SQL insertando los datos Adicionales ",
					e);
		} catch (Exception e) {
			logger.error("Error insetrtando los datos adicionales ", e);
			throw new Exception("Error insertando datos adicionales : ", e);
		} finally {
			closeConexion();

			logger.info("finalizo dao insertar Datos Adicionales ! Inserto :"
					+ total);

		}

	}
	
	String SQL_VALIDAR_ESTADO_SOLICITUD = "  select top 1 estado_solicitud from publicar.solicitud WHERE idcliente = ? and estado  =2 order by idsolicitud desc ";
	public Integer  validarEstadoSolicitud(String idcliente) throws Exception{
		Integer estado = 0;
		try{
		con = ds.getConnection();
		ps = con.prepareStatement(SQL_VALIDAR_ESTADO_SOLICITUD);
		ps.setString(1, idcliente);

		rs = ps.executeQuery();
		int t = 1;
		while (rs.next()) {
			estado = rs.getInt(t++);		

		}
		

	} catch (SQLException e) {
		logger.error("Error SQL al tratar de consultar el estado de la solictud ",	e);
		throw new Exception("Error SQL al tratar de consultar el estado de la solictud ",	e);
	} catch (Exception e) {
		logger.error("Error al tratar consultar el estado de la solictud", e);
		throw new Exception("Error al tratar de consultar el estado de la solictud : ", e);
	} finally {
		closeConexion();
		logger.info("finalizo dao SolicitudFacturas (Validacion Estado Solicitud) !");

	}
		
		
		return estado;
	}
	

}
