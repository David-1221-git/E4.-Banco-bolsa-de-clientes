

package e4bolsa;

public class SistemaBolsa {
    public static void main(String[] args) {

        System.out.println("Sistema de bolsa de valores");

        // crear sector y empresas
        Sector sectorBancos = new Sector("Bancos y Financieras", 10);

        Empresa bPastor = new Empresa("B.pastor", "Bancos y Financieras", 41.95, 42.20, 41.70, 42.23);
        Empresa bPopular = new Empresa("B.popular", "Bancos y Financieras", 31.48, 31.80, 31.30, 32.19);
        Empresa bValencia = new Empresa("B.valencia", "Bancos y Financieras", 9.34, 9.28, 9.21, 9.34);

        sectorBancos.agregarEmpresa(bPastor);
        sectorBancos.agregarEmpresa(bPopular);
        sectorBancos.agregarEmpresa(bValencia);

        // mostrar sector
        System.out.println(sectorBancos);
        System.out.println();

        // mostrar empresas del sector
        System.out.println("Empresas del sector:");
        for (int i = 0; i < sectorBancos.getContadorEmpresas(); i++) {
            System.out.println(sectorBancos.getEmpresa(i));
        }
        System.out.println();

        // mostrar valor de 100 acciones por empresa
        int n = 100;
        System.out.println("Valor de " + n + " acciones:");
        for (int i = 0; i < sectorBancos.getContadorEmpresas(); i++) {
            Empresa emp = sectorBancos.getEmpresa(i);
            double[] valores = emp.calcularValorAcciones(n);
            System.out.println(emp.getNombre() + ":");
            System.out.println("  Minimo: " + valores[0]);
            System.out.println("  Actual: " + valores[1]);
            System.out.println("  Maximo: " + valores[2]);
        }
        System.out.println();

        // crear cliente y agregar acciones
        Cliente cliente1 = new Cliente("Juan Perez", 10);
        cliente1.agregarAccion(new AccionCliente(bPastor, 50, 41.50));
        cliente1.agregarAccion(new AccionCliente(bPopular, 100, 31.00));
        cliente1.agregarAccion(new AccionCliente(bValencia, 200, 9.00));

        // listar acciones sin y con detalle
        cliente1.listarAcciones();
        cliente1.listarAcciones(true);

        // agregar ordenes y listarlas
        cliente1.agregarOrden(new OrdenCompra(bPastor, 42.00, 5000));
        cliente1.agregarOrden(new OrdenVenta(bPopular, 32.50, 50));
        cliente1.listarOrdenes();

        // ejecutar ordenes
        System.out.println("\nEjecutando ordenes:");
        for (int i = 0; i < cliente1.getContadorOrdenes(); i++) {
            Orden orden = cliente1.getOrden(i);
            double precioActual = orden.getEmpresa().getPrecioActual();
            if (orden.getTipo().equals("compra")) {
                OrdenCompra oc = (OrdenCompra) orden;
                oc.ejecutar(precioActual);
            } else {
                OrdenVenta ov = (OrdenVenta) orden;
                ov.ejecutar(precioActual);
            }
        }

        // cliente institucional
        System.out.println("\ncliente Institucional:");
        ClienteInstitucional clienteInst = new ClienteInstitucional("Banco Inversor SA", "INST-001", 0.02, 10);
        clienteInst.agregarAccion(new AccionCliente(bPastor, 1000, 41.00));
        clienteInst.agregarAccion(new AccionCliente(bPopular, 2000, 30.50));
        clienteInst.listarAcciones();

        // comparar valores
        System.out.println("\ncomparando carteras:");
        System.out.println("cliente regular - Valor total: " + cliente1.calcularValorTotal());
        System.out.println("cliente institucional - Valor neto: " + clienteInst.calcularValorTotal());
    }
}
