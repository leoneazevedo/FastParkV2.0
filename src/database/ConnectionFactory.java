/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leoneeng
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost/farmacia";
    private static final String USER = "root";
    private static final String PASS = "";
    
//---------------------------------------------------------------------------------------------------------------------------------------------
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao conectar", ex);
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
//---------------------------------------------------------------------------------------------------------------------------------------------
    public static void closeConnection(Connection con, PreparedStatement stmt) { //inserir, updade, delete        
        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) { //exibição, busca
        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
