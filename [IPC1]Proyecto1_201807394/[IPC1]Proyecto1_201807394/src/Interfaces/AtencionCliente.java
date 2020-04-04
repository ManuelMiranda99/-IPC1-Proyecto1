
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgencias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class AtencionCliente extends JFrame{
    
    //Objetos Interfaz
    JButton aC, sP, sT, regresar;
    
    int idC, idL;
    String tipo;
    public AtencionCliente(int idC, int idL, String tipo){
        super("Agencia " + listaAgencias[idL].getNombre());
        this.idC = idC;
        this.idL = idL; 
        this.tipo = tipo;
        setSize(250, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        botones();
    }
    
    public void botones(){
        aC = new JButton("Abrir Cuenta");
        aC.setBounds(50, 20, 150, 30);
        add(aC);
        
        aC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AbrirCuenta a = new AbrirCuenta(idC, idL, tipo);
                a.setVisible(true);
            }
        
        });
        
        sP = new JButton("Solicitar Prestamo");
        sP.setBounds(50, 60, 150, 30);
        add(sP);
        
        sP.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Solicitar s = new Solicitar(idC, idL, tipo, "Prestamo");
                s.setVisible(true);
            }
        
        });
        
        sT = new JButton("Solicitar Tarjeta");
        sT.setBounds(50, 100, 150, 30);
        add(sT);
        
        sT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Solicitar s = new Solicitar(idC, idL, tipo, "Tarjeta");
                s.setVisible(true);
            }
        
        });
        
        regresar = new JButton("Regresar");
        regresar.setBounds(50, 140, 150, 30);
        add(regresar);
        
        regresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(tipo.equals("SIN")){                    
                    OpAgencia c = new OpAgencia(idC, idL);
                    c.setVisible(true);
                }else{
                    OpAgenciaA cA = new OpAgenciaA(idC, idL);
                    cA.setVisible(true);
                }
                
            }
        
        });
    }
    
}
