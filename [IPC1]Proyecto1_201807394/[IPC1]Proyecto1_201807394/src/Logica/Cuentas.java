
package Logica;



public class Cuentas {
    /*
        Tipo toma los valores AHORRO y MONETARIA
    */
    
    
    //Datos Cuentas
    int id, idCliente;
    String tipo;
    double monto;
    String fechaApertura;
    
    public Cuentas(int id, int idCliente, String tipo, double monto, String fechaApertura){
        this.id = id;
        this.idCliente = idCliente;
        this.tipo = tipo;
        this.monto = monto;
        this.fechaApertura = fechaApertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto, String tipo) {
        if(tipo.equals("DEP")){
            this.monto += monto;
        }else{
            this.monto -= monto;
        }
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}
