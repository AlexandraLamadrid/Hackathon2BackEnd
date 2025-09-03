package com.agenda.core;

import com.agenda.model.Contacto;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda() {
        this(10); // tamaño por defecto
    }

    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            JOptionPane.showMessageDialog(null, "La agenda está llena. No se pueden añadir más contactos.");
            return;
        }
        if (existeContacto(c)) {
            JOptionPane.showMessageDialog(null, "El contacto ya existe en la agenda.");
            return;
        }
        contactos.add(c);
        JOptionPane.showMessageDialog(null, "Contacto añadido correctamente.");
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La agenda está vacía.");
            return;
        }
        List<Contacto> ordenados = new ArrayList<>(contactos);
        Collections.sort(ordenados, Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));

        StringBuilder lista = new StringBuilder("📒 Lista de Contactos:\n");
        for (Contacto c : ordenados) {
            lista.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void buscaContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                JOptionPane.showMessageDialog(null, "El teléfono de " + nombre + " " + apellido + " es: " + c.getTelefono());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El contacto no se ha encontrado.");
    }

    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el contacto en la agenda.");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                JOptionPane.showMessageDialog(null, "Teléfono modificado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el contacto para modificar.");
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }
}
