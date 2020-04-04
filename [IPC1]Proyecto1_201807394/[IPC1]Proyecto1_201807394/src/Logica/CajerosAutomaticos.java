
package Logica;


public class CajerosAutomaticos {
    
    /*
        Estado solo puede tomar valores: ACTIVO y NO_ACTIVO
    */
    
    //Datos Cajeros Automaticos
    int id, noTransacciones;
    String ubicacion, estado;
    double efectivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoTransacciones() {
        return noTransacciones;
    }

    public void setNoTransacciones() {
        this.noTransacciones += 1;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo, String tipo) {
        this.efectivo -= efectivo;
        if(this.efectivo==0){
            this.estado = "NO_ACTIVO";
        }
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
        if(this.efectivo==0){
            this.estado = "NO_ACTIVO";
        }
    }
    
    
    public CajerosAutomaticos(int id, String ubicacion, String estado, double efectivo){
        this.id = id;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.efectivo = efectivo;
        noTransacciones = 0;
    }
    
    public void eliminarC(){
        this.ubicacion = "";
        this.estado = "";
        this.efectivo = 0;
        noTransacciones = 0;
    }
    
}
