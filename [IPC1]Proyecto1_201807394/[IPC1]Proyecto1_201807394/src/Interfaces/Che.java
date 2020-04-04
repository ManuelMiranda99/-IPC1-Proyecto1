
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Che extends JFrame{
    
    //Objetos interfaz
    JComboBox combo1, combo2;
    JLabel txt1, txt2, txt3, fecha;
    JTextField m;
    JButton cambio, back;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup radio;
    
    int idC, idL, noCuentaR, noCuentaD;
    String tipo;
    Date date = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    double monto;
    
    public Che(int idC, int idL, String tipo){
        super("Cambio de Cheques");
        this.idC = idC;
        this.idL = idL;
        this.tipo = tipo;        
        setSize(400, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        
        rbtn1 = new JRadioButton("Efectivo", false);
        rbtn1.setBounds(50, 20, 150, 30);
        add(rbtn1);
        
        rbtn2 = new JRadioButton("Depositado", false);
        rbtn2.setBounds(50, 60, 150, 30);
        add(rbtn2);
        
        rbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                combo2.setEnabled(false);
            }        
        });
        
        rbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                combo2.setEnabled(true);
            }        
        });
        
        txt1 = new JLabel("No. de Cuenta de retiro");
        txt1.setBounds(50, 100, 150, 30);
        add(txt1);
        
        combo1 = new JComboBox();
        for(int i=0;i<cCuentas;i++){
            if(listaCuentas[i].getIdCliente()==idC){
                if(listaCuentas[i].getTipo().equals("MONETARIA")){
                    combo1.addItem(listaCuentas[i].getId());
                }
            }
        }
        combo1.setBounds(50, 140, 150, 30);
        add(combo1);
        
        txt2 = new JLabel("No. de Cuenta a depositar");
        txt2.setBounds(50, 180, 150, 30);
        add(txt2);
        
        combo2 = new JComboBox();
        for(int i=0;i<cCuentas;i++){
            combo2.addItem(listaCuentas[i].getId());
        }
        combo2.setBounds(50, 220, 150, 30);
        combo2.setEnabled(false);
        add(combo2);
        
        fecha = new JLabel(formato.format(date));
        fecha.setBounds(50, 260, 150, 30);
        add(fecha);
        
        txt3 = new JLabel("Monto del Cheque");
        txt3.setBounds(50, 300, 150, 30);
        add(txt3);
        
        m = new JTextField();
        m.setBounds(50, 340, 150, 30);
        add(m);
        
        radio = new ButtonGroup();
        radio.add(rbtn1);
        radio.add(rbtn2);
                
        
        botones();
    }
    
    public void botones(){
        
        combo1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cambio.setEnabled(true);
            }
            
        });
        
        
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        cambio = new JButton("Cambiar Cheque");
        cambio.setBounds(50, 380, 150, 30);
        cambio.setEnabled(false);
        add(cambio);
        
        cambio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                monto = Double.parseDouble(m.getText());
                noCuentaR = Integer.parseInt(combo1.getSelectedItem().toString());
                noCuentaD = Integer.parseInt(combo2.getSelectedItem().toString());                         
                
                if(m.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Monto a Depositar se encuentra vacio", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }else if(monto<=listaCuentas[noCuentaR].getMonto()){                    
                    
                    listaClientes[idC].setEfectivo(monto, "RET");
                    if(rbtn2.isSelected()){
                        listaClientes[listaCuentas[noCuentaD].getIdCliente()].setEfectivo(monto, "DEP");
                    }
                    
                    if(tipo.equals("SIN")){
                        listaAgencias[idL].setEfectivo(monto, "RET");
                        listaAgencias[idL].setNoUsos();
                    }else if(tipo.equals("CON")){
                        listaAgenciasA[idL].setEfectivo(monto, "RET");
                        listaAgenciasA[idL].setNoUsos();
                    }
                    
                    JOptionPane.showMessageDialog(null, "Cambio de Cheque realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);                    
                    int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                    if(msj!=JOptionPane.YES_OPTION){
                        dispose();
                        ClientesInicio out = new ClientesInicio();
                        out.setVisible(true);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Monto ingresaro mayor al dinero dentro de cuenta", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);                    
                }
                
            }
        
        });
        
        back = new JButton("Regresar");
        back.setBounds(210, 380, 150, 30);
        add(back);
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FAgenciayA re = new FAgenciayA(idC,idL,tipo);
                re.setVisible(true);
            }
        
        });
    }
}
