
package Interfaces;

import Logica.CallCenter;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Transferencias extends JFrame{
    
    //Objetos Interfaz
    JComboBox combo1, combo2;
    JLabel txt1, txt2, txt3;
    JTextField m;
    JButton transferir, cancelar;
    
    int idC, noCR, noCD;
    double monto;
    public Transferencias(int idC){
        super("Transferencias");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
        this.idC = idC;
        
        txt1 = new JLabel("Cuenta de donde desea transferir el dinero:");
        txt1.setBounds(30, 20, 150, 30);
        add(txt1);
        
        combo1 = new JComboBox();
        for(int i=0; i<cCuentas;i++){
            if(listaCuentas[i].getIdCliente()==idC){
                combo1.addItem(listaCuentas[i].getId());
            }
        }
        combo1.setBounds(30, 60, 150, 30);
        add(combo1);
        
        
        txt2 = new JLabel("Cuenta a la que desea transferir el dinero:");
        txt2.setBounds(30, 100, 150, 30);
        add(txt2);
        
        combo2 = new JComboBox();
        for(int i=0; i<cCuentas;i++){
            combo2.addItem(listaCuentas[i].getId());
        }
        combo2.setBounds(30, 140, 150, 30);
        add(combo2);
        
        txt3 = new JLabel("Monto a transferir:");
        txt3.setBounds(30, 180, 150, 30);
        add(txt3);
        
        m = new JTextField();
        m.setBounds(30, 220, 150, 30);
        add(m);
        
        botones();
    }
    
    public void botones(){
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                transferir.setEnabled(true);
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        transferir = new JButton("Transferir");
        transferir.setBounds(30, 260, 150, 30);
        transferir.setEnabled(false);
        add(transferir);
        
        transferir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                noCR = Integer.parseInt(combo1.getSelectedItem().toString());
                noCD = Integer.parseInt(combo2.getSelectedItem().toString());
                monto = Double.parseDouble(m.getText());
                if(monto<=listaCuentas[noCR].getMonto()){
                    listaCuentas[noCR].setMonto(monto, "RET");
                    listaCuentas[noCD].setMonto(monto, "DEP");
                    listaClientes[listaCuentas[noCR].getIdCliente()].setEfectivo(monto, "RET");
                    listaClientes[listaCuentas[noCD].getIdCliente()].setEfectivo(monto, "DEP");
                    CallCenter.usoTransferencia();
                    
                    JOptionPane.showMessageDialog(null, "Transferencia realizada con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        ClientesInicio out = new ClientesInicio();
                        out.setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Monto ingresado mayor al monto en la cuenta a retirar", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(190, 260, 150, 30);
        add(cancelar);
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OpCallCenter call = new OpCallCenter(idC);
                call.setVisible(true);
            }
            
        });
    }
}
