
package Logica;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.io.FileNotFoundException;
import java.io.File;

public class CreacionPDFTopCuentas {
    
    String[] topNombre = new String[3];    
    String[] topNumero = new String[3];
    int c=1;
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("TopClientesCuentas.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        Paragraph p = new Paragraph("Top Clientes con mayor numero de cuentas bancarias:\n");
        doc.add(p);
        
        for(int i=0;i<cClientes;i++){
            if(i==0){
                topNombre[0] = listaClientes[0].getNombre();
                topNumero[0] = String.valueOf(listaClientes[0].getNoCuentas());
                
            }else if(i==1){
                if(listaClientes[1].getNoCuentas()>listaClientes[0].getNoCuentas()){
                    topNombre[0] = listaClientes[1].getNombre();
                    topNumero[0] = String.valueOf(listaClientes[1].getNoCuentas());
                    
                    topNombre[1] = listaClientes[0].getNombre();
                    topNumero[1] = String.valueOf(listaClientes[0].getNoCuentas());
                }else{
                    topNombre[1] = listaClientes[1].getNombre();
                    topNumero[1] = String.valueOf(listaClientes[1].getNoCuentas());
                }
            }else if(i==2){
                if(listaClientes[2].getNoCuentas()>Integer.parseInt(topNumero[0])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = topNombre[0];
                    topNumero[1] = topNombre[0];
                    
                    topNombre[0] = listaClientes[2].getNombre();
                    topNumero[0] = String.valueOf(listaClientes[2].getNoCuentas());
                }else if(listaClientes[2].getNoCuentas()>Integer.parseInt(topNumero[1])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = listaClientes[2].getNombre();
                    topNumero[1] = String.valueOf(listaClientes[2].getNoCuentas());
                }else{
                    topNombre[2] = listaClientes[2].getNombre();
                    topNumero[2] = String.valueOf(listaClientes[2].getNoCuentas());
                }
            }else{
                if(listaClientes[i].getNoCuentas()>Integer.parseInt(topNumero[0])){
                    
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = topNombre[0];
                    topNumero[1] = topNumero[0];
                    
                    topNombre[0] = listaClientes[i].getNombre();
                    topNumero[0] = String.valueOf(listaClientes[i].getNoCuentas());
                }else if(listaClientes[i].getNoCuentas()>Integer.parseInt(topNumero[1])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = listaClientes[i].getNombre();
                    topNumero[1] = String.valueOf(listaClientes[i].getNoCuentas());
                }else if(listaClientes[i].getNoCuentas()>Integer.parseInt(topNumero[2])){
                    topNombre[2] = listaClientes[i].getNombre();
                    topNumero[2] = String.valueOf(listaClientes[i].getNoCuentas());
                }
            }
            
            
        }
        
        List lista = new List().setSymbolIndent(12).setListSymbol("-");
        for(int i=0;i<3;i++){
            lista.add(new ListItem(c + ". " + topNombre[i] + " con " + topNumero[i] + " cuentas bancarias"));
            c+=1;
        }
        
        doc.add(lista);
        doc.close();
    }
    
}
