
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

public class CrearPDFCallCenter {
    
    String t1, t2;
    int c=1;

    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("TopOPCall.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        Paragraph p = new Paragraph("Top 2 Operaciones mas realizadas en Call-Center:\n");
        doc.add(p);
        
        int[] s = new int[4];
        s[0] = CallCenter.noPrestamo;
        s[1] = CallCenter.noServicios;
        s[2] = CallCenter.noTarjeta;
        s[3] = CallCenter.noTransferencias;
        
        for(int i = 0; i < s.length - 1; i++)
        {
            for(int j = 0; j < s.length - 1; j++)
            {
                if (s[j] < s[j + 1])
                {
                    int aux = s[j+1];
                    s[j+1] = s[j];
                    s[j] = aux;
                }
            }
        }
        
        if(s[0]==CallCenter.noPrestamo){
            t1 = "Prestamos";
            if(s[1]==CallCenter.noServicios){
                t2 = "Servicios";
            }else if(s[1]==CallCenter.noTarjeta){
                t2 = "Tarjetas";
            }else if(s[1]==CallCenter.noTransferencias){
                t2 = "Transferencias";
            }
        }else if(s[0]==CallCenter.noServicios){
            t1 = "Pago de Servicios";
            if(s[1]==CallCenter.noPrestamo){
                t2 = "Prestamos";
            }else if(s[1]==CallCenter.noTarjeta){
                t2 = "Tarjetas";
            }else if(s[1]==CallCenter.noTransferencias){
                t2 = "Transferencias";
            }
        }else if(s[0]==CallCenter.noTarjeta){
            t1 = "Tarjetas";
            if(s[1]==CallCenter.noServicios){
                t2 = "Servicios";
            }else if(s[1]==CallCenter.noPrestamo){
                t2 = "Prestamos";
            }else if(s[1]==CallCenter.noTransferencias){
                t2 = "Transferencias";
            }
        }else if(s[0]==CallCenter.noTransferencias){
            t1 = "Transferencias";
            if(s[1]==CallCenter.noServicios){
                t2 = "Servicios";
            }else if(s[1]==CallCenter.noTarjeta){
                t2 = "Tarjetas";
            }else if(s[1]==CallCenter.noPrestamo){
                t2 = "Prestamos";
            }
        }
        
        List lista = new List().setSymbolIndent(12).setListSymbol(String.valueOf("-"));
        lista.add(new ListItem(c + ". " + t1 + " con " + s[0] + " veces usada"));
        c+=1;
        lista.add(new ListItem(c + ". " + t2 + " con " + s[1] + " veces usada"));
        
        doc.add(lista);
        doc.close();
        
    }
}
