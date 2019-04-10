package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Cuota;
import co.sistemcobro.yanbal.bean.Descuento;

public class CuotaDAO extends BaseDAO {

	public CuotaDAO(DataSource ds) {
		super(ds);
	}
	
	private static Logger logger = Logger.getLogger(DescuentoDAO.class);

	private String SQL_BUSCAR_CUOTA_CLIENTE = " SELECT distinct "
			+ " documento,  1 AS '1', 3 AS '3',6 AS '6',12 AS '12'"
			+ " FROM expertis.politicadescuento "
			+ " where documento = ? AND estado = 2 ";

	public List<Cuota> cuotaPorCliente(String idCliente) throws Exception{
		
		List<Cuota> listaCuotas = new ArrayList<>();
		Cuota cuota = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_CUOTA_CLIENTE);
			
			ps.setString(1, idCliente);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;				
				cuota = new Cuota();
				
				cuota.setDni(rs.getString(t++));
				cuota.setNumeroCuota(rs.getInt(t++));
				
				listaCuotas.add(cuota);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los Descuentos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los Descuentos ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return listaCuotas;
	}

}