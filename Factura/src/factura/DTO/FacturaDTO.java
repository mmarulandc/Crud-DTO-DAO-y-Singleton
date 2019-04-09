
package factura.DTO;

import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author mmarulandc
 */
public class FacturaDTO {
    private int NroFactura;
    private Date FechaFactura;
    private long TotalFactura;
    private String Estado;
    private String IdCliente;

    public FacturaDTO(Date FechaFactura, long TotalFactura, String Estado,  String IdCliente) {
        
        this.FechaFactura = FechaFactura;
        this.TotalFactura = TotalFactura;
        this.Estado = Estado;
        this.IdCliente = IdCliente;
    }

    public FacturaDTO(int NroFactura) {
        this.NroFactura = NroFactura;
    }

    public FacturaDTO() {
    }

    public FacturaDTO(int NroFactura, Date FechaFactura, long TotalFactura, String Estado, String IdCliente) {
        this.NroFactura = NroFactura;
        this.FechaFactura = FechaFactura;
        this.TotalFactura = TotalFactura;
        this.Estado = Estado;
        this.IdCliente = IdCliente;
    }

    public int getNroFactura() {
        return NroFactura;
    }

    public void setNroFactura(int NroFactura) {
        this.NroFactura = NroFactura;
    }

    public Date getFechaFactura() {
        return FechaFactura;
    }

    public void setFechaFactura(Date FechaFactura) {
        this.FechaFactura = FechaFactura;
    }

    public long getTotalFactura() {
        return TotalFactura;
    }

    public void setTotalFactura(long TotalFactura) {
        this.TotalFactura = TotalFactura;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }



    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    
    
}
