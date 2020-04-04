
package Logica;


public class Empleados {
    
    //Datos Empleados
    String nombre, lugarDeTrabajo;
    
    
    public Empleados(String nombre, String lugarDeTrabajo){
        this.nombre = nombre;
        this.lugarDeTrabajo = lugarDeTrabajo;
    }
    
    public void eliminarE(){
        this.nombre = "";
        this.lugarDeTrabajo = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarDeTrabajo() {
        return lugarDeTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarDeTrabajo = lugarDeTrabajo;
    }
}
