package EPS.dominio;
import java.util.Comparator;
import java.util.List;

public class EPS {
    public static final byte CAPACIDAD = 100;
    private String nombre;
    private List<Paciente> pacientes;
    private List<Enfermedad> enfermedades;


    public boolean afiliarPaciente(long cedula,String nombre,String enfermedad,int gravedad){
        Paciente paciente = this.buscarPacientePorCedula(cedula);

        if (this.pacientes.size() < CAPACIDAD && paciente == null) {
            Paciente pacienteToAdd = new Paciente(cedula,nombre);
            Enfermedad enfermedadToAdd = new Enfermedad(enfermedad,gravedad);
            enfermedadToAdd.getNombre();
            this.pacientes.add(pacienteToAdd+);
            this.enfermedades.add(enfermedadToAdd);
            return true;
        }
        return false;
    }

    public void sacarPaciente(long celuda){
        Paciente paciente = this.buscarPacientePorCedula(celuda);

        if (paciente != null) {
            this.pacientes.remove(paciente);
            System.out.println("El paciente con los datos mostrados fue eliminado!!..");
        } else {
            System.out.println("El paciente con cedula '"+celuda+"' no existe.");
        }
    }

    public Paciente buscarPacientePorCedula(long cedula){
        Paciente pacienteToReturn = null;

        for (Paciente paciente : this.pacientes) {
            if (paciente.getCedula() == cedula) {
                pacienteToReturn = paciente;
                System.out.println("El paciente fue encontrado su informacion es:");
                System.out.println("#De Cedula: "+paciente.getCedula()+" Nombre del paciente: "+paciente.getNombre());
                break;
            }
        }
        return pacienteToReturn;
    }

    public List<Paciente> buscarPacientesPorEnfermedad(String inEnfermedad){


    }
    public List<Paciente> obtenerPacientesSinEnfermedades(){

    }

    public void ordenarPacientesPosNombres() {
        this.pacientes.sort(Comparator.comparing(Paciente::getNombre));
    }


}
