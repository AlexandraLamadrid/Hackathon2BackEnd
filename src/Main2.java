import javax.swing.*;

public class Main2 {



        public static void main(String[] args) {
            String[] opciones = {
                    "Listar Contactos",
                    "Buscar Contacto",
                    "Eliminar Contacto",
                    "Modificar Contacto",
                    "Cupos disponibles",
                    "Salir"
            };

            int opcion;
            do {
                opcion = JOptionPane.showOptionDialog(
                        null,
                        "Bienvenido a tu lista de contactos\nSelecciona una opción:",
                        "Agenda Telefónica",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );

                switch (opcion) {
                    case 0 -> JOptionPane.showMessageDialog(null, "📋 Aquí listarías los contactos");
                    case 1 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String apellido = JOptionPane.showInputDialog("Apellido:");
                        JOptionPane.showMessageDialog(null, "🔎 Buscando: " + nombre + " " + apellido);
                    }
                    case 2 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String apellido = JOptionPane.showInputDialog("Apellido:");
                        JOptionPane.showMessageDialog(null, "🗑 Eliminando: " + nombre + " " + apellido);
                    }
                    case 3 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String apellido = JOptionPane.showInputDialog("Apellido:");
                        JOptionPane.showMessageDialog(null, "✏ Modificando: " + nombre + " " + apellido);
                    }
                    case 4 -> JOptionPane.showMessageDialog(null, "ℹ Cupos disponibles: (aquí iría tu lógica)");
                    case 5 -> JOptionPane.showMessageDialog(null, "👋 Saliendo de la agenda...");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida");
                }

            } while (opcion != 5);
        }
    }





