public class ListaOrdenes {
    private Orden[] ordenes;
    private int contador;
    private int capacidad;

    public ListaOrdenes(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.ordenes = new Orden[capacidadInicial];
        this.contador = 0;
    }

    public void agregar(Orden orden) {
        if (contador >= capacidad) {
            expandirCapacidad();
        }
        ordenes[contador] = orden;
        contador++;
    }

    private void expandirCapacidad() {
        capacidad = capacidad * 2;
        Orden[] nuevoArray = new Orden[capacidad];
        for (int i = 0; i < ordenes.length; i++) {
            nuevoArray[i] = ordenes[i];
        }
        ordenes = nuevoArray;
    }

    public Orden get(int indice) {
        if (indice >= 0 && indice < contador) {
            return ordenes[indice];
        }
        return null;
    }

    public int size() {
        return contador;
    }
}