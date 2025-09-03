# 📒 Agenda Telefónica en Java

Este proyecto implementa un sistema de gestión de contactos (agenda telefónica) en Java.  
Permite añadir, listar, buscar, modificar y eliminar contactos, así como verificar si la agenda está llena y cuántos espacios libres quedan.

---

## 🚀 Requisitos
- Java 8 o superior
- Git Bash o CMD/PowerShell en Windows

---

## 📂 Estructura del proyecto
Hackathon2BackEnd/
│── src/
│ ├── main/java/com/agenda/App.java
│ ├── main/java/com/agenda/core/Agenda.java
│ ├── main/java/com/agenda/model/Contacto.java
│── out/ (se genera al compilar)

# Ejecutar el programa
java -cp out com.agenda.App

📌 Funcionalidades principales

Añadir contacto (validando duplicados y formato de teléfono).

Listar contactos en orden alfabético.

Buscar contacto por nombre y apellido.

Eliminar contacto de la agenda.

Modificar teléfono de un contacto existente.

Comprobar si la agenda está llena.

Mostrar espacios libres disponibles.

🏆 Notas

La agenda puede crearse con un tamaño personalizado o con el tamaño por defecto (10 contactos).

Los nombres y apellidos no distinguen mayúsculas/minúsculas.

Un contacto se considera duplicado si el nombre y apellido coinciden.
