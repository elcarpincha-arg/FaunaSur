package faunasur;

public class Mamifero extends Animal
        implements Rehabilitable {

    private double peso;

    public Mamifero(String codigo, String nombre,
                    EstadoSalud estadoSalud,
                    double peso) {

        super(codigo, nombre, estadoSalud);

        if (peso <= 0) {
            throw new IllegalArgumentException(
                "El peso debe ser positivo."
            );
        }

        this.peso = peso;
    }

    @Override
    public double calcularCostoDiario() {
        return peso * 10;
    }

    @Override
    public String rehabilitar() {
        return "Se está rehabilitando al mamífero "
                + getNombre() + ".";
    }
}