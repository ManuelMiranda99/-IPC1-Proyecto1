

package Interfaces;

import Logica.Prestamos;
import Logica.Tarjeta;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class Solicitar extends JFrame{
    
    //Objetos Interfaz
    JLabel txt;
    JTextField m;
    JButton sol, can;
    
    int idC, idL;
    String tipo, tipoS;
    double monto;
    Date date = new Date();
    Calendar calendario = Calendar.getInstance();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public Solicitar(int idC, int idL, String tipo, String tipoS){
        
        super(tipoS);
        this.idC = idC;
        this.idL = idL; 
        this.tipo = tipo;
        this.tipoS = tipoS;
        setSize(250, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        calendario.setTime(date);
        //Para fecha de vencimiento se le sumo 3 anos a la fecha de solicitud
        calendario.add(Calendar.DAY_OF_YEAR, 1092);
        
        if(tipoS.equals("Prestamo")){
            txt = new JLabel("Monto del prestamo a Solicitar");
        }else{
            txt = new JLabel("Limite de Credito a Solicitar");
        }
        txt.setBounds(20, 20, 210, 30);
        add(txt);
        
        m = new JTextField();
        m.setBounds(20, 60, 210, 30);
        add(m);        
       
        botones();
    }
    
    public void botones(){
        m.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                sol.setEnabled(true);
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        sol = new JButton("Solicitar");
        sol.setBounds(20, 100, 100, 30);
        sol.setEnabled(false);
        add(sol);
        sol.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                monto = Double.parseDouble(m.getText().toString());
                if(tipoS.equals("Prestamo")){
                    listaPrestamos[cPrestamos] = new Prestamos(cPrestamos, idC, "PENDIENTE", monto, formato.format(date));
                    cPrestamos+=1;
                    JOptionPane.showMessageDialog(null, "Solicitud de Prestamo realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    listaTarjetas[cTarjetas] = new Tarjeta(cTarjetas, idC, "PENDIENTE", monto, formato.format(calendario.getTime()));
                    cTarjetas+=1;
                    JOptionPane.showMessageDialog(null, "Solicitud de Tarjeta realizado con exito", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                }
                
                if(tipo.equals("SIN")){
                    listaAgencias[idL].setNoUsos();
                }else if(tipo.equals("CON")){
                    listaAgenciasA[idL].setNoUsos();
                }
                
                int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                if(msj!=JOptionPane.YES_OPTION){
                    dispose();
                    ClientesInicio out = new ClientesInicio();
                    out.setVisible(true);
                }
            }
        
        });
        
        can = new JButton("Cancelar");
        can.setBounds(130, 100, 100, 30);
        add(can);
        can.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AtencionCliente a = new AtencionCliente(idC, idL, tipo);
                a.setVisible(true);
            }
        });        
    }
}
