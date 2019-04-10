package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Parentesco;

public class ParentescoDAO extends BaseDAO {

	public ParentescoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(ParentescoDAO.class);

	private String SQL_BUSCAR_PARENTESCOS = "SELECT idparentesco, nombre "
			+ " FROM expertis.parentesco "
			+ " WHERE estado = 2 ";

	public List<Parentesco> buscarPArentescos() throws Exception {

		List<Parentesco> parentescos = new ArrayList<Parentesco>();
		Parentesco parentesco = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_PARENTESCOS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				parentesco = new Parentesco();
				
				parentesco.setIdParentesco(rs.getInt(t++));
				parentesco.setNombre(rs.getString(t++));
				
				parentescos.add(parentesco);

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
		return parentescos;
	}

}
