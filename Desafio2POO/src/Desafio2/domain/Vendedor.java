package Desafio2.domain;

public class Vendedor extends Directo{
    private long ventasDelMes;

    public Vendedor(String nombre, long salario, long ventasDelMes) {
        super(nombre, salario);
        this.ventasDelMes = ventasDelMes;
    }

    public long calcularComision() {
        if (ventasDelMes < 999_999) {
            return (long) (ventasDelMes * 0.045);
        } else {
            return (long) (ventasDelMes * 0.035);
        }
    }

    @Override
    public long calcularSalario() {
        return super.calcularSalario() + calcularComision();
    }
}
