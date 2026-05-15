public class Incorrecto {

    static class Descuento {
        protected double porcentaje;

        public Descuento(double porcentaje) {
            this.porcentaje = porcentaje;
        }

        public double aplicar(double monto) {
            return monto - (monto * porcentaje / 100);
        }
    }

    static class DescuentoVIP extends Descuento {
        public DescuentoVIP(double porcentaje) {
            super(porcentaje);
        }

        @Override
        public double aplicar(double monto) {
            if (monto < 100) {
                throw new RuntimeException("Monto mínimo 100 requerido");
            }
            return super.aplicar(monto);
        }
    }

    public static void main(String[] args) {
        Descuento normal = new Descuento(10);
        System.out.println("Descuento normal 100 => " + normal.aplicar(100));

        Descuento vip = new DescuentoVIP(20);
        System.out.println("Descuento VIP 50 => " + vip.aplicar(50));
    }
}
