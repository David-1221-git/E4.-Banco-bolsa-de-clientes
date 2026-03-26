
package e4bolsa;

public class Empresa {

    private String nombre;
    private String categoria;
    private double precioAnterior;
    private double precioActual;
    private double precioMin;
    private double precioMax;

    public Empresa(String nombre, String categoria, double precioAnterior, double precioActual, double precioMin, double precioMax) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioAnterior = precioAnterior;
        this.precioActual = precioActual;
        this.precioMin = precioMin;
        this.precioMax = precioMax;
    }

    public double calcularDiferencia() {
        double diferencia = precioMax - precioMin;
        return diferencia;
    }

    public double[] calcularValorAcciones(int n) {
        double[] valores = new double[3];
        valores[0] = n * precioMin;
        valores[1] = n * precioActual;
        valores[2] = n * precioMax;
        return valores;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecioAnterior() {
        return precioAnterior;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public double getPrecioMin() {
        return precioMin;
    }

    public double getPrecioMax() {
        return precioMax;
    }

    public String toString() {
        return "Empresa: " + nombre + " | Categoria: " + categoria + " | Anterior: " + precioAnterior + " | Actual: " + precioActual + " | Min: " + precioMin + " | Max: " + precioMax + " | Dif: " + calcularDiferencia();
    }
}
