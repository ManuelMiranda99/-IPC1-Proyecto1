
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgencia;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgenciaA;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgencias;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgenciasA;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarAgencias extends JFrame{
    
    JTextField buscador;
    JComboBox resultados;
    JButton buscar, regresar;    
    
    String tipo;
    
    public BuscarAgencias(String tipo){
        super("Buscar Agencias");
        setSize(300,400);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.tipo = tipo;
        
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
                    
                    if(tipo.equals("SIN")){
                        for(int i=0;i<cAgencia;i++){
                            if(listaAgencias[i].getNombre().contains(palabra)){
                                resultados.addItem(listaAgencias[i].getNombre());
                            }
                        }
                    }else{
                        for(int i=0;i<cAgenciaA;i++){
                            if(listaAgenciasA[i].getNombre().contains(palabra)){
                                resultados.addItem(listaAgenciasA[i].getNombre());
                            }
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
