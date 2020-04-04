
package Interfaces;

import Logica.CallCenter;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PagoTyP extends JFrame{
    
    //Objetos Interfaz
    JLabel txt1, txt2;
    ButtonGroup radio;
    JRadioButton rbtn1, rbtn2;
    JComboBox combo;
    JTextField m;
    JButton pagar, re;
    
    int idC, idL, idT, idP;
    double monto;
    String tipo, ToP;
    public PagoTyP(int idC, int idL, String tipo, String ToP){
        super("Pago");
        setSize(350, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.ToP = ToP;
        this.tipo = tipo;
        this.idC = idC;
        this.idL = idL;
        
        txt1 = new JLabel("ID de " + ToP + " a pagar");
        txt1.setBounds(20, 20, 150, 30);
        add(txt1);
        
        combo = new JComboBox();
        if(ToP.equals("TARJETA")){
            for(int i=0;i<cTarjetas;i++){
                if(listaTarjetas[i].getEstado().equals("AUTORIZADO")){
                    if(listaTarjetas[i].getIdCliente()==idC){
                        combo.addItem(listaTarjetas[i].getId());
                    }
                }
            }
        }else{
            for(int i=0;i<cPrestamos;i++){
                if(listaPrestamos[i].getEstado().equals("AUTORIZADO")){
                    if(listaPrestamos[i].getIdCliente()==idC){
                        combo.addItem(listaPrestamos[i].getId());
                    }
                }
            }
        }
        combo.setBounds(20, 60, 150, 30);
        add(combo);
        
        rbtn1 = new JRadioButton("Cheque", false);
        rbtn1.setBounds(20, 100, 150, 30);
        add(rbtn1);
        
        rbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setEnabled(true);
            }
        
        });
        
        rbtn2 = new JRadioButton("Efectivo", false);
        rbtn2.setBounds(20, 140, 150, 30);
        add(rbtn2);
        
        rbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setEnabled(true);
            }
        
        });
        
        radio = new ButtonGroup();
        radio.add(rbtn1);
        radio.add(rbtn2);
        
        txt2 = new JLabel("Monto a pagar");
        txt2.setBounds(20, 180, 150, 30);
        add(txt2);
        
        m = new JTextField();
        m.setBounds(20, 220, 150, 30);
        m.setEnabled(false);
        add(m);
        
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
        
        pagar = new JButton("Pagar");
        pagar.setBounds(20, 260, 150, 30);
        pagar.setEnabled(false);
        add(pagar);
        
        pagar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                monto = Double.parseDouble(m.getText());
                if(ToP.equals("TARJETA")){
                    idT = Integer.parseInt(combo.getSelectedItem().toString());
                    if(monto<=listaTarjetas[idT].getDeuda()){
                        listaTarjetas[idT].setDeuda(monto, "RET");
                        listaClientes[idC].setDeuda(monto, tipo);
                        JOptionPane.showMessageDialog(null, "Pago Realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Monto Ingresado mayor al monto debido", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                    }                    
                    if(tipo.equals("CON")){
                        listaAgencias[idL].setEfectivo(monto, "DEP");
                        listaAgencias[idL].setNoUsos();
                    }else if(tipo.equals("SIN")){
                        listaAgenciasA[idL].setEfectivo(monto, "DEP");
                        listaAgenciasA[idL].setNoUsos();
                    }else if(tipo.equals("CALL")){
                        if(ToP.equals("TARJETA")){
                            CallCenter.usoTarjeta();
                        }else{
                            CallCenter.usoPrestamo();
                        }
                    }
                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        if(tipo.equals("CALL")){
                            OpCallCenter cal = new OpCallCenter(idC);
                            cal.setVisible(true);
                        }else{
                            FAgenciayA a = new FAgenciayA(idC, idL, tipo);
                            a.setVisible(true);
                        }
                    }
                }else{
                    idP = Integer.parseInt(combo.getSelectedItem().toString());
                    if(monto<=listaPrestamos[idP].getMonto()){
                        listaPrestamos[idP].setMontoPagado(monto);
                        listaClientes[idC].setDeuda(monto, tipo);
                        JOptionPane.showMessageDialog(null, "Pago Realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Monto Ingresado mayor al monto debido", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                    }                    
                    if(tipo.equals("CON")){
                        listaAgencias[idL].setEfectivo(monto, "DEP");
                        listaAgencias[idL].setNoUsos();
                    }else if(tipo.equals("SIN")){
                        listaAgenciasA[idL].setEfectivo(monto, "DEP");
                        listaAgenciasA[idL].setNoUsos();
                    }else if(tipo.equals("CALL")){
                        if(ToP.equals("TARJETA")){
                            CallCenter.usoTarjeta();
                        }else{
                            CallCenter.usoPrestamo();
                        }
                    }
                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        if(tipo.equals("CALL")){
                            OpCallCenter cal2 = new OpCallCenter(idC);
                            cal2.setVisible(true);
                        }else{
                            FAgenciayA a = new FAgenciayA(idC, idL, tipo);
                            a.setVisible(true);
                        }
                    }
                }                                                               
            }
        
        });
        
        re = new JButton("Regresar");
        re.setBounds(180, 260, 150, 30);
        add(re);
        
        re.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(tipo.equals("CALL")){
                    OpCallCenter call = new OpCallCenter(idC);
                    call.setVisible(true);
                }else{
                    FAgenciayA a = new FAgenciayA(idC, idL, tipo);
                    a.setVisible(true);
                }
            }
        
        });
    }
}
