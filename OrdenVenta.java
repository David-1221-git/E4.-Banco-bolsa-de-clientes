public class OrdenVenta extends Orden {
    private int cantidadVender;

    public OrdenVenta(Empresa empresa, double precioObjetivo, int cantidadVender) {
        super(empresa, precioObjetivo);
        this.cantidadVender = cantidadVender;
    }

    @Override
    public String getTipo() {
        return "VENTA";
    }

    @Override
    public boolean ejecutar(double precioMercado) {
        if (precioMercado >= precioObjetivo) {
            System.out.println("Orden de VENTA ejecutada.- " + cantidadVender + 
                             " acciones de " + empresa.getNombre() + 
                             " a " + precioMercado);
            return true;
        }
            System.out.println("Orden de VENTA no ejecutada para.- " + empresa.getNombre() + 
                                ". Precio actual (" + precioMercado + ") es menor que el precio objetivo (" + precioObjetivo + ").");
        return false;
    }

    @Override
    public String toString() {
        return String.format("Orden VENTA: %s | Precio Objetivo: %.2f | " +
                           "Cantidad: %d", empresa.getNombre(), precioObjetivo, cantidadVender);
    }
}
