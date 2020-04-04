
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarEmpleado extends JFrame{
    
    
    //Objetos Interfaz
    JLabel txtnombre, txtlugar;
    JComboBox combo, combo1;
    JTextField nombre, lugar;
    JButton crear, cancelar;
    
    String Nombre, lugarDeTrabajo;
    int id;
    
    public EditarEmpleado(){
        super("Editar Empleado");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        combo1 = new JComboBox();
        for(int i=0;i<cEmpleados;i++){
            combo1.addItem(listaEmpleados[i].getNombre());
        }
        combo1.setBounds(100, 20, 210, 30);
        add(combo1);
        
        combo1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                id = combo1.getSelectedIndex();
                nombre.enable(true);
                combo.enable(true);
                nombre.setText(listaEmpleados[id].getNombre());
                lugar.setText(listaEmpleados[id].getLugarDeTrabajo());
            }            
        });
        
        txtnombre = new JLabel("Nombre: ");
        txtnombre.setBounds(100, 60, 210, 20);
        add(txtnombre);
        
        nombre = new JTextField();
        nombre.setBounds(100, 90, 210, 20);
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
                lugar.setText(lugarDeTrabajo);
            }            
        });
        
        combo.setBounds(100, 190, 210, 30);
        add(combo);
        
        nombre.enable(false);
        combo.enable(false);
        
        txtlugar = new JLabel("Lugar de Trabajo: ");
        txtlugar.setBounds(100, 120, 210, 20);
        add(txtlugar);
        
        lugar = new JTextField();
        lugar.setBounds(100, 150, 210, 30);
        lugar.enable(false);
        add(lugar);
        botones();
        
    }
    
    public void botones(){
        crear = new JButton("Editar");
        crear.setBounds(100, 230, 100, 30);
        crear.setEnabled(false);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Nombre = nombre.getText();
                if(Nombre.length()==0 || lugarDeTrabajo.length()==0){
                    JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio, llenelo para poder continuar", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }else{
                    
                    listaEmpleados[id].setNombre(Nombre);
                    listaEmpleados[id].setLugarDeTrabajo(lugarDeTrabajo);
                    
                    JOptionPane.showMessageDialog(null, "Edicion de Empleado Exitosa", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    MenuAdmin menu = new MenuAdmin();
                    menu.setVisible(true);
                }
            }            
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(210, 230, 100, 30);
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
