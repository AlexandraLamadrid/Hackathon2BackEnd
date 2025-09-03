import models.Agenda;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = crearAgenda();

        int opcion;
        do {
            opcion = mostrarMenuConBotones();
            switch (opcion) {
                case 0: // Añadir contacto
                    anadir(agenda);
                    break;
                case 1: // Listar contactos
                    listar(agenda);
                    break;
                case 2: // Buscar contacto
                    buscar(agenda);
                    break;
                case 3: // Eliminar contacto
                    eliminar(agenda);
                    break;
                case 4: // Modificar teléfono
                    agenda.modificarTelefono(agenda);
                    break;
                case 5: // ¿Agenda llena?
                    JOptionPane.showMessageDialog(
                            null,
                            agenda.agendaLlena() ? "La agenda está llena." : "La agenda NO está llena."
                    );
                    break;
                case 6: // Espacios libres
                    JOptionPane.showMessageDialog(
                            null,
                            "Espacios libres: " + agenda.espaciosLibres()
                    );
                    break;
                case 7: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo... ¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void eliminar(Agenda agenda) {
    }

    private static void buscar(Agenda agenda) {
    }

    private static void listar(Agenda agenda) {
    }

    private static void anadir(Agenda agenda) {
    }

    private static Agenda crearAgenda() {
        String[] opciones = {"Por defecto (10)", "Personalizado"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "¿Deseas usar el tamaño por defecto (10) o indicar uno propio?",
                "Crear agenda",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion == 1) {
            String entrada = JOptionPane.showInputDialog("Ingresa el tamaño máximo de la agenda:");
            try {
                int tam = Integer.parseInt(entrada.trim());
                if (tam > 0) return new Agenda(tam);
            } catch (NumberFormatException ignored) {}
            JOptionPane.showMessageDialog(null, "Tamaño inválido. Se usará 10 por defecto.");
        }
        return new Agenda(10);
    }

    private static int mostrarMenuConBotones() {
        String[] opciones = {
                "Añadir contacto",
                "Listar contactos",
                "Buscar contacto",
                "Eliminar contacto",
                "Modificar teléfono",
                "¿Agenda llena?",
                "Espacios libres",
                "Salir"
        };

        return JOptionPane.showOptionDialog(
                null,
                "Selecciona una opción:",
                "Menú Agenda Telefónica",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
    }

    // Métodos auxiliares iguales que antes (anadir, listar, buscar, eliminar, modificarTelefono)
    // ...
}