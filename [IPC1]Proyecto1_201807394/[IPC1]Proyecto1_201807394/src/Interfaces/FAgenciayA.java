
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FAgenciayA extends JFrame{
    
    JButton dep, ret, che, ser, pT, pP, back;
    
    String tipo;
    int idC, idL, c1, c2, c3;
    public FAgenciayA(int idC, int idL, String tipo){
        super("Agencia");
        this.idC = idC;
        this.idL = idL;
        this.tipo = tipo;
        setSize(300, 325);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                
        c1=0;
        c2=0;
        c3=0;
        
        botones();
    }
    
    public void botones(){
        dep = new JButton("Depositar");
        dep.setBounds(50, 10, 200, 30);
        add(dep);
        
        dep.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Dep d = new Dep(idC,idL, tipo);
                d.setVisible(true);
            }
        
        });
        
        ret = new JButton("Retirar");
        ret.setBounds(50, 50, 200, 30);
        add(ret);
        
        ret.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ret r = new Ret(idC, idL, tipo);
                r.setVisible(true);
            }
        
        });
        
        che = new JButton("Cheques");
        che.setBounds(50, 90, 200, 30);
        add(che);
        
        che.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<cCuentas;i++){
                    if(listaCuentas[i].getIdCliente()==idC && listaCuentas[i].getTipo().equals("MONETARIA")){                        
                        c1=1;
                        break;
                    }
                }
                
                if(c1==1){
                    dispose();
                    Che c = new Che(idC, idL, tipo);
                    c.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente no posee una cuenta monetaria para realizar cheques", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }
            }
        
        });
        
        ser = new JButton("Pago Servicios");
        ser.setBounds(50, 130, 200, 30);
        add(ser);
        
        ser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ser s = new Ser(idC, idL, tipo);
                s.setVisible(true);
            }
        
        });
        
        pT = new JButton("Pago Tarjetas");
        pT.setBounds(50, 170, 200, 30);
        add(pT);
        
        pT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<cTarjetas;i++){
                    if(listaTarjetas[i].getEstado().equals("AUTORIZADO")){
                        if(listaTarjetas[i].getIdCliente()==idC){
                            c2=1;
                            break;
                        }
                    }
                }
                
                if(c2==1){
                    dispose();
                    PagoTyP pt = new PagoTyP(idC, idL, tipo, "TARJETA");
                    pt.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente no posee una tarjeta autorizada", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }
            }
        
        });
        
        pP = new JButton("Pago Prestamos");
        pP.setBounds(50, 210, 200, 30);
        add(pP);
        
        pP.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<cPrestamos;i++){
                    if(listaPrestamos[i].getEstado().equals("AUTORIZADO")){
                        if(listaPrestamos[i].getIdCliente()==idC){
                            c3=1;
                            break;
                        }
                    }
                }
                
                if(c3==1){
                    dispose();
                    PagoTyP pp = new PagoTyP(idC, idL, tipo, "PRESTAMO");
                    pp.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente no posee un prestamo autorizado", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }
            }
        
        });
        
        back = new JButton("Regresar");
        back.setBounds(50, 250, 200, 30);
        add(back);
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(tipo.equals("SIN")){
                    OpAgencia regresar = new OpAgencia(idC, idL);
                    regresar.setVisible(true);
                }else{
                    OpAgenciaA re = new OpAgenciaA(idC, idL);
                    re.setVisible(true);
                }
            }
            
        });
    }
    
}
