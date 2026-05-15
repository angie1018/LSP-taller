# Ejemplo 3: Gestor de Notificaciones

## El Problema (Incorrecto.java)

### Código Incorrecto
```java
static class NotificadorEmail extends Notificador {
    @Override
    public void enviar(String mensaje) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email no configurado");
        }
        // ...
    }
}
```

### ¿Qué viola LSP?

Cada notificador hereda de `Notificador` pero:

1. **NotificadorEmail** lanza excepciones si falta el email
2. **NotificadorSMS** silenciosamente trunca mensajes largos
3. **NotificadorWhatsapp** retorna sin hacer nada si hay problemas

El cliente espera que todos funcionen igual, pero:
- Algunos lanzan excepciones
- Otros silenciosamente modifican el comportamiento
- Otros simplemente ignoran el problema

**Imposible sustituir** un tipo por otro sin cambiar el código cliente.

---

## La Solución (Correcto.java)

### Cambios Clave

**1. Interfaz consistente con excepciones claras**
```java
interface CanalNotificacion {
    void enviar(String mensaje) throws NotificacionException;
    boolean puedeEnviar();
}
```

**2. Todos respetan el mismo contrato**
```java
class CanalEmail implements CanalNotificacion {
    @Override
    public void enviar(String mensaje) throws NotificacionException {
        if (email == null || email.isEmpty()) {
            throw new NotificacionException("Email no configurado");
        }
        // Envía exactamente lo que se pide
    }

    @Override
    public boolean puedeEnviar() {
        return email != null && !email.isEmpty();
    }
}
```

**3. Cliente verifica estado antes de enviar**
```java
if (canal.puedeEnviar()) {
    canal.enviar(contenido);
}
```

**4. Comportamientos especiales son explícitos**
```java
class CanalSMS implements CanalNotificacion {
    private static final int LIMITE_CARACTERES = 160;

    @Override
    public void enviar(String mensaje) throws NotificacionException {
        String procesado = mensaje.length() > LIMITE_CARACTERES
            ? mensaje.substring(0, LIMITE_CARACTERES)
            : mensaje;
        // Siempre hace lo que promete
    }

    public int getLimiteCaracteres() {
        return LIMITE_CARACTERES;  // Cliente puede consultarlo si lo necesita
    }
}
```

---

## Ejecución

### Incorrecto:
```
Enviando: Hola, esta es una notificación de prueba del sistema
✓ Email enviado a usuario@example.com: Hola, esta es una notificación...
SMS enviado a 1234567890: Hola, esta es una notificación de prueba...
✓ WhatsApp a 1234567890: Hola, esta es una notificación...

--- Casos problemáticos ---
Email sin configurar:
ERROR no esperado: Email no configurado

Mensaje muy largo en SMS:
SMS enviado a 9876543210: Este es un mensaje extremadamente largo que...
```

### Correcto:
```
--- Todos los canales funcionan consistentemente ---
✓ Email enviado a usuario@example.com: Hola, esta es una notificación...
✓ SMS enviado a 1234567890: Hola, esta es una notificación de prueba...
✓ WhatsApp a 573001234567: Hola, esta es una notificación...

--- Verificar antes de enviar ---
✗ Email no configurado, se omite el envío

--- SMS con límite de caracteres ---
Límite SMS: 160 caracteres
Mensaje original: 103 caracteres
✓ SMS enviado a 9876543210: Este es un mensaje extremadamente...
```

---

## Lecciones Clave

1. **Interfaz clara y consistente** - Todos los canales respetan el mismo contrato
2. **Excepciones explícitas** - `NotificacionException` es parte del contrato
3. **Validaciones públicas** - `puedeEnviar()` permite verificar antes de llamar
4. **Comportamientos especiales documentados** - Si hay límites, se documentan y son accesibles
5. **Sustitución verdadera** - Cualquier canal puede reemplazar a otro sin sorpresas

