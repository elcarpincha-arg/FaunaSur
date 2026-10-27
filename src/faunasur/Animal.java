package faunasur;

public abstract class Animal {

    private String codigo;
    private String nombre;
    private EstadoSalud estadoSalud;

    public Animal(String codigo, String nombre,
                  EstadoSalud estadoSalud) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                "El código no puede estar vacío."
            );
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío."
            );
        }

        if (estadoSalud == null) {
            throw new IllegalArgumentException(
                "El estado de salud no puede ser null."
            );
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.estadoSalud = estadoSalud;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public abstract double calcularCostoDiario();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Animal)) {
            return false;
        }

        Animal otro = (Animal) obj;

        return codigo.equals(otro.codigo)
                && nombre.equals(otro.nombre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(codigo, nombre);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{codigo='" + codigo
                + "', nombre='" + nombre
                + "', estado=" + estadoSalud
                + ", costo diario=" + calcularCostoDiario()
                + "}";
    }
}