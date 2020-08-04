package pe.edu.upeu.proyectofinal;

import pe.edu.upeu.dao.AppCrud;
import pe.edu.upeu.materiales.Almacenamiento;
import pe.edu.upeu.materiales.ProcesoPedidos;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

/**
 * Hello world!
 *
 */
public class App {

    static LeerTeclado teclado=new LeerTeclado();
    static LeerArchivo leerArc;
    static AppCrud dao=new AppCrud();
    static UtilsX utilx=new UtilsX();

    public static Object[][] introProducto(){
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

    public static Object[][] procesoPedidos(){
        System.out.println("--------------------------Sistema de Pedido--------------------------------");
        ProcesoPedidos Pedidos=new ProcesoPedidos();
        LeerArchivo leerProdPedido=new LeerArchivo("Almacenamiento.txt");
        dao=new AppCrud();
        Object[][] listaProduc=dao.listarContenido(leerProdPedido);
        for(int lista=0;lista<listaProduc.length;lista++){
            System.out.print(listaProduc[lista][0]+"="+listaProduc[lista][1]+" ("+listaProduc[lista][2]+") , \n");
        }
        Pedidos.setProductoId(teclado.leer("", "Ingrese el ID del producto que desea hacer pedido"));
        Pedidos.setNombreProducto(teclado.leer("", "Ingrese nombre del producto que desea hacer pedido"));
        Pedidos.setCantidadProducto(teclado.leer(0.0, "Ingrese la cantidad del producto que desea hacer pedido"));
        listaProduc=dao.buscarContenido(leerProdPedido, 0, Pedidos.getProductoId());
        Pedidos.setCostoProducto(Double.parseDouble(listaProduc[0][2].toString()));
        Pedidos.setCostoTotal(Pedidos.getCostoProducto()*Pedidos.getCantidadProducto());
        dao=new AppCrud();
        leerArc=new LeerArchivo("Pedidos.txt");
        return dao.agregarContenido(leerArc, Pedidos);
    }
    public static void main( String[] args ){
        System.out.println( "--------------------------Eliga un Algoritmo--------------------------" );
        try {  
                              
            char opcion='S'; //S=SI, N=NO
            int numAlgoritm=1;     
            

            do{            
                numAlgoritm=teclado.leer(0,
                "Ingrese el numero de Algoritmo que desea probar: \n"+
                "1= Control de Acceso\n"+
                "2= Agregar Productos\n"+
                "3= Registrar Pedido Nuevo");
               
                switch(numAlgoritm){
                    case 1: 
                        new ControlDeAcceso();         
                    break;
                    case 2: 
                        dao=new AppCrud();
                        dao.imprimirLista(introProducto());
                    break;  
                    case 3: 
                        dao=new AppCrud();  
                        dao.imprimirLista(procesoPedidos());
                    break;
                    default: System.out.println("La opcion No existe!!"); break;
                }            
                opcion=teclado.leer(' ', "Desea Probar mas Algoritmos? S=SI, N=NO");
            }while(opcion=='S' || opcion=='s');   
        } catch (Exception er) {
            System.out.println(er.getMessage());
    }
}
}