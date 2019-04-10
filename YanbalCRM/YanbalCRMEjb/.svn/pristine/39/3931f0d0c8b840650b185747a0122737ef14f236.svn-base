package co.sistemcobro.yanbal.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.yanbal.bean.Pago;

public class PagoDAO extends BaseDAO {

	public PagoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(MemoDAO.class);
	private String SQL_BUSCAR_PAGOS_POR_CLIENTE = "SELECT p.idpago, p.idcargue, p.tipoReg, p.numCta, "
			+ " p.codUser, p.descripcionUser, p.descripcionPago, p.fechaVencimiento, p.numItem, "
			+ " p.importePagado, p.importeMora, p.motoPagado, p.fechaPago, p.horaPago, p.numOp, "
			+ " p.idUser, p.idAg, p.numLiquidacion, p.codigoIdc, p.observacion, p.idusuariocrea, "
			+ " p.fechacrea, p.estado FROM expertis.pago p " + " join expertis.cargue c on c.idcargue = p.idcargue "
			+ " and c.idbase = (select top 1 max(b.idbase)  from  expertis.base b where b.estado = 2 ) "
			+ " WHERE CodUser = ? AND p.estado = 2 and c.estado = 2 ";

	public List<Pago> buscarPago(String idcliente) throws Exception {
		Pago pago = null;
		List<Pago> pagos = new ArrayList<Pago>();
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_PAGOS_POR_CLIENTE);
			ps.setString(1, idcliente);			
			
			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				pago = new Pago();
				
				pago.setIdpago(rs.getInt(t++)); 
				pago.setIdcargue(rs.getInt(t++)); 
				pago.setTipoReg(rs.getString(t++)); 
				pago.setNumCta(rs.getString(t++)); 
				pago.setCodUser(rs.getString(t++)); 
				pago.setDescripcionUser(rs.getString(t++)); 
				pago.setDescripcionPago(rs.getString(t++)); 
				pago.setFechaVencimiento(rs.getTimestamp(t++)); 
				pago.setNumItem(rs.getDouble(t++)); 
				pago.setImportePagado(rs.getDouble(t++)); 
				pago.setImporteMora(rs.getDouble(t++)); 
				pago.setMotoPagado(rs.getDouble(t++)); 
				pago.setFechaPago(rs.getTimestamp(t++)); 
				pago.setHoraPago(rs.getTime(t++)); 
				pago.setNumOp(rs.getString(t++)); 
				pago.setIdUser(rs.getString(t++)); 
				pago.setIdAg(rs.getString(t++)); 
				pago.setNumLiquidacion(rs.getString(t++)); 
				pago.setCodigoIdc(rs.getString(t++)); 
				pago.setObservacion(rs.getString(t++)); 
				pago.setIdusuarioCrea(rs.getInt(t++)); 
				pago.setFechaCrea(rs.getTimestamp(t++)); 
				pago.setEstado(rs.getInt(t++));
				
				pagos.add(pago);
			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los pagos ", e);
			throw new Exception("Error SQL al tratar de leer   ", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los pagos ",e);
			throw new Exception("Error al tratar de leer  : ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return pagos;
	}

}
