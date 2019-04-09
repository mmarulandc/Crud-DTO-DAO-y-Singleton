
package factura.DTO;

/**
 *
 * @author mmarulandc
 */
public class TipoItemDTO {
    
    private int Id;
    private String Descripcion;

    public TipoItemDTO(int Id, String Descripcion) {
        this.Id = Id;
        this.Descripcion = Descripcion;
    }

    public TipoItemDTO(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public TipoItemDTO() {
    }

    public TipoItemDTO(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
