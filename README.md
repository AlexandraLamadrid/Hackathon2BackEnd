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
