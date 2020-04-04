
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cClientes;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClientesInicio extends JFrame{
    
    //Objetos Interfaz
    JLabel txtselect;
    JComboBox combo;
    JButton next, back;
    
    //Variables logica
    int id;
    
    public ClientesInicio(){
        super("Inicio");
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        txtselect = new JLabel("Seleccionar Cliente");
        txtselect.setBounds(50, 10, 210, 30);
        add(txtselect);
        
        combo = new JComboBox();
        for(int i=0;i<cClientes;i++){
            combo.addItem(listaClientes[i].getNombre());
        }
        combo.setBounds(50, 50, 210, 30);
        add(combo);
        
        botones();
    }
    
    public void botones(){
        next = new JButton("Siguiente");
        next.setBounds(50, 90, 100, 30);
        next.setEnabled(false);
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                id = combo.getSelectedIndex();
                if(listaClientes[id].getNombre().equals("")){
                    JOptionPane.showMessageDialog(null, "Cliente a utilizar eliminado", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }else{
                    dispose();
                    ClientesDireccion c = new ClientesDireccion(id);
                    c.setVisible(true);
                }                
                }
        });
        add(next);
        
        back = new JButton("Regresar");
        back.setBounds(50,130, 100, 30);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPrincipal regresar = new MenuPrincipal();
                regresar.setVisible(true);
            }
            
        });
        add(back);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(true);
            }
            
        });        
    }
}
