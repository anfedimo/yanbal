package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Motivo;
import co.sistemcobro.yanbal.bean.Parentesco;

public class MotivoDAO extends BaseDAO {

	public MotivoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(MotivoDAO.class);

	private String SQL_BUSCAR_TIPIFICACIONES_POR_ID = " select idmotivonopago,"
			+ " (codigomotivo+' | '+nombre) as nombre "
			+ " FROM expertis.motivo_no_pago "
			+ " WHERE estado = 2 ";

	public List<Motivo> buscarMotivos() throws Exception {

		List<Motivo> motivos = new ArrayList<Motivo>();
		Motivo motivo = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_TIPIFICACIONES_POR_ID);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				motivo = new Motivo();
				
				motivo.setIdmotivonopago(rs.getInt(t++));
				motivo.setNombre(rs.getString(t++));
				
				motivos.add(motivo);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  ", e);
			throw new Exception("Error SQL al tratar de leer  ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  ", e);
			throw new Exception("Error al tratar de leer  : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return motivos;
	}

}
