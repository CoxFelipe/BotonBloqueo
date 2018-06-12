import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    private String usuario = "root";
    private String pass = "123";
    private String nombre_BD = "contraseña";

    private String URL = "jdbc:mysql://localhost/" + nombre_BD
                            + "?useUnicode=true"
                           + "&useJDBCCompliantTimezoneShift=true"
                            + "&useLegacyDatetimeCode=false"
                            + "&serverTimezone=UTC";
    private Connection con = null;

    public conexion() {
    }
    //Metodo que se devuelve la conexion o null si hubo un error
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance( );
            con = DriverManager.getConnection(this.URL,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
}
