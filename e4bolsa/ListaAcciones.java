
package e4bolsa;

public class ListaAcciones {

    private AccionCliente[] acciones;
    private int contador;
    private int capacidad;

    public ListaAcciones(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.acciones = new AccionCliente[capacidadInicial];
        this.contador = 0;
    }

    // agrega una accion a la lista
    public void agregar(AccionCliente accion) {
        if (contador >= capacidad) {
            // si no hay espacio, se duplica el tamaño
            capacidad = capacidad * 2;
            AccionCliente[] nuevaLista = new AccionCliente[capacidad];
            for (int i = 0; i < acciones.length; i++) {
                nuevaLista[i] = acciones[i];
            }
            acciones = nuevaLista;
        }
        acciones[contador] = accion;
        contador++;
    }

    // devuelve la accion en la posicion indicada
    public AccionCliente get(int indice) {
        if (indice >= 0 && indice < contador) {
            return acciones[indice];
        }
        return null;
    }

    // devuelve cuantas acciones hay
    public int size() {
        return contador;
    }
}
