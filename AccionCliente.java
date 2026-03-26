public class AccionCliente {
    private Empresa empresa;
    private int cantidad;
    private double precioCompra;

    public AccionCliente(Empresa empresa, int cantidad, double precioCompra) {
        this.empresa = empresa;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public double getValorActual() {
        return cantidad * empresa.getPrecioActual();
    }

    public double getValorCompra() {
        return cantidad * precioCompra;
    }

    public double getGanancia() {
        return getValorActual() - getValorCompra();
    }

    public Empresa getEmpresa() { return empresa; }
    public int getCantidad() { return cantidad; }
    public double getPrecioCompra() { return precioCompra; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return String.format("%s | Cantidad: %d | Precio Compra: %.2f | " +
                           "Valor Actual: %.2f | Ganancia: %.2f",
                           empresa.getNombre(), cantidad, precioCompra,
                           getValorActual(), getGanancia());
    }
}