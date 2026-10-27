package faunasur;

public class Reptil extends Animal
        implements Liberable {

    private double longitud;

    public Reptil(String codigo, String nombre,
                  EstadoSalud estadoSalud,
                  double longitud) {

        super(codigo, nombre, estadoSalud);

        if (longitud <= 0) {
            throw new IllegalArgumentException(
                "La longitud debe ser positiva."
            );
        }

        this.longitud = longitud;
    }

    @Override
    public double calcularCostoDiario() {
        return longitud + 15;
    }

    @Override
    public String liberar() {
        return "Se está liberando al reptil "
                + getNombre() + ".";
    }
}