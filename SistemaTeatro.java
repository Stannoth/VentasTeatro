/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasteatro;

/**
 *
 * @author Camilo
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SistemaTeatro {
    //arreglos fijos
    private Asiento[] asientos;
    private Cliente[] clientes;
    private Venta[] ventas;

    //Listas dinámicas
    private List<Promocion> promociones;
    private List<Reserva> reservas;

    //Constructor
    public SistemaTeatro(int capacidadSala, int maxClientes, int maxVentas) {
        this.asientos = new Asiento[capacidadSala];
        this.clientes = new Cliente[maxClientes];
        this.ventas = new Venta[maxVentas];

        this.promociones = new ArrayList<>();
        this.reservas = new ArrayList<>();

        //Promociones predefinidas
        promociones.add(new Promocion(1, "Estudiante 10%", 0.10));
        promociones.add(new Promocion(2, "3ra Edad 15%", 0.15));
    }

    //Iniciaremos el sistema
    public void iniciarSistema() {
        inicializarAsientos();
        mostrarMenu();

    }

    private void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n======= Menú Teatro Moro =======");
            System.out.println("1. Vender entrada");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Ver una reserva");
            System.out.println("4. Convertir una reserva en venta");
            System.out.println("5. Ver resumen de ventas");
            System.out.println("6. Salir");
            System.out.println("Selecciones una opción:");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    venderEntrada(scanner);
                    break;
                case 2:
                    reservarAsiento(scanner);
                    break;
                case 3:
                    mostrarReservas();
                    break;
                case 4:
                    convertirReserva(scanner);
                    break;
                case 5:
                    mostrarResumenVentas();
                    break;
                case 6:
                    System.out.println("Vuelva pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (option != 6);
    }

    private void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            String ubic;
            if (i < asientos.length * 0.1) {
                ubic = "VIP";
            } else if (i < asientos.length * 0.3) {
                ubic = "Platea";
            } else {
                ubic = "Balcón";
            }
            asientos[i] = new Asiento(i + 1, ubic);
        }
    }

    //Mostrar ventas registradas
    public void mostrarResumenVentas() {
        System.out.println("\n====== Resumen de ventas ======");
        for (Venta v : ventas) {
            if (v != null) {
                System.out.println(v);
            }
        }
    }

    private void venderEntrada(Scanner scanner) {
        System.out.print("ID de cliente (0 para nuevo): ");
        //Aqui vamos a pedir los datos del cliente
        int clienteId = scanner.nextInt();
        Cliente cliente;
        if (clienteId == 0) {
            //Crear un nuevo usuario
            System.out.println("Nombre: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();
            System.out.println("Edad: ");
            int edad = scanner.nextInt();
            System.out.println("¿Estudiante? (true/false): ");
            boolean esEst = scanner.nextBoolean();
            System.out.println("¿Tercera edad? (true/false): ");
            boolean esTerc = scanner.nextBoolean();

            int idxCliente = -1;
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] == null) {
                    idxCliente = i;
                    break;
                }
            }

            if (idxCliente == -1) {
                System.out.println("No se pueden registrar más clientes.");
            }

            clienteId = idxCliente + 1;
            cliente = new Cliente(clienteId, nombre, edad, esEst, esTerc);
            clientes[idxCliente] = cliente;

        } else {
            if (clienteId < 1 || clienteId > clientes.length || clientes[clienteId - 1] == null) {
                System.out.println("Cliente no válido.");
                return;
            }
            cliente = clientes[clienteId - 1];
        }

        System.out.println("\nAsientos disponibles: ");
        for (Asiento a : asientos) {
            if (a.isDisponible()) {
                System.out.println(a);
            }
        }
        int asientoId = scanner.nextInt();
        if (asientoId < 1 || asientoId > asientos.length) {
            System.out.println("Asiento no válido");
            return;
        }
        Asiento asiento = asientos[asientoId - 1];
        if (!asiento.isDisponible()) {
            System.out.println("Este asiento ya no está disponible.");
            return;
        }


        //Establecemos el precio base sobre la cual se harán los descuentos
        double precioBase;
        switch (asiento.getUbicacion()) {
            case "VIP":
                precioBase = 120.0;
                break;
            case "Platea":
                precioBase = 80.0;
                break;
            default:
                precioBase = 50.0;
                break;
        }

        double descuento = 0;
        if (cliente.isEsEstudiante()) {
            descuento = precioBase * 0.10;
        } else if (cliente.isEsTerceraEdad()) {
            descuento = precioBase * 0.15;
        }

        int idxVenta = -1;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] == null) {
                idxVenta = i;
                break;
            }
        }
        if (idxVenta == -1) {
            System.out.println("No se pueden procesar más ventas.");
            return;
        }
        int ventaId = idxVenta + 1;
        Venta venta = new Venta(ventaId, clienteId, asientoId, precioBase, descuento);
        ventas[idxVenta] = venta;
        asiento.setDisponible(false);

        System.out.println("\nVenta exitosa!" + venta);
    }

    private void reservarAsiento(Scanner scanner) {
        System.out.println("ID de cliente (0 si es nuevo): ");
        int clienteId = scanner.nextInt();
        Cliente cliente;
        if (clienteId == 0) {
            System.out.println("Nombre: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();
            System.out.println("Edad: ");
            int edad = scanner.nextInt();
            System.out.println("¿Estudiante? (true/false): ");
            boolean esEst = scanner.nextBoolean();
            System.out.println("¿Tercera edad?");
            boolean esTerc = scanner.nextBoolean();

            int idxCliente = -1;
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] == null) {
                    idxCliente = i;
                    break;
                }
            }
            if (idxCliente == -1) {
                System.out.println("No se puede registrar más clientes.");
                return;
            }
            clienteId = idxCliente + 1;
            cliente = new Cliente(clienteId, nombre, edad, esEst, esTerc);
            clientes[idxCliente] = cliente;
        } else {
            if (clienteId < 1 || clienteId > clientes.length || clientes[clienteId - 1] == null) {
                System.out.println("Cliente no válido");
                return;
            }
            cliente = clientes[clienteId - 1];
        }
        System.out.println("\nAsientos disponibles para reservar: ");
        for (Asiento a : asientos) {
            if (a.isDisponible()) {
                System.out.println(a);
            }
        }
        int asientoId = scanner.nextInt();
        if (asientoId < 1 || asientoId > asientos.length) {
            System.out.println("Asiento inválido.");
            return;
        }
        Asiento asiento = asientos[asientoId - 1];
        if (!asiento.isDisponible()) {
            System.out.println("Asiento no disponible por el momento.");
            return;
        }
        int reservaId = reservas.size() + 1;
        reservas.add(new Reserva(reservaId, clienteId, asientoId));
        asiento.setDisponible(false);
        System.out.println("\nReserva exitose! N° Reserva " + reservaId);

    }

    private void mostrarReservas() {
        System.out.println("\n====== Reservas ======");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    private void convertirReserva(Scanner scanner) {
        // Verificar que haya reservas
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas para convertir.");
            return;
        }

        // Mostrar todas las reservas
        System.out.println("\nReservas disponibles para venta:");
        for (Reserva r : reservas) {
            System.out.println(r);
        }

        // Pedir al usuario el ID de reserva a convertir
        System.out.print("N° de la reserva a convertir: ");
        int reservaId = scanner.nextInt();

        // Buscar la reserva seleccionada
        Reserva reservaSel = null;
        for (Reserva r : reservas) {
            if (r.getReservaId() == reservaId) {
                reservaSel = r;
                break;
            }
        }
        if (reservaSel == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        // Recuperar datos de la reserva
        int clienteId = reservaSel.getClienteId();
        int asientoId = reservaSel.getAsientoId();
        Cliente cliente = clientes[clienteId - 1];
        Asiento asiento = asientos[asientoId - 1];

        // Calcular precio base según ubicación
        double precioBase;
        switch (asiento.getUbicacion()) {
            case "VIP":
                precioBase = 120.0;
                break;
            case "Platea":
                precioBase = 80.0;
                break;
            default:
                precioBase = 50.0;
                break;
        }

        // Calcular descuento según cliente
        double descuento = 0;
        if (cliente.isEsEstudiante()) {
            descuento = precioBase * 0.10;
        } else if (cliente.isEsTerceraEdad()) {
            descuento = precioBase * 0.15;
        }

        // Crear la venta en el primer hueco libre
        int idxVenta = -1;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] == null) {
                idxVenta = i;
                break;
            }
        }
        if (idxVenta == -1) {
            System.out.println("No se pueden registrar más ventas.");
            return;
        }
        int ventaId = idxVenta + 1;
        Venta venta = new Venta(ventaId, clienteId, asientoId, precioBase, descuento);
        ventas[idxVenta] = venta;

        // 9) Eliminar la reserva y la reserva del asiento
        reservas.remove(reservaSel);

        System.out.println("\nReserva convertida a venta con éxito:");
        System.out.println(venta);
    }
}
