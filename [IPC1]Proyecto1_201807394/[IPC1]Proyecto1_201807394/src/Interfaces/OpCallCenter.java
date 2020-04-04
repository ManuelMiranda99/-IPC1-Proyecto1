
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OpCallCenter extends JFrame{
    
    JButton ser, pt, pp, tran, can;
    
    int idC, c1, c2;
    public OpCallCenter(int idC){
        super("Call Center");
        setSize(250, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                
        c1=0;
        c2=0;
        
        this.idC = idC;
        botones();
    }
    
    public void botones(){
        ser = new JButton("Pago de Servicios");
        ser.setBounds(20, 20, 200, 30);
        add(ser);
        
        ser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ser s = new Ser(idC, 0, "CALL");
                s.setVisible(true);
            }
        
        });
        
        pt = new JButton("Pago de Tarjeta");
        pt.setBounds(20, 60, 200, 30);
        add(pt);
        
        pt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<cTarjetas;i++){
                    if(listaTarjetas[i].getIdCliente()==idC && listaTarjetas[i].getEstado().equals("AUTORIZADO")){
                        c1=1;
                        break;
                    }
                }
                if(c1==1){
                    dispose();
                    PagoTyP pta = new PagoTyP(idC, 0, "CALL", "TARJETA");
                    pta.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente no posee una tarjeta autorizada para pagar", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }
            }
        
        });
        
        pp = new JButton("Pago de Prestamo");
        pp.setBounds(20, 100, 200, 30);
        add(pp);
        
        pp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<cPrestamos;i++){
                    if(listaPrestamos[i].getIdCliente()==idC && listaPrestamos[i].getEstado().equals("AUTORIZADO")){
                        c2=1;
                        break;
                    }
                }
                if(c2==1){
                    dispose();
                    PagoTyP ppr = new PagoTyP(idC, 0, "CALL", "PRESTAMO");
                    ppr.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente no posee un prestamo autorizado para pagar", "Banco del Exterior", JOptionPane.WARNING_MESSAGE);
                }                                
            }
        
        });
        
        tran = new JButton("Transferencias");
        tran.setBounds(20, 140, 200, 30);
        add(tran);
        
        tran.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Transferencias t = new Transferencias(idC);
                t.setVisible(true);
            }
        
        });
        
        can = new JButton("Cancelar");
        can.setBounds(20, 180, 200, 30);
        add(can);
        
        can.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientesDireccion re = new ClientesDireccion(idC);
                re.setVisible(true);
            }
        
        });
    }
    
}
