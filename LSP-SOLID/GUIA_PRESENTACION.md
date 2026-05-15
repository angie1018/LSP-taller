# Guía de Presentación - LSP (Liskov Substitution Principle)

## Estructura de la exposición (15-20 minutos)

### Introducción (2 minutos)
- **¿Qué es LSP?**
  - "Si B es subtipo de A, entonces objetos de A se pueden reemplazar por objetos de B"
  - Es sobre **confiabilidad** y **predecibilidad** en la herencia
  
- **¿Por qué importa?**
  - Evita errores en tiempo de ejecución
  - Hace que el código sea más mantenible
  - Facilita la reutilización de código

---

### Ejemplo 1: Figuras Geométricas (4 minutos)

**Diapositiva: El Problema**
```
¿Es un Cuadrado un tipo de Rectángulo?
- Matemáticamente: Sí (es un rectángulo especial)
- En programación: ¡NO! (comportamientos diferentes)
```

**Mostrar código incorrecto:**
- Heredar `Cuadrado` de `Rectángulo`
- El método `setAlto()` también cambia el ancho
- **Resultado:** Área incorrecta (100 en vez de 50)

**Mostrar código correcto:**
- Ambos implementan interfaz `Figura`
- Métodos específicos: `setAncho/setAlto` vs `setLado`
- **Resultado:** Cada uno funciona como esperado

**Lección:** "Un Cuadrado no puede simplemente heredar de Rectángulo"

---

### Ejemplo 2: Sistema de Descuentos (4 minutos)

**Diapositiva: El Problema**
```
Todas son "Descuentos", pero...
- DescuentoSimple: Siempre funciona
- DescuentoVIP: Lanza excepciones si monto < mínimo
- DescuentoNegocio: Lanza excepciones si monto > máximo
```

**¿Qué pasa cuando intentas sustituir?**
- Código cliente: `descuento.aplicar(monto);`
- Unas veces funciona, otras lanzan excepciones
- **Violación LSP:** El cliente debe saber qué tipo es realmente

**Mostrar código correcto:**
- Interfaz consistente: `EstrategiaDescuento`
- Método `cumplePrerrequisitos()` para validaciones
- Método `aplicar()` nunca lanza excepciones sorpresa

**Lección:** "Los contratos deben respetarse en todas las subclases"

---

### Ejemplo 3: Gestor de Notificaciones (4 minutos)

**Diapositiva: El Problema**
```
"Enviar" es diferente para cada canal:
- Email: Lanza excepciones si no está configurado
- SMS: Silenciosamente trunca si > 160 caracteres
- WhatsApp: Silenciosamente ignora si sin número
```

**¿Cuál es el contrato?**
- Para `Email`: Excepciones son parte del contrato
- Para `SMS`: Cambios silenciosos del mensaje
- Para `WhatsApp`: Ignora el problema
- **Imposible sustituir uno por otro**

**Mostrar código correcto:**
- Interfaz clara: `CanalNotificacion` con `enviar()` y `puedeEnviar()`
- Excepciones explícitas: `NotificacionException`
- Cliente verifica `puedeEnviar()` primero
- Comportamientos especiales (límite SMS) son públicos

**Lección:** "Los comportamientos especiales deben ser explícitos"

---

## Conclusión (2 minutos)

### Principios clave de LSP

**Las subclases deben respetar el contrato de la superclase**
- Mismo comportamiento esperado
- Mismas excepciones
- Mismas garantías

**No fortalecer precondiciones**
- La subclase no debe pedir más que la superclase

**No debilitar postcondiciones**
- La subclase no debe prometer menos que la superclase

**Usar interfaces cuando el comportamiento difiera**
- Mejor que herencia en esos casos

### Impacto en el Código Real

- **Código más confiable**: Sabes qué esperar
- **Mejor mantenimiento**: Cambios seguros sin sorpresas
- **Reutilización real**: Puedes reemplazar implementaciones
- **Menos bugs**: Comportamientos predecibles

---

## Preguntas posibles y respuestas

**P: ¿Cuándo violo LSP sin saberlo?**
R: Cuando heredas para "reutilizar código" sin que la relación sea real. Un `ArchivoSoloLectura` no debería heredar de `Archivo` si luego sobrescribes `guardar()` para lanzar excepción.

**P: ¿Siempre debo usar interfaces en lugar de herencia?**
R: No, pero cuando los comportamientos son sustancialmente diferentes, una interfaz es mejor que herencia.

**P: ¿Qué pasa si mi proyecto actual viola LSP?**
R: Identifica dónde el cliente necesita preguntar "¿qué tipo realmente eres?". Eso es señal de violación LSP.

---

## Slides sugeridas

1. Título: "LSP - Liskov Substitution Principle"
2. ¿Qué es LSP?
3. Ejemplo 1: Figuras - El Problema
4. Ejemplo 1: Figuras - La Solución
5. Ejemplo 2: Descuentos - El Problema
6. Ejemplo 2: Descuentos - La Solución
7. Ejemplo 3: Notificaciones - El Problema
8. Ejemplo 3: Notificaciones - La Solución
9. Conclusión: 4 Principios Clave
10. Preguntas

---

## Cómo presentar el código

**Opción A: Mostrar en pantalla durante la exposición**
```
1. Compilar en vivo (¡muestra que funciona!)
2. Ejecutar versión incorrecta
3. Mostrar el error / comportamiento inesperado
4. Ejecutar versión correcta
5. Comparar resultados
```

**Opción B: Diapositivas con código**
- Incluir fragmentos clave del código en las diapositivas
- Mantener el color de sintaxis
- Marcar las diferencias principales

**Mi recomendación:** Combinar ambas
- Diapositivas para explicar conceptos
- Compilar y ejecutar en vivo para demostrar

---

## Timing sugerido

- Introducción: 2 min
- Ejemplo 1 (Figuras): 4 min (1 min concepto + 2 min demo + 1 min explicación)
- Ejemplo 2 (Descuentos): 4 min
- Ejemplo 3 (Notificaciones): 4 min
- Conclusión: 2 min
- Preguntas: 4 min
- **Total: 20 minutos**

---

## Checklist de presentación

- [ ] Compilé todos los ejemplos y funcionan
- [ ] Preparé mis diapositivas
- [ ] Practiqué la presentación
- [ ] Tengo los archivos .java listos para mostrar
- [ ] Entiendo cada ejemplo lo suficientemente bien para responder preguntas
- [ ] Preparé ejemplos extra (si lo crees necesario)
- [ ] Subí todo a GitHub (con README claro)

