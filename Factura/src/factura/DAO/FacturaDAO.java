/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.DAO;

import factura.ConexionSingleton.Conexion;
import factura.DTO.FacturaDTO;
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
public class FacturaDAO implements factura.interfaces.FacturaDaoInterface<FacturaDTO> {
    private static final String SQL_CREATE = "INSERT INTO factura (NroFactura,FechaFactura,idCliente,TotalFactura,Estado) VALUES (?,?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM factura WHERE NroFactura = ?";
    private static final String SQL_UPDATE = "UPDATE factura SET FechaFactura = ? ,idCliente = ?, TotalFactura = ?, Estado = ?   WHERE NroFactura = ?";
    private static final String SQL_DELETE = "DELETE FROM factura WHERE NroFactura = ?";
    private static final String SQL_READALL = "SELECT * from factura";

    private static final Conexion con = Conexion.estado(); // aplicamos singleton
    
    @Override
    public boolean create(FacturaDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_CREATE);
            ps.setInt(1, c.getNroFactura());
            ps.setDate(2, c.getFechaFactura());
            ps.setString(3, c.getIdCliente());
            ps.setFloat(4, c.getTotalFactura());
            ps.setString(5, c.getEstado());

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
    public FacturaDTO read(Object c) {
        PreparedStatement ps;
        ResultSet res;
        FacturaDTO Factura = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, c.toString());

            res = ps.executeQuery();

            while (res.next()) {
                Factura = new FacturaDTO(res.getInt(1), res.getDate(2), res.getLong(4), res.getString(5), res.getString(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return Factura;
    }

    @Override
    public boolean update(FacturaDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(5, c.getNroFactura());
            ps.setDate(1, c.getFechaFactura());
            ps.setString(2, c.getIdCliente());
            ps.setLong(3, c.getTotalFactura());
            ps.setString(4, c.getEstado());
            

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
    public boolean delete(Object c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, (Integer)c);

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
    public List<FacturaDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<FacturaDTO> Facturas = new ArrayList();

        try {
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                Facturas.add(new FacturaDTO(res.getInt(1), res.getDate(2), res.getLong(4), res.getString(5), res.getString(3)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return Facturas;
    }
    
}
