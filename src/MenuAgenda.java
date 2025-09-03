import models.Agenda;

import javax.swing.*;
import java.awt.*;

public class MenuAgenda extends JFrame {
    private Agenda agenda;

    public MenuAgenda() {
        agenda = new Agenda(10); // agenda con 10 contactos máx

        setTitle("Agenda Telefónica");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel con layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btnListar = new JButton("📋 Listar Contactos");
        JButton btnBuscar = new JButton("🔎 Buscar Contacto");
        JButton btnEliminar = new JButton("🗑 Eliminar Contacto");
        JButton btnModificar = new JButton("✏ Modificar Contacto");
        JButton btnCupos = new JButton("ℹ Cupos disponibles");
        JButton btnSalir = new JButton("❌ Salir");

        // Eventos de los botones
        btnListar.addActionListener(e ->
                JOptionPane.showMessageDialog(this, agenda.listarContactos().toString())
        );

        btnBuscar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            var contacto = agenda.buscarContacto(nombre, apellido);
            JOptionPane.showMessageDialog(this,
                    contacto.map(Object::toString).orElse("No encontrado"));
        });

        btnEliminar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            agenda.eliminarContacto(nombre, apellido);
            JOptionPane.showMessageDialog(this, "Contacto eliminado (si existía)");
        });

        btnModificar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            var contacto = agenda.buscarContacto(nombre, apellido);
            if (contacto.isPresent()) {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", contacto.get().getName());
                String nuevoApellido = JOptionPane.showInputDialog("Nuevo apellido:", contacto.get().getLastname());
                contacto.get().setName(nuevoNombre);
                contacto.get().setLastname(nuevoApellido);
                JOptionPane.showMessageDialog(this, "Contacto modificado");
            } else {
                JOptionPane.showMessageDialog(this, "No encontrado");
            }
        });

//        btnCupos.addActionListener(e -> {
//            int cupos = agenda. - agenda.getContacts().size();
//            JOptionPane.showMessageDialog(this, "Cupos disponibles: " + cupos);
//        });

        btnSalir.addActionListener(e -> System.exit(0));

        // Agregar botones al panel
        panel.add(btnListar);
        panel.add(btnBuscar);
        panel.add(btnEliminar);
        panel.add(btnModificar);
        panel.add(btnCupos);
        panel.add(btnSalir);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuAgenda::new);
    }
}
