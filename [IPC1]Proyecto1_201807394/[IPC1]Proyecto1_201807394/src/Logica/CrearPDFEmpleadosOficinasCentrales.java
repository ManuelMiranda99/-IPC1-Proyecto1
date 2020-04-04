
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

public class CrearPDFEmpleadosOficinasCentrales {
        
    
    String ge, ma, in, fi, re, co;
    int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0;
    
    public void CrearPDF() throws FileNotFoundException{
        File dir = new File("EmpleadosOficinasCentrales.pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);
        Paragraph p = new Paragraph("\n \n \n \n ");
        doc.add(p);
        
        for(int i=0;i<cEmpleados;i++){
            if(listaEmpleados[i].getLugarDeTrabajo().equals("Gerencia")){
                if(c1==0){
                    ge = listaEmpleados[i].getNombre();
                    c1=1;
                }else{
                    ge = ge + "-" + listaEmpleados[i].getNombre();
                }
            }else if(listaEmpleados[i].getLugarDeTrabajo().equals("Departamento de Marketing")){
                if(c2==0){
                    ma = listaEmpleados[i].getNombre();
                    c2=1;
                }else{
                    ma = ma + "-" + listaEmpleados[i].getNombre();
                }
            }else if(listaEmpleados[i].getLugarDeTrabajo().equals("Departamento de Informatica")){
                if(c3==0){
                    in = listaEmpleados[i].getNombre();
                    c3=1;
                }else{
                    in = in + "-" + listaEmpleados[i].getNombre();
                }
            }else if(listaEmpleados[i].getLugarDeTrabajo().equals("Departamento Financiero")){
                if(c4==0){
                    fi = listaEmpleados[i].getNombre();
                    c4=1;
                }else{
                    fi = fi + "-" + listaEmpleados[i].getNombre();
                }
            }else if(listaEmpleados[i].getLugarDeTrabajo().equals("Departamento de Reclamos")){
                if(c5==0){
                    re = listaEmpleados[i].getNombre();
                    c5=1;
                }else{
                    re = re + "-" + listaEmpleados[i].getNombre();
                }
            }else if(listaEmpleados[i].getLugarDeTrabajo().equals("Departamento de Cobros")){
                if(c6==0){
                    co = listaEmpleados[i].getNombre();
                    c6=1;
                }else{
                    co = co + "-" + listaEmpleados[i].getNombre();
                }
            }
        }
        
        List lista = new List().setSymbolIndent(12).setListSymbol(String.valueOf("\u2022"));
        lista.add(new ListItem("Empleados del area de Gerencia: " + ge))
                .add(new ListItem("Empleados del Departamento de Marketing: " + ma))
                .add(new ListItem("Empleados del Departamento de Informatica: " + in))
                .add(new ListItem("Empleados del Departamento Financiero: " + fi))
                .add(new ListItem("Empleados del Departamento de Reclamos: " + re))
                .add(new ListItem("Empleados del Departamento de Cobros: " + co));
        
        doc.add(lista);
        doc.close();
        
        
        
    }
    
}
