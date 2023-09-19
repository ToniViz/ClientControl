
package datos;

import dominio.Cliente;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class has the MySQL Statements to sava, add, update and delete users. 
 * @author Toni
 */
public class ClienteDaoJDBC {
    //Select all users
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente";
    //Select an user by his ID
    private static final String SQL_SELECT_BY_ID = " SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente WHERE id_cliente = ?";
    //Insert an user
    private static final String SQL_INSERT = " INSERT INTO cliente(nombre, apellido, email, telefono, saldo) VALUES (?, ?, ?, ?, ?)";
    //User's update
    private static final String SQL_UPDATE = " UPDATE cliente SET nombre =?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=? ";
    //User's delete
    private static final String SQL_DELETE = " DELETE FROM cliente WHERE id_cliente=?";
    
    /**
     * List all users of the application
     * @return: List of clients 
     */
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                clientes.add(new Cliente(idCliente, nombre, apellido, email, telefono, saldo));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            try {
                
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return clientes;
    }

        /**
         * Find a user if his exist
         * @param cliente
         * @return: client
         */
    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.next();
                
            

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return cliente;
    }
    
    /**
     * Search an user by his ID
     * @param identificador
     * @return 
     */
    public Cliente buscar(int identificador){

        Cliente cliente = null;

        List<Cliente> clientes = new ArrayList();

        clientes = this.listar();

        for(Cliente c : clientes){

            if(c.getIdCliente() == identificador){

                    cliente = c;

                    break;

                }

        }

        return cliente;

    }

    /**
     * Insert a new user into the database
     * @param cliente
     * @return: number of executed fields
     */
    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());

            rows = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return rows;
    }
    
    /**
     * Update the user of the context 
     * @param cliente
     * @return: number of executed fields
     */
    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());

            rows = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return rows;
    }
    
    /**
     * Deletes the user from the database
     * @param cliente
     * @return: number of executed fields
     */
    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());

            rows = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            try {
                
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return rows;
    }
}
