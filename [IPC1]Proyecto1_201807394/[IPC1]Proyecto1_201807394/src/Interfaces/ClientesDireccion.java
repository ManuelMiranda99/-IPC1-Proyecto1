
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClientesDireccion extends JFrame{
    
    //Objetos Interfaz
    JLabel txt;
    ButtonGroup radio;
    JRadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;
    JComboBox comboAgencia, comboAgenciaA, comboCajero;
    JButton next, back;
    
    //Variables Logica
    int id, idLugar, c;
    
    public ClientesDireccion(int id){
        super("Clientes");
        
        //ID DEL CLIENTE
        this.id = id;
        c=0;
        
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        txt = new JLabel("A donde desea dirigirse?");
        txt.setBounds(40, 10, 150, 30);
        add(txt);
        
        rbtn1 = new JRadioButton("Agencia Bancaria", false);
        rbtn1.setBounds(40, 50, 150, 30);
        add(rbtn1);
        
        rbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                comboAgencia.enable(true);
                comboAgenciaA.enable(false);
                comboCajero.enable(false);                
            }        
        });        
        
        rbtn2 = new JRadioButton("Agencia Bancaria con Autobanco", false);
        rbtn2.setBounds(40, 90, 150, 30);
        add(rbtn2);
        
        rbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                comboAgencia.enable(false);
                comboAgenciaA.enable(true);
                comboCajero.enable(false);
            }
        
        });        
        
        rbtn3 = new JRadioButton("Cajero", false);
        rbtn3.setBounds(40, 130, 150, 30);
        add(rbtn3);
        
        rbtn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                comboAgencia.enable(false);
                comboAgenciaA.enable(false);
                comboCajero.enable(true);
            }
        
        });        
        
        rbtn4 = new JRadioButton("CallCenter", false);
        rbtn4.setBounds(40, 170, 150, 30);
        add(rbtn4);
        
        rbtn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(true);
                comboAgencia.enable(false);
                comboAgenciaA.enable(false);
                comboCajero.enable(false);
            }
        
        });        
        
        rbtn5 = new JRadioButton("Compra con Tarjeta", false);
        rbtn5.setBounds(40, 210, 150, 30);
        add(rbtn5);
        
        rbtn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(true);
                comboAgencia.enable(false);
                comboAgenciaA.enable(false);
                comboCajero.enable(false);
            }
        
        });        
        
        radio = new ButtonGroup();
        radio.add(rbtn1);
        radio.add(rbtn2);
        radio.add(rbtn3);
        radio.add(rbtn4);
        radio.add(rbtn5);
        
        
        comboAgencia = new JComboBox();
        for(int i=0;i<cAgencia;i++){
            comboAgencia.addItem(listaAgencias[i].getNombre());
        }
        comboAgencia.setBounds(200, 50, 150, 30);
        comboAgencia.enable(false);
        add(comboAgencia);
        /*
            ------------------------------------------------
        */        
        comboAgenciaA = new JComboBox();
        for(int i=0;i<cAgenciaA;i++){
            comboAgenciaA.addItem(listaAgenciasA[i].getNombre());
        }
        comboAgenciaA.setBounds(200, 90, 150, 30);
        comboAgenciaA.enable(false);
        add(comboAgenciaA);        
        /*
            ------------------------------------------------
        */        
        comboCajero = new JComboBox();
        for(int i=0;i<cCajeros;i++){
            comboCajero.addItem(listaCajeros[i].getUbicacion());
        }
        comboCajero.setBounds(200, 130, 150, 30);
        comboCajero.enable(false);
        add(comboCajero);   
        
        botones();
    }
    
    public void botones(){
        next = new JButton("Siguiente");
        next.setBounds(40, 250, 150, 30);
        next.setEnabled(false);
        add(next);
        
        //Para seguir a otro Frame
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbtn1.isSelected()){
                    //Agencia
                    dispose();
                    OpAgencia opA = new OpAgencia(id, idLugar);
                    opA.setVisible(true);
                }else if(rbtn2.isSelected()){
                    //Agencia A
                    dispose();
                    OpAgenciaA opAA = new OpAgenciaA(id, idLugar);
                    opAA.setVisible(true);
                }else if(rbtn3.isSelected()){
                    //Cajero
                    if(listaCajeros[idLugar].getEstado().equals("NO_ACTIVO")){
                        JOptionPane.showMessageDialog(null, "Cajero seleccionado fuera de servicio", "Banco del Exterior", JOptionPane.OK_OPTION);
                    }else{
                        dispose();
                        Cajero c = new Cajero(id, idLugar);
                        c.setVisible(true);
                    }
                }else if(rbtn4.isSelected()){
                    //CallCenter
                    dispose();
                    OpCallCenter call = new OpCallCenter(id);
                    call.setVisible(true);
                }else if(rbtn5.isSelected()){
                    //Tarjeta
                    for(int i=0;i<cTarjetas;i++){
                        if(listaTarjetas[i].getIdCliente()==id && listaTarjetas[i].getEstado().equals("AUTORIZADO")){
                            c=1;
                            break;
                        }
                    }
                    
                    if(c==1){
                        dispose();
                        CompraTarjeta com = new CompraTarjeta(id);
                        com.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "No posee tarjeta para realizar su compra", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        
        });
        
        back = new JButton("Regresar");
        back.setBounds(200, 250, 150, 30);
        add(back);
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientesInicio c = new ClientesInicio();
                c.setVisible(true);
            }
        
        });
        
        comboAgencia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(true);
                idLugar = comboAgencia.getSelectedIndex();
            }
            
        });
        
        comboAgenciaA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(true);
                idLugar = comboAgenciaA.getSelectedIndex();
            }
            
        });
        
        comboCajero.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                next.setEnabled(true);
                idLugar = comboCajero.getSelectedIndex();
            }
            
        });
        
    }
}
