# Instrucciones de Compilación y Ejecución

## Requisitos
- Java 8 o superior
- Terminal/Consola

## Estructura del Proyecto

```
LSP-SOLID/
├── README.md                          (Introducción general)
├── ejemplo-1-figuras-geometricas/
│   ├── Incorrecto.java               (Violando LSP)
│   ├── Correcto.java                 (Respetando LSP)
│   └── Explicacion.md                (Análisis detallado)
├── ejemplo-2-sistema-descuentos/
│   ├── Incorrecto.java
│   ├── Correcto.java
│   └── Explicacion.md
└── ejemplo-3-gestor-notificaciones/
    ├── Incorrecto.java
    ├── Correcto.java
    └── Explicacion.md
```

## Cómo compilar y ejecutar cada ejemplo

### Ejemplo 1: Figuras Geométricas

```bash
cd ejemplo-1-figuras-geometricas

# Compilar
javac Incorrecto.java
javac Correcto.java

# Ejecutar versión incorrecta (muestra la violación de LSP)
java Incorrecto

# Ejecutar versión correcta
java Correcto
```

**Salida esperada en Incorrecto:**
- Verás cómo el Cuadrado no respeta el contrato de Rectángulo
- El área no coincide con lo esperado

**Salida esperada en Correcto:**
- Cada forma implementa su propia interfaz
- Los valores son predecibles y consistentes

---

### Ejemplo 2: Sistema de Descuentos

```bash
cd ejemplo-2-sistema-descuentos

# Compilar
javac Incorrecto.java
javac Correcto.java

# Ejecutar versión incorrecta
java Incorrecto

# Ejecutar versión correcta
java Correcto
```

**Salida esperada en Incorrecto:**
- Se lanzan excepciones inesperadas
- El cliente no puede sustituir los descuentos

**Salida esperada en Correcto:**
- Sin excepciones sorpresa
- Todas las estrategias respetan el contrato

---

### Ejemplo 3: Gestor de Notificaciones

```bash
cd ejemplo-3-gestor-notificaciones

# Compilar
javac Incorrecto.java
javac Correcto.java

# Ejecutar versión incorrecta
java Incorrecto

# Ejecutar versión correcta
java Correcto
```

**Salida esperada en Incorrecto:**
- Comportamientos inconsistentes entre canales
- Algunos lanzan excepciones, otros no

**Salida esperada en Correcto:**
- Todos los canales funcionan consistentemente
- Se pueden intercambiar sin problemas

---

## Compilar y ejecutar todo de una vez

### En Windows (cmd/PowerShell):

```bash
cd LSP-SOLID

echo === Ejemplo 1 ===
cd ejemplo-1-figuras-geometricas
javac Incorrecto.java Correcto.java
echo.
echo Versión Incorrecta:
java Incorrecto
echo.
echo Versión Correcta:
java Correcto
cd ..

echo.
echo === Ejemplo 2 ===
cd ejemplo-2-sistema-descuentos
javac Incorrecto.java Correcto.java
echo.
echo Versión Incorrecta:
java Incorrecto
echo.
echo Versión Correcta:
java Correcto
cd ..

echo.
echo === Ejemplo 3 ===
cd ejemplo-3-gestor-notificaciones
javac Incorrecto.java Correcto.java
echo.
echo Versión Incorrecta:
java Incorrecto
echo.
echo Versión Correcta:
java Correcto
cd ..
```

### En Linux/Mac (bash):

```bash
cd LSP-SOLID

echo "=== Ejemplo 1 ==="
cd ejemplo-1-figuras-geometricas
javac Incorrecto.java Correcto.java
echo ""
echo "Versión Incorrecta:"
java Incorrecto
echo ""
echo "Versión Correcta:"
java Correcto
cd ..

echo ""
echo "=== Ejemplo 2 ==="
cd ejemplo-2-sistema-descuentos
javac Incorrecto.java Correcto.java
echo ""
echo "Versión Incorrecta:"
java Incorrecto
echo ""
echo "Versión Correcta:"
java Correcto
cd ..

echo ""
echo "=== Ejemplo 3 ==="
cd ejemplo-3-gestor-notificaciones
javac Incorrecto.java Correcto.java
echo ""
echo "Versión Incorrecta:"
java Incorrecto
echo ""
echo "Versión Correcta:"
java Correcto
cd ..
```

---

## Notas Importantes

1. Los archivos `.class` se generan automáticamente al compilar (puedes eliminarlos)
2. No necesitas herramientas especiales como Maven o Gradle
3. Cada ejemplo es independiente
4. Lee el archivo `Explicacion.md` en cada carpeta para entender qué se violó

## Próximos pasos

1. Revisa el README.md para entender los conceptos
2. Ejecuta los ejemplos "Incorrecto" para ver las violaciones
3. Compara con los ejemplos "Correcto"
4. Lee las explicaciones en Explicacion.md


