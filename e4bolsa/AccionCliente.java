

package e4bolsa;

public class AccionCliente {

    // datos de la accion
    private Empresa empresa;
    private int cantidad;
    private double precioCompra;

    // constructor
    public AccionCliente(Empresa empresa, int cantidad, double precioCompra) {
        this.empresa = empresa;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public double getValorActual() {
        double valor = cantidad * empresa.getPrecioActual();
        return valor;
    }

    public double getValorCompra() {
        double valor = cantidad * precioCompra;
        return valor;
    }

    public double getGanancia() {
        double ganancia = getValorActual() - getValorCompra();
        return ganancia;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString() {
        return empresa.getNombre() + " | Cantidad: " + cantidad + " | Precio Compra: " + precioCompra + " | Valor Actual: " + getValorActual() + " | Ganancia: " + getGanancia();
    }
}
