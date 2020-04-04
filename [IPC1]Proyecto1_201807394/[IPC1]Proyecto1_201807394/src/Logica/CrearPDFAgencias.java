
package Logica;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgencia;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgenciaA;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgencias;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgenciasA;
import java.io.FileNotFoundException;
import java.io.File;


public class CrearPDFAgencias {
    
    String[] listaID = new String[cAgencia+cAgenciaA];
    String[] listaCajas = new String[cAgencia+cAgenciaA];
    String[] listaEscritorios = new String[cAgencia+cAgenciaA];
    String[] listaCajasA = new String[cAgencia+cAgenciaA];
    String[] listaEmpleados = new String[cAgencia+cAgenciaA];
    String[] listaNombre = new String[cAgencia+cAgenciaA];
    String[] listaDireccion = new String[cAgencia+cAgenciaA];
    String[] listaTelefono = new String[cAgencia+cAgenciaA];
    String[] listaEfectivo = new String[cAgencia+cAgenciaA];
    int c=0;
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("ListaAgencias.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf, PageSize.A4.rotate());
        
        Table tabla = new Table(new float[]{5,50,50,50,50,50,50,50,50});
        
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Cajas")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Escritorios Servicio al Cliente")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Cajas Autobanco")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("No. Empleados")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Nombre")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Direccion")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Telefono")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Efectivo")));
        
        for(int i=0;i<cAgencia;i++){
            listaID[c] = String.valueOf(listaAgencias[i].getId());
            listaCajas[c] = String.valueOf(listaAgencias[i].getNoCajas());
            listaEscritorios[c] = String.valueOf(listaAgencias[i].getNoEscritoriosServicioCliente());
            listaCajasA[c] = "0";
            listaEmpleados[c] = String.valueOf(listaAgencias[i].getNoEmpleados());
            listaNombre[c] = listaAgencias[i].getNombre();
            listaDireccion[c] = listaAgencias[i].getDireccion();
            listaTelefono[c] = listaAgencias[i].getTelefono();        
            listaEfectivo[c] = String.valueOf(listaAgencias[i].getEfectivo());
            c+=1;
        }
        
        for(int i=0;i<cAgenciaA;i++){
            listaID[c] = String.valueOf(listaAgenciasA[i].getId());
            listaCajas[c] = String.valueOf(listaAgenciasA[i].getNoCajas());
            listaEscritorios[c] = String.valueOf(listaAgenciasA[i].getNoEscritoriosServicioCliente());
            listaCajasA[c] = String.valueOf(listaAgenciasA[i].getNoCajasAutobanco());
            listaEmpleados[c] = String.valueOf(listaAgenciasA[i].getNoEmpleados());
            listaNombre[c] = listaAgenciasA[i].getNombre();
            listaDireccion[c] = listaAgenciasA[i].getDireccion();
            listaTelefono[c] = listaAgenciasA[i].getTelefono();        
            listaEfectivo[c] = String.valueOf(listaAgenciasA[i].getEfectivo());
            c+=1;
        }
        
        //Filas
        for(int i=0;i<c;i++){
            tabla.addCell(listaID[i]);
            tabla.addCell(listaCajas[i]);
            tabla.addCell(listaEscritorios[i]);
            tabla.addCell(listaCajasA[i]);
            tabla.addCell(listaEmpleados[i]);
            tabla.addCell(listaNombre[i]);
            tabla.addCell(listaDireccion[i]);
            tabla.addCell(listaTelefono[i]);
            tabla.addCell(listaEfectivo[i]);
        }
        
        doc.add(tabla);        
        doc.close();
    }
    
    
}
