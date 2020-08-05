package pe.edu.upeu.proyectofinal;

import java.io.Console;

import pe.edu.upeu.dao.AppCrud;
import pe.edu.upeu.dao.ProcesoVentas;
import pe.edu.upeu.materiales.Almacenamiento;
import pe.edu.upeu.materiales.Proceso;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

/**
 * Hello world!
 *
 */
public class App {

    
    static LeerTeclado teclado = new LeerTeclado();
    static LeerArchivo leerArc;
    static AppCrud dao=new AppCrud();
    static UtilsX utilx=new UtilsX();
    

    public static Object[][] introProducto(){
        System.out.println("-----------------------Introducción de Productos--------------------------");
        leerArc=new LeerArchivo("Almacenamiento.txt");
        Almacenamiento Almac=new Almacenamiento();
        Almac=new Almacenamiento();
        Almac.setProductoId(teclado.leer("", "ingrese el ID de Nuevo Producto"));
        Almac.setNombreProducto(teclado.leer("", "ingrese el Nombre de Nuevo Producto"));
        Almac.setCostoProducto(teclado.leer(0.0, "ingrese el costo de Nuevo Producto"));
        Almac.setProductoStock(teclado.leer("", "ingrese la Cantidad de Productos en Stock"));
        Almac.setProducDefectuosos(teclado.leer("", "ingrese la Cantidad de Productos Defectuosos"));
        dao=new AppCrud();
        return dao.agregarContenido(leerArc, Almac);
    }


    public static void main( String[] args ){
        System.out.println( "--------------------------Eliga un Algoritmo--------------------------" );
        
            Console con = System.console();    

            try {  
                              
            char opcion='S'; //S=SI, N=NO
            int numAlgoritm=1;     
            String usuario=teclado.leer("", "Ingrese Usuario:");      
            System.out.println("Ingrese su clave: ");   
            char[] password=con.readPassword();   
            if(usuario.equals("alan") &&  String.valueOf(password).equals("123456")){  

            do{            
                numAlgoritm=teclado.leer(0,
                "Ingrese el numero de Algoritmo que desea probar: \n"+
                "1= Control de Acceso\n"+
                "2= Agregar Productos\n"+
                "3= Registrar Pedido Nuevo\n"+
                "4= Reporte de Nueva Venta");
                //String fechaInicio;
                        //String fechaFinal;
                switch(numAlgoritm){
                    case 1: 
                        new ControlDeAcceso();         
                    break;
                    case 2: 
                        utilx.clearConsole();
                        dao=new AppCrud();
                        dao.imprimirLista(introProducto());
                    break;  
                    case 3: 
                        utilx.clearConsole();
                        ProcesoVentas Pedidos=new ProcesoVentas();  
                        Pedidos.procesoPedidos();
                        Pedidos.ProcesoVentas();
                    break;
                    case 4:
                        utilx.clearConsole();
                        reporteVentas reporte=new reporteVentas();  
                        reporte.ReporteVentasRangoFecha(
                            teclado.leer("", "Ingrese Fecha de Inicio: (dd-MM-yyyy):"),
                            teclado.leer("", "Ingrese Fecha de Fin: (dd-MM-yyyy):" ));
                    break;

                    default: System.out.println("La opcion No existe!!"); break;
                }            
                opcion=teclado.leer(' ', "Desea Probar mas Algoritmos? S=SI, N=NO");
            }while(opcion=='S' || opcion=='s');   
        }
        } catch (Exception er) {
            System.out.println(er.getMessage());
    }
}
}

