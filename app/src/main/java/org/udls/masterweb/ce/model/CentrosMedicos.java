package org.udls.masterweb.ce.model;



public  class CentrosMedicos {
    private int IdCentromedico;
    private String Tipo;
    private String Estado;
    private String NombreCentroMedico;
    private String Direccion;
    private double Longitud;
    private double Latitud;
    private String Fotografia;
    private String Telefono;
    private String Horario;
    private String Correo;

    public  CentrosMedicos( int IdCentromedico, String Tipo, String Estado, String NombreCentroMedico, String Direccion, double Longitud, double Latitud, String Fotografia, String Telefono, String Horario, String Correo){
        this.IdCentromedico = IdCentromedico;
        this.Tipo = Tipo;
        this.Estado = Estado;
        this.NombreCentroMedico = NombreCentroMedico;
        this.Direccion = Direccion;
        this.Longitud = Longitud;
        this.Latitud = Latitud;
        this.Fotografia = Fotografia;
        this.Telefono = Telefono;
        this.Horario = Horario;
        this.Correo = Correo;
    }
    public CentrosMedicos(){

    }
    public int getIdCentromedico() {
        return IdCentromedico;
    }

    public void setIdCentromedico(int idCentromedico) {
        IdCentromedico = idCentromedico;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getNombreCentroMedico() {
        return NombreCentroMedico;
    }

    public void setNombreCentroMedico(String nombreCentroMedico) {
        NombreCentroMedico = nombreCentroMedico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public String getFotografia() {
        return Fotografia;
    }

    public void setFotografia(String fotografia) {
        Fotografia = fotografia;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}