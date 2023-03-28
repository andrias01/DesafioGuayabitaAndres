package EPS.dominio;

public class Paciente {
    private long cedula;
    private String nombre;

    public Paciente(long cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
}
