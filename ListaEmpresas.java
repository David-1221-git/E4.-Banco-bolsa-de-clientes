public class ListaEmpresas {
    private Empresa[] empresas;
    private int contador;
    private int capacidad;

    public ListaEmpresas(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.empresas = new Empresa[capacidadInicial];
        this.contador = 0;
    }

    public void agregar(Empresa empresa) {
        if (contador >= capacidad) {
            expandirCapacidad();
        }
        empresas[contador] = empresa;
        contador++;
    }

    private void expandirCapacidad() {
        capacidad = capacidad * 2;
        Empresa[] nuevoArray = new Empresa[capacidad];
        for (int i = 0; i < empresas.length; i++) {
            nuevoArray[i] = empresas[i];
        }
        empresas = nuevoArray;
    }

    public Empresa get(int indice) {
        if (indice >= 0 && indice < contador) {
            return empresas[indice];
        }
        return null;
    }

    public int size() {
        return contador;
    }

    public void listar() {
        for (int i = 0; i < contador; i++) {
            System.out.println(empresas[i]);
        }
    }
}
