public record Particula(double x, double y, double vx, double vy) {
    public Particula actualizar(double nuevoX, double nuevoY, double nuevoVx, double nuevoVy) {
        return new Particula(nuevoX, nuevoY, nuevoVx, nuevoVy);
    }

}