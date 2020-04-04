
package Interfaces;

//Importacion de Bibliotecas a utilizar
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.cClientes;
import static ipc1.proyecto1_201807394.IPC1Proyecto1_201807394.listaClientes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame{
    
    //Objetos para la interfaz MenuAdmin
    JMenuBar menu;
    JMenu clt, ab, aba, caj, tar, pre, emp, rep;
    JButton regresar;
    
    //Para Clientes
    JMenuItem crearclt, buscarclt, editarclt, eliminarclt;
    //Para Agencias Bancarias
    JMenuItem crearab, buscarab, editarab, eliminarab;
    //Para Agencias Bancarias con AutoBanco
    JMenuItem crearaba, buscaraba, editaraba, eliminaraba;
    //Para Cajeros
    JMenuItem crearcaj, buscarcaj, editarcaj, eliminarcaj;
    //Para Tarjetas
    JMenuItem autorizartar, rechazartar;
    //Para Prestamos
    JMenuItem autorizarpre, rechazarpre;
    //Para Empleados
    JMenuItem crearemp, buscaremp, editaremp, eliminaremp;    
    //Para Reportes
    JMenuItem repi;
    
    //Objetos Interfaz para Operaciones
    //Crear Cliente
    JLabel txtCnombre, txtCdireccion, txtCtelefono;
    JTextField Cnombre, Cdireccion, Ctelefono;
    JButton Ccrear, CCancelar;
    
    
    public MenuAdmin(){
        super("Banco Del Exterior: Menu Administrador");
        setSize(700,200);
        setLayout(null);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);        
        String listaDClientes[] = new String[cClientes];
        for(int i = 0; i<cClientes; i++){
            listaDClientes[i] = listaClientes[i].getNombre();
        }
        
        
        regresar = new JButton("Regresar");
        regresar.setBounds(20, 100, 130, 40);
        add(regresar);
        regresar.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el boton al ser presionado
            public void actionPerformed(ActionEvent e){
                dispose();
                MenuPrincipal inicio = new MenuPrincipal();        
                inicio.setVisible(true);
            }
        });
        construirMenu();
    }
    
    public void construirMenu(){
        //Barra
        this.menu = new JMenuBar();
        
        //Menus
        this.clt = new JMenu("Clientes");
        this.ab = new JMenu("Agencias Bancarias");
        this.aba = new JMenu("Agencias con Autobanco");
        this.caj = new JMenu("Cajeros");
        this.tar = new JMenu("Tarjetas");
        this.pre = new JMenu("Prestamos");
        this.emp = new JMenu("Empleados");
        this.rep = new JMenu("Reportes");
        
        //Items
        //Clientes
        this.crearclt = new JMenuItem("Crear");
        this.buscarclt = new JMenuItem("Buscar");
        this.editarclt = new JMenuItem("Editar");
        this.eliminarclt = new JMenuItem("Eliminar");
        //Agencias Bancarias
        this.crearab = new JMenuItem("Crear");
        this.buscarab = new JMenuItem("Buscar");
        this.editarab = new JMenuItem("Editar");
        this.eliminarab = new JMenuItem("Eliminar");
        //Agencias Bancarias con Autobanco
        this.crearaba = new JMenuItem("Crear");
        this.buscaraba = new JMenuItem("Buscar");
        this.editaraba = new JMenuItem("Editar");
        this.eliminaraba = new JMenuItem("Eliminar");
        //Cajeros
        this.crearcaj = new JMenuItem("Crear");
        this.buscarcaj = new JMenuItem("Buscar");
        this.editarcaj = new JMenuItem("Editar");
        this.eliminarcaj = new JMenuItem("Eliminar");
        //Empleados
        this.crearemp = new JMenuItem("Crear");
        this.buscaremp = new JMenuItem("Buscar");
        this.editaremp = new JMenuItem("Editar");
        this.eliminaremp = new JMenuItem("Eliminar");
        //Tarjeta
        this.autorizartar = new JMenuItem("Autorizar");
        this.rechazartar = new JMenuItem("Rechazar");
        //Prestamo
        this.autorizarpre = new JMenuItem("Autorizar");
        this.rechazarpre = new JMenuItem("Rechazar");
        //Reportes
        this.repi = new JMenuItem("Ingresar");
        
        this.menu();
    }
    
    public void menu(){
        
        this.menu.add(this.clt);
        this.clt.add(this.crearclt);
        this.clt.add(this.buscarclt);
        this.clt.add(this.editarclt);
        this.clt.add(this.eliminarclt);
        
        this.menu.add(this.ab);
        this.ab.add(this.crearab);
        this.ab.add(this.buscarab);
        this.ab.add(this.editarab);
        this.ab.add(this.eliminarab);
        
        this.menu.add(this.aba);
        this.aba.add(this.crearaba);
        this.aba.add(this.buscaraba);
        this.aba.add(this.editaraba);
        this.aba.add(this.eliminaraba);
        
        this.menu.add(this.caj);
        this.caj.add(this.crearcaj);
        this.caj.add(this.buscarcaj);
        this.caj.add(this.editarcaj);
        this.caj.add(this.eliminarcaj);
        
        this.menu.add(this.tar);
        this.tar.add(this.autorizartar);
        this.tar.add(this.rechazartar);
        
        this.menu.add(this.pre);
        this.pre.add(this.autorizarpre);
        this.pre.add(this.rechazarpre);
        
        this.menu.add(this.emp);
        this.emp.add(this.crearemp);
        this.emp.add(this.buscaremp);
        this.emp.add(this.editaremp);
        this.emp.add(this.eliminaremp);
        
        this.menu.add(this.rep);
        this.rep.add(this.repi);
        
        this.setJMenuBar(this.menu);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        operacionesItems();
        
    }
    
    //Lista Acabados: CrearCliente, CrearAgencia (Con y Sin), CrearCajero, CrearEmpleado
    
    public void operacionesItems(){
        //Inicio Items Clientes
        this.crearclt.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                CrearCliente crearC = new CrearCliente();
                crearC.setVisible(true);
            }
        });    //Listo
        
        this.buscarclt.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                BuscarCliente buscar = new BuscarCliente();
                buscar.setVisible(true);
            }
        });   //Listo
        
        this.editarclt.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EditarCliente editar = new EditarCliente();
                editar.setVisible(true);
            }
        });   //Listo
        
        this.eliminarclt.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EliminarCliente e1 = new EliminarCliente();
                e1.setVisible(true);
            }
        });
        //Fin Items Clientes
        
        //Inicio Items Agencias
        this.crearab.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){                
                dispose();
                CrearAgencias crearA = new CrearAgencias("SIN");
                crearA.setVisible(true);
            }
        });     //Listo
        
        this.buscarab.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                BuscarAgencias buscar = new BuscarAgencias("SIN");
                buscar.setVisible(true);
            }
        });    //Listo
        
        this.editarab.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EditarAgencia editar = new EditarAgencia("SIN");
                editar.setVisible(true);
            }
        });    //Listo
        
        this.eliminarab.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EliminarAgencia e2 = new EliminarAgencia();
                e2.setVisible(true);
            }
        });
        //Fin Items Agencias
        
        //Inicio Items Agencias con Autobanco
        this.crearaba.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                CrearAgencias crearA = new CrearAgencias("CON");
                crearA.setVisible(true);
            }
        });    //Listo
        
        this.buscaraba.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                BuscarAgencias buscar = new BuscarAgencias("CON");
                buscar.setVisible(true);
            }
        });   //Listo
        
        this.editaraba.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EditarAgencia editar = new EditarAgencia("CON");
                editar.setVisible(true);
            }
        });   //Listo
        
        this.eliminaraba.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EliminarAgenciaA e3 = new EliminarAgenciaA();
                e3.setVisible(true);
            }
        });
        //Fin Items Agencia con Autobanco
        
        //Inicio Items Cajero
        this.crearcaj.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                CrearCajeros CrearCa = new CrearCajeros();                
                CrearCa.setVisible(true);
            }
        });    //Listo
        
        this.buscarcaj.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                BuscarCajeros buscar = new BuscarCajeros();
                buscar.setVisible(true);
            }
        });   //Listo
        
        this.editarcaj.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EditarCajeros editar = new EditarCajeros();
                editar.setVisible(true);
            }
        });   //Listo
        
        this.eliminarcaj.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EliminarCajeros e4 = new EliminarCajeros();
                e4.setVisible(true);
            }
        });
        //Fin Items Cajero
                
        //Inicio Items Tarjeta
        this.autorizartar.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                AutorizarRechazarTyP ta = new AutorizarRechazarTyP("TARJETA","AUTORIZAR");
                ta.setVisible(true);
            }
        });
        
        this.rechazartar.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                AutorizarRechazarTyP tr = new AutorizarRechazarTyP("TARJETA","RECHAZAR");
                tr.setVisible(true);
            }
        });
        //Fin Items Tarjeta
        
        //Inicio Items Prestamos
        this.autorizarpre.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                AutorizarRechazarTyP pa = new AutorizarRechazarTyP("PRESTAMO","AUTORIZAR");
                pa.setVisible(true);
            }
        });
        
        this.rechazarpre.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                AutorizarRechazarTyP pr = new AutorizarRechazarTyP("PRESTAMO","RECHAZAR");
                pr.setVisible(true);
            }
        });
        //Fin Items Prestamos
        
        //Inicio Items Empleados
        this.crearemp.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                CrearEmpleado CrearE = new CrearEmpleado();
                CrearE.setVisible(true);
            }
        });    //Listo
        
        this.buscaremp.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                BuscarEmpleados buscar = new BuscarEmpleados();
                buscar.setVisible(true);
            }
        });   //Listo
        
        this.editaremp.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EditarEmpleado editar = new EditarEmpleado();
                editar.setVisible(true);
            }
        });   //Listo
        
        this.eliminaremp.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                EliminarEmpleados e5 = new EliminarEmpleados();
                e5.setVisible(true);
            }
        });
        //Fin Items Empleados
        
        //Inicio Reportes
        this.repi.addActionListener(new ActionListener(){
            @Override
            //Accion que realizara el item al ser presionado            
            public void actionPerformed(ActionEvent e){
                dispose();
                OperacionesReportes op = new OperacionesReportes();
                op.setVisible(true);
            }
        });
    }    
}
