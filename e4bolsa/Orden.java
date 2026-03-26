

package e4bolsa;

public class Orden {

    protected Empresa empresa;
    protected String tipo; // "compra" o "venta"
    protected double precioObjetivo;

    public Orden(Empresa empresa, String tipo, double precioObjetivo) {
        this.empresa = empresa;
        this.tipo = tipo;
        this.precioObjetivo = precioObjetivo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioObjetivo() {
        return precioObjetivo;
    }

    public String toString() {
        return "Orden: " + tipo + " | Empresa: " + empresa.getNombre() + " | Precio Objetivo: " + precioObjetivo;
    }
}
