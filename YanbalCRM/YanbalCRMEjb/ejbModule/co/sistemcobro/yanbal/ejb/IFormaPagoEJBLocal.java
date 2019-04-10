package co.sistemcobro.yanbal.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.faces.model.SelectItem;

@Local
public interface IFormaPagoEJBLocal {

	public List<SelectItem> buscarFormasPago() throws Exception;

}
