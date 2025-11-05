import java.util.*;

public class AlgoritmoPSO {

    public static void ejecutar(int numParticulas, int iteraciones, double limite) {
        Random rand = new Random();

        // Crear enjambre inicial
        List<Particula> enjambre = new ArrayList<>();
        for (int i = 0; i < numParticulas; i++) {
            double x = (rand.nextDouble() * 2 * limite) - limite;
            double y = (rand.nextDouble() * 2 * limite) - limite;
            double vx = rand.nextDouble() - 0.5;
            double vy = rand.nextDouble() - 0.5;
            enjambre.add(new Particula(x, y, vx, vy));
        }

        // Evolución aleatoria
        for (int iter = 0; iter < iteraciones; iter++) {
            System.out.printf("Iteración %d:%n", iter);
            for (int i = 0; i < numParticulas; i++) {
                Particula p = enjambre.get(i);

                // Nueva velocidad aleatoria
                double nuevoVx = rand.nextDouble() - 0.5;
                double nuevoVy = rand.nextDouble() - 0.5;

                // Actualizar posición
                double nuevoX = p.x() + nuevoVx;
                double nuevoY = p.y() + nuevoVy;

                // Limitar posición
                nuevoX = Math.max(-limite, Math.min(limite, nuevoX));
                nuevoY = Math.max(-limite, Math.min(limite, nuevoY));

                // Actualizar partícula
                enjambre.set(i, new Particula(nuevoX, nuevoY, nuevoVx, nuevoVy));

                // Mostrar datos
                System.out.printf("  Partícula %d -> Pos(%.2f, %.2f) Vel(%.2f, %.2f)%n",
                        i, nuevoX, nuevoY, nuevoVx, nuevoVy);
            }
            System.out.println();
        }
    }
}
