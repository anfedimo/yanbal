package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Comite;
import co.sistemcobro.yanbal.bean.ComiteEstado;
import co.sistemcobro.yanbal.bean.Gestion;
import co.sistemcobro.yanbal.bean.Motivo;
import co.sistemcobro.yanbal.bean.ObligacionGestion;

public class ObligacionGestionDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(ObligacionGestionDAO.class);

	public ObligacionGestionDAO(DataSource ds) {
		super(ds);
	}

	public boolean insertarObligacionGestion(ObligacionGestion obligacionGestion) throws Exception {
		boolean insertado = false;

		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO expertis.obligacion_gestion ");
		varname1.append(" ( ");
		varname1.append(" idgestion, idobligacion, idusuariocrea, fechacrea, estado ");
		varname1.append(" ) ");
		varname1.append("VALUES ( ");
		varname1.append(" ?,"); // 1
		varname1.append(" ?,"); // 2
		varname1.append(" ?,"); // 3
		varname1.append(" GETDATE(),"); // 4
		varname1.append(" 2 "); // 5
		varname1.append(" )");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);
			int t = 1;
			
			ps.setInt(t++, obligacionGestion.getIdGestion());
			ps.setInt(t++, obligacionGestion.getIdObligacion());
			ps.setInt(t++, obligacionGestion.getIdUsuariocrea());

			// ps.setInt(t, gestion.getId());
			ps.executeUpdate();
			insertado = true;
			closeConexion();

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
		return insertado;
	}

}
