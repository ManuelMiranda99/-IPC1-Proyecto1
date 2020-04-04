
package Logica;


public class CallCenter {
    
    //Datos CallCenter
    public static int noServicios=0, noTarjeta=0, noPrestamo=0, noTransferencias=0;
    
    
    public static void usoServicios(){
        noServicios+=1;
    }
    
    public static void usoTarjeta(){
        noTarjeta+=1;
    }
    
    public static void usoPrestamo(){
        noPrestamo+=1;
    }
    
    public static void usoTransferencia(){
        noTransferencias+=1;
    }
}
