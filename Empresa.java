public class Empresa {
    private String nombre;
    private String categoria;
    private double precioActual;
    private double precioMin;
    private double precioMax;
    private double precioAnterior;

    public Empresa(String nombre, String categoria, double precioAnterior, 
                   double precioActual, double precioMin, double precioMax) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioAnterior = precioAnterior;
        this.precioActual = precioActual;
        this.precioMin = precioMin;
        this.precioMax = precioMax;
    }

    public double calcularDiferencia() {
        return precioMax - precioMin;
    }

    public double[] calcularValorAcciones(int n) {
        return new double[] {
            n * precioMin,
            n * precioActual,
            n * precioMax
        };
    }

    public double calcularValorAcciones(int n, String tipo) {
        switch(tipo.toLowerCase()) {
            case "minimo": return n * precioMin;
            case "maximo": return n * precioMax;
            case "actual": 
            default: return n * precioActual;
        }
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecioActual() { return precioActual; }
    public double getPrecioMin() { return precioMin; }
    public double getPrecioMax() { return precioMax; }
    public double getPrecioAnterior() { return precioAnterior; }

    @Override
    public String toString() {
        return String.format("Empresa: %s | Categoria: %s | Actual: %.2f | " +
                           "Min: %.2f | Max: %.2f | Dif: %.2f",
                           nombre, categoria, precioActual, precioMin, 
                           precioMax, calcularDiferencia());
    }
}