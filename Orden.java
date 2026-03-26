public abstract class Orden {
    protected Empresa empresa;
    protected double precioObjetivo;

    public Orden(Empresa empresa, double precioObjetivo) {
        this.empresa = empresa;
        this.precioObjetivo = precioObjetivo;
    }

    public abstract String getTipo();
    public abstract boolean ejecutar(double precioMercado);

    public Empresa getEmpresa() { return empresa; }
    public double getPrecioObjetivo() { return precioObjetivo; }
}