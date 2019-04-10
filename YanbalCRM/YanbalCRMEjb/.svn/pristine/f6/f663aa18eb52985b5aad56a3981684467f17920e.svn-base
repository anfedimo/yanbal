package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Telefono;
import co.sistemcobro.yanbal.bean.TelefonoDatosAdicionales;

public class TelefonoDAO extends BaseDAO {

	public TelefonoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(TelefonoDAO.class);



	private String SQL_BUSCAR_TELEFONOS = "  select * from ( select yy.cedula, yy.tipo, yy.numero from  "
			+ " (select 'Movil' as tipo, c.carg_estado estado_cargo, d.deud_estado as estado_deudor, "
			+ " d.deud_identificacion as cedula, deud_celular as numero,  d.deud_identificacion "
			+ " from yanbal.deudor d  join yanbal.cargue c on c.carg_id = d.deud_idcargue and c.carg_idbase IN (select b.base_id from  yanbal.base b where b.base_estado = 2 ) "
			+ " union  select 'Fijo' as tipo, c.carg_estado estado_cargo, d.deud_estado as estado_deudor, d.deud_identificacion as cedula, d.deud_telefono as numero, d.deud_identificacion "
			+ " from yanbal.deudor d  join yanbal.cargue c on c.carg_id = d.deud_idcargue and c.carg_idbase IN (select b.base_id from  yanbal.base b where b.base_estado = 2 ) "
			+ " union select 'Telefono' as tipo, 2 as estado_cargo, 2 as estado_deudor, t.teld_identificacion as cedula, t.teld_tel as telefono,t.teld_identificacion "
			+ " from yanbal.telefonodeudor t) yy where yy.estado_deudor = 2 and yy.estado_cargo =2 and yy.cedula = ?   ) xx  where xx.numero is not null";
	
	public List<Telefono> buscarTelefonos(String cliente) throws Exception {

		ArrayList<Telefono> telefonos = new ArrayList<Telefono>();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_TELEFONOS);
			ps.setString(1, cliente);
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Telefono telefono = new Telefono();

				telefono.setCedula(rs.getString(t++));
				telefono.setTipo(rs.getString(t++));
				telefono.setNumero(rs.getString(t++));
				telefonos.add(telefono);

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
			logger.info("finalizo dao telefonos!");

		}
		return telefonos;
	}

	
	
	private String SQL_TELEFONOS = "Select  t.teld_identificacion, t.teld_tipo, t.teld_tel "
				+ "from yanbal.telefonodeudor t where t.teld_identificacion = ? ";
		public List<TelefonoDatosAdicionales> telefonos(String cliente) throws Exception {

			ArrayList<TelefonoDatosAdicionales> telefonos = new ArrayList<TelefonoDatosAdicionales>();

			try {
				con = ds.getConnection();
				ps = con.prepareStatement(SQL_TELEFONOS);
				ps.setString(1, cliente);
				rs = ps.executeQuery();
				int t = 1;
				while (rs.next()) {
					t = 1;
					TelefonoDatosAdicionales telefono = new TelefonoDatosAdicionales();

					telefono.setIdentificacion(rs.getString(t++));
					telefono.setTipo(rs.getString(t++));
					telefono.setTelefono(rs.getString(t++));
					telefonos.add(telefono);

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
				logger.info("finalizo dao telefonos!");

			}
			return telefonos;
		}

		
	
	
}
