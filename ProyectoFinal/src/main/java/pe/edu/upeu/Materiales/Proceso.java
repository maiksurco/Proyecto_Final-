package pe.edu.upeu.materiales;

public class Proceso {
    public String fechaPedidos;
    public String productoId;
    public Double costoProducto;
    public String cantidadProducto;
    public Double costoTotal;
    public Double precioTotal;

    public String getFechaPedidos() {
        return fechaPedidos;
    }

    public void setFechaPedidos(String fechaPedidos) {
        this.fechaPedidos = fechaPedidos;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public Double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(Double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}