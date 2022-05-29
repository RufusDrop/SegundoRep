        package classes;

import java.io.Serializable;


public class ClienteEmpresa extends Cliente implements Serializable{
    private String CIF;
    private String web;

    public ClienteEmpresa(String nombre, String correo, String clave, Direccion direccion, Tarjeta tarjeta, int telefono,String CIF,String web) {
        super(nombre, correo, clave, direccion, tarjeta, telefono);
        this.CIF = CIF;
        this.web = web;
    }

    @Override
    public String toString() {
        return super.toString()+"ClienteEmpresa{" + "CIF=" + CIF + ", web=" + web + '}';
    }
    

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    
    
}
