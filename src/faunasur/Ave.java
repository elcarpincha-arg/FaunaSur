package faunasur;

public class Ave extends Animal
        implements Rehabilitable, Liberable {

    private double envergaduraAlar;

    public Ave(String codigo, String nombre,
               EstadoSalud estadoSalud,
               double envergaduraAlar) {

        super(codigo, nombre, estadoSalud);

        if (envergaduraAlar <= 0) {
            throw new IllegalArgumentException(
                "La envergadura alar debe ser positiva."
            );
        }

        this.envergaduraAlar = envergaduraAlar;
    }

    @Override
    public double calcularCostoDiario() {
        return envergaduraAlar * 2;
    }

    @Override
    public String rehabilitar() {
        return "Se está rehabilitando al ave "
                + getNombre() + ".";
    }

    @Override
    public String liberar() {
        return "Se está liberando al ave "
                + getNombre() + ".";
    }
}