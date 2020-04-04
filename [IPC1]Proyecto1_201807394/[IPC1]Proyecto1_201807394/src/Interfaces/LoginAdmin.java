
package Interfaces;

//Importacion de Bibliotecas a utilizar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdmin extends JFrame{
    
    //Objetos para la interfaz LoginAdmin
    JLabel img, txt1, txt2, txte;
    JButton btn1, btn2;
    JTextField user;
    JPasswordField pass;
    
    public LoginAdmin(){
        super("Login");
        setSize(400,400);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        img = new JLabel(new ImageIcon("usuario.png"));        
        img.setBounds(100,20,200,200);
        add(img);
        txt1 = new JLabel("Usuario:");
        txt1.setBounds(90,205,100,20);
        add(txt1);
        
        user = new JTextField();
        user.setBounds(90, 225, 220, 20);
        add(user);
        
        txt2 = new JLabel("Contraseña:");
        txt2.setBounds(90,250,100,20);
        add(txt2);
        
        pass = new JPasswordField();
        pass.setBounds(90,270, 220, 20);
        add(pass);
        
        Botones();

    }
    
    public void Botones(){
        setLayout(null);
        btn1 = new JButton("Ingresar");
        btn1.setBounds(90, 310, 100, 30);
        add(btn1);
        btn1.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado
            public void actionPerformed(ActionEvent e){
                String us, pa;
                us = user.getText();
                pa = pass.getText();
                
                if(us.equals("admin") & pa.equals("123456")){
                    dispose();
                    MenuAdmin inicio = new MenuAdmin();
                    inicio.setVisible(true);
                }else{
                    user.setText("");
                    pass.setText("");
                    JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrectos, pruebe de nuevo", "Banco Del Exterior",JOptionPane.WARNING_MESSAGE);                    
                }
            }
        });
        
        btn2 = new JButton("Regresar");
        btn2.setBounds(210, 310, 100, 30);
        add(btn2);
        btn2.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado
            public void actionPerformed(ActionEvent e){
                dispose();
                MenuPrincipal inicio = new MenuPrincipal();        
                inicio.setVisible(true);
            }
        });
    }
}
