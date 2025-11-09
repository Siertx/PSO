import java.util.*;

public class AlgoritmoPSO {

    public static void ejecutar(int numParticulas, int iteraciones, double w, double c1, double c2, Problema problema) {
        Random rand = new Random();

        // Inicializar enjambre
        List<Particula> enjambre = new ArrayList<>();
        for (int i = 0; i < numParticulas; i++) {
            double x = rand.nextDouble() * 5;
            double y = rand.nextDouble() * 5;
            double vx = rand.nextDouble() - 0.5;
            double vy = rand.nextDouble() - 0.5;
            enjambre.add(new Particula(x, y, vx, vy, x, y));
        }

        // Inicializar gbest según la mejor partícula inicial
        double gbestX = enjambre.get(0).x();
        double gbestY = enjambre.get(0).y();
        double gbestValor = problema.evaluar(gbestX, gbestY);

        for (int iter = 0; iter < iteraciones; iter++) {
            System.out.printf("Iteración %d:%n", iter);

            for (int i = 0; i < numParticulas; i++) {
                Particula p = enjambre.get(i);

                // r1 y r2 aleatorios
                double r1 = rand.nextDouble();
                double r2 = rand.nextDouble();

                // Actualizar velocidad
                double nuevoVx = w * p.vx() + c1 * r1 * (p.pbestX() - p.x()) + c2 * r2 * (gbestX - p.x());
                double nuevoVy = w * p.vy() + c1 * r1 * (p.pbestY() - p.y()) + c2 * r2 * (gbestY - p.y());

                // Actualizar posición
                double nuevoX = p.x() + nuevoVx;
                double nuevoY = p.y() + nuevoVy;

                // Evaluar función objetivo
                double valorActual = problema.evaluar(nuevoX, nuevoY);

                // Actualizar pbest si mejora
                double nuevoPbestX = p.pbestX();
                double nuevoPbestY = p.pbestY();
                if (valorActual < problema.evaluar(p.pbestX(), p.pbestY())) {
                    nuevoPbestX = nuevoX;
                    nuevoPbestY = nuevoY;
                }

                // Actualizar gbest si mejora
                if (valorActual < gbestValor) {
                    gbestX = nuevoX;
                    gbestY = nuevoY;
                    gbestValor = valorActual;
                }

                // Guardar nueva partícula
                enjambre.set(i, p.actualizar(nuevoX, nuevoY, nuevoVx, nuevoVy, nuevoPbestX, nuevoPbestY));

                // Mostrar datos
                System.out.printf("  Partícula %d -> Pos(%.2f, %.2f) Vel(%.2f, %.2f) f=%.4f%n",
                        i, nuevoX, nuevoY, nuevoVx, nuevoVy, valorActual);
            }

            System.out.printf("Mejor global: (%.4f, %.4f) f=%.4f%n%n", gbestX, gbestY, gbestValor);
        }
    }
}
