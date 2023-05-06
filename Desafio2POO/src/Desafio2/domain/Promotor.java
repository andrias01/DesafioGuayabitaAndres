package Desafio2.domain;

public class Promotor extends Empleado{
    private int volantesRepartidos;
    private  long valorVolante;
    private int comprasVolante;

    public Promotor(String nombre, int volantesRepartidos, long valorVolante,int comprasVolante) {
        super(nombre);
        this.volantesRepartidos=volantesRepartidos;
        this.valorVolante = valorVolante;
        this.comprasVolante = comprasVolante;
    }

    @Override
    public long calcularSalario() {
        int valorVolantesRepartidosSinCompra = (int) ((volantesRepartidos-comprasVolante)*valorVolante);
        long valorVolantesRepartidosConCompra = comprasVolante*15_000;
        return valorVolantesRepartidosSinCompra+valorVolantesRepartidosConCompra;
    }
}
