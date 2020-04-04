
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cCajeros;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaCajeros;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarCajeros extends JFrame{
    
    JTextField buscador;
    JComboBox resultados;
    JButton buscar, regresar;    
    
    String tipo;
    
    public BuscarCajeros(){
        super("Buscar Cajeros");
        setSize(300,400);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        buscador = new JTextField();
        buscador.setBounds(50, 80, 200, 30);
        add(buscador);
        
        resultados = new JComboBox();
        resultados.setBounds(50, 120, 200, 30);
        botones();
        add(resultados);
        
    }
    
    public void botones(){
        buscar = new JButton("Buscar");
        buscar.setBounds(50, 160, 200, 30);
        add(buscar);
        
        buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                resultados.removeAllItems();
                String[] palabras = buscador.getText().split("//s+");
                for(String palabra : palabras){
                    for(int i=0;i<cCajeros;i++){
                        if(listaCajeros[i].getUbicacion().contains(palabra)){
                            resultados.addItem(listaCajeros[i].getUbicacion());
                        }
                    }
                }
            }            
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(50, 200, 200, 30);
        add(regresar);
        
        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }            
        });
    }    
}
