
package Logica;



public class Tarjeta {
    
    int id, idCliente;
    String estado;
    double limiteCredito, deuda, disponible;
    String fechaVencimiento;
    
    public Tarjeta(int id, int idCliente, String estado, double limiteCredito, String fechaVencimiento){
        this.id = id;
        this.idCliente = idCliente;
        this.estado = estado;
        this.limiteCredito = limiteCredito;
        this.deuda = 0;
        this.fechaVencimiento = fechaVencimiento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda, String tipo) {
        if(tipo.equals("RET")){
            this.deuda -=deuda;
        }else{
            this.deuda +=deuda;
        }        
    }

    public double getDisponible() {
        disponible = limiteCredito - deuda;
        return disponible;
    }

    public void setDisponible(double disponible) {
        this.disponible = disponible;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
