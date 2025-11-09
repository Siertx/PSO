import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int numParticulas = 1000;
        int iteraciones = 100;
        double w = 0.5;
        double c1 = 0.5;
        double c2 = 0.5;
        Problema problema = new Problema1();
        AlgoritmoPSO.ejecutar(numParticulas, iteraciones, w, c1, c2, problema);
    }
}
