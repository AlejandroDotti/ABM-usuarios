package Busisness;

import DTO.User;
import DataAccess.ConectionManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Manager {
   
    public int guardarAlumno (User ouser) throws SQLException{
        int user_consulta_resultado =0;
        int dni_consulta_resultado  =0;   // 0 no existe 1 existe
        int email_consulta_resultado=0;
        int resultadoAlta=0;
        ConectionManager ConnectionGuardarDB = new ConectionManager();
        User user_tmp= new User();
//        Object planilla_consulta_Db =new Object();
        resultadoAlta=ConnectionGuardarDB.AltaAlumnoProcedureDB(ouser);
        return resultadoAlta;  // 0 no fue posible ingresar datos en DB, Ya existe el DNI
    }

   public String[][] consultaAlumno (User ouser) throws SQLException{
        int user_consulta_resultado =0;
        int dni_consulta_resultado  =0;   // 0 no existe 1 existe
        int email_consulta_resultado=0;
        String [][]Tmp_Manager_data_DB=new String [100][8];
        DefaultTableModel Tabla_Datos_DB=new DefaultTableModel();
        ConectionManager ConnectionConsultarDB = new ConectionManager();
        User user_tmp= new User();
 //       Object planilla_consulta_Db =new Object();
        Tmp_Manager_data_DB=ConnectionConsultarDB.consultaAlumnoDb_cmd_SQL(ouser.getNombre(),ouser.getApellido(),ouser.getDNI(),ouser.getUser(),ouser.getEmail());
        return Tmp_Manager_data_DB;  // 0 no fue posible ingresar datos en DB, Ya existe el DNI
    }


    public String[][] consultaAlumnoDb_Procedure (User ouser) throws SQLException{
        int user_consulta_resultado =0;
        int dni_consulta_resultado  =0;   // 0 no existe 1 existe
        int email_consulta_resultado=0;
        String [][]Tmp_Manager_data_DB=new String [100][8];
        DefaultTableModel Tabla_Datos_DB=new DefaultTableModel();
        ConectionManager ConnectionConsultarDB = new ConectionManager();
        User user_tmp= new User();
 //       Object planilla_consulta_Db =new Object();
        Tmp_Manager_data_DB=ConnectionConsultarDB.consultaAlumnoDb_Procedure(ouser.getNombre(),ouser.getApellido(),ouser.getDNI(),ouser.getTelefono(),ouser.getUser(),ouser.getEmail());
        return Tmp_Manager_data_DB;  // 0 no fue posible ingresar datos en DB, Ya existe el DNI
    }   
    
     public int ActualizarAlumnoDb_Procedure (User ouser) throws SQLException{
        ConectionManager ActualizarDBprocedure = new ConectionManager();
        int resultado=0;
        resultado=ActualizarDBprocedure.ActuliazarAlumnoProcedureDb(ouser);
     
     return resultado;
     }  
     
     public int BorrarAlumnoDb_Procedure (String DNI) throws SQLException{
        ConectionManager BorrarDBprocedure = new ConectionManager();
        int resultado=0;
        resultado=BorrarDBprocedure.BorraAlumnoProcedureDb(DNI);
        return resultado;
     }  
        
}
