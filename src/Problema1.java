public class Problema1 implements Problema {
    @Override
    public double evaluar(double x, double y) {
        return Math.pow(x - 3.14, 2) +
                Math.pow(y - 2.72, 2) +
                Math.sin(3 * x + 1.41) +
                Math.sin(4 * y - 1.73);
    }
}
