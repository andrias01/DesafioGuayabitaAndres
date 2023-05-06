package Desafio2.domain;

public class Directo extends Empleado {
    private long salario;

    public Directo(String nombre, long salario) {
        super(nombre);
        this.salario = salario;
    }

    public long calcularSalud() {
        return (long) (salario * 0.05);
    }

    public long calcularPension() {
        return (long) (salario * 0.065);
    }

    public long calcularAporte() {
        return calcularSalud() + calcularPension();
    }

    @Override
    public long calcularSalario() {
        return salario - calcularAporte();
    }
}
