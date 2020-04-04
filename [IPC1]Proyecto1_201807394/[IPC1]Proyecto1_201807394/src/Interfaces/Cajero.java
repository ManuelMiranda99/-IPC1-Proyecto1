
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Cajero extends JFrame{
    
    //Objetos Interfaz
    JComboBox combo;
    JTextField m;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup radio;
    JButton retirar, cancelar;
    
    int idC, idL, noCuenta;
    double monto;
    public Cajero(int idC, int idL){
        super("Cajero");
        this.idC = idC;
        this.idL = idL;
        setSize(300, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);   
        
        
        combo = new JComboBox();
        for(int i=0; i<cCuentas;i++){
            if(listaCuentas[i].getIdCliente()==idC){
                combo.addItem(listaCuentas[i].getId());
            }
        }
        combo.setBounds(50, 30, 200, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rbtn1.setEnabled(true);
                rbtn2.setEnabled(true);
            }
        });
        
        m = new JTextField();
        m.setBounds(50, 70, 200, 30);
        m.setEnabled(false);
        add(m);
        
        rbtn1 = new JRadioButton("Retirar", false);
        rbtn1.setBounds(50, 110, 200, 30);
        rbtn1.setEnabled(false);
        add(rbtn1);
        
        rbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setText("");
                m.setEnabled(true);
            }
        });
        
        rbtn2 = new JRadioButton("Consultar", false);
        rbtn2.setBounds(50, 150, 200, 30);
        rbtn2.setEnabled(false);
        add(rbtn2);
        
        rbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setEnabled(false);
                m.setText(String.valueOf(listaCuentas[Integer.parseInt(combo.getSelectedItem().toString())].getMonto()));
            }
        });
        
        radio = new ButtonGroup();
        radio.add(rbtn1);
        radio.add(rbtn2);
        
        botones();
        
    }
    
    public void botones(){
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                retirar.setEnabled(true);
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
         
         retirar = new JButton("Retirar");
         retirar.setBounds(50, 190, 200, 30);
         retirar.setEnabled(false);
         add(retirar);
         
         retirar.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 noCuenta = Integer.parseInt(String.valueOf(combo.getSelectedItem()));
                 monto = Double.parseDouble(m.getText());
                 if(monto<=listaCuentas[noCuenta].getMonto()){
                     if(monto<=listaCajeros[idL].getEfectivo()){
                        listaClientes[idC].setEfectivo(monto, "RET");
                        listaCuentas[noCuenta].setMonto(monto, "RET");
                        listaCajeros[idL].setEfectivo(monto, "RET");
                        listaCajeros[idL].setNoTransacciones();
                        
                        JOptionPane.showMessageDialog(null, "Retiro realizado con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                        int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                        if(msj!=JOptionPane.YES_OPTION){
                            dispose();
                            ClientesInicio out = new ClientesInicio();
                            out.setVisible(true);
                        }
                        
                     }else{
                         JOptionPane.showMessageDialog(null, "Monto ingresado mayor a dinero dentro del cajero", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                     }                  
                 }else{
                     JOptionPane.showMessageDialog(null, "Monto ingresado mayor a dinero dentro de cuenta", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                 }
                 
             }
         
         });
         
         cancelar = new JButton("Cancelar");
         cancelar.setBounds(50, 230, 200, 30);
         add(cancelar);
         
         cancelar.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 dispose();
                 ClientesDireccion c = new ClientesDireccion(idC);
                 c.setVisible(true);
             }
         
         });         
    }
}
