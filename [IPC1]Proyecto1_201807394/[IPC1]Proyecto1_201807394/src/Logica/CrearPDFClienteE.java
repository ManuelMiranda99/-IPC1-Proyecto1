
package Logica;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.io.FileNotFoundException;
import java.io.File;

public class CrearPDFClienteE {

    String cuentasA, cuentasM, tar, pre;
    int c=0;
    int c1=0;
    
    public CrearPDFClienteE(int id) throws FileNotFoundException {
        File dir = new File("ListaCliente" + id + ".pdf");      
        PdfWriter writer = new PdfWriter(dir.getAbsolutePath());
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf, PageSize.A4.rotate());
        
        Table tabla = new Table(new float[]{50,50,50,50,50,50,50,50,30});
        
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Nombre")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Direccion")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Telefono")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID Cuentas Ahorro Asociadas")));
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID Cuentas Monetarias Asociadas")));      
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID Prestamos Asociados")));        
        tabla.addHeaderCell(new Cell().add(new Paragraph("ID Tarjetas Asociadas")));       
        tabla.addHeaderCell(new Cell().add(new Paragraph("Numero de Transacciones Realizadas")));
        
        
        for(int j=0;j<cCuentas;j++){
                if(listaCuentas[j].getTipo().equals("AHORRO")){
                    if(listaCuentas[j].getIdCliente()==listaClientes[id].getId()){
                        if(c==0){
                            cuentasA = String.valueOf(listaCuentas[j].getId());
                            c=1;
                        }else{
                            cuentasA = cuentasA + "-" + String.valueOf(listaCuentas[j].getId());
                        }
                    }else{
                        if(cuentasA == null){
                            cuentasA ="";
                        }
                    }
                }else if(listaCuentas[j].getTipo().equals("MONETARIA")){
                    if(listaCuentas[j].getIdCliente()==listaClientes[id].getId()){
                        if(c1==0){
                            cuentasM = String.valueOf(listaCuentas[j].getId());
                            c1=1;
                        }else{
                            cuentasM = cuentasM + "-" + String.valueOf(listaCuentas[j].getId());
                        }
                    }else{
                        if(cuentasM == null){
                            cuentasM ="";
                        }                        
                    }
                }
            }
            
            c=0;
            c1=0;
            
            if(cPrestamos==0){
                pre = "";
            }
            
            for(int j=0;j<cPrestamos;j++){
                if(listaPrestamos[j].getIdCliente()==listaClientes[id].getId()){
                    if(c==0){
                        pre = String.valueOf(listaPrestamos[j].getId());
                        c=1;
                    }else{
                        pre = pre + "-" + String.valueOf(listaPrestamos[j].getId());
                    }
                }else{
                    if(pre == null){
                        pre = "";                        
                    }
                    
                }
            }
            
            c=0;
            
            if(cTarjetas==0){
                tar="";
            }
            
            for(int j=0;j<cTarjetas;j++){
                if(listaTarjetas[j].getIdCliente()==listaClientes[id].getId()){
                    if(c==0){
                        tar = String.valueOf(listaTarjetas[j].getId());
                        c=1;
                    }else{
                        tar = tar + "-" + String.valueOf(listaTarjetas[j].getId());
                    }
                }else{
                    if(tar == null){
                        tar = "";
                    }                    
                }
            }
        
        
        tabla.addCell(String.valueOf(listaClientes[id].getId()));
        tabla.addCell(listaClientes[id].getNombre());
        tabla.addCell(listaClientes[id].getDireccion());
        tabla.addCell(listaClientes[id].getTelefono());
        tabla.addCell(cuentasA);
        tabla.addCell(cuentasM);
        tabla.addCell(pre);
        tabla.addCell(tar);
        tabla.addCell(String.valueOf(listaClientes[id].getNoTransacciones()));
            
        
        doc.add(tabla);
        doc.close();
    }    
    
}
