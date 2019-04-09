
package factura.ConexionSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmarulandc
 */
public class Conexion {
    public static Conexion instance; //Singleton
    private Connection cnn;
    
    /*
    De esta manera no se podran crear objetos de esta clase, y para poder hacer la conexion se hará solo a travez de la variable instance. 
    La cual será unica, verificandose con el metodo con el metodo estado(), así se aplica el Singleton
    */
    private Conexion() { 
        try {
            Class.forName("com.mysql.jdbc.Driver"); //driver
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Mateo246810@");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Si quiero crear una conexion tengo que llamar este metodo. Además verifica que la instancia sea única
    */
    public static Conexion estado(){
        if(instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }
     
    public void cerrarConexion(){
        instance = null;
    }
}
