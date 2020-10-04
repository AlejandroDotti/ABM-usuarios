package DataAccess;

import DTO.User;
import com.mysql.jdbc.CallableStatement;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



public class ConectionManager {


public int getExisteDniAlumnoDb(String tmpDNI) throws SQLException// throws SQLException 
    {
       ConectarDB  con = new ConectarDB();                          // instanciamos a la clase ConectarDB
       Statement stm = null;
       ResultSet rs = null;
    try {
        stm = con.getConnection().createStatement(); // pide una conexion
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    } 
    try {
        rs = stm.executeQuery("Select  DNI_Alumnos FROM alumnos where DNI_Alumnos = " +tmpDNI+";"); //realiza un Select
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }finally { con=null;}
    if (!rs.next())
       return 0; //No existe  
    else
       return 1; //Si existe  
}

public int getExisteUserAlumnoDb(String tmpUser) throws SQLException// throws SQLException 
    {
       ConectarDB  con = new ConectarDB();                          // instanciamos a la clase ConectarDB
       Statement stm = null;
       ResultSet rs = null;
    try {
        stm = con.getConnection().createStatement(); // pide una conexion
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        rs = stm.executeQuery("Select  User_Alumnos FROM alumnos where User_Alumnos = '"+tmpUser+"';"); //realiza un Select
        if (!rs.next())
          return 0; //No existe  
        else
          return 1; //Si existe  

    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }finally { con=null;}
return 1;
}

public int getExisteEmailAlumnoDb(String tmpEmail) throws SQLException// throws SQLException 
    {
       ConectarDB  con = new ConectarDB();                          // instanciamos a la clase ConectarDB
       Statement stm = null;
       ResultSet rs = null;
    try {
        stm = con.getConnection().createStatement(); // pide una conexion
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    } 
    try {
  //      rs = stm.executeQuery("Select  Email_Alumnos FROM alumnos where Email_Alumnos = " +tmpEmail+";"); //realiza un Select
        rs = stm.executeQuery("Select  Email_Alumnos FROM alumnos where Email_Alumnos = '"+tmpEmail+"';"); //realiza un Select
    if (!rs.next())
       return 0; //No existe  
    else
       return 1; //Si existe  

    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }finally{ 
      con=null;}
return 1; //Si existe  
}

public void GuardarAlumnoDb(User ouser)  {
    int tst = 0;
    ConectarDB con = new ConectarDB();
    try {
         Statement stm = con.getConnection().createStatement();
         String sql="INSERT INTO alumnos (Nombre_Alumnos,Apellido_Alumnos,DNI_Alumnos,Telefono_Alumnos,User_Alumnos,Password_Alumnos,Email_Alumnos) VALUE(?,?,?,?,?,?,?)";
         PreparedStatement sqlcmd= (PreparedStatement) con.getConnection().prepareStatement(sql);
         sqlcmd.setString(1,ouser.getNombre());
         sqlcmd.setString(2,ouser.getApellido());
         sqlcmd.setString(3,ouser.getDNI());
         sqlcmd.setString(4,ouser.getTelefono());
         sqlcmd.setString(5,ouser.getUser());
         sqlcmd.setString(6,ouser.getPassword());
         sqlcmd.setString(7,ouser.getEmail());
         tst=sqlcmd.executeUpdate();
        } 
    catch (SQLException ex) {
           Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{con=null;}
    
      if (tst>0)
           JOptionPane.showMessageDialog(null, "Registro guardado en DB)");
       else
           JOptionPane.showMessageDialog(null, "No fue posible guardar datos en DB");  
     }
    
    
    public int AltaAlumnoProcedureDB(User ouser) throws SQLException {
       ConectarDB conexionDB = new ConectarDB();
       User tmp_osuer=new User();
       tmp_osuer=null;
       Connection reg=conexionDB.getConnection();
       String procedimientoSql;
       int resultadoAlta=999;
       CallableStatement procedimientoDB = null;
       procedimientoSql=("call InsertarAlumnos(?,?,?,?,?,?,?,?)");
       try {
              procedimientoDB = (CallableStatement) reg.prepareCall(procedimientoSql);
              procedimientoDB.setString(1, ouser.getNombre());
              procedimientoDB.setString(2, ouser.getApellido());
              procedimientoDB.setString(3, ouser.getDNI());
              procedimientoDB.setString(4, ouser.getTelefono());
              procedimientoDB.setString(5, ouser.getUser());
              procedimientoDB.setString(6, ouser.getPassword());
              procedimientoDB.setString(7, ouser.getEmail());
              procedimientoDB.registerOutParameter(8, java.sql.Types.INTEGER);
              procedimientoDB.executeUpdate();
              resultadoAlta = procedimientoDB.getInt(8);
        } catch (SQLException e) 
          {
            System.out.println("Error"+e);
            resultadoAlta=999; 
          }
       conexionDB.desconectar();
       return resultadoAlta;
    }
       
     public User AltaAlumnoProcedureDb(User ouser) throws SQLException {
       ConectarDB conexionDB = new ConectarDB();
       User tmp_osuer=new User();
       tmp_osuer=null;
       Connection reg=conexionDB.getConnection();
       String procedimientoSql;
       int resultadoAlta=999;
       CallableStatement procedimientoDB = null;
       procedimientoSql=("call InsertarAlumnos(?,?,?,?,?,?,?,?)");
       try {
              procedimientoDB=(CallableStatement)reg.prepareCall(procedimientoSql);
              procedimientoDB.setString(1, ouser.getNombre());
              procedimientoDB.setString(2, ouser.getApellido());
              procedimientoDB.setString(3, ouser.getDNI());
              procedimientoDB.setString(4, ouser.getTelefono());
              procedimientoDB.setString(5, ouser.getUser());
              procedimientoDB.setString(6, ouser.getPassword());
              procedimientoDB.setString(7, ouser.getEmail());
              procedimientoDB.registerOutParameter(8, java.sql.Types.INTEGER);
              procedimientoDB.executeUpdate();
              resultadoAlta = procedimientoDB.getInt(8);
        } catch (SQLException e) 
          {
            System.out.println("Error"+e);
            resultadoAlta=999; 
          }
       conexionDB.desconectar();
       return tmp_osuer;
    }

public User consultaAlumnoDb(String Nomtmp, String Apetmp, String DNItmp, String Usertmp, String Emailtmp) throws SQLException
    {
       ConectarDB  con = new ConectarDB();                          // instanciamos a la clase ConectarDB
       Statement stm = null;
       ResultSet rs = null;
       User ouser=new User();
       String tmpUser=DNItmp;
    try {
        stm = con.getConnection().createStatement(); // pide una conexion
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        rs = stm.executeQuery("Select  * FROM alumnos where DNI_Alumnos = '"+tmpUser+"';"); //realiza un Select
        while (rs.next())
        {
          ouser.setNombre(rs.getString(2));
          ouser.setApellido(rs.getString(3));
          ouser.setDNI(rs.getString(4));
          ouser.setTelefono(rs.getString(5));
          ouser.setUser(rs.getString(6));
          ouser.setPassword("*********");
          ouser.setEmail(rs.getString(8));
          ouser.setResultado(1);    // Resultado OK
          return ouser; //No existe  
        }
        ouser.setResultado(0);
        return ouser; //Si existe  
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }finally { con=null;}
return ouser;
}

    
public String[][] consultaAlumnoDb_cmd_SQL(String Nomtmp, String Apetmp, String DNItmp, String Usertmp, String Emailtmp) throws SQLException
    {
       ConectarDB  con = new ConectarDB();                          // instanciamos a la clase ConectarDB
       Statement stm = null;
       ResultSet rs = null;
       User ouser=new User();
       String tmpUser=DNItmp;
       String [][]Tmp=new String [100][8];
       DefaultTableModel Tabla_datos_Select =new DefaultTableModel();
       int int_tmp=0;
       try {
            stm = con.getConnection().createStatement(); // pide una conexion
       } catch (SQLException ex) {
          Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
       }
        try {
             rs = stm.executeQuery("Select  * FROM alumnos where DNI_Alumnos = '"+tmpUser+"';"); //realiza un Select
        while (rs.next())
        {
          Tmp[int_tmp][0]=(rs.getString(2));
          Tmp[int_tmp][1]=(rs.getString(3));
          Tmp[int_tmp][2]=(rs.getString(4));
          Tmp[int_tmp][3]=(rs.getString(5));
          Tmp[int_tmp][4]=(rs.getString(6));
          Tmp[int_tmp][5]=(rs.getString(7));
          Tmp[int_tmp][6]=(rs.getString(8));
          Tmp[int_tmp][7]=Integer.toString(1);
          int_tmp++;
         }
        return Tmp; //Si existe  
    } catch (SQLException ex) {
        Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
    }finally { con=null;}
return Tmp;
} 


  public String[][] consultaAlumnoDb_Procedure(String Nomtmp, String Apetmp, String DNItmp, String Teltmp,String Usertmp, String Emailtmp){
       ConectarDB con = new ConectarDB();
       Connection reg=con.getConnection();
       String sql;
       CallableStatement consultaProcedureDb = null;
       sql=("call ListarAlumnos(?,?,?,?,?,?)");
       ResultSet rs = null;
       String [][]Tmp=new String [100][8];
       String Psw_tmp="*********";
       int int_tmp=0;
       try {
              consultaProcedureDb = (CallableStatement) reg.prepareCall(sql);
              consultaProcedureDb.setString(1, Nomtmp);
              consultaProcedureDb.setString(2, Apetmp);
              consultaProcedureDb.setString(3, DNItmp);
              consultaProcedureDb.setString(4, Teltmp);
              consultaProcedureDb.setString(5, Usertmp);
              consultaProcedureDb.setString(6, Emailtmp);
              consultaProcedureDb.executeUpdate();
     //         consultaProcedureDb.execute(sql);
              rs = consultaProcedureDb.getResultSet();
            while (rs.next())
            {
              Tmp[int_tmp][0]=(rs.getString(1));
              Tmp[int_tmp][1]=(rs.getString(2));
              Tmp[int_tmp][2]=(rs.getString(3));
              Tmp[int_tmp][3]=(rs.getString(4));
              Tmp[int_tmp][4]=(rs.getString(5));
              Tmp[int_tmp][5]=Psw_tmp;
              Tmp[int_tmp][6]=(rs.getString(7));
              Tmp[int_tmp][7]=Integer.toString(1);
              int_tmp++;
 //       Tabla_datos_Select.addRow(Tmp);
            }
             return Tmp; //Si existe  
            
        } catch (SQLException ex) {
            Logger.getLogger(ConectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tmp;
    }

     public int ActuliazarAlumnoProcedureDb(User ouser) throws SQLException {
       ConectarDB conexionDB = new ConectarDB();
      //User tmp_osuer=new User();
      // tmp_osuer=null;
       Connection reg=conexionDB.getConnection();
       String procedimientoSql;
       int resultadoActualizar=999;
       CallableStatement procedimientoDB = null;
       procedimientoSql=("call ActualizarAlumnos(?,?,?,?,?,?,?,?)");
       try {
              procedimientoDB=(CallableStatement)reg.prepareCall(procedimientoSql);
              procedimientoDB.setString(1, ouser.getNombre());
              procedimientoDB.setString(2, ouser.getApellido());
              procedimientoDB.setString(3, ouser.getDNI());
              procedimientoDB.setString(4, ouser.getTelefono());
              procedimientoDB.setString(5, ouser.getUser());
              procedimientoDB.setString(6, ouser.getPassword());
              procedimientoDB.setString(7, ouser.getEmail());
              procedimientoDB.registerOutParameter(8, java.sql.Types.INTEGER);
              procedimientoDB.executeUpdate();
              resultadoActualizar = procedimientoDB.getInt(8);
        } catch (SQLException e) 
          {
            System.out.println("Error"+e);
            resultadoActualizar=999; 
          }
       conexionDB.desconectar();
       return resultadoActualizar;
    }

     
      public int BorraAlumnoProcedureDb(String DNI) throws SQLException {
       ConectarDB conexionDB = new ConectarDB();
      //User tmp_osuer=new User();
      // tmp_osuer=null;
       Connection reg=conexionDB.getConnection();
       String procedimientoSql;
       int resultadoBorrar=999;
       CallableStatement procedimientoDB = null;
       procedimientoSql=("call BorrarAlumnos(?,?)");
       try {
              procedimientoDB=(CallableStatement)reg.prepareCall(procedimientoSql);
              procedimientoDB.setString(1, DNI);
              procedimientoDB.registerOutParameter(2, java.sql.Types.INTEGER);
              procedimientoDB.executeUpdate();
              resultadoBorrar = procedimientoDB.getInt(2);
        } catch (SQLException e) 
          {
            System.out.println("Error"+e);
            resultadoBorrar=999; 
          }
       conexionDB.desconectar();
       return resultadoBorrar;
    }


}
