package pe.edu.upeu.materiales;

public class Almacenamiento {
    public String productoId;
    public String nombreProducto;
    public Double costoProducto;
    public String productoStock;
    public String producDefectuosos;

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(Double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getProductoStock() {
        return productoStock;
    }

    public void setProductoStock(String productoStock) {
        this.productoStock = productoStock;
    }

    public String getProducDefectuosos() {
        return producDefectuosos;
    }

    public void setProducDefectuosos(String producDefectuosos) {
        this.producDefectuosos = producDefectuosos;
    }
    
}