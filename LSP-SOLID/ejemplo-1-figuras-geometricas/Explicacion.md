# Ejemplo 1: Figuras Geométricas

## El Problema (Incorrecto.java)

### Código Incorrecto
```java
static class Cuadrado extends Rectangulo {
    @Override
    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.alto = ancho;  // Fuerza que sea igual
    }
}
```

### ¿Qué viola LSP?

Cuando llamamos a `imprimirInfo()`:
```java
Rectangulo figura = new Cuadrado(5);
figura.setAncho(5);
figura.setAlto(10);  // Se espera que alto sea 10, pero será 5
```

**Problema**: El `Cuadrado` cambia el comportamiento esperado:
- Al usuario le dice que está usando un `Rectangulo`
- Pero cuando llama a `setAlto(10)`, internamente se ignora y se iguala al ancho
- **El contrato se viola**: `setAlto()` no hace lo que promete

---

## La Solución (Correcto.java)

### Cambios Clave

**1. Usar interfaces en lugar de herencia**
```java
interface Figura {
    int calcularArea();
}

class Rectangulo implements Figura { ... }
class Cuadrado implements Figura { ... }
```

**2. Métodos específicos para cada tipo**
```java
// Rectangulo tiene ancho y alto distintos
rectangulo.setAncho(5);
rectangulo.setAlto(10);

// Cuadrado tiene solo un lado
cuadrado.setLado(5);
```

**3. No hay sorpresas**
- Cada clase respeta su propio contrato
- No hay comportamientos ocultos
- El código es predecible

---

## Ejecución

### Incorrecto:
```
Ancho: 5
Alto: 10
Área esperada: 50
Área real: 50

--- Usando Cuadrado como Rectangulo ---
Ancho: 10
Alto: 10
Área esperada: 50
Área real: 100    ← ❌ ¡ERROR! No es lo esperado
¿Es correcto? false
```

### Correcto:
```
Ancho: 5
Alto: 10
Área esperada: 50
Área real: 50
✓ Es correcto: true

--- Usando Cuadrado (su propia interfaz) ---
Lado: 5
Área esperada: 25
Área real: 25
✓ Es correcto: true
```

---

## Lecciones Clave

1. **No heredar solo porque es "parecido"** - Un cuadrado no es un tipo de rectángulo desde el punto de vista del comportamiento
2. **Respetar contratos** - Si heredes, mantén el mismo comportamiento esperado
3. **Considerar interfaces** - Mejor que herencia cuando los comportamientos difieren
4. **Precondiciones y postcondiciones** - Deben ser consistentes en subclases

