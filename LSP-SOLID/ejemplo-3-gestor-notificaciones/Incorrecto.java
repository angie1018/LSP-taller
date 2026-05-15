public class Incorrecto {

    static class Notificador {
        public void enviar(String mensaje) {
            System.out.println("Enviando: " + mensaje);
        }
    }

    static class NotificadorEmail extends Notificador {
        private String email;

        public NotificadorEmail(String email) {
            this.email = email;
        }

        @Override
        public void enviar(String mensaje) {
            if (email == null || email.isEmpty()) {
                throw new RuntimeException("Email no configurado");
            }
            System.out.println("Email a " + email + ": " + mensaje);
        }
    }

    static class NotificadorSMS extends Notificador {
        private String telefono;

        public NotificadorSMS(String telefono) {
            this.telefono = telefono;
        }

        @Override
        public void enviar(String mensaje) {
            if (mensaje.length() > 20) {
                mensaje = mensaje.substring(0, 20) + "...";
            }
            System.out.println("SMS a " + telefono + ": " + mensaje);
        }
    }

    public static void main(String[] args) {
        Notificador email = new NotificadorEmail("");
        try {
            email.enviar("Hola");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Notificador sms = new NotificadorSMS("1234567890");
        sms.enviar("Mensaje largo que se corta");
    }
}
