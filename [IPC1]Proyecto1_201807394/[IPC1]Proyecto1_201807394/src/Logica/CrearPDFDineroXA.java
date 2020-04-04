
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

public class CrearPDFDineroXA{
    
    public void CrearPDFDineroXA() throws FileNotFoundException{
        File dir = new File("DineroXAgencia.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        
        List lista = new List().setSymbolIndent(12).setListSymbol("-");        
        for(int i=0;i<cAgencia;i++){
            lista.add(new ListItem(listaAgencias[i].getNombre() + " cuenta con: Q" + String.valueOf(listaAgencias[i].getEfectivo())));
        }
        
        for(int i=0;i<cAgenciaA;i++){
            lista.add(new ListItem(listaAgenciasA[i].getNombre() + " cuenta con: Q" + String.valueOf(listaAgenciasA[i].getEfectivo())));
        }
        
        doc.add(lista);
        doc.close();
    }
    
}
