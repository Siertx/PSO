public record Particula(double x, double y, double vx, double vy, double pbestX, double pbestY) {
    public Particula actualizar(double nuevoX, double nuevoY, double nuevoVx, double nuevoVy, double nuevoPbestX, double nuevoPbestY) {
        return new Particula(nuevoX, nuevoY, nuevoVx, nuevoVy, nuevoPbestX, nuevoPbestY);
    }
}