package DataAccess;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "erabalf";
    private static final String url = "jdbc:mysql://localhost:3306/db_2017";

    public ConectarDB() {     
        conn = null;
        try {
            Class.forName(driver);                                                 //verfica que la referencia este referenciada
            conn = (Connection) DriverManager.getConnection(url, user, password);  //patron de diseño FACTORY
            if(conn!=null)
              {
                System.out.println("Conexion establecida");
              }
            } 
            catch(ClassNotFoundException | SQLException e)
                {
                    System.out.println("Error al conectar" + e);
                }
    }
    
    //Este metodo retorna la conexion
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        if(conn!=null)
        {
          try 
            {
             conn.close();
            } 
            catch(Exception e)
                {
                    System.out.println("Error al desconectar, error " + e);
                }  
         }
    }
    
    
    
 
}