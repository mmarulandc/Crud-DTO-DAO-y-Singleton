/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.DAO;

import factura.ConexionSingleton.Conexion;
import factura.DTO.TipoItemDTO;
import factura.interfaces.FacturaDaoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmarulandc
 */
public class TipoItemDAO implements FacturaDaoInterface<TipoItemDTO> {
    
     private static final String SQL_CREATE = "INSERT INTO tipoitem (idTipoItem,Descripcion) VALUES (?,?)";
     private static final String SQL_READ = "SELECT * FROM tipoitem WHERE idTipoItem = ?";
     private static final String SQL_UPDATE = "UPDATE tipoitem SET Descripcion = ?  WHERE idTipoItem = ?";
     private static final String SQL_DELETE = "DELETE FROM tipoitem WHERE idTipoItem = ?";
     private static final String SQL_READALL = "SELECT * from tipoitem";
     
     private static final Conexion con = Conexion.estado(); // aplicamos singleton

    @Override
    public boolean create(TipoItemDTO c) {
        PreparedStatement ps;
         try {            
             ps = con.getCnn().prepareStatement(SQL_CREATE);
             ps.setInt(1, c.getId());
             ps.setString(2, c.getDescripcion());
             
             if(ps.executeUpdate() > 0){
                 return true;
             }
         } catch (SQLException ex) {
             Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally{
             con.cerrarConexion();
         }
         
         return false;
    }

    @Override
    public TipoItemDTO read(Object c) {
         PreparedStatement ps;
         ResultSet res;
         TipoItemDTO TipoItem = null;
         try {
             ps = con.getCnn().prepareStatement(SQL_READ);
             ps.setInt(1, (Integer)c);
             res = ps.executeQuery();
             
             while(res.next()){
                TipoItem =  new TipoItemDTO(res.getInt(1), res.getString(2));
             }

         } catch (SQLException ex) {
             Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             con.cerrarConexion();
         }
         
         return TipoItem;
    }

    @Override
    public boolean update(TipoItemDTO c) {
         PreparedStatement ps;
         try {
             ps = con.getCnn().prepareStatement(SQL_UPDATE);
             ps.setString(1, c.getDescripcion());
             ps.setInt(2, c.getId());
             
             if(ps.executeUpdate() > 0) {
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
    public boolean delete(Object c) {
        PreparedStatement ps;
         try {
             ps = con.getCnn().prepareStatement(SQL_DELETE);
             ps.setInt(1, (Integer)c);
             
             if(ps.executeUpdate() > 0) {
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
    public List<TipoItemDTO> readAll() {
         PreparedStatement ps;
         ResultSet res;
         ArrayList<TipoItemDTO> TiposItems = new ArrayList();
         
         try {
             ps = con.getCnn().prepareStatement(SQL_READALL);
             res = ps.executeQuery();
             
             while(res.next()){
                TiposItems.add(new TipoItemDTO(res.getInt(1), res.getString(2)));
             }

         } catch (SQLException ex) {
             Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             con.cerrarConexion();
         }
         
         return TiposItems;
    }

}
