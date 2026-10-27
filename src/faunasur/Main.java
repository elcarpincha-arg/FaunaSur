package faunasur;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CentroRescate centro =
                new CentroRescate("FaunaSur");

        try {
            centro.agregarAnimal(
                new Ave("AV-10", "Luna",
                        EstadoSalud.ESTABLE, 80)
            );

            centro.agregarAnimal(
                new Mamifero("MA-20", "Puma",
                        EstadoSalud.EN_RECUPERACION, 12)
            );

            centro.agregarAnimal(
                new Reptil("RE-30", "Sol",
                        EstadoSalud.ESTABLE, 65)
            );

            centro.agregarAnimal(
                new Ave("AV-40", "Nube",
                        EstadoSalud.CRITICO, 50)
            );

        } catch (AnimalDuplicadoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== TODOS LOS ANIMALES ===");
        mostrarAnimales(centro.obtenerAnimales());

        System.out.println("\n=== POR ESTADO: ESTABLE ===");
        mostrarAnimales(
            centro.filtrarPorEstado(EstadoSalud.ESTABLE)
        );

        System.out.println("\n=== COSTO MAXIMO: 100 ===");
        mostrarAnimales(
            centro.obtenerAnimalesConCostoMaximo(100)
        );

        System.out.println("\n=== COSTOS DIARIOS ===");
        mostrarCostos(centro.obtenerAnimales());

        System.out.println("\n=== REHABILITACIONES ===");
        mostrarRehabilitaciones(centro.obtenerAnimales());

        System.out.println("\n=== LIBERACIONES ===");
        mostrarLiberaciones(centro.obtenerAnimales());

        System.out.println("\n=== PRUEBA DE DUPLICADO ===");

        try {
            centro.agregarAnimal(
                new Reptil("AV-10", "Luna",
                        EstadoSalud.CRITICO, 90)
            );
        } catch (AnimalDuplicadoException e) {
            System.out.println(
                "Duplicado detectado: " + e.getMessage()
            );
        }
    }

    private static void mostrarAnimales(
            List<Animal> animales) {

        for (Animal animal : animales) {
            System.out.println(animal);
        }
    }

    private static void mostrarCostos(
            List<Animal> animales) {

        for (Animal animal : animales) {
            System.out.println(
                animal.getNombre() + ": "
                + animal.calcularCostoDiario()
            );
        }
    }

    private static void mostrarRehabilitaciones(
            List<Animal> animales) {

        for (Animal animal : animales) {
            if (animal instanceof Rehabilitable) {
                Rehabilitable rehabilitable =
                        (Rehabilitable) animal;

                System.out.println(
                    rehabilitable.rehabilitar()
                );
            }
        }
    }

    private static void mostrarLiberaciones(
            List<Animal> animales) {

        for (Animal animal : animales) {
            if (animal instanceof Liberable) {
                Liberable liberable =
                        (Liberable) animal;

                System.out.println(
                    liberable.liberar()
                );
            }
        }
    }
}