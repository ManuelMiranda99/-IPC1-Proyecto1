
package Logica;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.io.FileNotFoundException;
import java.io.File;

public class CrearPDFDineroTodas {
    
    double dinero;
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("DineroTodasAgencias.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        
        for(int i=0;i<cAgencia;i++){
            dinero += listaAgencias[i].getEfectivo();
        }
        
        for(int i=0;i<cAgenciaA;i++){
            dinero += listaAgenciasA[i].getEfectivo();
        }
        
        Paragraph p = new Paragraph("\n \n \n El dinero disponible en todas las agencias es de: " + dinero);
        doc.add(p);
        doc.close();
    }
}
