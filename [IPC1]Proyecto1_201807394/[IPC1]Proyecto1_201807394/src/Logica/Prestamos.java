
package Logica;




public class Prestamos {
    
    /*
        estado toma los valores de PENDIENTE AUTORIZADO RECHAZADO
    */
    
    //Datos Prestamos
    int id, idCliente;
    String estado;
    double monto, montoPagado;
    String fechaPedido;
    
    public Prestamos(int id, int idCliente, String estado, double monto, String fechaPedido){
        this.id = id;
        this.idCliente = idCliente;
        this.estado = estado;
        this.monto = monto;
        montoPagado = 0;
        this.fechaPedido = fechaPedido;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.monto -= montoPagado;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    
    
}
