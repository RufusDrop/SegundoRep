package classes;

import java.io.Serializable;


public abstract class Cliente implements Serializable{
    private String nombre;
    private String correo;
    private String clave;
    private Direccion direccion;
    private Tarjeta tarjeta;
    private int telefono;

    public Cliente(String nombre, String correo, String clave, Direccion direccion, Tarjeta tarjeta, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + ", direccion=" + direccion + ", tarjeta=" + tarjeta + ", telefono=" + telefono + '}';
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
