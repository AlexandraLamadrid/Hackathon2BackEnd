package com.agenda.model;

import java.util.Objects;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() ||
                apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden estar vacíos.");
        }
        if (!telefono.matches("\\+?\\d{7,15}")) {
            throw new IllegalArgumentException("Formato de teléfono inválido.");
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.telefono = telefono.trim();
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto contacto = (Contacto) o;
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
