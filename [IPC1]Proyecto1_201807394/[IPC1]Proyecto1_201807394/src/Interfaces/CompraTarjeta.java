
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CompraTarjeta extends JFrame{
    
    //Objetos Interfaz
    JComboBox combo;
    JLabel txt1, txt2, txt3;
    JTextField p, m;
    JButton com, can;
    
    int idC, idT;
    double monto;
    public CompraTarjeta(int idC){
        super("Compra con Tarjeta");
        setSize(300, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
        this.idC = idC;
        
        txt1 = new JLabel("ID Tarjeta a utilizar");
        txt1.setBounds(10, 10, 150, 30);
        add(txt1);
        
        combo = new JComboBox();
        for(int i=0;i<cTarjetas;i++){
            if(listaTarjetas[i].getIdCliente()==idC){
                combo.addItem(listaTarjetas[i].getId());
            }
        }
        combo.setBounds(10, 50, 150, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setEnabled(true);
            }
            
        });
        
        txt2 = new JLabel("Producto:");
        txt2.setBounds(10, 90, 150, 30);
        add(txt2);
        
        p = new JTextField();
        p.setBounds(10, 130, 150, 30);
        add(p);
        
        txt3 = new JLabel("Monto:");
        txt3.setBounds(10, 170, 150, 30);
        add(txt3);
        
        m = new JTextField();
        m.setBounds(10, 210, 150, 30);
        m.setEnabled(false);
        add(m);
        
        botones();
    }
    
    public void botones(){
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                com.setEnabled(true);
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        com = new JButton("Comprar");
        com.setBounds(10, 250, 130, 30);
        com.setEnabled(false);
        add(com);
        
        com.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                monto = Double.parseDouble(m.getText());
                idT = Integer.parseInt(combo.getSelectedItem().toString());
                if(monto<=listaTarjetas[idT].getDisponible()){
                    
                    listaClientes[idC].setDeuda(monto);
                    listaTarjetas[idT].setDeuda(monto, "DEP");
                    listaClientes[idC].setNoTransacciones();
                    
                    JOptionPane.showMessageDialog(null, "Compra realizada con exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                    
                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        ClientesInicio out = new ClientesInicio();
                        out.setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Precio del producto mayor al dinero disponible", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        
        can = new JButton("Cancelar");
        can.setBounds(150, 250, 130, 30);
        add(can);
        
        can.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientesDireccion re = new ClientesDireccion(idC);
                re.setVisible(true);
            }
            
        });
    }
}
