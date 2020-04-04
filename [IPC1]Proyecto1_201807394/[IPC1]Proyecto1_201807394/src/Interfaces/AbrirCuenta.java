
package Interfaces;

import Logica.*;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class AbrirCuenta extends JFrame{
    
    //Objetos Interfaz
    JButton crear, regresar;
    JTextField m;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup radio;
    JLabel txt;
    
    int idC, idL;
    double monto;
    String tipo, tipoC;    
    Date date = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public AbrirCuenta(int idC, int idL, String tipo){
        super("Abrir Cuenta");
        this.idC = idC;
        this.idL = idL; 
        this.tipo = tipo;
        setSize(250, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        rbtn1 = new JRadioButton("Monetaria");
        rbtn1.setBounds(20, 20, 100, 30);
        add(rbtn1);
        
        rbtn2 = new JRadioButton("Ahorro");
        rbtn2.setBounds(20, 60, 100, 30);
        add(rbtn2);
        
        rbtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setEnabled(rootPaneCheckingEnabled);
            }
            
        });
        
        rbtn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setEnabled(rootPaneCheckingEnabled);
            }
            
        });
        
        radio = new ButtonGroup();
        radio.add(rbtn1);
        radio.add(rbtn2);
        
        txt = new JLabel("Monto Inicial");
        txt.setBounds(20, 100, 100, 30);
        add(txt);
        
        m = new JTextField();
        m.setBounds(20, 140, 100, 30);
        m.setEnabled(false);
        add(m);
        
        botones();
    }
    
    public void botones(){
        //Solo numeros
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                crear.setEnabled(true);
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        crear = new JButton("Crear");
        crear.setBounds(20, 180, 100, 30);
        crear.setEnabled(false);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {   
                monto = Double.parseDouble(m.getText().toString());
                if(rbtn1.isSelected()){
                    tipoC = "MONETARIA";
                }else{
                    tipoC = "AHORRO";
                }
                listaCuentas[cCuentas] = new Cuentas(cCuentas, idC, tipoC, monto, formato.format(date));
                listaClientes[idC].setEfectivo(monto, "DEP");
                listaClientes[idC].setNoCuentas();
                
                if(tipo.equals("SIN")){
                    listaAgencias[idL].setEfectivo(monto, "DEP");
                    listaAgencias[idL].setNoUsos();
                }else if(tipo.equals("CON")){
                    listaAgenciasA[idL].setEfectivo(monto, "DEP");
                    listaAgenciasA[idL].setNoUsos();
                }
                
                JOptionPane.showMessageDialog(null, "Creacion de Cuenta Exitosa", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                cCuentas+=1;
                int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                if(msj!=JOptionPane.YES_OPTION){
                    dispose();
                    ClientesInicio out = new ClientesInicio();
                    out.setVisible(true);
                }
            }
            
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(130, 180, 100, 30);
        add(regresar);
        
        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AtencionCliente a = new AtencionCliente(idC, idL, tipo);
                a.setVisible(true);
            }
            
        });
    }
}
