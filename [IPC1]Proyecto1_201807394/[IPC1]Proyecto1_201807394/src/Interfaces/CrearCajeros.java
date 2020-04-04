
package Interfaces;

import Logica.CajerosAutomaticos;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cCajeros;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaCajeros;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CrearCajeros extends JFrame{
    
    //Objetos Interfaz
    JLabel txtubicacion, txtefectivo;
    JTextField ubicacion, efectivo;
    JButton crear, cancelar;
    
    String Ubicacion, Efectivo;
    Double EfectivoF;
    
    public CrearCajeros(){
        super("Crear Cajero");
        setSize(400,450);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        txtubicacion = new JLabel("Ubicacion: ");
        txtubicacion.setBounds(100, 100, 210, 20);
        add(txtubicacion);
        
        ubicacion = new JTextField();
        ubicacion.setBounds(100, 130, 210, 20);
        add(ubicacion);
        
        txtefectivo = new JLabel("Efectivo Inicial: ");
        txtefectivo.setBounds(100, 160, 210, 20);
        add(txtefectivo);
        
        efectivo = new JTextField();
        efectivo.setBounds(100, 190, 210, 20);
        add(efectivo);
        
        numero();
        botones();
    }
    
    //Validacion para que solo coloque numeros en el TextField efectivo
    public void numero(){
        efectivo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
    }
    
    public void botones(){
        crear = new JButton("Crear");
        crear.setBounds(100, 230, 100, 30);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Ubicacion = ubicacion.getText();
                Efectivo = efectivo.getText();
                
                if(Ubicacion.length()==0 || Efectivo.length()==0){
                    JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio, llenelo para poder continuar", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }else{
                    EfectivoF = Double.parseDouble(Efectivo);
                    listaCajeros[cCajeros] = new CajerosAutomaticos(cCajeros, Ubicacion, "ACTIVO", EfectivoF);
                    JOptionPane.showMessageDialog(null, "Creacion de Cajero Exitosa", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                    cCajeros+=1;
                    dispose();
                    MenuAdmin menu = new MenuAdmin();
                    menu.setVisible(true);
                }
            }            
        });   
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(210, 230, 100, 30);
        add(cancelar);
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }
        });
    }
    
}
