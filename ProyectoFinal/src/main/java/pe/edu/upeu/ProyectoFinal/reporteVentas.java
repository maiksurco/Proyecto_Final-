package pe.edu.upeu.proyectofinal;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upeu.dao.AppCrud;
import pe.edu.upeu.utils.LeerArchivo; 
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

public class reporteVentas extends AppCrud {

    LeerArchivo leerArc;
    UtilsX util=new UtilsX();
    LeerTeclado teclado=new LeerTeclado();
    SimpleDateFormat formateadorfecha = new SimpleDateFormat("dd-MM-yyyy");
    
    public void ReporteVentasRangoFecha(String fechaInicio, String fechaFinal){
        leerArc=new LeerArchivo("Pedidos.txt");
        System.out.println("-------------------------REPORTE DE LA VENTA POR FECHA------------------------------");        
        Object[][] data=listarContenido(leerArc);
        int cantidadFilas=0;
        double cantDeVentas=0, RecaudacionTotal=0;
        try {            
        for(int fila=0;fila<data.length;fila++){
            String[] vectorFecha=data[fila][1].toString().split(" ");
            Date fecha=formateadorfecha.parse(vectorFecha[0].toString());
            if((fecha.after(formateadorfecha.parse(fechaInicio)) && 
            fecha.before(formateadorfecha.parse(fechaFinal))) || 
            vectorFecha[0].equals(fechaInicio) || 
            vectorFecha[0].equals(fechaFinal) ){
                cantidadFilas++;
            }
        }
        System.out.println("la cantidad de filas es:"+cantidadFilas);
        Object[][] dataDia=new Object[cantidadFilas][data[0].length];
        int filaX=0, columnaX=0;
        for(int fila=0;fila<data.length;fila++){
            String[] vectorFecha=data[fila][1].toString().split(" ");
            Date fecha=formateadorfecha.parse(vectorFecha[0].toString());
            if((fecha.after(formateadorfecha.parse(fechaInicio)) && 
            fecha.before(formateadorfecha.parse(fechaFinal))) || 
            vectorFecha[0].equals(fechaInicio) || 
            vectorFecha[0].equals(fechaFinal)){
            for(int columna=0;columna<data[0].length;columna++){
                dataDia[filaX][columnaX]=data[fila][columna];
                if(columna==2){RecaudacionTotal+=Double.parseDouble(data[fila][columna].toString());}
                columnaX++;
                }
            filaX++;
            columnaX=0;
            cantDeVentas++;
            }             
        }
        imprimirLista(dataDia); 
        System.out.println("------------------------------------------Resumen de ventas------------------------------------");
        System.out.println("La Cantidad de venta es:"+cantDeVentas+"-----------Monto Recaudado:"+RecaudacionTotal);
        System.out.println("---------------------------------------------------------------------");



        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
               
    }
}