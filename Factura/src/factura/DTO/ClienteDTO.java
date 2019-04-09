package factura.DTO;

import java.sql.Date;

/**
 *
 * @author mmarulandc
 */
public class ClienteDTO {
    
    private String Id;
    private String Nombre,Apellidos;
    private String Genero;
    private Date FechaN;
    private String EstadoC;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public ClienteDTO(String Id) {
        this.Id = Id;
    }

    public ClienteDTO(String Id, String Nombre, String Apellidos, String Genero, Date FechaN, String EstadoC) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Genero = Genero;
        this.FechaN = FechaN;
        this.EstadoC = EstadoC;
    }
    
 

    public ClienteDTO() {
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Date getFechaN() {
        return FechaN;
    }

    public void setFechaN(Date FechaN) {
        this.FechaN = FechaN;
    }

    public String getEstadoC() {
        return EstadoC;
    }

    public void setEstadoC(String EstadoC) {
        this.EstadoC = EstadoC;
    }
   
    
}
