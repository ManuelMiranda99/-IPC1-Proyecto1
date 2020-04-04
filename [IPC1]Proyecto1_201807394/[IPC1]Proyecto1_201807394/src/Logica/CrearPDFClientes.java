
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

public class CrearPDFClientes {
    
    String[] listaID = new String[cClientes];
    String[] listaNombre = new String[cClientes];
    String[] listaDireccion = new String[cClientes];
    String[] listaTelefono = new String[cClientes];
    String[] listaCuentasAhorro = new String[cClientes];
    String[] listaCuentasMonetarias = new String[cClientes];
    String[] listaPrestamosF = new String[cClientes];
    String[] listaTarjetaF = new String[cClientes];
    String[] listaTransacciones = new String[cClientes];
    
    int c=0;
    int c1=0;
    
    public void crearPDF() throws FileNotFoundException{
        File dir = new File("ListaClientes.pdf");      
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
                
        //Ciclo para asignar valores a mis arreglos para colocar en el pdf
        for(int i=0;i<cClientes;i++){
            listaID[i] = String.valueOf(listaClientes[i].getId());
            listaNombre[i] = listaClientes[i].getNombre();
            listaDireccion[i] = listaClientes[i].getDireccion();
            listaTelefono[i] = listaClientes[i].getTelefono();
            
            //Ciclo para agregar a mis arreglos de Cuentas
            for(int j=0;j<cCuentas;j++){
                if(listaCuentas[j].getTipo().equals("AHORRO")){
                    if(listaCuentas[j].getIdCliente()==listaClientes[i].getId()){
                        if(c==0){
                            listaCuentasAhorro[i] = String.valueOf(listaCuentas[j].getId());
                            c=1;
                        }else{
                            listaCuentasAhorro[i] = listaCuentasAhorro[i] + "-" + String.valueOf(listaCuentas[j].getId());
                        }
                    }else{
                        if(listaCuentasAhorro[i] == null){
                            listaCuentasAhorro[i] ="";
                        }
                    }
                }else if(listaCuentas[j].getTipo().equals("MONETARIA")){
                    if(listaCuentas[j].getIdCliente()==listaClientes[i].getId()){
                        if(c1==0){
                            listaCuentasMonetarias[i] = String.valueOf(listaCuentas[j].getId());
                            c1=1;
                        }else{
                            listaCuentasMonetarias[i] = listaCuentasMonetarias[i] + "-" + String.valueOf(listaCuentas[j].getId());
                        }
                    }else{
                        if(listaCuentasMonetarias[i] == null){
                            listaCuentasMonetarias[i] ="";
                        }                        
                    }
                }
            }
            
            c=0;
            c1=0;
            
            if(cPrestamos==0){
                listaPrestamosF[i] = "";
            }
            
            for(int j=0;j<cPrestamos;j++){
                if(listaPrestamos[j].getIdCliente()==listaClientes[i].getId()){
                    if(c==0){
                        listaPrestamosF[i] = String.valueOf(listaPrestamos[j].getId());
                        c=1;
                    }else{
                        listaPrestamosF[i] = listaPrestamosF[i] + "-" + String.valueOf(listaPrestamos[j].getId());
                    }
                }else{
                    if(listaPrestamosF[i] == null){
                        listaPrestamosF[i] = "";                        
                    }
                    
                }
            }
            
            c=0;
            
            if(cTarjetas==0){
                listaTarjetaF[i]="";
            }
            
            for(int j=0;j<cTarjetas;j++){
                if(listaTarjetas[j].getIdCliente()==listaClientes[i].getId()){
                    if(c==0){
                        listaTarjetaF[i] = String.valueOf(listaTarjetas[j].getId());
                        c=1;
                    }else{
                        listaTarjetaF[i] = listaTarjetaF[i] + "-" + String.valueOf(listaTarjetas[j].getId());
                    }
                }else{
                    if(listaTarjetaF[i] == null){
                        listaTarjetaF[i] = "";
                    }                    
                }
            }
            
            listaTransacciones[i] = String.valueOf(listaClientes[i].getNoTransacciones());
        }        
        
        
        
        
        
        //Filas
        for(int i=0;i<cClientes;i++){
            tabla.addCell(listaID[i]);
            tabla.addCell(listaNombre[i]);
            tabla.addCell(listaDireccion[i]);
            tabla.addCell(listaTelefono[i]);
            tabla.addCell(listaCuentasAhorro[i]);
            tabla.addCell(listaCuentasMonetarias[i]);
            tabla.addCell(listaPrestamosF[i]);
            tabla.addCell(listaTarjetaF[i]);
            tabla.addCell(listaTransacciones[i]);            
        }        
        
        doc.add(tabla);        
        doc.close();
    }
    
}
