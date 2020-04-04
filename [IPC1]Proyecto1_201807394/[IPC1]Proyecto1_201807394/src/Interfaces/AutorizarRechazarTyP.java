
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutorizarRechazarTyP extends JFrame{
    
    JButton ac, re;
    JComboBox combo;
    JLabel txt;
    
    int idT, idP;
    String ToP, AoR;
    
    public AutorizarRechazarTyP(String ToP, String AoR){
        super("Autorizar o Rechazar");
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        this.ToP = ToP;
        this.AoR = AoR;
        
        txt = new JLabel("Id de " + ToP + " a " + AoR);
        txt.setBounds(40, 20, 310, 30);
        add(txt);
        
        combo = new JComboBox();
        if(ToP.equals("TARJETA")){
            for(int i=0;i<cTarjetas;i++){
                if(listaTarjetas[i].getEstado().equals("PENDIENTE")){
                    combo.addItem(listaTarjetas[i].getId());
                }
            }
        }else{
            for(int i=0;i<cPrestamos;i++){
                if(listaPrestamos[i].getEstado().equals("PENDIENTE")){
                    combo.addItem(listaPrestamos[i].getId());
                }
            }
        }
        combo.setBounds(40, 60, 310, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ac.setEnabled(true);
            }
        
        });
        
        botones();
    }
    
    public void botones(){
        ac = new JButton(AoR);
        ac.setBounds(40, 100, 150, 30);
        ac.setEnabled(false);
        add(ac);
        
        ac.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(AoR.equals("AUTORIZAR")){
                    if(ToP.equals("TARJETA")){
                        idT = Integer.parseInt(combo.getSelectedItem().toString());                        
                        listaTarjetas[idT].setEstado("AUTORIZADO");                        
                        JOptionPane.showMessageDialog(null, "Tarjeta Autorizada con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        idP = Integer.parseInt(combo.getSelectedItem().toString());
                        listaPrestamos[idP].setEstado("AUTORIZADO");
                        listaClientes[listaPrestamos[idP].getIdCliente()].setDeuda(listaPrestamos[idP].getMonto());
                        JOptionPane.showMessageDialog(null, "Prestamo Autorizada con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else if(AoR.equals("RECHAZAR")){
                    if(ToP.equals("TARJETA")){
                        idT = Integer.parseInt(combo.getSelectedItem().toString());
                        listaTarjetas[idT].setEstado("RECHAZADO");
                        JOptionPane.showMessageDialog(null, "Tarjeta Rechazada con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        idP = Integer.parseInt(combo.getSelectedItem().toString());
                        listaPrestamos[idP].setEstado("RECHAZADO");
                        JOptionPane.showMessageDialog(null, "Prestamo Rechazado con Exito", "Banco del Exterior", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                int msj = JOptionPane.showConfirmDialog(null, "Desea realizar otra accion?", "Banco del Exterior", JOptionPane.YES_NO_OPTION);
                if(msj!=JOptionPane.YES_OPTION){
                    dispose();
                    MenuAdmin menu = new MenuAdmin();
                    menu.setVisible(true);
                }
            }
        
        });
        
        re = new JButton("Cancelar");
        re.setBounds(200, 100, 150, 30);
        add(re);
        
        re.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }
        });
    }
}
