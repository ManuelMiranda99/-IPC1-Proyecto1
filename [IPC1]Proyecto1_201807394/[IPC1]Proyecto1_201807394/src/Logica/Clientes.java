
package Logica;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cCuentas;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaCuentas;


public class Clientes {

    public void setDeuda(double deuda) {
        this.deuda += deuda;
    }
    
    public void setDeuda(double deuda, String tipo) {
        this.deuda -= deuda;
    }

    public void setNoCuentas() {
        this.noCuentas += 1;
    }
    
    //Datos de Cliente
    private int id, noCuentas, noTransacciones;
    private String nombre, direccion, telefono;
    private double efectivo, deuda;

    public int getId() {
        return id;
    }

    public int getNoCuentas() {
        return noCuentas;
    }

    public void setNoTransacciones() {
        this.noTransacciones += 1;
    }

    public int getNoTransacciones() {
        return noTransacciones;
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

    public double getEfectivo() {
        return efectivo;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setEfectivo(double efectivo, String tipo) {
        if(tipo.equals("DEP")){
            this.efectivo += efectivo;
        }else{
            this.efectivo -= efectivo;
        }
    }
    
    
    public Clientes(int id, int noCuentas, String nombre, 
            String direccion, String telefono){
        this.id = id;
        this.noCuentas = noCuentas;
        noTransacciones = 0;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.efectivo = 0;
        this.deuda = 0;
    }
    
    public void asignarEfectivoI(){
        for(int i=0;i<cCuentas;i++){
            if(listaCuentas[i].getIdCliente() == this.id){
                efectivo+=listaCuentas[i].getMonto();
            }
        }
    }
    
    public void eliminarC(){
        this.noCuentas = 0;
        noTransacciones = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.efectivo = 0;
        this.deuda = 0;
    }
}
