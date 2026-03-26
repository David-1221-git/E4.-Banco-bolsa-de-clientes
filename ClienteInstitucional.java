public class ClienteInstitucional extends Cliente {
    private double comision;
    private String codigoInstitucional;

    public ClienteInstitucional(String nombre, String codigoInstitucional, 
                                double comision, int capacidadMaxima) {
        super(nombre, capacidadMaxima);
        this.codigoInstitucional = codigoInstitucional;
        this.comision = comision;
    }

    @Override
    public void listarAcciones() {
        System.out.println("\nAcciones de " + getNombre() + " (ITQ)");
        System.out.println("Codigo: " + codigoInstitucional);
        System.out.println("Comision: " + (comision * 100) + "%");
        
        double totalConComision = 0;
        for (int i = 0; i < getContadorAcciones(); i++) {
            AccionCliente accion = getAccion(i);
            System.out.println(accion);
            totalConComision += accion.getValorActual();
        }
        
        double comisionTotal = totalConComision * comision;
        System.out.println("\nValor Total: " + totalConComision);
        System.out.println("Comision: " + comisionTotal);
        System.out.println("Valor Neto: " + (totalConComision - comisionTotal));
        System.out.println("Ganancia Total: " + (calcularGananciaTotal() - comisionTotal));
    }

    @Override
    public double calcularValorTotal() {
        double valorTotal = super.calcularValorTotal();
        return valorTotal - (valorTotal * comision);
    }
}