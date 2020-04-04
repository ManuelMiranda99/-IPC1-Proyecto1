
package Interfaces;

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cClientes;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaClientes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarCliente extends JFrame{
    
    //Objetos para la interfaz
    JLabel txtnombre, txtdireccion, txttelefono;
    JTextField nombre, direccion, telefono;
    JButton crear, cancelar;
    JComboBox combo;
    
    //Variables para logica
    String Nombre, Direccion, Telefono;
    int id;
    
    public EditarCliente(){
        super("Editar Cliente");
        setSize(400,450);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        combo = new JComboBox();
        for(int i=0;i<cClientes;i++){
            combo.addItem(listaClientes[i].getNombre());
        }
        combo.setBounds(90, 20, 210, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                id = combo.getSelectedIndex();
                nombre.enable(true);
                direccion.enable(true);
                telefono.enable(true);
                nombre.setText(listaClientes[id].getNombre());
                direccion.setText(listaClientes[id].getDireccion());
                telefono.setText(listaClientes[id].getTelefono());
            }            
        });
        
        txtnombre = new JLabel("Nombre: ");
        txtnombre.setBounds(90, 60, 100, 30);
        add(txtnombre);
        
        nombre = new JTextField();
        nombre.setBounds(90, 100, 210, 30);
        nombre.enable(false);
        add(nombre);
        
        txtdireccion = new JLabel("Direccion: ");
        txtdireccion.setBounds(90, 140, 100, 30);
        add(txtdireccion);
        
        direccion = new JTextField();
        direccion.setBounds(90, 180, 210, 30);
        direccion.enable(false);
        add(direccion);
        
        txttelefono = new JLabel("Telefono: ");
        txttelefono.setBounds(90, 220, 100, 30);
        add(txttelefono);
        
        telefono = new JTextField();
        telefono.setBounds(90, 260, 210, 30);
        telefono.enable(false);
        add(telefono);
                
        //Para agrerar botones y funcionalidad para telefono
        botones();
        
    }
    
    public void botones(){
        //Validacion para que el usuario solo pueda colocar numeros en el numero de telefono
        telefono.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
        
        //Boton Crear
        crear = new JButton("Editar");
        crear.setBounds(90, 300, 100, 30);        
        add(crear);
        
        
        crear.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado
            public void actionPerformed(ActionEvent e){     
                
                Nombre = nombre.getText();
                Direccion = direccion.getText();
                Telefono = telefono.getText();
                
                if(Nombre.length()==0 || Direccion.length()==0 || Telefono.length()==0){
                    JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio, llenelo para poder continuar", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }else{
                    if(Telefono.length()!=8){
                        JOptionPane.showMessageDialog(null, "Numero de Telefono ingresado incorrecto", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                    }else{                        
                        
                        listaClientes[id].setNombre(Nombre);
                        listaClientes[id].setDireccion(Direccion);
                        listaClientes[id].setTelefono(Telefono);
                        
                        JOptionPane.showMessageDialog(null, "Edicion de Cliente Exitosa", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        MenuAdmin menu = new MenuAdmin();
                        menu.setVisible(true);
                    }
                }
                
            }
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(200, 300, 100, 30);
        add(cancelar);
        
        cancelar.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado
            public void actionPerformed(ActionEvent e){   
                dispose();
                MenuAdmin menu = new MenuAdmin();
                menu.setVisible(true);
            }
        });
    }    
    
}
