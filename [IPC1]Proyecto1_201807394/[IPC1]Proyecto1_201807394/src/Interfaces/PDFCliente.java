
package Interfaces;

import Logica.CrearPDFClienteE;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cClientes;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jmiranda
 */
public class PDFCliente extends JFrame{
    
    JLabel txt;
    JComboBox combo;
    JButton crear, cancelar;
    
    int id;
    
    public PDFCliente(){
        super("Reporte Cliente");
        setSize(500, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        txt = new JLabel("Crear PDF:");
        txt.setBounds(20, 30, 300, 30);
        add(txt);
        
        combo = new JComboBox();
        for(int i=0;i<cClientes;i++){
            if(listaClientes[i].getNombre()==null){
                combo.addItem("");
            }else{
                combo.addItem(listaClientes[i].getNombre());
            }            
        }
        
        combo.setBounds(20, 70, 450, 30);
        add(combo);
        
        
        botones();
    }    
    
    public void botones(){
        crear = new JButton("Generar PDF");
        crear.setEnabled(false);
        crear.setBounds(20, 110, 145, 30);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(combo.getSelectedItem().equals("")){
                        
                    }else{
                        id = combo.getSelectedIndex();
                        CrearPDFClienteE crear = new CrearPDFClienteE(id);
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Algo sucedio mal, pruebe de nuevo", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });                     
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(305, 110, 145, 30);
        add(cancelar);
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OperacionesReportes menu = new OperacionesReportes();
                menu.setVisible(true);
            }
            
        });        
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                crear.setEnabled(true);
            }
            
        });        
    }
}
