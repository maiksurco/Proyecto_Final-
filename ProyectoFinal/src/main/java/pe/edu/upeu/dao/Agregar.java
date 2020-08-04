package pe.edu.upeu.dao;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upeu.materiales.Proceso;
import pe.edu.upeu.utils.LeerArchivo;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

public class Agregar {
    
    LeerArchivo leerArc;
    UtilsX util=new UtilsX();
    LeerTeclado teclado=new LeerTeclado();
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat formateadorOpc2 = new SimpleDateFormat("dd-MM-yyyy");

    public Object[][] agregarMaterial(){
        leerArc = new LeerArchivo("Productos.txt");
        return null;

    }
}