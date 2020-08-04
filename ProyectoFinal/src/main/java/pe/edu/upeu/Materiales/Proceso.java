package pe.edu.upeu.materiales;

public class Proceso {
    public String numeroVenta;
    public String fechaPedidos;
    public String productoId;
    public String nombreProducto;
    public Double costoProducto;
    public Double cantidadProducto;
    public Double costoTotal;
    public Double precioTotal;

    public String getNumeroPedido() {
        return numeroVenta;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroVenta = numeroPedido;
    }

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

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
}

    