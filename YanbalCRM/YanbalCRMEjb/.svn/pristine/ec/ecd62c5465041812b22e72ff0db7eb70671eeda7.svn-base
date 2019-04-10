package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.HistoricoCambio;
import co.sistemcobro.yanbal.bean.Telefono;

public class HistoricoCambioDAO extends BaseDAO {

	public HistoricoCambioDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(HistoricoCambioDAO.class);

	
	private String SQL_HISTORICO_CAMBIOS = " SELECT xx.documento, xx.tipo, xx.valor, xx.idusuario, xx.fecha FROM (SELECT   "
			+ "	d.deud_identificacion as documento,	case when d.deud_direccion is null then 'correo' else 'dirección' end as tipo,  "
			+ "	case when d.deud_direccion is null then d.deud_direccion end as valor, case	when d.deud_idusuariocrea  is null   "
			+ "	then d.deud_idusuariomod else d.deud_idusuariocrea	end as idusuario,	case		when d.deud_fechacrea  is null   "
			+ "	then d.deud_fechamod else d.deud_fechacrea	end as fecha  FROM yanbal.deudor d  where   d.deud_estado = 2   AND    "
			+ "	(d.deud_idusuariomod is not null and d.deud_fechamod is not null  OR   d.deud_idusuariocrea is not null and d.deud_fechacrea is not null)  "
			+ "	UNION   SELECT   "
			+ "	 t.documento as documento,	  t.tipo as tipo      ,t.tel as valor,	   "
			+ "	case		when t.idusuariocrea  is null then t.idusuariomod   "
			+ "	else t.idusuariocrea	  end as idusuario,	  case		when t.fechacrea  is null   "
			+ "	then t.fechamod else t.fechacrea	  end as fecha  FROM yanbal.telefonodeudor t  "
			+ "	 where   t.estado = 2     "
			+ "	AND    (t.idusuariomod is not null and t.fechamod is not null     "
			+ "	OR   t.idusuariocrea is not null and t.fechacrea is not null)) AS xx   "
			+ "	WHERE xx.documento = ? order by 1 desc ";

	public List<HistoricoCambio> buscarHistoricoCambios(String documento) throws Exception {

		ArrayList<HistoricoCambio> historicoCambios = new ArrayList<HistoricoCambio>();
		HistoricoCambio historicoCambio = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_HISTORICO_CAMBIOS);
			ps.setString(1, documento);
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				historicoCambio = new HistoricoCambio();

				historicoCambio.setDocumento(rs.getString(t++));
				historicoCambio.setTipo(rs.getString(t++));
				historicoCambio.setValor(rs.getString(t++));
				historicoCambio.setIdusuario(rs.getString(t++));
				historicoCambio.setFecha(rs.getTimestamp(t++));
				
				historicoCambios.add(historicoCambio);

			}
			// cliente.setTelefonos(Telefonos);
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de consultar telefonos ", e);
			e.printStackTrace();
			throw new Exception("Error SQL al tratar de consultar telefonos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de consultar telefonos", e);
			throw new Exception("Error al tratar de consultar telefonos : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao historico cambios!");
		}
		return historicoCambios;
	}

	

}
