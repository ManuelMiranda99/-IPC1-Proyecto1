
package Interfaces;

import Logica.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class OperacionesReportes extends JFrame{
    
    JLabel txt;
    JComboBox combo;
    JButton crear, cancelar;
    
    int id;
    
    public OperacionesReportes(){
        super("Reportes");
        setSize(500, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        txt = new JLabel("Crear PDF:");
        txt.setBounds(20, 30, 300, 30);
        add(txt);
        
        combo = new JComboBox();
        combo.addItem("Lista Agencias");                                    //0  Listo
        combo.addItem("Lista Cajeros");                                     //1  Listo
        combo.addItem("Lista Clientes");                                    //2  Listo
        combo.addItem("Top 3 Clientes con mas Cuentas");                    //3  Listo
        combo.addItem("Top 3, Clientes con mas Dinero");                    //4  Listo
        combo.addItem("Top 3, Clientes con mas Deuda");                     //5  
        combo.addItem("Top 3, Agencias mas utilizadas");                    //6  Listo
        combo.addItem("Top 2, Operaciones mas realizadas en Call-Center");  //7  Listo
        combo.addItem("Dinero Efectivo en Todas las Agencias");             //8  Listo
        combo.addItem("Datos de Cliente");                                  //9  Listo
        combo.addItem("Dinero Efectivo por agencia");                       //10 Listo
        combo.addItem("Lista de Empleados por Agencia");                    //11 Listo
        combo.addItem("Lista de Empleados en Oficinas Centrales");          //12 Listo
        combo.addItem("Agencia con mas empleados");                         //13 Listo
        combo.addItem("Top 3, Clientes con mayor compras en Tarjeta");      //14 Listo
        
        combo.setBounds(20, 70, 450, 30);
        add(combo);
        
        
        botones();
    }    
    
    public void botones(){
        crear = new JButton("Generar PDF");
        crear.setEnabled(false);
        crear.setBounds(20, 110, 145, 30);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = combo.getSelectedIndex();
                    switch(id){
                        case 0:
                            
                            CrearPDFAgencias crear0 = new CrearPDFAgencias();
                            crear0.crearPDF();
                            
                            break;
                        case 1:
                            
                            CrearPDFCajeros crear1 = new CrearPDFCajeros();
                            crear1.crearPDF();
                            
                            break;
                        case 2:
                            
                            CrearPDFClientes crear2 = new CrearPDFClientes();
                            crear2.crearPDF();
                            
                            break;
                        case 3:
                            
                            CreacionPDFTopCuentas crear3 = new CreacionPDFTopCuentas();
                            crear3.crearPDF();
                            
                            break;
                        case 4:
                            
                            CrearPDFClientesME crear4 = new CrearPDFClientesME();
                            crear4.crearPDF();
                            
                            break;
                        case 5:
                            
                            CrearPDFClientesDeuda crear5 = new CrearPDFClientesDeuda();
                            crear5.crearPDF();
                            
                            break;
                        case 6:
                            
                            CrearPDFAgenciasMas crear6 = new CrearPDFAgenciasMas();
                            crear6.crearPDF();
                            
                            break;
                        case 7:
                            
                            CrearPDFCallCenter crear7 = new CrearPDFCallCenter();
                            crear7.crearPDF();
                            
                            break;
                        case 8:
                            
                            CrearPDFDineroTodas crear8 = new CrearPDFDineroTodas();
                            crear8.crearPDF();
                            
                            break;
                        case 9:
                            
                            dispose();
                            PDFCliente crear9 = new PDFCliente();
                            crear9.setVisible(true);
                            
                            break;
                        case 10:
                            
                            CrearPDFDineroXA crear10 = new CrearPDFDineroXA();
                            crear10.CrearPDFDineroXA();
                            
                            break;
                        case 11:
                            
                            CrearPDFEmpleadosA crear11 = new CrearPDFEmpleadosA();
                            crear11.crearPDF();
                            
                            break;
                        case 12:
                            
                            CrearPDFEmpleadosOficinasCentrales crear12 = new CrearPDFEmpleadosOficinasCentrales();
                            crear12.CrearPDF();
                            
                            break;
                        case 13:
                            
                            CrearPDFTopAgenciaE crear13 = new CrearPDFTopAgenciaE();
                            crear13.crearPDF();
                            
                            break;
                        case 14:
                            
                            CrearPDFComprasT crear14 = new CrearPDFComprasT();
                            crear14.crearPDF();
                            
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Algo sucedio mal, pruebe de nuevo", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                            break;
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Algo sucedio mal, pruebe de nuevo", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });                     
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(305, 110, 145, 30);
        add(cancelar);
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }
            
        });        
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                crear.setEnabled(true);
            }
            
        });        
    }
    
}
