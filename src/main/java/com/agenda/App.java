package com.agenda;

import com.agenda.core.Agenda;
import com.agenda.model.Contacto;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido a la Agenda Telefónica");

        Agenda agenda = crearAgenda();
        int opcion;

        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case 1 -> anadir(agenda);
                case 2 -> existe(agenda);
                case 3 -> agenda.listarContactos();
                case 4 -> buscar(agenda);
                case 5 -> eliminar(agenda);
                case 6 -> modificar(agenda);
                case 7 -> JOptionPane.showMessageDialog(null, agenda.agendaLlena() ? "La agenda está llena." : "Aún hay espacio disponible.");
                case 8 -> JOptionPane.showMessageDialog(null, "Espacios libres: " + agenda.espaciosLibres());
                case 0 -> JOptionPane.showMessageDialog(null, "Saliendo de la agenda...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- Métodos auxiliares ---
    private static Agenda crearAgenda() {
        String respuesta = JOptionPane.showInputDialog("¿Desea crear la agenda con tamaño personalizado? (s/n): ");
        if (respuesta != null && respuesta.equalsIgnoreCase("s")) {
            int capacidad;
            do {
                capacidad = leerEntero("Ingrese la capacidad máxima (>0): ");
                if (capacidad <= 0) {
                    JOptionPane.showMessageDialog(null, "La capacidad debe ser mayor que 0.");
                }
            } while (capacidad <= 0);
            return new Agenda(capacidad);
        } else {
            return new Agenda();
        }
    }

    private static int mostrarMenu() {
        String menu = """
                --- Menú ---
                1. Añadir contacto
                2. Verificar si existe un contacto
                3. Listar contactos
                4. Buscar contacto y mostrar teléfono
                5. Eliminar contacto
                6. Modificar teléfono de un contacto
                7. ¿Agenda llena?
                8. Espacios libres
                0. Salir
                """;

        return leerEntero(menu + "\nSeleccione una opción:");
    }

    private static void anadir(Agenda agenda) {
        try {
            String nombre = leerTexto("Nombre: ");
            String apellido = leerTexto("Apellido: ");
            String telefono = leerTexto("Teléfono: ");
            Contacto c = new Contacto(nombre, apellido, telefono);
            agenda.añadirContacto(c);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void existe(Agenda agenda) {
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        Contacto c = new Contacto(nombre, apellido, "+0000000");
        JOptionPane.showMessageDialog(null, agenda.existeContacto(c) ? "El contacto existe." : "El contacto no existe.");
    }

    private static void buscar(Agenda agenda) {
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        agenda.buscaContacto(nombre, apellido);
    }

    private static void eliminar(Agenda agenda) {
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        Contacto c = new Contacto(nombre, apellido, "+0000000");
        agenda.eliminarContacto(c);
    }

    private static void modificar(Agenda agenda) {
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        String nuevoTel = leerTexto("Nuevo teléfono: ");
        agenda.modificarTelefono(nombre, apellido, nuevoTel);
    }

    private static int leerEntero(String prompt) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(prompt);
                if (input == null) return 0; // Cancelar = salir
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }

    private static String leerTexto(String prompt) {
        while (true) {
            String input = JOptionPane.showInputDialog(prompt);
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            JOptionPane.showMessageDialog(null, "Este campo es obligatorio. Intente de nuevo.");
        }
    }
}
