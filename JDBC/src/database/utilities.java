/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import java.sql.*;
import javax.management.Query;

/**
 *
 * @author 'Toine
 */
public class utilities {
    
    public static int ORACLE = 1;
    public static int SQL = 2;
    
    private int typeConnection;
    private String nameConnection;
    private String login;
    private String motdepasse;
    private Connection con;
    private Statement instruc;


    public utilities(int ptype, String plogin, String pmotdepasse) throws ClassNotFoundException, Exception {
        String tmpCon;
        this.typeConnection = ptype;
        if(ptype == SQL)
        {
            nameConnection = "org.gjt.mm.mysql.Driver";
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
        tmpCon = "jdbc:" + (ptype == SQL ? "mysql://localhost:5500/": "oracle:thin@localhost:1521:")+"BD_AIRPORT"; 
        con = DriverManager.getConnection(tmpCon, login, motdepasse);
        instruc =  con.createStatement();
    }
    
    public ResultSet query(String pquery) throws SQLException
    {
        return instruc.executeQuery(pquery);
    }
    
    public int update(String pupdate) throws SQLException
    {
        return instruc.executeUpdate(pupdate);
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
