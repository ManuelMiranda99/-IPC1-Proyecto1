
package Logica;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cCajeros;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaCajeros;
import java.io.FileNotFoundException;
import java.io.File;

public class CrearPDFCajeros {
    
    String[] listaID = new String[cCajeros];
    String[] listaUbicacion = new String[cCajeros];
    String[] listaEstados = new String[cCajeros];
    String[] listaEfectivo = new String[cCajeros];
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("ListaCajeros.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf, PageSize.A4.rotate());
        
        Table tabla = new Table(new float[]{50,70,70,70});
        
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Cajas")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Escritorios Servicio al Cliente")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Cajas Autobanco")));        
        
        for(int i=0;i<cCajeros;i++){
            listaID[i] = String.valueOf(listaCajeros[i].getId());
            listaUbicacion[i] = listaCajeros[i].getUbicacion();
            listaEstados[i] = listaCajeros[i].getEstado();
            listaEfectivo[i] = String.valueOf(listaCajeros[i].getEfectivo());
        }        
        
        //Filas
        for(int i=0;i<cCajeros;i++){
            tabla.addCell(listaID[i]);
            tabla.addCell(listaUbicacion[i]);
            tabla.addCell(listaEstados[i]);
            tabla.addCell(listaEfectivo[i]);
        }
        
        doc.add(tabla);        
        doc.close();
    }
    
}
