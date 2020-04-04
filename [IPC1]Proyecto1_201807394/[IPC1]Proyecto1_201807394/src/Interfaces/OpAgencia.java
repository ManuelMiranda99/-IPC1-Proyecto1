
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Sin Autobanco

public class OpAgencia extends JFrame{
    
    //Objetos Interfaz
    JButton cajas, atencion, regresar;
    
    int idC, idL;
    public OpAgencia(int idC, int idL){
        super("Agencia " + listaAgencias[idL].getNombre());
        this.idC = idC;
        this.idL = idL; 
        setSize(250, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        botones();
    }
    
    public void botones(){
        cajas = new JButton("Cajas");
        cajas.setBounds(50, 40, 150, 30);
        add(cajas);
        
        cajas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FAgenciayA c = new FAgenciayA(idC, idL, "SIN");
                c.setVisible(true);
            }
        
        });
        
        atencion = new JButton("Atencion al Cliente");
        atencion.setBounds(50, 80, 150, 30);
        add(atencion);
        
        atencion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AtencionCliente a = new AtencionCliente(idC, idL, "SIN");
                a.setVisible(true);
            }
        
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(50, 120, 150, 30);
        add(regresar);
        
        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientesDireccion c = new ClientesDireccion(idC);
                c.setVisible(true);
            }
        
        });
    }
}
