/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author 'Toine
 */
public class utilities {
    
    static int ORACLE = 1;
    static int SQL = 1;
    
    private int typeConnection;
    private String nameConnection;
    private String login;
    private String motdepasse;
    private Connection con;
    private Statement instruc;


    public utilities(int ptype, String plogin, String pmotdepasse) throws ClassNotFoundException, Exception {
        this.typeConnection = ptype;
        if(ptype == SQL)
        {
            nameConnection = "sun.jdbc.odbc.JdbcOdbcDriver";
        }
        else if(ptype == ORACLE)
        {
            nameConnection = "oracle.jdbc.driver.OracleDriver";
        }
        else
        {
            throw new Exception("Erreur utilities");
        }
        Class.forName(nameConnection);
        login = plogin;
        motdepasse = pmotdepasse;
        DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_Food", login, motdepasse);
        instruc =  con.createStatement();
    }
    
//<editor-fold defaultstate="collapsed" desc="Getter">
    public String getNameConnection() {
        return nameConnection;
    }
    
    public int getTypeConnection() {
        return typeConnection;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getMotdepasse() {
        return motdepasse;
    }
    
    public Connection getCon() {
        return con;
    }
//</editor-fold>
}
