/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.DAO;

import factura.ConexionSingleton.Conexion;
import factura.DTO.ItemsDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmarulandc
 */
public class ItemsDAO implements factura.interfaces.FacturaDaoInterface<ItemsDTO> {
    private static final String SQL_CREATE = "INSERT INTO items (idTipoItem,idItems,Descripcion,ValorUnidad,idFactura) VALUES (?,?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM items WHERE idTipoItem = ?";
    private static final String SQL_UPDATE = "UPDATE items SET Descripcion = ?  WHERE idTipoItem = ?";
    private static final String SQL_DELETE = "DELETE FROM items WHERE idTipoItem = ?";
    private static final String SQL_READALL = "SELECT * from items";

    private static final Conexion con = Conexion.estado(); // aplicamos singleton

    @Override
    public boolean create(ItemsDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_CREATE);
            ps.setInt(1, c.getTipoItem());
            ps.setInt(2, c.getId());
            ps.setString(3, c.getDescipcion());
            ps.setFloat(4, c.getValorUnidad());
            ps.setInt(5, c.getIdFactura().getNroFactura());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return false;
    }

    @Override
    public ItemsDTO read(Object c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ItemsDTO c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemsDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
