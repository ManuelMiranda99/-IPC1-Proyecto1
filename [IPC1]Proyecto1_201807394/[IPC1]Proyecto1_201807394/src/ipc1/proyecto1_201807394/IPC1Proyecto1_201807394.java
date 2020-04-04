
package ipc1.proyecto1_201807394;

import Interfaces.MenuPrincipal;
import Logica.*;

public class IPC1Proyecto1_201807394 {

    //Arrays que se utilizaran dentro de todo el programa
    /*-----------------------------------------------------------------------------
            ARRAY CLIENTES
    */
    public static Clientes listaClientes[] = new Clientes[1000];
    public static int cClientes;
    /*-----------------------------------------------------------------------------
            ARRAY AGENCIA BANCARIA
    */
    public static AgenciaBancaria listaAgencias[] = new AgenciaBancaria[1000];
    public static int cAgencia;
    /*-----------------------------------------------------------------------------
            ARRAY AGENCIA BANCARIA CON AUTOBANCO
    */
    public static AgenciaBancariaA listaAgenciasA[] = new AgenciaBancariaA[1000];
    public static int cAgenciaA;
    /*-----------------------------------------------------------------------------
            ARRAY EMPLEADOS    
    */
    public static Empleados listaEmpleados[] = new Empleados[1000];    
    public static int cEmpleados;
    /*-----------------------------------------------------------------------------
            ARRAY CAJEROS AUTOMATIVOS
    */
    public static CajerosAutomaticos listaCajeros[] = new CajerosAutomaticos[1000];    
    public static int cCajeros;
    /*-----------------------------------------------------------------------------
            ARRAY CUENTAS
    */
    public static Cuentas listaCuentas[] = new Cuentas[1000];
    public static int cCuentas;
    /*-----------------------------------------------------------------------------
            ARRAY PRESTAMOS
    */
    public static Prestamos listaPrestamos[] = new Prestamos[1000];
    public static int cPrestamos=0;
    /*-----------------------------------------------------------------------------
            ARRAY TARJETAS
    */
    public static Tarjeta listaTarjetas[] = new Tarjeta[1000];
    public static int cTarjetas=0;
    /*-----------------------------------------------------------------------------
            OBJETO OPERACIONES CALLCENTER
    */
    public static CallCenter operacionesCallCenter = new CallCenter();

    
    
    public static void main(String[] args) {
        asignacionInicial();
        MenuPrincipal inicio = new MenuPrincipal();        
        inicio.setVisible(true);
    }

