package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Tipificacion;

public class TipificacionDAO extends BaseDAO {

	public TipificacionDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(TipificacionDAO.class);

	private String SQL_BUSCAR_TIPIFICACIONES = " select (t.tipi_nombretipificacion) as nombre  ,t.tipi_id "
			+ " from yanbal.tipificacion t  "
			+ " where  t.tipi_estado=2  and t.tipi_idtipificacionpadre = ?";
		//	+ "order by t.nombretipificacion";

	public List<SelectItem> buscarTipificaciones(int categoriaPadre) throws Exception {

		ArrayList<SelectItem> tipificaciones = new ArrayList<SelectItem>();
		SelectItem tipificacion = new SelectItem();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_TIPIFICACIONES);
			ps.setInt(1, categoriaPadre);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				tipificacion = new SelectItem();
				tipificacion.setLabel(rs.getString(t++));
				tipificacion.setValue(rs.getInt(t++));
				tipificaciones.add(tipificacion);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las tipificaciones", e);
			throw new Exception("Error SQL al tratar de leer  las tipificaciones", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  las tipificaciones", e);
			throw new Exception("Error al tratar de leer  las tipificaciones: ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return tipificaciones;
	}
	
	
	private String SQL_BUSCAR_ID_TIPIFICACION_POR_CODIGO = "   "
			+ " from yanbal.tipificacion t  "
			+ "  where  t.tipi_estado=2 and t.tipi_nombretipificacion = ?";
		//	+ "order by t.nombretipificacion";
	
	public Integer buscarIdTipificacionPorCodigo(String idtipificacionpadre) throws Exception {

		Integer idTipificacion = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ID_TIPIFICACION_POR_CODIGO);

			ps.setString(1, idtipificacionpadre);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				
				idTipificacion = rs.getInt(t++);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las tipificaciones", e);
			throw new Exception("Error SQL al tratar de leer  las tipificaciones", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  las tipificaciones", e);
			throw new Exception("Error al tratar de leer  las tipificaciones: ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return idTipificacion;
	}
	
	private String SQL_BUSCAR_TIPIFICACIONES_POR_ID = "  select t.tipi_id, t.tipi_idtipificacionpadre,  "
			+ " (t.tipi_nombretipificacion) as nombre "
			+ "  from yanbal.tipificacion t  "
			+ " where  t.tipi_estado=2 and t.tipi_idtipificacionpadre = ? "
			+ "order by t.tipi_nombretipificacion asc " ;

	public List<Tipificacion> buscarTipificacionesPorNivel(Integer idNivelTipificacion) throws Exception {

		List<Tipificacion> tipificaciones = new ArrayList<Tipificacion>();
		Tipificacion tipificacion = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_TIPIFICACIONES_POR_ID);
			
			ps.setInt(1, idNivelTipificacion);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				tipificacion = new Tipificacion();
				
				tipificacion.setId(rs.getString(t++));
				tipificacion.setIdtipificacionpadre(rs.getString(t++));
				tipificacion.setNombretipificacion(rs.getString(t++));
				
				tipificaciones.add(tipificacion);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las tipificaciones", e);
			throw new Exception("Error SQL al tratar de leer  las tipificaciones", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  las tipificaciones", e);
			throw new Exception("Error al tratar de leer  las tipificaciones: ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return tipificaciones;
	}

}
