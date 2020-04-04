
package Interfaces;

import Logica.CallCenter;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Ser extends JFrame{
    
    ButtonGroup radio1, radio2;
    JRadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;
    JLabel txt1, txt2, txt3, txt4, txt5;
    JTextField m;
    JComboBox combo;
    JButton pagar, back;
    
    
    int idC, idL, noCuenta;
    String tipo;
    double monto;
    Date date = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public Ser(int idC, int idL, String tipo){
        super("Servicios");
        this.idC = idC;
        this.idL = idL;
        this.tipo = tipo;
        setSize(400, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
        txt1 = new JLabel("Servicio a Pagar: ");
        txt1.setBounds(50, 5, 150, 30);
        add(txt1);
        
        rbtn1 = new JRadioButton("Agua");
        rbtn1.setBounds(50, 40, 150, 30);
        add(rbtn1);
        
        rbtn2 = new JRadioButton("Luz");
        rbtn2.setBounds(50, 80, 150, 30);
        add(rbtn2);
        
        rbtn3 = new JRadioButton("Telefono");
        rbtn3.setBounds(50, 120, 150, 30);
        add(rbtn3);
        
        radio1 = new ButtonGroup();
        radio1.add(rbtn1);
        radio1.add(rbtn2);
        radio1.add(rbtn3);
        
        txt2 = new JLabel("Tipo de Pago");
        txt2.setBounds(50, 160, 150, 30);
        add(txt2);
        
        rbtn4 = new JRadioButton("Efectivo");
        rbtn4.setBounds(50, 200, 150, 30);
        add(rbtn4);
        
        rbtn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.setEnabled(false);
                m.setEnabled(true);
            }
        });
        
        rbtn5 = new JRadioButton("Cheque");
        rbtn5.setBounds(50, 240, 150, 30);
        add(rbtn5);
        
        rbtn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.setEnabled(true);
                m.setEnabled(true);
            }
        });
        
        radio2 = new ButtonGroup();
        radio2.add(rbtn4);
        radio2.add(rbtn5);
        
        txt5 = new JLabel("Cuentas Asociadas");
        txt5.setBounds(50, 280, 150, 30);
        add(txt5);
        
        combo = new JComboBox();
        for(int i=0; i<cCuentas; i++){
            if(listaCuentas[i].getIdCliente()==idC && listaCuentas[i].getTipo().equals("MONETARIA")){
                combo.addItem(listaCuentas[i].getId());
            }
        }
        combo.setBounds(50, 320, 150, 30);
        combo.setEnabled(false);
        add(combo);
                
        
        txt3 = new JLabel("Monto a pagar: ");
        txt3.setBounds(50, 360, 150, 30);
        add(txt3);
        
        m = new JTextField();
        m.setBounds(50, 400, 150, 30);
        m.setEnabled(false);
        add(m);
        
        txt4 = new JLabel(formato.format(date));
        txt4.setBounds(50, 440, 150, 30);
        add(txt4);
        
        botones();
        
    }
    
    public void botones(){
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                pagar.setEnabled(true);
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
         
         pagar = new JButton("Pagar Servicio");
         pagar.setBounds(50, 480, 150, 30);
         pagar.setEnabled(false);
         add(pagar);
         
         pagar.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                monto = Double.parseDouble(m.getText());
                
                if(rbtn4.isSelected()){
                    if(tipo.equals("CON")){
                        listaAgenciasA[idL].setEfectivo(monto, "DEP");
                        listaAgenciasA[idL].setNoUsos();
                    }else if(tipo.equals("SIN")){
                        listaAgencias[idL].setEfectivo(monto, "DEP");
                        listaAgencias[idL].setNoUsos();
                    }else if(tipo.equals("CALL")){
                        CallCenter.usoServicios();
                    }
                    JOptionPane.showMessageDialog(null, "Pago de Servicio Realizado con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                    
                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        ClientesInicio out = new ClientesInicio();
                        out.setVisible(true);
                    }
                    
                }else if(rbtn5.isSelected()){
                    noCuenta = Integer.parseInt(combo.getSelectedItem().toString());
                    if(monto<=listaCuentas[noCuenta].getMonto()){
                        if(tipo.equals("CON")){
                            listaAgenciasA[idL].setEfectivo(monto, "DEP");
                            listaAgenciasA[idL].setNoUsos();
                        }else if(tipo.equals("SIN")){
                            listaAgencias[idL].setEfectivo(monto, "DEP");
                            listaAgencias[idL].setNoUsos();
                        }else if(tipo.equals("CALL")){
                            CallCenter.usoServicios();
                        }
                        listaClientes[idC].setEfectivo(monto, "RET");
                        listaCuentas[noCuenta].setMonto(monto, "RET");
                        JOptionPane.showMessageDialog(null, "Pago de Servicio Realizado con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                        
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
                
             }
         
         });
         
         back = new JButton("Regresar");
         back.setBounds(210, 480, 150, 30);
         add(back);
         
         back.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                dispose();                
                if(tipo.equals("CALL")){
                    OpCallCenter call = new OpCallCenter(idC);
                    call.setVisible(true);
                }else{
                    FAgenciayA re = new FAgenciayA(idC,idL,tipo);
                    re.setVisible(true);
                }                
             }
         
         });
    }
}
