public class OrdenCompra extends Orden {
    private double montoInversion;
    public OrdenCompra(Empresa empresa, double precioObjetivo, double montoInversion) {
        super(empresa, precioObjetivo);
        this.montoInversion = montoInversion;
    }
    @Override
    public String getTipo() {
        return "COMPRA";
    }
    @Override
    public boolean ejecutar(double precioActual) {
        if (precioActual <= getPrecioObjetivo()) {
            System.out.println("Orden de COMPRA ejecutada para.- " + getEmpresa().getNombre() + 
                               " a un precio de " + precioActual + " por acción.");
            return true;
        } else {
            System.out.println("Orden de COMPRA no ejecutada para.- " + getEmpresa().getNombre() + 
                               ". Precio actual (" + precioActual + ") es mayor que el precio objetivo (" + getPrecioObjetivo() + ").");
            return false;
        }
    }
      @Override
    public String toString() {
        return String.format("Orden COMPRA: %s | Precio Objetivo: %.2f | " +
                           "Monto: %.2f", empresa.getNombre(), precioObjetivo, montoInversion);
    }
    
}
