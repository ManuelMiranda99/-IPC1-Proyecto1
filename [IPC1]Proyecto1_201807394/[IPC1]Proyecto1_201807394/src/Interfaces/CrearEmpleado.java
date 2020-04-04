
package Interfaces;

//Importacion de Bibliotecas/Paquetes a utilizar
import Logica.Empleados;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearEmpleado extends JFrame{
    
    //Objetos Interfaz
    JLabel txtnombre;
    JComboBox combo;
    JTextField nombre;
    JButton crear, cancelar;
    
    String Nombre, lugarDeTrabajo;
    
    public CrearEmpleado(){
        super("Crear Empleado");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                
        
        txtnombre = new JLabel("Nombre: ");
        txtnombre.setBounds(100, 100-30, 210, 20);
        add(txtnombre);
        
        nombre = new JTextField();
        nombre.setBounds(100, 130-30, 210, 20);
        add(nombre);
        
        combo = new JComboBox();
        //Agregacion de Datos al ComboBox
        for(int i=0;i<cAgencia;i++){
            combo.addItem(listaAgencias[i].getNombre());
        }

        for(int i=0;i<cAgenciaA;i++){
            combo.addItem(listaAgenciasA[i].getNombre());
        }        
        combo.addItem("Gerencia");
        combo.addItem("Departamento de Marketing");
        combo.addItem("Departamento de Informatica");
        combo.addItem("Departamento Financiero");
        combo.addItem("Departamento de Reclamos");
        combo.addItem("Departamento de Cobros");
        
        //Para que guarde el elemento seleccionado
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                crear.setEnabled(true);
                lugarDeTrabajo = (String)combo.getSelectedItem();
            }            
        });
        
        combo.setBounds(100, 160-30, 210, 30);
        add(combo);
        
        botones();
        
    }
    
    public void botones(){
        crear = new JButton("Crear");
        crear.setBounds(100, 200-30, 100, 30);
        crear.setEnabled(false);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Nombre = nombre.getText();
                if(Nombre.length()==0 || lugarDeTrabajo.length()==0){
                    JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio, llenelo para poder continuar", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }else{
                    listaEmpleados[cEmpleados] = new Empleados(Nombre, lugarDeTrabajo);
                    cEmpleados+=1;
                    JOptionPane.showMessageDialog(null, "Creacion de Empleado Exitosa", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    MenuAdmin menu = new MenuAdmin();
                    menu.setVisible(true);
                }
            }            
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(210, 200-30, 100, 30);
        add(cancelar);
        
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }            
        });
    }
}
