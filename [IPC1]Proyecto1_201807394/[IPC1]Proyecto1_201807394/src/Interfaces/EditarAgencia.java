
package Interfaces;

/*-----------------------------Aun Falta--------------------------------------Ver Nota------------------------------------------------*/

import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgencia;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cAgenciaA;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgencias;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaAgenciasA;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarAgencia extends JFrame{
    
    //Objetos Interfaz
    JLabel txtnoCajas, txtnoEscritorios, txtnoCajasA, txtnoEmpleados, txtnombre, txtdireccion, txttelefono, txtefectivo;
    JTextField noCajas, noEscritorios, noCajasA, noEmpleados, nombre, direccion, telefono, efectivo;
    JButton crear, cancelar;
    JComboBox combo;
    
    String Nombre, Direccion, Telefono, NoCajas, NoEscritorios, NoCajasA, NoEmpleados, Efectivo, tipo;
    int NoCajasF, NoEscritoriosF, NoCajasAF, NoEmpleadosF, id;
    double EfectivoF;
    
    public EditarAgencia(String tipo){
    super("Editar Agencia");
        setSize(400,450);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                
        this.tipo = tipo;
        
        combo = new JComboBox();
        if(tipo.equals("SIN")){
            for(int i=0;i<cAgencia;i++){
                combo.addItem(listaAgencias[i].getNombre());
            }
        }else if(tipo.equals("CON")){
            for(int i=0;i<cAgenciaA;i++){
                combo.addItem(listaAgenciasA[i].getNombre());
            }
        }
        combo.setBounds(45, 20, 210, 30);
        add(combo);
        
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                id = combo.getSelectedIndex();
                
                nombre.enable(true);
                direccion.enable(true);
                telefono.enable(true);
                efectivo.enable(true);
                noCajas.enable(true);
                noEscritorios.enable(true);
                noEmpleados.enable(true);

                if(tipo.equals("CON")){
                    noCajasA.setEnabled(true);
                }
                
                if(tipo.equals("CON")){
                    nombre.setText(listaAgenciasA[id].getNombre());
                    direccion.setText(listaAgenciasA[id].getDireccion());
                    telefono.setText(listaAgenciasA[id].getTelefono());
                    efectivo.setText(String.valueOf(listaAgenciasA[id].getEfectivo()));
                    noCajas.setText(String.valueOf(listaAgenciasA[id].getNoCajas()));
                    noEscritorios.setText(String.valueOf(listaAgenciasA[id].getNoEscritoriosServicioCliente()));
                    noCajasA.setText(String.valueOf(listaAgenciasA[id].getNoCajasAutobanco()));
                    noEmpleados.setText(String.valueOf(listaAgenciasA[id].getNoEmpleados()));
                }else{
                    nombre.setText(listaAgencias[id].getNombre());
                    direccion.setText(listaAgencias[id].getDireccion());
                    telefono.setText(listaAgencias[id].getTelefono());
                    efectivo.setText(String.valueOf(listaAgencias[id].getEfectivo()));
                    noCajas.setText(String.valueOf(listaAgencias[id].getNoCajas()));
                    noEscritorios.setText(String.valueOf(listaAgencias[id].getNoEscritoriosServicioCliente()));
                    noEmpleados.setText(String.valueOf(listaAgencias[id].getNoEmpleados()));
                }
                
                
            }            
        });
        
        txtnombre = new JLabel("Nombre: ");
        txtnombre.setBounds(20+25, 60, 150, 20);
        add(txtnombre);
        
        nombre = new JTextField();
        nombre.setBounds(180+25, 60, 150, 20);
        add(nombre);
        
        txtdireccion = new JLabel("Direccion: ");
        txtdireccion.setBounds(20+25, 90, 150, 20);
        add(txtdireccion);
        
        direccion = new JTextField();
        direccion.setBounds(180+25, 90, 150, 20);
        add(direccion);
        
        txttelefono = new JLabel("Telefono: ");
        txttelefono.setBounds(20+25, 120, 150, 20);
        add(txttelefono);
        
        telefono = new JTextField();
        telefono.setBounds(180+25, 120, 150, 20);
        add(telefono);
        
        txtefectivo = new JLabel("Efectivo: ");
        txtefectivo.setBounds(20+25, 150, 150, 20);
        add(txtefectivo);
        
        efectivo = new JTextField();
        efectivo.setBounds(180+25, 150, 150, 20);
        add(efectivo);
        
        txtnoCajas = new JLabel("Numero de Cajas: ");
        txtnoCajas.setBounds(20+25, 180, 150, 20);
        add(txtnoCajas);
        
        noCajas = new JTextField();
        noCajas.setBounds(180+25, 180, 150, 20);
        add(noCajas);
        
        txtnoEscritorios = new JLabel("Numero de Escritorios: ");
        txtnoEscritorios.setBounds(20+25, 210, 150, 20);
        add(txtnoEscritorios);
        
        noEscritorios = new JTextField();
        noEscritorios.setBounds(180+25, 210, 150, 20);
        add(noEscritorios);
        
        
        txtnoCajasA = new JLabel("Numero de Cajas Autobanco: ");
        txtnoCajasA.setBounds(20+25, 240, 150, 20);
        add(txtnoCajasA);

        noCajasA = new JTextField("0");
        noCajasA.setBounds(180+25, 240, 150, 20);
        add(noCajasA);            
        if(tipo.equals("SIN")){
            noCajasA.setEnabled(false);
        }
        
        txtnoEmpleados = new JLabel("Numero de Empleados: ");
        txtnoEmpleados.setBounds(20+25, 270, 150, 20);
        add(txtnoEmpleados);
        
        noEmpleados = new JTextField();
        noEmpleados.setBounds(180+25, 270, 150, 20);
        add(noEmpleados);
                
        nombre.enable(false);
        direccion.enable(false);
        telefono.enable(false);
        efectivo.enable(false);
        noCajas.enable(false);
        noEscritorios.enable(false);
        noCajasA.enable(false);
        noEmpleados.enable(false);
        
        numeros1();
        numeros2();
        numeros3();
        numeros4();
        numeros5();
        numeros6();
        botones();
    }
    
    //Validacion para que el usuario solo pueda colocar numeros en los TextFields necesarios
    public void numeros1(){        
        telefono.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
    }    
    public void numeros2(){
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
    public void numeros3(){
        noCajas.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
    }    
    public void numeros4(){
        noEscritorios.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
    }    
    public void numeros5(){
        noCajasA.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
    }    
    public void numeros6(){
        noEmpleados.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char num = e.getKeyChar();
                
                if(((num < '0') || (num > '9')) && (num != '\b')){
                    e.consume();
                }
            }
        });
    }
    
    //Accion y Agregacion de Botones junto con Logica
    public void botones(){
        crear = new JButton("Editar");
        crear.setBounds(20+25, 300, 150, 30);
        add(crear);
        
        crear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Nombre = nombre.getText();
                Direccion = direccion.getText();
                Telefono = telefono.getText();
                NoCajas = noCajas.getText();
                NoCajasA = noCajasA.getText();
                NoEscritorios = noEscritorios.getText();
                NoEmpleados = noEmpleados.getText();
                Efectivo = efectivo.getText();                
                
                if(Nombre.length()==0 || Direccion.length()==0 || Telefono.length()==0 || NoCajas.length()==0 ||
                   NoEscritorios.length()==0 || NoCajasA.length()==0 || NoEmpleados.length()==0 || Efectivo.length()==0){
                    JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio, llenelo para poder continuar", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                }else{
                    if(Telefono.length()!=8){
                        JOptionPane.showMessageDialog(null, "Numero de Telefono ingresado incorrecto", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);
                    }else{
                        NoCajasF = Integer.parseInt(NoCajas);
                        NoEscritoriosF = Integer.parseInt(NoEscritorios);
                        NoCajasAF = Integer.parseInt(NoCajasA);
                        NoEmpleadosF = Integer.parseInt(NoEmpleados);
                        EfectivoF = Double.parseDouble(Efectivo);
                        
                        if(tipo.equals("CON")){
                            listaAgenciasA[id].setNombre(Nombre);
                            listaAgenciasA[id].setDireccion(Direccion);
                            listaAgenciasA[id].setTelefono(Telefono);
                            listaAgenciasA[id].setNoCajas(NoCajasF);
                            listaAgenciasA[id].setNoEscritoriosServicioCliente(NoEscritoriosF);
                            listaAgenciasA[id].setNoCajasAutobanco(NoCajasAF);
                            listaAgenciasA[id].setNoEmpleados(NoEmpleadosF);
                            listaAgenciasA[id].setEfectivo(EfectivoF);
                        }else{
                            listaAgencias[id].setNombre(Nombre);
                            listaAgencias[id].setDireccion(Direccion);
                            listaAgencias[id].setTelefono(Telefono);
                            listaAgencias[id].setNoCajas(NoCajasF);
                            listaAgencias[id].setNoEscritoriosServicioCliente(NoEscritoriosF);
                            listaAgencias[id].setNoEmpleados(NoEmpleadosF);
                            listaAgencias[id].setEfectivo(EfectivoF);
                        }
                        
                        
                        
                        
                        JOptionPane.showMessageDialog(null, "Edicion de Agencia Exitosa", "Banco Del Exterior",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        MenuAdmin menu = new MenuAdmin();
                        menu.setVisible(true);
                    }
                }
                
            }            
        });
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(180+25, 300, 150, 30);
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
