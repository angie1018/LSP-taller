public class Correcto {

    interface EstrategiaDescuento {
        double aplicar(double monto);
    }

    static class DescuentoSimple implements EstrategiaDescuento {
        private double porcentaje;

        public DescuentoSimple(double porcentaje) {
            this.porcentaje = porcentaje;
        }

        @Override
        public double aplicar(double monto) {
            return monto - (monto * porcentaje / 100);
        }
    }

    static class DescuentoVIP implements EstrategiaDescuento {
        private double porcentaje;

        public DescuentoVIP(double porcentaje) {
            this.porcentaje = porcentaje;
        }

        @Override
        public double aplicar(double monto) {
            if (monto < 100) {
                return monto;
            }
            return monto - (monto * porcentaje / 100);
        }
    }

    public static void main(String[] args) {
        EstrategiaDescuento normal = new DescuentoSimple(10);
        EstrategiaDescuento vip = new DescuentoVIP(20);

        System.out.println("Normal 100 => " + normal.aplicar(100));
        System.out.println("VIP 50 => " + vip.aplicar(50));
        System.out.println("VIP 150 => " + vip.aplicar(150));
    }
}
