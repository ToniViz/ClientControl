/*
 * La clase se encarga de conectarse a una base de datos
 */
package datos;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * This class initializes and connect to MySQL Database
 * @author Toni
 */
public class Conexion {
    //URL connection
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //Database user
    private static final String JDBC_USER = "root";
    //Database password
    private static final String JDBC_PASSWORD = "admin";
    //BasicDataSource
    private static BasicDataSource dataSource;

    /**
     * Connect to the database with a username, password and MySQL driver. Start 20 connections. 
     * @return 
     */
    public static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            //Para tener cincuenta conexiones de manera inicial
            dataSource.setInitialSize(20);
        }
        return dataSource;
    }

    /**
     * Return the database connection
     * @return: Connection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    /**
     * Close Resultset
     * @param rs
     * @throws SQLException 
     */
    public static void close(ResultSet rs) throws SQLException {

        rs.close();

    }
    /**
     * Close PreparedStatement
     * @param stmt
     * @throws SQLException 
     */
    public static void close(PreparedStatement stmt) throws SQLException {

        stmt.close();

    }
    
    /**
     * Close the connection
     * @param conn
     * @throws SQLException 
     */
    public static void close(Connection conn) throws SQLException {

        conn.close();

    }
}
