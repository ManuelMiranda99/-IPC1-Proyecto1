
package Logica;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.io.FileNotFoundException;
import java.io.File;

public class CrearPDFTopAgenciaE {
    
    String mas;
    /*
        [i][0] : Nombre de la Agencia
        [i][1] : Numero de Empleados
    */
    String[][] AgenciasT = new String[cAgencia+cAgenciaA][2];
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("AgenciaMEmpleados.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        
        for(int i=0;i<cAgencia;i++){
            AgenciasT[i][0] = listaAgencias[i].getNombre();
            AgenciasT[i][1] = String.valueOf(listaAgencias[i].getNoEmpleados());
        }
        
        for(int i=cAgencia;i<cAgencia+cAgenciaA;i++){
            AgenciasT[i][0] = listaAgenciasA[i-cAgencia].getNombre();
            AgenciasT[i][1] = String.valueOf(listaAgenciasA[i-cAgencia].getNoEmpleados());
        }
        
        for(int i=0;i<cAgencia+cAgenciaA;i++){
            if(i==0){
                mas = AgenciasT[0][0];
            }else{
                if(Integer.parseInt(AgenciasT[i][1])>Integer.parseInt(AgenciasT[i-1][1])){
                    mas = AgenciasT[i][0];
                }
            }
        }
        
        Paragraph p = new Paragraph("\n \n \n La agencia con mayor numero de empleados es: " + mas);
        doc.add(p);
        doc.close();
    }
}
