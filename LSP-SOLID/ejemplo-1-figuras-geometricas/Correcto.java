public class Correcto {

    interface Figura {
        int calcularArea();
    }

    static class Rectangulo implements Figura {
        private int ancho;
        private int alto;

        public Rectangulo(int ancho, int alto) {
            this.ancho = ancho;
            this.alto = alto;
        }

        @Override
        public int calcularArea() {
            return ancho * alto;
        }
    }

    static class Cuadrado implements Figura {
        private int lado;

        public Cuadrado(int lado) {
            this.lado = lado;
        }

        @Override
        public int calcularArea() {
            return lado * lado;
        }
    }

    public static void main(String[] args) {
        Figura rectangulo = new Rectangulo(5, 10);
        Figura cuadrado = new Cuadrado(5);

        System.out.println("Rectángulo área = " + rectangulo.calcularArea());
        System.out.println("Cuadrado área = " + cuadrado.calcularArea());
    }
}
