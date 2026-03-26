

package e4bolsa;

public class ClienteInstitucional extends Cliente {

    private double comision;
    private String codigoInstitucional;

    public ClienteInstitucional(String nombre, String codigoInstitucional, double comision, int capacidadMaxima) {
        super(nombre, capacidadMaxima);
        this.codigoInstitucional = codigoInstitucional;
        this.comision = comision;
    }

    public void listarAcciones() {
        System.out.println("\nAcciones de " + getNombre() + " (institucional)");
        System.out.println("Codigo: " + codigoInstitucional);
        System.out.println("Comision: " + (comision * 100) + "%");

        double total = 0;
        for (int i = 0; i < getContadorAcciones(); i++) {
            AccionCliente accion = getAccion(i);
            System.out.println(accion);
            total = total + accion.getValorActual();
        }

        double montoComision = total * comision;
        System.out.println("\nValor total: " + total);
        System.out.println("Comision: " + montoComision);
        System.out.println("Valor neto: " + (total - montoComision));
        System.out.println("Ganancia total: " + (calcularGananciaTotal() - montoComision));
    }

    public double calcularValorTotal() {
        double valorTotal = super.calcularValorTotal();
        double descuento = valorTotal * comision;
        return valorTotal - descuento;
    }
}
