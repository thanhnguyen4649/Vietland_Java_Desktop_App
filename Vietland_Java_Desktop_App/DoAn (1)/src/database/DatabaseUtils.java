/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author xuanthanhnguyen
 */

public class DatabaseUtils {

    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=DB_ASS_Java3;user=sa;password=Password.1";

public static Connection getDBConnect() {
try {
    Connection con = null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);
        return con;
} catch (ClassNotFoundException ex) {
                    System.out.println("Where is Driver?") ;
                    System.out.println("Error: " + ex.toString());
} catch (SQLException ex) {
                        //201 ket noi
                        System.out.println("Error: " + ex.toString());
        }
return null;
                    }
                }
    
