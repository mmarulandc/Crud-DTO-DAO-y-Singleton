
package factura.interfaces;

import factura.DTO.FacturaDTO;
import java.util.List;

/**
 *
 * @author mmarulandc
 */
public interface FacturaDaoInterface <any> {
    
    public boolean create(any c);
    public any read(Object c);
    public boolean update(any c);
    public boolean delete(Object c);
    public List<any> readAll();
    
}
