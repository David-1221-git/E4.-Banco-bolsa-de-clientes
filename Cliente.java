public class Cliente {
    private String nombre;
    private ListaAcciones listaAcciones;
    private ListaOrdenes listaOrdenes;

    public Cliente(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.listaAcciones = new ListaAcciones(capacidadMaxima);
        this.listaOrdenes = new ListaOrdenes(capacidadMaxima);
    }

    public void agregarAccion(AccionCliente accion) {
        listaAcciones.agregar(accion);
    }

    public void agregarOrden(Orden orden) {
        listaOrdenes.agregar(orden);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < listaAcciones.size(); i++) {
            total += listaAcciones.get(i).getValorActual();
        }
        return total;
    }

    public double calcularGananciaTotal() {
        double ganancia = 0;
        for (int i = 0; i < listaAcciones.size(); i++) {
            ganancia += listaAcciones.get(i).getGanancia();
        }
        return ganancia;
    }

    public void listarAcciones() {
        System.out.println("\n=== Acciones de " + nombre + " ===");
        for (int i = 0; i < listaAcciones.size(); i++) {
            System.out.println(listaAcciones.get(i));
        }
        System.out.println("Valor Total: " + calcularValorTotal());
        System.out.println("Ganancia Total: " + calcularGananciaTotal());
    }

    public void listarAcciones(boolean conDetalle) {
        if (!conDetalle) {
            listarAcciones();
            return;
        }

        System.out.println("\n=== Acciones de " + nombre + " (CON DETALLE) ===");
        for (int i = 0; i < listaAcciones.size(); i++) {
            AccionCliente accion = listaAcciones.get(i);
            Empresa emp = accion.getEmpresa();
            int cant = accion.getCantidad();
            
            System.out.println("\nEmpresa: " + emp.getNombre());
            System.out.println("  Cantidad: " + cant);
            System.out.println("  Precio Compra: " + accion.getPrecioCompra());
            
            double[] valores = emp.calcularValorAcciones(cant);
            System.out.println("  Valor Minimo: " + valores[0]);
            System.out.println("  Valor Actual: " + valores[1]);
            System.out.println("  Valor Maximo: " + valores[2]);
            System.out.println("  Ganancia: " + accion.getGanancia());
        }
        System.out.println("\nValor Total: " + calcularValorTotal());
        System.out.println("Ganancia Total: " + calcularGananciaTotal());
    }

    public void listarOrdenes() {
        System.out.println("\n=== Ordenes de " + nombre + " ===");
        for (int i = 0; i < listaOrdenes.size(); i++) {
            System.out.println(listaOrdenes.get(i));
        }
    }

    public String getNombre() { return nombre; }
    
    public AccionCliente getAccion(int indice) {
        return listaAcciones.get(indice);
    }
    
    public Orden getOrden(int indice) {
        return listaOrdenes.get(indice);
    }
    
    public int getContadorAcciones() { return listaAcciones.size(); }
    public int getContadorOrdenes() { return listaOrdenes.size(); }
}