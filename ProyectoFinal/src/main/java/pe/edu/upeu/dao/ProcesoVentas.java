package pe.edu.upeu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upeu.materiales.Almacenamiento;
import pe.edu.upeu.materiales.DetalleVenta;
import pe.edu.upeu.materiales.Proceso;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;

public class ProcesoVentas extends AppCrud{
    LeerArchivo leerProdPedidoX;
    LeerArchivo leerProdPedido;
    LeerArchivo leerDetalleVenta;
    LeerArchivo leerDetalleVentaX;
    
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


    public Object[][] procesoDetalleVenta(String numeroVenta){
        System.out.println("--------------------------Detalle Venta--------------------------------");
        leerDetalleVenta=new LeerArchivo("DetalleVenta.txt");
        Object[][] datosAnt=buscarContenido(leerDetalleVenta, 1, numeroVenta);

        DetalleVenta detalle=new DetalleVenta();

        int tamanho=(datosAnt==null?0:datosAnt.length);
        int numColum=numColumna(leerDetalleVenta, detalle);
        Object[][] datosNew=new Object[tamanho+1][numColum];
        for (int i = 0; i < tamanho; i++) {
            for(int j = 0;j<datosAnt[0].length;j++){
                datosNew[i][j]=datosAnt[i][j];
            }
        }
        leerDetalleVentaX=new LeerArchivo("DetalleVenta.txt");
        detalle.setNumeroVentDetalle(generadorId(leerDetalleVentaX, 0, "D"));                    
        detalle.setProductoId(teclado.leer("", "Ingrese el ID del producto que desea hacer pedido"));
        
        detalle.setCantidadProducto(teclado.leer(0.0, "Ingrese la cantidad del producto que desea hacer pedido"));        
        leerProdPedido=new LeerArchivo("Almacenamiento.txt");
        Object[][] listaProduc=buscarContenido(leerProdPedido, 0, detalle.getProductoId());
        detalle.setNombreProducto(listaProduc[0][1].toString());
        detalle.setCostoProducto(Double.parseDouble(listaProduc[0][2].toString()));
        detalle.setCostoTotal(detalle.getCostoProducto()*detalle.getCantidadProducto());
        leerDetalleVentaX=new LeerArchivo("DetalleVenta.txt");
        return agregarContenido(leerDetalleVentaX, detalle);

    }
 
    public Object[][] procesoPedidos(){
        System.out.println("--------------------------Sistema de Pedido--------------------------------");
        leerProdPedido=new LeerArchivo("Almacenamiento.txt");
        Object[][] listaProduc=listarContenido(leerProdPedido);
        for(int lista=0;lista<listaProduc.length;lista++){
            System.out.print(listaProduc[lista][0]+"="+listaProduc[lista][1]+" ("+listaProduc[lista][2]+") , \n");
        }
        Pedidos=new Proceso();
        leerProdPedidoX=new LeerArchivo("Pedidos.txt");
        System.out.println("-----------------------------------------");
        Pedidos.setNumeroVenta(generadorId(leerProdPedidoX, 0, "V"));
        Pedidos.setFechaPedidos(formateador.format(new Date()));
        Pedidos.setPrecioTotal(0.0);
        LeerArchivo leerArc=new LeerArchivo("Pedidos.txt");
        agregarContenido(leerArc, Pedidos);
        String contiVen="NO";
        
        double precioTotal=0.0;
        do{
            procesoDetalleVenta(Pedidos.getNumeroVenta());
            contiVen=teclado.leer("", "Desea Agregar Mas productos? SI/NO");
        }while(contiVen.toUpperCase().equals("SI"));
        leerDetalleVentaX=new LeerArchivo("DetalleVenta.txt");
        String numeroVenta=Pedidos.getNumeroVenta();
        Object[][] detVent=buscarContenido(leerDetalleVentaX, 1, numeroVenta);
        
        for(int x=0;x<detVent.length;x++){
            precioTotal+=Double.parseDouble(detVent[x][6].toString());
        }
        Pedidos=new Proceso();
        Pedidos.setPrecioTotal(precioTotal);
        leerArc=new LeerArchivo("Pedidos.txt");
        return editarRegistro(leerArc, 0, numeroVenta, Pedidos);

    }

    public void ProcesoVentas(){
        LeerArchivo leerArc=new LeerArchivo("Pedidos.txt");
        imprimirLista(listarContenido(leerArc));
    }
}