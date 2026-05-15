# Ejemplo 2: Sistema de Descuentos

## El Problema (Incorrecto.java)

### Código Incorrecto
```java
static class DescuentoVIP extends Descuento {
    @Override
    public double aplicar(double monto) {
        if (monto < montoMinimo) {
            throw new RuntimeException("Monto mínimo requerido...");
        }
        return super.aplicar(monto);
    }
}
```

### ¿Qué viola LSP?

El contrato de `Descuento.aplicar()` es:
- **Entrada**: cualquier monto positivo
- **Salida**: monto con descuento aplicado
- **Garantía**: nunca lanza excepciones

Pero `DescuentoVIP` viola esto:
- **Lanza excepciones** si el monto es muy bajo
- El cliente no puede sustituir `Descuento` por `DescuentoVIP` sin cambiar su código
- El cliente debe anticipar y manejar excepciones inesperadas

---

## La Solución (Correcto.java)

### Cambios Clave

**1. Usar interfaces en lugar de herencia**
```java
interface EstrategiaDescuento {
    double aplicar(double monto);
}
```

**2. Validar antes, nunca lanzar dentro de aplicar()**
```java
// DescuentoVIP respeta el contrato
@Override
public double aplicar(double monto) {
    if (!cumplePrerrequisitos(monto)) {
        return monto;  // Sin excepción
    }
    return monto - (monto * porcentaje / 100);
}
```

**3. Métodos separados para validaciones**
```java
// El cliente puede verificar prerrequisitos antes
if (descuentoVIP.cumplePrerrequisitos(monto)) {
    procesarCompra(descuentoVIP, monto);
}
```

**4. DescuentoNegocio también respeta el contrato**
```java
// Nunca lanza excepción, ajusta automáticamente
@Override
public double aplicar(double monto) {
    double montoAplicable = Math.min(monto, limiteMaximo);
    double descuento = montoAplicable * porcentaje / 100;
    return monto - descuento;
}
```

---

## Ejecución

### Incorrecto:
```
Monto original: 100
Monto con descuento: 90

Monto original: 500
Monto con descuento: 450

--- Descuentos VIP (lanza excepciones) ---
ERROR: Monto mínimo de 100 requerido. Monto actual: 50

--- Descuentos Negocio (lanza excepciones) ---
ERROR: Monto no puede exceder 100. Monto actual: 200
```

### Correcto:
```
Monto original: 100
Monto con descuento: 90

Monto original: 500
Monto con descuento: 450

--- Descuentos VIP (sin excepciones) ---
Monto original: 50
Monto con descuento: 50
Monto original: 150
Monto con descuento: 120

--- Descuentos Negocio (sin excepciones) ---
Monto original: 80
Monto con descuento: 68
Monto original: 200
Monto con descuento: 185
```

---

## Lecciones Clave

1. **El contrato debe ser respetado** - Si la clase base no lanza excepciones, las subclases tampoco deben
2. **No fortalecer precondiciones** - No añadas restricciones inesperadas
3. **Mantener postcondiciones** - Los resultados deben ser predecibles
4. **Usar interfaces cuando cambien comportamientos** - Mejor que heredar de clases con contratos rígidos

