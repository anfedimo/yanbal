package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.DireccionTipo;

public class DireccionTipoDAO extends BaseDAO {

	public DireccionTipoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(DireccionTipoDAO.class);

	private String SQL_BUSCAR_TIPO_DIRECCION = ""
			+ " select idcontactodirecciontipo, nombre from publicar.publicar.contacto_direcciontipo "
            +" where estado = ? ";

	public List<DireccionTipo> buscarDireccionTipo() throws Exception {

		ArrayList<DireccionTipo> direccionestipo = new ArrayList<DireccionTipo>();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_TIPO_DIRECCION);
			ps.setInt(1, 2);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				DireccionTipo direcciontipo = new DireccionTipo();
				direcciontipo.setIdcontactodirecciontipo(rs.getInt(t++));
				direcciontipo.setNombre(rs.getString(t++));							
				direccionestipo.add(direcciontipo);

			}
		
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los tipos de direccion ", e);
			throw new Exception("Error SQL al tratar de leer  los tipos de direccion ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  tipos de direccion ", e);
			throw new Exception("Error al tratar de leer los tipos de direccion : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao DireccionTipos !");

		}
		return direccionestipo;
	}

}
