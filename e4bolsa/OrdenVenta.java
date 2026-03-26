
package e4bolsa;

public class OrdenVenta extends Orden {

    private int cantidadVender;
    public OrdenVenta(Empresa empresa, double precioObjetivo, int cantidadVender) {
        super(empresa, "venta", precioObjetivo);
        this.cantidadVender = cantidadVender;
    }

    public boolean ejecutar(double precioMercado) {
        if (precioMercado >= precioObjetivo) {
            System.out.println("Orden de venta ejecutada: " + cantidadVender + " acciones de " + empresa.getNombre() + " a " + precioMercado);
            return true;
        } else {
            System.out.println("Orden de venta no ejecutada: " + empresa.getNombre() + " precio actual " + precioMercado + " es menor al objetivo " + precioObjetivo);
            return false;
        }
    }

    public int getCantidadVender() {
        return cantidadVender;
    }

    public String toString() {
        return "Orden VENTA | Empresa: " + empresa.getNombre() + " | precio Objetivo: " + precioObjetivo + " | Cantidad: " + cantidadVender;
    }
}
