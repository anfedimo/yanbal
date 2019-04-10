package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.DatosAdicionales;
import co.sistemcobro.yanbal.bean.gestionCantidad;
import co.sistemcobro.yanbal.bean.sms;

public class SmsDAO extends BaseDAO {

	public SmsDAO(DataSource ds2) {
		super(ds2);
		// TODO Auto-generated constructor stub
	}

	private static Logger logger = Logger.getLogger(SmsDAO.class);

	private String SQL_BUSCAR_SMS_CLIENTE = "SELECT [idsms],[texto]  FROM [publicar].[publicar].[sms] where segmento = 'all' or segmento=? and idpais=2 and estado=2";

	public List<sms> buscarMensajes(String segmento) throws Exception {

		ArrayList<sms> mensajes = new ArrayList<>();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_SMS_CLIENTE);
			ps.setString(1, segmento);
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				sms mensaje = new sms();

				mensaje.setId(rs.getInt(t++));
				mensaje.setTexto(rs.getString(t++));

				mensajes.add(mensaje);
			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  las gestiones del dia ", e);
			throw new SQLException("Error SQL al tratar de leer  las gestiones del dia ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  las gestiones del dia ", e);
			throw new Exception("Error al tratar de leer  las gestiones del dia : ", e);
		} finally {
			closeConexion();

		}
		return mensajes;
	}

	public void insertarMensajeEnviado(sms mensaje) throws Exception {
		int total = 0;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(
					"insert into publicar.sms_enviado ([idsms],[idcliente],[celular],[respuesta],[idusuariocrea],[fechacrea],[estado],[idpais] ) values(?,?,?,?,?,getdate(),2,2)");
			ps.setInt(1, mensaje.getId());
			ps.setString(2, mensaje.getCliente());
			ps.setString(3, mensaje.getCelular());
			ps.setString(4, mensaje.getRepuesta());
			ps.setInt(5,mensaje.getAsesor());
			total = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("error guardando sms", e);
			throw new Exception("error guardando sms", e);
		} catch (Exception e) {
			logger.error("error guardando sms ", e);
			throw new Exception("Eerror guardando sms : ", e);
		} finally {
			closeConexion();

			logger.info("finalizo dao insertar sms ! Inserto :" + total);

		}

	}
}
