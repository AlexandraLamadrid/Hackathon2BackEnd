# 📒 Agenda Telefónica – Java (Hackatón)

## 📌 Descripción
Este proyecto implementa un **sistema de agenda telefónica** en Java, ejecutable por consola.  
La agenda permite **gestionar contactos** (nombre, apellido y teléfono) con validaciones y reglas específicas.

## ✅ Funcionalidades
- **Añadir contacto** (valida que no sea duplicado y que el teléfono sea válido).
- **Verificar si existe un contacto**.
- **Listar contactos** (ordenados por nombre y apellido).
- **Buscar contacto** (muestra el teléfono).
- **Eliminar contacto**.
- **Modificar teléfono** de un contacto.
- **Revisar si la agenda está llena**.
- **Consultar espacios libres**.

### Reglas de negocio
- Un contacto se identifica por **nombre + apellido** (sin importar mayúsculas/minúsculas).
- Nombre y apellido **no pueden estar vacíos**.
- Teléfono válido: entre **7 y 15 dígitos** (permitidos `+`, espacios, `-`, `(`, `)`).
- Agenda con **capacidad por defecto de 10 contactos**, o un tamaño personalizado definido por el usuario.

---

## 🗂️ Estructura del proyecto
agenda-telefonica/
├─ src/
│ └─ com/
│ └─ agenda/
│ ├─ model/
│ │ └─ Contacto.java
│ ├─ core/
│ │ └─ Agenda.java
│ └─ App.java
└─ README.md
java -cp out com.agenda.App

2. Ejecutar
   java -cp out com.agenda.App

📖 Uso

Al iniciar, la aplicación preguntará si deseas crear la agenda:

Con capacidad por defecto (10).

Con capacidad personalizada.

Luego aparecerá el menú:
1. Añadir contacto
2. Verificar si existe un contacto
3. Listar contactos
4. Buscar contacto y mostrar teléfono
5. Eliminar contacto
6. Modificar teléfono de un contacto
7. ¿Agenda llena?
8. Espacios libres
0. Salir

🎯 Criterios de Evaluación

Este proyecto cumple con:

Definición de contacto (nombre, apellido, teléfono).

Igualdad de contactos por nombre + apellido.

Agenda creada con capacidad definida o por defecto (10).

Menú por consola para probar todas las funcionalidades.

Buenas prácticas en Java: camelCase, OOP, equals/hashCode, colecciones, validaciones.

👩‍💻 Autores: Andres Cuervo, Sergio Andres Mesa, Juan Daniel Gonzalez, Alexandra Lamadrid
  
📅 *Hackatón – 03/09/2025
