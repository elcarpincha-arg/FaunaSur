package faunasur;

import java.util.ArrayList;
import java.util.List;

public class CentroRescate {

    private String nombre;
    private List<Animal> animales;

    public CentroRescate(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre del centro no puede estar vacío."
            );
        }

        this.nombre = nombre;
        this.animales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarAnimal(Animal animal)
            throws AnimalDuplicadoException {

        if (animal == null) {
            throw new IllegalArgumentException(
                "El animal no puede ser null."
            );
        }

        if (animales.contains(animal)) {
            throw new AnimalDuplicadoException(
                "Ya existe un animal con ese código y nombre."
            );
        }

        animales.add(animal);
    }

    public List<Animal> obtenerAnimales() {
        return new ArrayList<>(animales);
    }

    public List<Animal> filtrarPorEstado(
            EstadoSalud estado) {

        if (estado == null) {
            throw new IllegalArgumentException(
                "El estado no puede ser null."
            );
        }

        List<Animal> resultado = new ArrayList<>();

        for (Animal animal : animales) {
            if (animal.getEstadoSalud() == estado) {
                resultado.add(animal);
            }
        }

        return resultado;
    }

    public List<Animal> obtenerAnimalesConCostoMaximo(
            double maximo) {

        if (maximo <= 0) {
            throw new IllegalArgumentException(
                "El costo máximo debe ser positivo."
            );
        }

        List<Animal> resultado = new ArrayList<>();

        for (Animal animal : animales) {
            if (animal.calcularCostoDiario() <= maximo) {
                resultado.add(animal);
            }
        }

        return resultado;
    }
}