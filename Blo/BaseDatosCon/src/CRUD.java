import javax.swing.*;
import java.sql.*;

public class CRUD {

    private conexion conexion = new conexion();
    private Connection con;
    private Statement st,st2;
    private ResultSet rs,rs1,rs2;

    public CRUD() {
        try{
            if((con = conexion.getConexionMYSQL())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
            st2 = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean login( String cont){
        boolean res;
        ResultSet rr;
        Statement stmt;
        try {

            stmt=con.createStatement();

            String  query =("SELECT * FROM acceso WHERE Contraseña= '"+cont+"'");
            rs = st.executeQuery(query);

            rr=stmt.executeQuery(query);

            while(rr.next())
            {
                return true;
            }
            rr.close();
            stmt.close();
           /*

            while(rs.next()){
                if(rs.equals(rs.getString("Contraseña"))){
                    return true;
                }
            }*/
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

