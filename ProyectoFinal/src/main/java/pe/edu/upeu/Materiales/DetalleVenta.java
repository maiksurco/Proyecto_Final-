package pe.edu.upeu.materiales;

public class DetalleVenta {
    public String numeroVentDetalle;
    public String numeroVenta;
    public String productoId;//DEtalle    
    public String nombreProducto;//detalle
    public Double costoProducto;//detalle
    public Double cantidadProducto;//detalle
    public Double costoTotal;//detalle

    


    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
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

    public Double getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Double cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getNumeroVentDetalle() {
        return numeroVentDetalle;
    }

    public void setNumeroVentDetalle(String numeroVentDetalle) {
        this.numeroVentDetalle = numeroVentDetalle;
    }


    

}