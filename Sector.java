public class Sector {
    private String nombre;
    private Empresa[] empresas;
    private int contadorEmpresas;

    public Sector(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.empresas = new Empresa[capacidadMaxima];
        this.contadorEmpresas = 0;
    }

    public void agregarEmpresa(Empresa empresa) {
        if (contadorEmpresas < empresas.length) {
            empresas[contadorEmpresas] = empresa;
            contadorEmpresas++;
        } else {
            System.out.println("No se puede agregar más empresas. Capacidad máxima alcanzada.");
        }
    }

    public double calcularIndice() {
        if (contadorEmpresas == 0) return 0;
        double suma = 0;
        for (int i = 0; i < contadorEmpresas; i++) {
            suma += empresas[i].getPrecioActual();
        }
        return suma / contadorEmpresas;
    }

    public double calcularValorMin() {
        if (contadorEmpresas == 0) return 0;
        double min = empresas[0].getPrecioActual();
        for (int i = 1; i < contadorEmpresas; i++) {
            if (empresas[i].getPrecioActual() < min) {
                min = empresas[i].getPrecioActual();
            }
        }
        return min;
    }

    public double calcularValorMax() {
        if (contadorEmpresas == 0) return 0;
        double max = empresas[0].getPrecioActual();
        for (int i = 1; i < contadorEmpresas; i++) {
            if (empresas[i].getPrecioActual() > max) {
                max = empresas[i].getPrecioActual();
            }
        }
        return max;
    }

    public double calcularDiferencia() {
        return calcularValorMax() - calcularValorMin();
    }

    public String getNombre() { 
        return nombre; 
    }

    public Empresa getEmpresa(int indice) {
        if (indice >= 0 && indice < contadorEmpresas) {
            return empresas[indice];
        }
        return null;
    }

    public int getContadorEmpresas() {
        return contadorEmpresas;
    }

    @Override
    public String toString() {
        return String.format("Sector: %s | Indice: %.2f | Min: %.2f | Max: %.2f | Dif: %.2f",
                           nombre, calcularIndice(), calcularValorMin(), 
                           calcularValorMax(), calcularDiferencia());
    }
}