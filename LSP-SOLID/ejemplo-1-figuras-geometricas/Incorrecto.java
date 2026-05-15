public class Incorrecto {

    static class Rectangulo {
        protected int ancho;
        protected int alto;

        public Rectangulo(int ancho, int alto) {
            this.ancho = ancho;
            this.alto = alto;
        }

        public void setAncho(int ancho) {
            this.ancho = ancho;
        }

        public void setAlto(int alto) {
            this.alto = alto;
        }

        public int calcularArea() {
            return ancho * alto;
        }
    }

    static class Cuadrado extends Rectangulo {
        public Cuadrado(int lado) {
            super(lado, lado);
        }

        @Override
        public void setAncho(int ancho) {
            this.ancho = ancho;
            this.alto = ancho;
        }

        @Override
        public void setAlto(int alto) {
            this.ancho = alto;
            this.alto = alto;
        }
    }

    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(5, 10);
        System.out.println("Rectángulo área = " + rectangulo.calcularArea());

        Rectangulo cuadrado = new Cuadrado(5);
        cuadrado.setAlto(10);
        System.out.println("Cuadrado como Rectángulo área = " + cuadrado.calcularArea());
    }
}
