
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgencia;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgencias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EliminarAgencia extends JFrame{
    JComboBox combo;
    JLabel nombre;
    JButton el, can;
    
    int idC;
    
    public EliminarAgencia(){
        super("Eliminar Agencia");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        combo = new JComboBox();
        for(int i=0;i<cAgencia;i++){
            combo.addItem(listaAgencias[i].getNombre());
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
                listaAgencias[idC].eliminarA();
                JOptionPane.showMessageDialog(null, "Agencia Eliminada con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
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