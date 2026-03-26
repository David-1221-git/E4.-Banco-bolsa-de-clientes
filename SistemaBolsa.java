public class SistemaBolsa {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de bolsa de valores.-");

        Sector sectorBancos = new Sector("Bancos y Financieras");

        Empresa bPastor = new Empresa("B.PASTOR", "Bancos y Financieras", 
                                      41.95, 42.20, 41.70, 42.23);
        Empresa bPopular = new Empresa("B.POPULAR", "Bancos y Financieras", 
                                       31.48, 31.80, 31.30, 32.19);
        Empresa bValencia = new Empresa("B.VALENCIA", "Bancos y Financieras", 
                                        9.34, 9.28, 9.21, 9.34);

        sectorBancos.agregarEmpresa(bPastor);
        sectorBancos.agregarEmpresa(bPopular);
        sectorBancos.agregarEmpresa(bValencia);

        System.out.println(sectorBancos);
        System.out.println();

        System.out.println("EMPRESAS DEL SECTOR BANCOS Y FINANCIERAS.-");
        for (Empresa emp : sectorBancos.getEmpresas()) {
            System.out.println(emp);
        }
        System.out.println();

        int n = 100;
        System.out.println("VALOR DE.- " + n + " ACCIONES");
        for (Empresa emp : sectorBancos.getEmpresas()) {
            double[] valores = emp.calcularValorAcciones(n);
            System.out.println(emp.getNombre() + ":");
            System.out.println("  Minimo: " + valores[0]);
            System.out.println("  Actual: " + valores[1]);
            System.out.println("  Maximo: " + valores[2]);
        }
        System.out.println();

        Cliente cliente1 = new Cliente("Juan Perez");

        cliente1.agregarAccion(new AccionCliente(bPastor, 50, 41.50));
        cliente1.agregarAccion(new AccionCliente(bPopular, 100, 31.00));
        cliente1.agregarAccion(new AccionCliente(bValencia, 200, 9.00));

        cliente1.listarAcciones();

        cliente1.listarAcciones(true);

        System.out.println("\nOrdenes del cliente.-");
        cliente1.agregarOrden(new OrdenCompra(bPastor, 42.00, 5000));
        cliente1.agregarOrden(new OrdenVenta(bPopular, 32.50, 50));
        cliente1.listarOrdenes();

        System.out.println("\nEjecutando ordenes del cliente.-");
        for (Orden orden : cliente1.getListaOrdenes()) {
            orden.ejecutar(orden.getEmpresa().getPrecioActual());
        }

        System.out.println("\n\nCliente Institucional.-");
        ClienteInstitucional clienteInst = new ClienteInstitucional(
            "Banco Inversor SA", "INST-001", 0.02);

        clienteInst.agregarAccion(new AccionCliente(bPastor, 1000, 41.00));
        clienteInst.agregarAccion(new AccionCliente(bPopular, 2000, 30.50));

        clienteInst.listarAcciones();

        System.out.println("\nComparando valor total de las carteras.-");
        System.out.println("Cliente Regular - Valor Total: " + cliente1.calcularValorTotal());
        System.out.println("Cliente Institucional - Valor Neto: " + clienteInst.calcularValorTotal());

        System.out.println("Simulacion terminada.-");
    }
}