    public static void asignacionInicial(){
        //Asignacion Clientes Iniciales
        listaClientes[0] = new Clientes(0, 2, "Victor Leon Perez", "Zona 10", "99524633");
        listaClientes[1] = new Clientes(1, 1, "Manuel Marti Fuentes", "Zona 1", "13373660");
        listaClientes[2] = new Clientes(2, 1, "Hugo Iglesias Rodriguez", "Las Charcas", "94176289");
        listaClientes[3] = new Clientes(3, 2, "Inés Grau Vega", "Antigua Guatemala", "41344864");
        listaClientes[4] = new Clientes(4, 1, "Miriam Moya Cabrera", "Mixco", "45152866");
        listaClientes[5] = new Clientes(5, 1, "Raquel Navarro Ramirez", "Zona 2", "66053179");
        listaClientes[6] = new Clientes(6, 2, "Rocío Domenech Cano", "Zona 5", "63847691");
        listaClientes[7] = new Clientes(7, 1, "Gerard Aguilar Gimenez", "Zona 10", "65083646");
        listaClientes[8] = new Clientes(8, 1, "Miguel Dominguez Pascual", "Zona 1", "88134039");
        listaClientes[9] = new Clientes(9, 1, "Blanca Vidal Esteban", "San Lucas Sacatepequez", "54185995");
        cClientes = 10;
        
        //Asignacion Agencias Bancarias Iniciales        
        listaAgencias[0] = new AgenciaBancaria(0, 2, 3, 4, "MirafloresS", "Miraflores", "28985377", 50000);
        listaAgencias[1] = new AgenciaBancaria(1, 2, 3, 3, "Zona 10S", "Zona 10", "10565751", 50000);
        listaAgencias[2] = new AgenciaBancaria(2, 2, 3, 3, "Zona 1S", "Zona 1", "76069068", 50000);
        listaAgencias[3] = new AgenciaBancaria(3, 2, 3, 3, "Zona 2S", "Zona 2", "44900764", 50000);
        listaAgencias[4] = new AgenciaBancaria(4, 2, 3, 3, "Antigua GuatemalaS", "5ta Calle Poniente", "25906114", 50000);
        cAgencia = 5;
        
        //Asignacion Agencias Bancarias con Autobanco Iniciales
        listaAgenciasA[0] = new AgenciaBancariaA(5, 2, 3, 2, 3, "Zona 3C", "Zona 3", "44283406", 50000);
        listaAgenciasA[1] = new AgenciaBancariaA(6, 2, 3, 2, 3, "Zona 10C", "Zona 10", "74406864", 50000);
        listaAgenciasA[2] = new AgenciaBancariaA(7, 2, 3, 2, 3, "Zona 1C", "Zona 1", "04678355", 50000);
        listaAgenciasA[3] = new AgenciaBancariaA(8, 2, 3, 2, 3, "Zona 2C", "Zona 2", "42125466", 50000);
        listaAgenciasA[4] = new AgenciaBancariaA(9, 2, 3, 2, 3, "Antigua GuatemalaC", "4ta Calle Poniente", "56296276", 50000);
        cAgenciaA = 5;
        
        //Asignacion Cuentas Iniciales
        listaCuentas[0] = new Cuentas(0, 0, "AHORRO", 2000, "15/03/2019");
        listaCuentas[1] = new Cuentas(1, 0, "MONETARIA", 5000, "14/02/2019");
        listaCuentas[2] = new Cuentas(2, 1, "AHORRO", 1000, "10/03/2019");
        listaCuentas[3] = new Cuentas(3, 2, "MONETARIA", 2000, "23/03/2019");
        listaCuentas[4] = new Cuentas(4, 3, "AHORRO", 500, "20/03/2019");
        listaCuentas[5] = new Cuentas(5, 3, "AHORRO", 1000, "02/03/2019");
        listaCuentas[6] = new Cuentas(6, 4, "AHORRO", 1000, "02/03/2019");
        listaCuentas[7] = new Cuentas(7, 5, "MONETARIA", 3000, "02/01/2019");
        listaCuentas[8] = new Cuentas(8, 6, "AHORRO", 2000, "15/03/2019");
        listaCuentas[9] = new Cuentas(9, 6, "AHORRO", 5000, "14/02/2019");
        listaCuentas[10] = new Cuentas(10, 7, "MONETARIA", 4500, "15/01/2019");
        listaCuentas[11] = new Cuentas(11, 8, "MONETARIA", 3500, "15/03/2019");
        listaCuentas[12] = new Cuentas(12, 9, "AHORRO", 2500, "10/03/2019");
        listaCuentas[13] = new Cuentas(13, 9, "AHORRO", 2500, "10/03/2019");
        cCuentas = 14;
        
        //Asignacion Cajeros Iniciales
        listaCajeros[0] = new CajerosAutomaticos(0, "Zona 10", "ACTIVO", 10000);
        listaCajeros[1] = new CajerosAutomaticos(1, "Zona 11", "ACTIVO", 10000);
        listaCajeros[2] = new CajerosAutomaticos(2, "Zona 1", "ACTIVO", 10000);
        listaCajeros[3] = new CajerosAutomaticos(3, "Zona 9", "ACTIVO", 10000);
        listaCajeros[4] = new CajerosAutomaticos(4, "Antigua Guatemala", "ACTIVO", 10000);
        listaCajeros[5] = new CajerosAutomaticos(5, "Zona 2", "ACTIVO", 10000);
        listaCajeros[6] = new CajerosAutomaticos(6, "San Lucas Sacatepequez", "ACTIVO", 10000);
        listaCajeros[7] = new CajerosAutomaticos(7, "Zona 7", "ACTIVO", 10000);
        listaCajeros[8] = new CajerosAutomaticos(8, "Zona 3", "ACTIVO", 10000);
        listaCajeros[9] = new CajerosAutomaticos(9, "Mixco", "ACTIVO", 10000);
        cCajeros = 10;
        
        //Asignacion Empleados Iniciales
        //Agencias
        listaEmpleados[0] = new Empleados("Lola Ramos Delgado", "MirafloresS");
        listaEmpleados[1] = new Empleados("Diego Castro Cabrera", "MirafloresS");
        listaEmpleados[2] = new Empleados("Jordi Puig Romero", "MirafloresS");
        listaEmpleados[3] = new Empleados("Miguel Blanco Ruiz", "Zona 10C");
        listaEmpleados[4] = new Empleados("Berta Ruiz Parra", "Zona 10S");
        listaEmpleados[5] = new Empleados("Salma Iglesias Montero", "Zona 10C");
        listaEmpleados[6] = new Empleados("Manuela Blanco Torres", "Zona 1C");
        listaEmpleados[7] = new Empleados("Enrique Bosch Flores", "Zona 1S");
        listaEmpleados[8] = new Empleados("Éric Costa Mendez", "Zona 1S");
        listaEmpleados[9] = new Empleados("Leyre Alonso Herrera", "Zona 2C");
        listaEmpleados[10] = new Empleados("Lucía Leon Dominguez", "Zona 2C");
        listaEmpleados[11] = new Empleados("Martín Rodriguez Sanz", "Zona 2S");
        listaEmpleados[12] = new Empleados("Joel Gil Navarro", "Antigua GuatemalaC");
        listaEmpleados[13] = new Empleados("Juan Flores Aguilar", "Antigua GuatemalaS");
        listaEmpleados[14] = new Empleados("Adriana Domenech Muñoz", "Antigua GuatemalaS");
        listaEmpleados[15] = new Empleados("Lara Aguilar Iglesias", "Zona 3S");
        listaEmpleados[16] = new Empleados("Alexia Ramirez Herrera", "Zona 3S");
        listaEmpleados[17] = new Empleados("Mikel Vazquez Garrido", "Zona 3C");
        listaEmpleados[18] = new Empleados("Martín Jimenez Vidal", "Zona 10S");
        listaEmpleados[19] = new Empleados("Cristian Duran Gil", "Zona 10S");
        listaEmpleados[20] = new Empleados("Jana Riera Muñoz", "Zona 10C");
        listaEmpleados[21] = new Empleados("Iris Cano Medina", "Zona 1C");
        listaEmpleados[22] = new Empleados("Paula Castillo Medina", "Zona 1C");
        listaEmpleados[23] = new Empleados("Francisco Javier Flores Serrano", "Zona 1C");
        listaEmpleados[24] = new Empleados("Joel Cortes Gallardo", "Zona 2S");
        listaEmpleados[25] = new Empleados("Miriam Leon Castillo", "Zona 2C");
        listaEmpleados[26] = new Empleados("Alejandro Morales Dominguez", "Zona 2S");
        listaEmpleados[27] = new Empleados("José Costa Rubio", "Antigua GuatemalaC");
        listaEmpleados[28] = new Empleados("Óscar Iglesias Sanchez", "Antigua GuatemalaC");
        listaEmpleados[29] = new Empleados("Yeray Perez Gallardo", "Antigua GuatemalaC");
        //CallCenters
        listaEmpleados[30] = new Empleados("Alberto Hernandez Guerrer", "CallCenter");
        listaEmpleados[31] = new Empleados("Luis Fernandez Lozano", "CallCenter");
        listaEmpleados[32] = new Empleados("lnés Hernandez Marquez", "CallCenter");
        listaEmpleados[33] = new Empleados("Victoria Ramos Nuñez", "CallCenter");
        listaEmpleados[34] = new Empleados("Enrique Riera Nuñez", "CallCenter");
        listaEmpleados[35] = new Empleados("Marti Ruiz Torres", "CallCenter");
        listaEmpleados[36] = new Empleados("Sergio Pascual Santiago", "CallCenter");
        listaEmpleados[37] = new Empleados("Aitor Carmona Ruiz", "CallCenter");
        listaEmpleados[38] = new Empleados("Samuel Mas Castillo", "CallCenter");
        listaEmpleados[39] = new Empleados("Blanca Fuentes Sanchez", "CallCenter");
        //Departamentos
        listaEmpleados[40] = new Empleados("Omar Dominguez Vargas", "Gerencia");
        listaEmpleados[41] = new Empleados("Manuel Mora Santiago", "Gerencia");
        listaEmpleados[42] = new Empleados("Aroa Roca Sanz", "Departamento de Marketing");
        listaEmpleados[43] = new Empleados("Raúl Moya Lopez", "Departamento de Marketing");
        listaEmpleados[44] = new Empleados("Daniel Medina Nuñez", "Departamento de Informatica");
        listaEmpleados[45] = new Empleados("Ainhoa Moya Vidal", "Departamento de Informatica");
        listaEmpleados[46] = new Empleados("Nadia Iglesias Molina", "Departamento Financiero");
        listaEmpleados[47] = new Empleados("Óliver Reyes Morales", "Departamento Financiero");
        listaEmpleados[48] = new Empleados("Santiago Tomas Nuñez", "Departamento de Reclamos");
        listaEmpleados[49] = new Empleados("Antonio Sole Suarez", "Departamento de Reclamos");
        listaEmpleados[50] = new Empleados("Noa Sola Carrasco", "Departamento de Cobros");
        listaEmpleados[51] = new Empleados("Malak Cano Vicente", "Departamento de Cobros");
        cEmpleados = 52;       
        
        for(int i=0;i<cClientes;i++){
            listaClientes[i].asignarEfectivoI();
        }
        
    }
}
