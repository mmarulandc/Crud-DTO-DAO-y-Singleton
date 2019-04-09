package factura.DTO;

/**
 *
 * @author mmarulandc
 */
public class ItemsDTO {
    private int TipoItem;
    private int Id;
    private String Descipcion;
    private float ValorUnidad;
    private FacturaDTO IdFactura;

    public ItemsDTO(int TipoItem, int Id, String Descipcion, float ValorUnidad, FacturaDTO IdFactura) {
        this.TipoItem = TipoItem;
        this.Id = Id;
        this.Descipcion = Descipcion;
        this.ValorUnidad = ValorUnidad;
        this.IdFactura = IdFactura;
    }

    public ItemsDTO(int TipoItem, String Descipcion, float ValorUnidad, FacturaDTO IdFactura) {
        this.TipoItem = TipoItem;
        this.Descipcion = Descipcion;
        this.ValorUnidad = ValorUnidad;
        this.IdFactura = IdFactura;
    }

    public ItemsDTO() {
    }

    public ItemsDTO(int Id) {
        this.Id = Id;
    }

    public int getTipoItem() {
        return TipoItem;
    }

    public void setTipoItem(int TipoItem) {
        this.TipoItem = TipoItem;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescipcion() {
        return Descipcion;
    }

    public void setDescipcion(String Descipcion) {
        this.Descipcion = Descipcion;
    }

    public float getValorUnidad() {
        return ValorUnidad;
    }

    public void setValorUnidad(float ValorUnidad) {
        this.ValorUnidad = ValorUnidad;
    }

    public FacturaDTO getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(FacturaDTO IdFactura) {
        this.IdFactura = IdFactura;
    }

   
    
    
    
    
}
