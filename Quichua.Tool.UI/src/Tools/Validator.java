/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author erabalf
 */
public class Validator {
    
    
    
     //protected static boolean SoloLetras(String AuxString, char auxChar){
     public  boolean SoloLetras(String AuxString, char auxChar){
     boolean resultado=false;
     if (auxChar=='A')
     {    
        for ( int tmp_int = 0; tmp_int<= (AuxString.length()-1); tmp_int++) 
            if( ( AuxString.charAt(tmp_int)>='A')&&( AuxString.charAt(tmp_int)<='Z')||
               ( AuxString.charAt(tmp_int)>='a')&&( AuxString.charAt(tmp_int)<='z'))
               resultado=true;
            else
            {
               resultado=false;
               return resultado;
            }
      return resultado;
     }
     else
     {
       if (auxChar=='E')
       {    
           for ( int tmp_int = 0; tmp_int<= (AuxString.length()-1); tmp_int++) 
             if(( AuxString.charAt(tmp_int)>='A')&&( AuxString.charAt(tmp_int)<='Z')||
               (( AuxString.charAt(tmp_int)>='a')&&( AuxString.charAt(tmp_int)<='z'))||
               (( AuxString.charAt(tmp_int)>='0')&&( AuxString.charAt(tmp_int)<='9'))||
                 (AuxString.charAt(tmp_int)=='.')||( AuxString.charAt(tmp_int)=='@')||
                (AuxString.charAt(tmp_int)=='_')||( AuxString.charAt(tmp_int)=='-'))
               resultado=true;
             else
             {
               resultado=false;
               return resultado;
             }
            int tmp=0;
            for ( int tmp_int = 0; tmp_int<= (AuxString.length()-1); tmp_int++) 
              if (( AuxString.charAt(tmp_int)=='@'))
                tmp=tmp+1;
            if (tmp==1)
              resultado=true;
            else
              resultado=false;
            return resultado;
        }
        else
          if (auxChar=='U')
          {    
            for ( int tmp_int = 0; tmp_int<= (AuxString.length()-1); tmp_int++) 
              if (((AuxString.charAt(tmp_int)>='A')&&(AuxString.charAt(tmp_int)<='Z'))||
                 ((AuxString.charAt(tmp_int)>='a')&&(AuxString.charAt(tmp_int)<='z'))||
                  (AuxString.charAt(tmp_int)=='.')||(AuxString.charAt(tmp_int)=='-')||
                  (AuxString.charAt(tmp_int)=='_')||( AuxString.charAt(tmp_int)=='-')||
                  ((AuxString.charAt(tmp_int)>='0')&&( AuxString.charAt(tmp_int)<='9'))||
                   (AuxString.charAt(tmp_int)=='#')||( AuxString.charAt(tmp_int)=='*'))
                      resultado=true;
              else
              {
                resultado=false;
                return resultado;
              }
          }  
     }
     return resultado;
}    
    //protected static boolean SoloNumeros(String AuxString, char auxChar){
    public boolean SoloNumeros(String AuxString, char auxChar){
    boolean resultado=true;
    if (auxChar=='D') // verificar informacion para DNI...solo Numeros
    {
        for ( int tmp_int = 0; tmp_int<= (AuxString.length()-1); tmp_int++) 
        {  
           if(((AuxString.charAt(tmp_int)<'0')||( AuxString.charAt(tmp_int)>'9'))&&
               (AuxString.charAt(tmp_int)!='.'))    
              {
               return resultado=false;
              }
         }
        int tmp_int2=0;
        for ( int tmp_int = 0; tmp_int<= (AuxString.length()-1); tmp_int++) 
         {    
           if (AuxString.charAt(tmp_int)=='.')   
              {
               tmp_int2++;
              }
         }
        if (tmp_int2!=0)
           if ((AuxString.charAt(3)=='.')&&(AuxString.charAt(7)=='.'))
              resultado=true;
           else
              resultado=false;               
   }
   else
    {    
      if (auxChar=='T') // verificar informacion para DNI...solo Numeros
      {
        for ( int tmp_int2 = 0; tmp_int2<= (AuxString.length()-1); tmp_int2++) 
        {
            if (( AuxString.charAt(tmp_int2) <'0')||( AuxString.charAt(tmp_int2)>'9'))
                 if ( AuxString.charAt(tmp_int2)!='.')
                    if ( AuxString.charAt(tmp_int2)!='+') 
                      if ( AuxString.charAt(tmp_int2)!='-') 
                         if ( AuxString.charAt(tmp_int2)!='(') 
                            if (AuxString.charAt(tmp_int2)!=')') 
                                return (false);
        }    
        return resultado;
      }
    }
    return resultado;
}   
    
    
}
