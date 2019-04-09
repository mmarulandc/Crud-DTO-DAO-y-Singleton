/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura.DAO;

import factura.ConexionSingleton.Conexion;
import factura.DTO.ClienteDTO;
import java.sql.Date;
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
public class ClienteDAO implements factura.interfaces.FacturaDaoInterface<ClienteDTO>{
    
    private static final String SQL_CREATE = "INSERT INTO cliente (idCliente,Nombre,Apellidos,Genero,FechaNacimiento,EstadoCivil) VALUES (?,?,?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM cliente WHERE idCliente = ?";
    private static final String SQL_UPDATE = "UPDATE cliente SET Nombre = ?, Apellidos = ?, Genero = ?, FechaNacimiento = ?, EstadoCivil= ?   WHERE idCliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idCliente = ?";
    private static final String SQL_READALL = "SELECT * from cliente";

    private static final Conexion con = Conexion.estado(); // aplicamos singleton

    @Override
    public boolean create(ClienteDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_CREATE);
            ps.setString(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.setString(4, c.getGenero());
            ps.setDate(5,  c.getFechaN());
            ps.setString(6, c.getEstadoC());
            
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
    public ClienteDTO read(Object c) {
        PreparedStatement ps;
        ResultSet res;
        ClienteDTO cliente = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1,  c.toString());
            res = ps.executeQuery();

            while (res.next()) {
                cliente = new ClienteDTO(res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return cliente;
    }

    @Override
    public boolean update(ClienteDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.setString(4, c.getGenero());
            ps.setDate(5, c.getFechaN());
            ps.setString(6, c.getEstadoC());

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
            ps.setString(1, c.toString());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return false;    }

    @Override
    public List<ClienteDTO> readAll() {
        
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<ClienteDTO> Clientes = new ArrayList();

        try {
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                Clientes.add(new ClienteDTO(res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getDate(5),res.getString(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return Clientes;
    }

    
}
