package com.misiontic.reto5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <span>Descripción:</span>
 * <p>
 * Se encarga de generar la conexión y desconexión a la base de datos usando el
 * JDBC.</p> 
 * 
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Roller Stivenson Sosa Llanes Email: stivenson.sosa@gmail.com
 * @version 1.0.0
 * @since 2021
 */
public class Conexion {

    private static final String DBNAME = "reto4";
    private static final String USER = "root";
    private static final String PASSWORD = "dflr.com";
    private static final String URL = "jdbc:mysql://localhost/" + DBNAME + "?useUnicode=true&use"
            + "JDBCCompliantTimezoneSHift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";

    private static Connection connection;
    
    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la conexión a la base de datos y la retorna.</p>
     *
     * @return connection - Retorna un objeto de tipo {@code Connection} el
     * estado de la conexión.
     */
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión exitosa a : " + DBNAME);
                
            }
        } catch (ClassNotFoundException e) {
            System.out.println("¡Ocurre una ClassNotFoundException : " + e.getMessage() + "!");
        } catch (SQLException e) {
            System.out.println("¡Ocurre una SQLException: " + e.getMessage() + "!");
        }
        return connection;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la conexión.</p>
     *
     * @return connection - Retorna un objeto de tipo {@code Conexion}
     * connection el estado de la conexión.
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desconecta la base de datos.</p>
     *
     * @throws java.sql.SQLException - Retorna una SQLException.
     */
    public void disconnect() throws SQLException {
        try {
            connection.close();
            System.out.println("Conexión terminada");
        } catch (SQLException error) {
            System.out.println(error);
        } finally {
            connection.close();
        }
    }

}
