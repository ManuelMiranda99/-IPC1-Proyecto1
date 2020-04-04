/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cCajeros;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaCajeros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jmiranda
 */
public class EliminarCajeros extends JFrame{
    JComboBox combo;
    JLabel nombre;
    JButton el, can;
    
    int idC;
    
    public EliminarCajeros(){
        super("Eliminar Cajeros");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        combo = new JComboBox();
        for(int i=0;i<cCajeros;i++){
            combo.addItem(listaCajeros[i].getUbicacion());
        }
        combo.setBounds(20, 20, 150, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText(combo.getSelectedItem().toString());
                el.setEnabled(true);
            }            
        });
        
        nombre = new JLabel();
        nombre.setBounds(20, 60, 150, 30);
        add(nombre);
        
        botones();
    }
    
    public void botones(){
        el = new JButton("Eliminar");
        el.setBounds(20, 100, 150, 30);
        el.setEnabled(false);
        add(el);
        
        el.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                idC = combo.getSelectedIndex();
                listaCajeros[idC].eliminarC();
                JOptionPane.showMessageDialog(null, "Cajero Eliminado con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        
        can = new JButton("Cancelar");
        can.setBounds(20, 140, 150, 30);
        add(can);
        
        can.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }
            
        });
    }
}
