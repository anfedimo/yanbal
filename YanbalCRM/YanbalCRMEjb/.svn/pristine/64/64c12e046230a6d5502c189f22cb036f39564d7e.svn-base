package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.Obligacion;

public class FacturaGestionDAO extends BaseDAO {

	public FacturaGestionDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(FacturaGestionDAO.class);
/*
	private String SQL_INSERTAR_FACTURA_GESTION = "INSERT INTO [publicar].[factura_gestion] " 
			+ "           ([factura] "
			+ "           ,[idgestion] " 
			+ "           ,[capital] " 
			+ "           ,[capital_descuento] "
			+ "           ,[capital_porcentaje] " 
			+ "           ,[interes] " 
			+ "           ,[interes_descuento] "
			+ "           ,[interes_porcentaje] " 
			+ "           ,[total_Descuento] " 
			+ "           ,[total_cobro] "
			+ "           ,[estado] " 
			+ "           ,[idusuariocrea] " 
			+ "           ,[fechacrea]) " 
			+ "     VALUES "
			+ "           (?,?,?,?,?,?,?,?,?,?,2,?,getdate())";

	public DatosAdicionales insertarobligacions(Obligacion obligacion) throws Exception {
		int total = 0;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_INSERTAR_FACTURA_GESTION);
			ps.setString(1, obligacion.getFactura());
			ps.setInt(2, obligacion.getIdgestion());
			ps.setBigDecimal(3, obligacion.getTotalCartera());
			ps.setBigDecimal(4, obligacion.getTotalCartera().subtract(obligacion.getTotalCapDesc()));
			ps.setBigDecimal(5, obligacion.getCapitalDescuento());			
			ps.setBigDecimal(6, obligacion.getInteresesMora());			
			ps.setBigDecimal(7, obligacion.getInteresesMora().subtract(obligacion.getTotalIntDesc()));
			ps.setBigDecimal(8, obligacion.getInteresDescuento());
			ps.setBigDecimal(9, obligacion.getTotalCartera().subtract(obligacion.getTotalCapDesc())
					.add(obligacion.getInteresesMora().subtract(obligacion.getTotalIntDesc())));
			ps.setBigDecimal(10, obligacion.getTotalCobro());
			ps.setInt(11, obligacion.getIdusuariocrea());
			total = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("Error SQL insertando las obligacions", e);
			throw new Exception("Error SQL insertando las obligacions", e);
		} catch (Exception e) {
			logger.error("Error insetrtando las obligacions", e);
			throw new Exception("Error insertando datos adicionales : ", e);
		} finally {
			closeConexion();

			logger.info("finalizo dao insertar obligacions ! Inserto :" + total);

		}
		return null;

	}
	private String SQL_INSERTAR_FACTURA_COMITE = "INSERT INTO [publicar].[comite_obligacion] " 
			+ "           ([factura] "
			+ "           ,[idcomite] " 
			+ "           ,[capital] " 
			+ "           ,[capital_porcentaje] " 
			+ "           ,[interes] " 
			+ "           ,[interes_porcentaje] " 
			+ "           ,[total_cobro] "
			+ "           ,[estado] " 
			+ "           ,[idusuariocrea] " 
			+ "           ,[fechacrea]) " 
			+ "     VALUES "
			+ "           (?,?,?,?,?,?,?,2,?,getdate())";

	public DatosAdicionales insertarobligacionsComite(Obligacion obligacion) throws Exception {
		int total = 0;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_INSERTAR_FACTURA_COMITE);
			ps.setString(1, obligacion.getFactura());
			ps.setInt(2, obligacion.getIdComite());
			ps.setBigDecimal(3, obligacion.getTotalCapDesc());
			ps.setBigDecimal(4, obligacion.getCapitalDescuento());			
			ps.setBigDecimal(5, obligacion.getTotalIntDesc());			
			ps.setBigDecimal(6, obligacion.getInteresDescuento());
			ps.setBigDecimal(7, obligacion.getTotalCobro());
			ps.setInt(8, obligacion.getIdusuariocrea());
			total = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("Error SQL insertando las obligacions", e);
			throw new Exception("Error SQL insertando las obligacions", e);
		} catch (Exception e) {
			logger.error("Error insetrtando las obligacions", e);
			throw new Exception("Error insertando datos adicionales : ", e);
		} finally {
			closeConexion();

			logger.info("finalizo dao insertar obligacions ! Inserto :" + total);

		}
		return null;

	}
*/
}
