/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC-C202
 */
public class User {

    /**
     * @return the _Resultado
     */
    public int getResultado() {
        return _Resultado;
    }

    /**
     * @param _Resultado the _Resultado to set
     */
    public void setResultado(int _Resultado) {
        this._Resultado = _Resultado;
    }



    private String _User;
    private String _password;
    private String _Nombre;
    private String _Apellido;
    private String _DNI;
    private String _telefono;
    private String _email;
    private int _Resultado  ;
    
    
    
    
    /**
     * @param _email the _email to set
     */
    public void setEmail(String _email) {
        this._email = _email;
    }
    /**
     * @return the _user
     */
    public String getUser() {
        return _User;
    }

    /**
     * @param _user the _user to set
     */
    public void setUser(String _user) {
        this._User = _user;
    }

    /**
     * @return the _password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * @param _password the _password to set
     */
    public void setPassword(String _password) {
        this._password = _password;
    }
        /**
     * @param _DNI the _DNI to set
     */
    public void setDNI(String _DNI) {
        this._DNI = _DNI;
    }

    /**
     * @return the _Nombre
     */
    public String getNombre() {
        return _Nombre;
    }

    /**
     * @param _Nombre the _Nombre to set
     */
    public void setNombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    /**
     * @return the _Apellido
     */
    public String getApellido() {
        return _Apellido;
    }

    /**
     * @param _Apellido the _Apellido to set
     */
    public void setApellido(String _Apellido) {
        this._Apellido = _Apellido;
    }

    /**
     * @return the _DNI
     */
    public String getDNI() {
        return _DNI;
    }

    
    /**
     * @return the _telefono
     */
    public String getTelefono() {
        return _telefono;
    }

    /**
     * @param _telefono the _telefono to set
     */
    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    /**
     * @return the _email
     */
    public String getEmail() {
        return _email;
    }
}
