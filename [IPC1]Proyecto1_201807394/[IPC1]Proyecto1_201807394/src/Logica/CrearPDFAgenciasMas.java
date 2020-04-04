
package Logica;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.io.File;
import java.io.FileNotFoundException;


public class CrearPDFAgenciasMas {
    
    String[] topNombre = new String[3];    
    String[] topNumero = new String[3];
    int c=1;
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("TopAgenciasUsadas.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        Paragraph p = new Paragraph("Top Agencias mas utilizadas:\n");
        doc.add(p);
        
        for(int i=0;i<cAgencia;i++){
            if(i==0){
                topNombre[0] = listaAgencias[0].getNombre();
                topNumero[0] = String.valueOf(listaAgencias[0].getNoUsos());
                
            }else if(i==1){
                if(listaAgencias[1].getNoUsos()>listaAgencias[0].getNoUsos()){
                    topNombre[0] = listaAgencias[1].getNombre();
                    topNumero[0] = String.valueOf(listaAgencias[1].getNoUsos());
                    
                    topNombre[1] = listaAgencias[0].getNombre();
                    topNumero[1] = String.valueOf(listaAgencias[0].getNoUsos());
                }else{
                    topNombre[1] = listaAgencias[1].getNombre();
                    topNumero[1] = String.valueOf(listaAgencias[1].getNoUsos());
                }
            }else if(i==2){
                if(listaAgencias[2].getNoUsos()>Integer.parseInt(topNumero[0])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = topNombre[0];
                    topNumero[1] = topNombre[0];
                    
                    topNombre[0] = listaAgencias[2].getNombre();
                    topNumero[0] = String.valueOf(listaAgencias[2].getNoUsos());
                }else if(listaAgencias[2].getNoUsos()>Integer.parseInt(topNumero[1])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = listaAgencias[2].getNombre();
                    topNumero[1] = String.valueOf(listaAgencias[2].getNoUsos());
                }else{
                    topNombre[2] = listaAgencias[2].getNombre();
                    topNumero[2] = String.valueOf(listaAgencias[2].getNoUsos());
                }
            }else{
                if(listaAgencias[i].getNoUsos()>Integer.parseInt(topNumero[0])){
                    
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = topNombre[0];
                    topNumero[1] = topNumero[0];
                    
                    topNombre[0] = listaAgencias[i].getNombre();
                    topNumero[0] = String.valueOf(listaAgencias[i].getNoUsos());
                }else if(listaAgencias[i].getNoUsos()>Integer.parseInt(topNumero[1])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = listaAgencias[i].getNombre();
                    topNumero[1] = String.valueOf(listaAgencias[i].getNoUsos());
                }else if(listaAgencias[i].getNoUsos()>Integer.parseInt(topNumero[2])){
                    topNombre[2] = listaAgencias[i].getNombre();
                    topNumero[2] = String.valueOf(listaAgencias[i].getNoUsos());
                }
            }
            
            
        }
        
        for(int i=0;i<cAgenciaA;i++){
            if(listaAgenciasA[i].getNoUsos()>Integer.parseInt(topNumero[0])){
                    
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = topNombre[0];
                    topNumero[1] = topNumero[0];
                    
                    topNombre[0] = listaAgenciasA[i].getNombre();
                    topNumero[0] = String.valueOf(listaAgenciasA[i].getNoUsos());
                }else if(listaAgenciasA[i].getNoUsos()>Integer.parseInt(topNumero[1])){
                    topNombre[2] = topNombre[1];
                    topNumero[2] = topNumero[1];
                    
                    topNombre[1] = listaAgenciasA[i].getNombre();
                    topNumero[1] = String.valueOf(listaAgenciasA[i].getNoUsos());
                }else if(listaAgenciasA[i].getNoUsos()>Integer.parseInt(topNumero[2])){
                    topNombre[2] = listaAgenciasA[i].getNombre();
                    topNumero[2] = String.valueOf(listaAgenciasA[i].getNoUsos());
                }
        }
        
        List lista = new List().setSymbolIndent(12).setListSymbol("-");
        for(int i=0;i<3;i++){
            lista.add(new ListItem(c + ". " + topNombre[i] + " con " + topNumero[i] + " usos"));
            c+=1;
        }
        
        doc.add(lista);
        doc.close();
    }
    
}
