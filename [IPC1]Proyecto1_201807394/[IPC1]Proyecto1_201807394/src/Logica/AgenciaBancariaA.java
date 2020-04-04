
package Logica;


public class AgenciaBancariaA {
    
    //Datos de Agencia Bancaria sin AutoBanco
    int id, noCajas, noEscritoriosServicioCliente, noCajasAutobanco,noUsos, noEmpleados;
    String nombre, direccion, telefono;
    double efectivo;

    public int getId() {
        return id;
    }

    public int getNoCajas() {
        return noCajas;
    }

    public void setNoCajas(int noCajas) {
        this.noCajas = noCajas;
    }

    public int getNoEscritoriosServicioCliente() {
        return noEscritoriosServicioCliente;
    }

    public void setNoEscritoriosServicioCliente(int noEscritoriosServicioCliente) {
        this.noEscritoriosServicioCliente = noEscritoriosServicioCliente;
    }
    
    public int getNoCajasAutobanco() {
        return noCajasAutobanco;
    }

    public void setNoCajasAutobanco(int noCajasAutobanco) {
        this.noCajasAutobanco = noCajasAutobanco;
    }

    public int getNoUsos() {
        return noUsos;
    }

    public int getNoEmpleados() {
        return noEmpleados;
    }

    public void setNoEmpleados(int noEmpleados) {
        this.noEmpleados = noEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setEfectivo(double efectivo, String tipo) {
        if(tipo.equals("DEP")){
            this.efectivo += efectivo;
        }else{
            this.efectivo -= efectivo;
        }
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setNoUsos() {
        this.noUsos += 1;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
    
    
    public AgenciaBancariaA(int id, int noCajas, int noEscritoriosServicioCliente, 
            int noCajasAutobanco, int noEmpleados, String nombre, String direccion, 
            String telefono, double efectivo){
        this.id = id;
        this.noCajas = noCajas;
        this.noEscritoriosServicioCliente = noEscritoriosServicioCliente;
        this.noCajasAutobanco = noCajasAutobanco;
        this.noEmpleados = noEmpleados;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.efectivo = efectivo;
        noUsos = 0;
    }
    
    public void eliminarAA(){
        this.noCajas = 0;
        this.noEscritoriosServicioCliente = 0;
        this.noCajasAutobanco = 0;
        this.noEmpleados = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.efectivo = 0;
        noUsos = 0;
    }
    
}
