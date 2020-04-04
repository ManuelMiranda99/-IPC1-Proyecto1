
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Dep extends JFrame{
    
    JComboBox combo;
    JLabel txt1, txt2;
    JTextField m;
    JButton dep, regresar;
    ButtonGroup radio;
    JRadioButton rbtn1, rbtn2;
    
    
    int idC, idL, noCuenta;
    String tipo;
    
    double monto;
    
    public Dep(int idC, int idL, String tipo){
        super("Deposito");
        this.idC = idC;
        this.idL = idL;
        this.tipo = tipo;
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
        rbtn1 = new JRadioButton("Cheque", false);
        rbtn1.setBounds(50, 10, 100, 30);
        add(rbtn1);
        
        rbtn2 = new JRadioButton("Efectivo", false);
        rbtn2.setBounds(50, 50, 100, 30);
        add(rbtn2);
        
        rbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.setEnabled(true);
            }        
        });
        
        rbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.setEnabled(true);
            }        
        });
        
        
        txt1 = new JLabel("Cuenta a la que desea depositar: ");
        txt1.setBounds(50, 90, 200, 30);
        add(txt1);
        
        combo = new JComboBox();
        for(int i=0;i<cCuentas;i++){
            combo.addItem(String.valueOf(listaCuentas[i].getId()));            
        }
        combo.setBounds(50, 130, 200, 30);
        combo.setEnabled(false);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dep.setEnabled(true);
            }
            
        });
        
        txt2 = new JLabel("Ingrese el monto: ");
        txt2.setBounds(50, 170, 150, 30);
        add(txt2);
        
        m = new JTextField();
        m.setBounds(50, 200, 150, 30);
        add(m);
        
        radio = new ButtonGroup();
        radio.add(rbtn1);
        radio.add(rbtn2);
        
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
        
        dep = new JButton("Depositar");
        dep.setBounds(50, 240, 150, 30);
        dep.setEnabled(false);
        add(dep);
        
        dep.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(m.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Monto a Depositar se encuentra vacio", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                }else{
                
                    monto = Double.parseDouble(m.getText());
                    noCuenta = Integer.parseInt(combo.getSelectedItem().toString());

                    listaClientes[listaCuentas[noCuenta].getIdCliente()].setEfectivo(monto, "DEP");
                    if(tipo.equals("SIN")){
                        listaAgencias[idL].setEfectivo(monto, "DEP");
                        listaAgencias[idL].setNoUsos();
                    }else{
                        listaAgenciasA[idL].setEfectivo(monto, "DEP");
                        listaAgenciasA[idL].setNoUsos();
                    }                

                    listaCuentas[noCuenta].setMonto(monto, "DEP");

                    JOptionPane.showMessageDialog(null, "Deposito Realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);

                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        ClientesInicio out = new ClientesInicio();
                        out.setVisible(true);
                    }
                }  
            }
            
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(210, 240, 150, 30);
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
