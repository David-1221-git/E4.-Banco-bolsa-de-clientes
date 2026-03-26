package e4bolsa;

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
            capacidad = capacidad * 2;
            Orden[] nuevaLista = new Orden[capacidad];
            for (int i = 0; i < ordenes.length; i++) {
                nuevaLista[i] = ordenes[i];
            }
            ordenes = nuevaLista;
        }
        ordenes[contador] = orden;
        contador++;
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
