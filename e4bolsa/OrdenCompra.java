
package e4bolsa;

public class OrdenCompra extends Orden {

    private double montoInversion;

    public OrdenCompra(Empresa empresa, double precioObjetivo, double montoInversion) {
        super(empresa, "compra", precioObjetivo);
        this.montoInversion = montoInversion;
    }

    public boolean ejecutar(double precioActual) {
        if (precioActual <= precioObjetivo) {
            System.out.println("Orden de compra ejecutada: " + empresa.getNombre() + " a " + precioActual);
            return true;
        } else {
            System.out.println("Orden de compra no ejecutada: " + empresa.getNombre() + " precio actual " + precioActual + " es mayor al objetivo " + precioObjetivo);
            return false;
        }
    }

    public double getMontoInversion() {
        return montoInversion;
    }

    public String toString() {
        return "Orden COMPRA | Empresa: " + empresa.getNombre() + " | Precio Objetivo: " + precioObjetivo + " | Monto: " + montoInversion;
    }
}
