package pe.edu.upeu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upeu.materiales.Almacenamiento;
import pe.edu.upeu.materiales.Proceso;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;

public class ProcesoPedidos extends AppCrud{
    LeerArchivo leerProdPedidoX;
    LeerArchivo leerProdPedido;
    Proceso Pedidos;
    LeerTeclado teclado=new LeerTeclado();
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");

    public String generadorId(LeerArchivo leerProdPedidoX, int numColum, String prefijo){
        int numX=1;
        Object[][] data=listarContenido(leerProdPedidoX);
        if(data!=null){
            numX=Integer.parseInt(data[data.length-1][numColum].toString().substring(1))+1;
        }
        return prefijo+""+numX;
    }
    public Object[][] procesoPedidos(){
        System.out.println("--------------------------Sistema de Pedido--------------------------------");
        leerProdPedido=new LeerArchivo("Almacenamiento.txt");
        Object[][] listaProduc=listarContenido(leerProdPedido);
        for(int lista=0;lista<listaProduc.length;lista++){
            System.out.print(listaProduc[lista][0]+"="+listaProduc[lista][1]+" ("+listaProduc[lista][2]+") , \n");
        }
        Pedidos=new Proceso();
        leerProdPedido=new LeerArchivo("Pedidos.txt");
        Pedidos.setNumeroPedido(generadorId(leerProdPedidoX, 0, "V"));
        
        Pedidos.setProductoId(teclado.leer("", "Ingrese el ID del producto que desea hacer pedido"));
        Pedidos.setNombreProducto(teclado.leer("", "Ingrese nombre del producto que desea hacer pedido"));
        Pedidos.setCantidadProducto(teclado.leer(0.0, "Ingrese la cantidad del producto que desea hacer pedido"));
        
        leerProdPedido=new LeerArchivo("Almacenamiento.txt");
        listaProduc=buscarContenido(leerProdPedido, 0, Pedidos.getProductoId());
        Pedidos.setCostoProducto(Double.parseDouble(listaProduc[0][2].toString()));
        
        Pedidos.setFechaPedidos(formateador.format(new Date()));
        Pedidos.setCostoTotal(Pedidos.getCostoProducto()*Pedidos.getCantidadProducto());
        LeerArchivo leerArc=new LeerArchivo("Pedidos.txt");
        return agregarContenido(leerArc, Pedidos);
    }

    public void reportePed(){
        LeerArchivo leerArc=new LeerArchivo("Pedidos.txt");
        imprimirLista(listarContenido(leerArc));
    }
}