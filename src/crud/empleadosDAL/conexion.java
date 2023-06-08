package crud.empleadosDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;


public class conexion {
    String strConexionDB = "jdbc:sqlite:src/crud/empleadosBD/Sistema.s3db";
    Connection conn = null;

    public conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConexionDB);
            System.out.println("Conexion establesida");
        } catch (Exception e) {
            System.out.println("Error De conexion"+e);
        }
    }
    
    public int ejecutarSetenciaSQL(String strSentenciaSQL){
        try {
             PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
             pstm.execute();
             return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String  strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet repuesta= pstm.executeQuery();
            return repuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
