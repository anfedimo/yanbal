package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Memo;
import co.sistemcobro.yanbal.bean.ObligacionYanbal;

public class MemoDAO extends BaseDAO {

	public MemoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(MemoDAO.class);
	private String SQL_BUSCAR_GESTION = "Select distinct * from consultarMemo(?) order by gest_fechafinllamada desc ";

	public List<Memo> buscarMemo(String idcliente, List<Memo> gestiones, List<ObligacionYanbal> listaObligaciones) throws Exception {
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_GESTION);
			ps.setString(1, idcliente);
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Memo memo = new Memo();
				
				memo.setIdGestion(rs.getString(t++));
				memo.setNombreTipificacion(rs.getString(t++));
				memo.setIdentificacion(rs.getString(t++));
				memo.setNombreCliente(rs.getString(t++));
				memo.setApellidoCliente(rs.getString(t++));
				memo.setFechaPromesa(rs.getString(t++));
				memo.setNombreCargue(rs.getString(t++));
				memo.setFactura(rs.getString(t++));
				memo.setNombreAsesor(rs.getString(t++));
				memo.setValorPromesa(rs.getString(t++));
				memo.setObservacion(rs.getString(t++));
				memo.setFechaUltimoContacto(rs.getString(t++));
				
				gestiones.add(memo);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las gestiones ", e);
			throw new Exception("Error SQL al tratar de leer   ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  las gestiones ", e);
			throw new Exception("Error al tratar de leer  : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");

		}
		return gestiones;
	}

	

	

}
