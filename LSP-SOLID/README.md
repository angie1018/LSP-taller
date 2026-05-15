# Principio de Sustitución de Liskov (LSP)

## Introducción

El **Liskov Substitution Principle (LSP)** establece que:

> "Los objetos de una clase derivada deben poder sustituir a los objetos de la clase base sin alterar las propiedades deseables del programa"

En otras palabras: **Si B es un subtipo de A, entonces los objetos de tipo A pueden ser reemplazados por objetos de tipo B sin que el programa pierda funcionalidad ni presente comportamientos inesperados**.

---

## ¿Por qué es importante?

1. **Confiabilidad**: El código que usa la clase base funciona correctamente con cualquier subclase
2. **Mantenibilidad**: Evita comportamientos sorpresivos al usar herencia
3. **Reutilización**: Permite aprovechar la abstracción sin miedo a efectos secundarios

---

## Violación común de LSP

Una violación ocurre cuando:

```java
Animal animal = new Pajaro();
animal.volar(); // ¿Qué pasa si obtenemos un Pinguino?
```

El `Pinguino` hereda de `Animal` pero no puede volar. Esto viola LSP.

---

## Ejemplos en este repositorio

| Ejemplo | Tema | Problema | Solución |
|---------|------|----------|----------|
| [Ejemplo 1](./ejemplo-1-figuras-geometricas) | Figuras Geométricas | Cuadrado como subclase de Rectángulo | Usar composición o interfaces específicas |
| [Ejemplo 2](./ejemplo-2-sistema-descuentos) | Sistema de Descuentos | Descuentos que lanzan excepciones inesperadas | Implementar estrategias consistentes |
| [Ejemplo 3](./ejemplo-3-gestor-notificaciones) | Gestor de Notificaciones | Notificadores con comportamientos incompatibles | Respetar el contrato de la interfaz |

---

## Cómo ejecutar los ejemplos

Cada carpeta contiene:

1. **Incorrecto.java** → Código que viola LSP
2. **Correcto.java** → Código que respeta LSP
3. **Explicacion.md** → Análisis detallado

Para compilar y ejecutar:

```bash
cd ejemplo-1-figuras-geometricas
javac *.java
java Incorrecto
java Correcto
```

---

## Resumen de principios clave

**Las subclases deben mantener el contrato de la clase padre**

**No debe haber comportamientos sorpresivos en las subclases**

**Si una subclase no puede hacer algo, no debe heredar de esa clase**

**No lanzar excepciones inesperadas en métodos heredados**

**No debilitar validaciones o precondiciones**

**No fortalecer postcondiciones más allá de lo esperado**
