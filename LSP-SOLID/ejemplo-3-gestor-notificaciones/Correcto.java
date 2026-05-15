public class Correcto {

    interface Canal {
        String enviar(String mensaje);
    }

    static class CanalEmail implements Canal {
        private String email;

        public CanalEmail(String email) {
            this.email = email;
        }

        @Override
        public String enviar(String mensaje) {
            if (email == null || email.isEmpty()) {
                return "Email no configurado";
            }
            return "Email a " + email + ": " + mensaje;
        }
    }

    static class CanalSMS implements Canal {
        private String telefono;

        public CanalSMS(String telefono) {
            this.telefono = telefono;
        }

        @Override
        public String enviar(String mensaje) {
            if (mensaje.length() > 20) {
                mensaje = mensaje.substring(0, 20) + "...";
            }
            return "SMS a " + telefono + ": " + mensaje;
        }
    }

    public static void main(String[] args) {
        Canal email = new CanalEmail("usuario@example.com");
        Canal sms = new CanalSMS("1234567890");

        System.out.println(email.enviar("Hola"));
        System.out.println(sms.enviar("Mensaje largo que se corta"));
    }
}
