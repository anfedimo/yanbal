package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class FormaPagoDAO extends BaseDAO {

	public FormaPagoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(FormaPagoDAO.class);

	private String SQL_BUSCAR_FORMA_PAGO = "select t.idformapago,t.nombreformapago from publicar.formapago t where t.estado=2 order by t.idformapago";

	public List<SelectItem> buscarTipificacionesPorGrupo() throws Exception {

		ArrayList<SelectItem> formas = new ArrayList<SelectItem>();
		SelectItem forma = new SelectItem();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_FORMA_PAGO);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				forma = new SelectItem();

				forma.setValue(rs.getInt(t++));
				forma.setLabel(rs.getString(t++));
				formas.add(forma);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las formas de pago", e);
			throw new Exception("Error SQL al tratar de leer  las formas de pago", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  las formas de pago", e);
			throw new Exception("Error al tratar de leer  las formas de pago: ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return formas;
	}

}
