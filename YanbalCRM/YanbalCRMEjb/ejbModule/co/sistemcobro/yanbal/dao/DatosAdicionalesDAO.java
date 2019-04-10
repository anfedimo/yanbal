package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.InformacionComplementaria;
import co.sistemcobro.yanbal.bean.TelefonoDatosAdicionales;

public class DatosAdicionalesDAO extends BaseDAO {

	public DatosAdicionalesDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(DatosAdicionalesDAO.class);

	private String SQL_BUSCAR_DATOS_ADICIONALES = " select top (1) b.base_nombrebase , d.deud_identificacion, d.deud_nombre, d.deud_primerapellido, deud_direccion, deud_email, d.deud_telefono, d.deud_celular, d.deud_numeroadicional,  c.carg_id  "
			+ " from yanbal.deudor d inner join yanbal.cargue c with(nolock) on c.carg_id = d.deud_idcargue "
			+ " inner join yanbal.base b with(nolock) on b.base_id = c.carg_idbase where d.deud_identificacion = ? ";

	public List<DatosAdicionales> buscarDatosAdicionales(String idcliente) throws Exception {

		ArrayList<DatosAdicionales> datosAdicionales = new ArrayList<DatosAdicionales>();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_DATOS_ADICIONALES);
			ps.setString(1, idcliente);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				DatosAdicionales datoAdicional = new DatosAdicionales();
				datoAdicional.setNombreBase(rs.getString(t++));
				datoAdicional.setIdentificacion(rs.getString(t++));
				datoAdicional.setNombre(rs.getString(t++));
				datoAdicional.setApellido(rs.getString(t++));
				datoAdicional.setDireccion(rs.getString(t++));
				datoAdicional.setEmail(rs.getString(t++));
				datoAdicional.setTelefono(rs.getString(t++));
				datoAdicional.setCelular(rs.getString(t++));
				datoAdicional.setNumeroAdicional(rs.getString(t++));
				datoAdicional.setIdCargue(rs.getInt(t++));
				
				datosAdicionales.add(datoAdicional);
			}

		} catch (SQLException e) {
			logger.error("Error SQL al tratar de mostrar los datos Adicionales ", e);
			throw new Exception("Error SQL al tratar de mostrar los datos Adicionales ", e);
		} catch (Exception e) {
			logger.error("Error al tratar demostrar los datos Adicionales ", e);
			throw new Exception("Error al tratar de mostrar los datos Adicionales : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao DatosAdicionales !");

		}
		return datosAdicionales;
	}

	private String SQL_ACTUALIZAR_DATOS = " UPDATE yanbal.deudor SET  deud_nombre = ?,  deud_primerapellido= ?,"
			+ "  deud_direccion= ?, deud_email= ?, deud_telefono= ?, deud_celular= ?, deud_numeroadicional = ?"
			+ " WHERE deud_identificacion  = ? and deud_idcargue = ? ";

	public int actualizarDatos(DatosAdicionales dato) throws Exception {
		int retorno = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_DATOS, Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			ps.setString(t++, dato.getNombre());
			ps.setString(t++, dato.getApellido());
			ps.setString(t++, dato.getDireccion());
			ps.setString(t++, dato.getEmail());
			ps.setString(t++, dato.getTelefono());
			ps.setString(t++, dato.getCelular());
			ps.setString(t++, dato.getNumeroAdicional());

			ps.setString(t++, dato.getIdentificacion());
			ps.setInt(t++, dato.getIdCargue());

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				retorno = rs.getInt(1);
			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de actualizar datos " + e.toString(), e.fillInStackTrace());
			throw new Exception("SQLException Error SQL al tratar de actualizar datos " + ps.toString(), e.getCause());
		} catch (Exception e) {
			logger.error("Exception Error  al tratar de actualizar datos " + e.toString(), e.fillInStackTrace());
			throw new Exception("Exception Error al tratar de  actualizar datos : " + e.getStackTrace(),
					e.getCause());
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}

		return retorno;
	}
	
	private String SQL_INSERTAR_TELEFONO = "  INSERT INTO  yanbal.telefonodeudor ( teld_identificacion, teld_tipo, "
			+ " teld_tel, teld_idusuariocrea, teld_fechacrea, teld_estado ) " 
			+ " VALUES (?,?,?,?,GETDATE(),2)";

	public int insertarTelefono(TelefonoDatosAdicionales telefono) throws Exception {
		int retorno = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_INSERTAR_TELEFONO, Statement.RETURN_GENERATED_KEYS);
			int t = 1;

			ps.setString(t++, telefono.getIdentificacion());
			ps.setString(t++, telefono.getTipo());
			ps.setString(t++, telefono.getTelefono());
			ps.setInt(t++, telefono.getIdUsuarioCrea());
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				retorno = rs.getInt(1);
			}

		} catch (SQLException e) {
			logger.error("Error SQL al tratar de insertar telefonos ", e);
			e.printStackTrace();
			throw new Exception("Error SQL al tratar de insertar telefonos ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de insertar telefonos", e);
			throw new Exception("Error al tratar de insertar telefonos : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao insertarTelefono!");
		}
		return retorno;
	}

}
