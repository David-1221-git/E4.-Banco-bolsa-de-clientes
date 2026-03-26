public class ListaAcciones {
    private AccionCliente[] acciones;
    private int contador;
    private int capacidad;

    public ListaAcciones(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.acciones = new AccionCliente[capacidadInicial];
        this.contador = 0;
    }

    public void agregar(AccionCliente accion) {
        if (contador >= capacidad) {
            expandirCapacidad();
        }
        acciones[contador] = accion;
        contador++;
    }

    private void expandirCapacidad() {
        capacidad = capacidad * 2;
        AccionCliente[] nuevoArray = new AccionCliente[capacidad];
        for (int i = 0; i < acciones.length; i++) {
            nuevoArray[i] = acciones[i];
        }
        acciones = nuevoArray;
    }

    public AccionCliente get(int indice) {
        if (indice >= 0 && indice < contador) {
            return acciones[indice];
        }
        return null;
    }

    public int size() {
        return contador;
    }
}