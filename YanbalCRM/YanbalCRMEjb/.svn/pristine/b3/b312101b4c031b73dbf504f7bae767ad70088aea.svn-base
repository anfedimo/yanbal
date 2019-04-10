package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Descuento;

public class DescuentoDAO extends BaseDAO {

	public DescuentoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(DescuentoDAO.class);

	public List<Descuento> descuentosClientePorCuota(String idCliente, Integer numeroCuota) throws Exception {

		List<Descuento> listaDescuentos = new ArrayList<>();
		Descuento descuento = null;

		String query = "select idpolitica, d.idcargue, iddeudor, documento, cartera, canal, " 
		+ " antiguedad, dk, dt, ";
		
		if (numeroCuota == 1) {
			query += " min_1, max_1, ";
		}
		if (numeroCuota == 3) {
			query += " min_3, max_3, ";
		}
		if (numeroCuota == 6) {
			query += " min_6, max_6, ";
		}
		if (numeroCuota == 12) {
			query += " min_12, max_12, ";
		}
		query += " d.fechacrea, d.estado  ";
		query += " from expertis.politicadescuento d"
			  + " join expertis.cargue c on c.idcargue = d.idcargue and c.idbase = (select top 1 max(b.idbase) from  expertis.base b where b.estado = 2 ) "
			  + " where d.documento = ? and d.estado = 2 AND c.estado = 2 ";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, idCliente);
			//ps.setInt(2, numeroCuota);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				descuento = new Descuento();

				descuento.setIdpolitica(rs.getInt(t++));
				descuento.setIdcargue(rs.getInt(t++));
				descuento.setIddeudor(rs.getInt(t++));
				descuento.setDocumento(rs.getString(t++));				
				descuento.setCartera(rs.getString(t++));
				descuento.setCanal(rs.getString(t++));
				descuento.setAntiguedad(rs.getString(t++));
				descuento.setDk(rs.getDouble(t++));
				descuento.setDt(rs.getDouble(t++));				
				
				descuento.setMinComodin(rs.getDouble(t++));
				descuento.setMaxComodin(rs.getDouble(t++));
				
				descuento.setFechacrea(rs.getTimestamp(t++));				
				descuento.setEstado(rs.getInt(t++));				

				listaDescuentos.add(descuento);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Descuentos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Descuentos ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return listaDescuentos;
	}

}
