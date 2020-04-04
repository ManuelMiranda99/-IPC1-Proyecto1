
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Ret extends JFrame{
    
    JComboBox combo;
    JLabel txt1, txt2;
    JTextField m;
    JButton dep, regresar;
    
    
    int idC, idL, noCuenta;
    String tipo;
    
    double monto;
    
    public Ret(int idC, int idL, String tipo){
        super("Retiro");
        this.idC = idC;
        this.idL = idL;
        this.tipo = tipo;
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);         
        
        
        txt1 = new JLabel("Cuentas asociadas: ");
        txt1.setBounds(50, 50, 150, 30);
        add(txt1);
        
        combo = new JComboBox();
        for(int i=0;i<cCuentas;i++){
            if(listaCuentas[i].getIdCliente()==listaClientes[idC].getId()){
                combo.addItem(String.valueOf(listaCuentas[i].getId()));
            }
        }
        combo.setBounds(50, 90, 200, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dep.setEnabled(true);
            }
            
        });
        
        txt2 = new JLabel("Ingrese el monto: ");
        txt2.setBounds(50, 130, 150, 30);
        add(txt2);
        
        m = new JTextField();
        m.setBounds(50, 170, 150, 30);
        add(m);
                
        
        botones();
    }
    
    public void botones(){
        
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        dep = new JButton("Retirar");
        dep.setBounds(50, 220, 150, 30);
        dep.setEnabled(false);
        add(dep);
        
        dep.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                monto = Double.parseDouble(m.getText());
                noCuenta = Integer.parseInt(combo.getSelectedItem().toString());
                if(m.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Monto a Retirar se encuentra vacio", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                }else if(monto <= listaCuentas[noCuenta].getMonto()){
                                        

                    listaClientes[idC].setEfectivo(monto, "RET");
                    if(tipo.equals("SIN")){
                        listaAgencias[idL].setEfectivo(monto, "RET");
                        listaAgencias[idL].setNoUsos();
                    }else if(tipo.equals("CON")){
                        listaAgenciasA[idL].setEfectivo(monto, "RET");
                        listaAgenciasA[idL].setNoUsos();
                    }

                    listaCuentas[noCuenta].setMonto(monto, "RET");

                    JOptionPane.showMessageDialog(null, "Retiro Realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);

                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        ClientesInicio out = new ClientesInicio();
                        out.setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Monto ingresado mayor al dinero dentro de la cuenta", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(210, 220, 150, 30);
        add(regresar);

        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FAgenciayA re = new FAgenciayA(idC,idL,tipo);
                re.setVisible(true);
            }
            
        });
    }
    
}
