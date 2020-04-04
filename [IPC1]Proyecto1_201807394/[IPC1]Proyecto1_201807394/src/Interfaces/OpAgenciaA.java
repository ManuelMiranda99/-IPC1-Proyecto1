/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OpAgenciaA extends JFrame{
    
    //Objetos Interfaz
    JButton cajas, atencion, regresar, cajasA;
    
    int idC, idL;
    public OpAgenciaA(int idC, int idL){
        super("Agencia " + listaAgenciasA[idL].getNombre());
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
        cajas.setBounds(50, 20, 150, 30);
        add(cajas);
        
        cajas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FAgenciayA c = new FAgenciayA(idC, idL, "CON");
                c.setVisible(true);
            }
        
        });
        
        cajasA = new JButton("Cajas Autobanco");
        cajasA.setBounds(50, 60, 150, 30);
        add(cajasA);
        
        cajasA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FAgenciayA c = new FAgenciayA(idC, idL, "CON");
                c.setVisible(true);
            }
        
        });
        
        atencion = new JButton("Atencion al Cliente");
        atencion.setBounds(50, 100, 150, 30);
        add(atencion);
        
        atencion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AtencionCliente a = new AtencionCliente(idC, idL, "CON");
                a.setVisible(true);
            }
        
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(50, 140, 150, 30);
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
