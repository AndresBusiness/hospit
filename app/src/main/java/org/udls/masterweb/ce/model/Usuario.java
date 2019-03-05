package org.udls.masterweb.ce.model;

/**
 * Created by Andres on 12/1/2017.
 */

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String password;
    private String foto;

    public Usuario(){

    }
    public Usuario(int idUsuario,  String nombre,  String correo,  String telefono,  String password,  String foto){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.foto = foto;
        this.password = password;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
