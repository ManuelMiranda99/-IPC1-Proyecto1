
package Interfaces;

//Importacion de Bibliotecas a utilizar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuPrincipal extends JFrame{
    
    //Objetos para la creacion de la interfaz del Menu Principal    
    JButton btn1, btn2;
    JLabel img;
    
    public MenuPrincipal(){        
        super("Banco Del Exterior");
        this.setSize(WIDTH, HEIGHT);
        setSize(400,450);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        img = new JLabel(new ImageIcon("logoProyecto1.png"));        
        img.setBounds(100,20,200,200);
        add(img);
        Botones();        
    }
    
    public void Botones(){
        btn1 = new JButton("Administrador");
        btn1.setBounds(100, 240, 200, 50);
        btn1.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado
            public void actionPerformed(ActionEvent e){
                
                dispose();                
                LoginAdmin inicio = new LoginAdmin();        
                inicio.setVisible(true);
                
            }
        });
        add(btn1);
        
        btn2 = new JButton("Cliente");
        btn2.setBounds(100, 320, 200, 50);
        btn2.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                ClientesInicio clientes = new ClientesInicio();
                clientes.setVisible(true);
            }
        });
        add(btn2);
        
    }
}
