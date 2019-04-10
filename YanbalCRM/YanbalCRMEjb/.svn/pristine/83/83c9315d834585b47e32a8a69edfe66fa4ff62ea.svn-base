package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.EstadoAuxiliar;

public class EstadoAuxiliarDAO extends BaseDAO {

	public EstadoAuxiliarDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(EstadoAuxiliarDAO.class);

	private String SQL_BUSCAR_ESTADOS_AUXILIARES = "SELECT  [idestadoaux] ,[nombreestado]  ,[action] FROM .[publicar].[estados_auxiliares] where estado=2";

	public ArrayList<EstadoAuxiliar> buscarEstadosAux() throws Exception {

		ArrayList<EstadoAuxiliar> estados = new ArrayList<>();
		EstadoAuxiliar estado = new EstadoAuxiliar();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ESTADOS_AUXILIARES);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				estado = new EstadoAuxiliar();
				estado.setId(rs.getInt(t++));
				estado.setNombre(rs.getString(t++));
				estado.setAction(rs.getString(t));

				estados.add(estado);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los bancos", e);
			throw new Exception("Error SQL al tratar de leer  los bancos", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los bancos", e);
			throw new Exception("Error al tratar de leer  los bancos: ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return estados;
	}

	private String SQL_INSERT_AUX = "INSERT INTO [publicar].[estados_auxiliares_agente]([idestadoaux],[idusuariocrea],[fechainicio],[estado]) VALUES (?,?,getdate(),2)";

	public Integer insertarAux(Integer idestado, Integer idusuario) {
		Integer resultado = 0;
		try {
			con = ds.getConnection();

			ps = con.prepareStatement(SQL_INSERT_AUX.toString(), Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, idestado);
			ps.setInt(2, idusuario);

			resultado = ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				resultado = rs.getInt(1);
			} else {
				throw new SQLException("Comite, no se pudo generar su auxiliar.");
			}
		} catch (SQLException e) {
			logger.error("Atrapó la excepcion", e);
		} catch (Exception e) {
			logger.error("Atrapó la excepcion", e);
		} finally {
			closeConexion();
		}
		return resultado;
	}

	private String SQL_UDATE_AUX = "update [publicar].[estados_auxiliares_agente] set fechafin=GETDATE() where idauxagente=?";

	public Integer actualizarAux(Integer llave) {
		Integer resultado = 0;
		try {
			con = ds.getConnection();

			ps = con.prepareStatement(SQL_UDATE_AUX.toString());

			ps.setInt(1, llave);

			resultado = ps.executeUpdate();

		//	rs = ps.getGeneratedKeys();

		} catch (SQLException e) {
			logger.error("Atrapó la excepcion", e);
		} catch (Exception e) {
			logger.error("Atrapó la excepcion", e);
		} finally {
			closeConexion();
		}
		return resultado;
	}
}
