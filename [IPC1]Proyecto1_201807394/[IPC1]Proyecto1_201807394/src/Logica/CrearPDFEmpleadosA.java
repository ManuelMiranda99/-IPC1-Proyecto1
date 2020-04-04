
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

public class CrearPDFEmpleadosA {
    
    /*
        [i][0] : Nombre Agencia
        [i][1] : Nombres Empleados
    */
    String[][] AgenciasT = new String[cAgencia+cAgenciaA][2];
    int c=0;
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("EmpleadosXAgencia.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        Paragraph p = new Paragraph("\n \n \n \n ");
        doc.add(p);
        
        for(int i=0;i<cAgencia;i++){
            AgenciasT[i][0] = listaAgencias[i].getNombre();
        }
        for(int i=cAgencia;i<cAgencia+cAgenciaA;i++){
            AgenciasT[i][0] = listaAgenciasA[i-cAgencia].getNombre();
        }
        
        for(int i=0;i<cEmpleados;i++){
            for(int j=0;j<cAgencia+cAgenciaA;j++){
                if(listaEmpleados[i].getLugarDeTrabajo().equals(AgenciasT[j][0])){
                    if(c==0){
                        AgenciasT[j][1] = listaEmpleados[i].getNombre();
                        c=1;
                    }else{
                        AgenciasT[j][1] = AgenciasT[j][1] + "-" + listaEmpleados[i].getNombre();
                    }
                }
            }
        }
        
        List lista = new List().setSymbolIndent(12).setListSymbol(String.valueOf("\u2022"));
        for(int i=0;i<cAgencia+cAgenciaA;i++){
            lista.add(new ListItem("La agencia " + AgenciasT[i][0] + " cuenta con los siguientes empleados: " + AgenciasT[i][1]));
        }
        doc.add(lista);
        doc.close();
    }
}
