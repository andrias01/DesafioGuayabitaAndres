package Desafio2.domain;

import java.util.ArrayList;

public class Nomina {
    private ArrayList<Empleado> empleados;

    public Nomina() {
        empleados = new ArrayList<>();
    }

    public void calcularNomina() {
        System.out.println("Nomina de la tienda de Bicicletas");
        for (Empleado empleado : empleados) {
//            long salario = empleado.calcularSalario();
//            System.out.println("El salario de " + empleado.nombre + " es: $" + salario);
            if (empleado instanceof Vendedor){
                long salario = empleado.calcularSalario();
                System.out.println("El salario de " + empleado.nombre + " es: $" + salario+ " (Valor ganado por comisión = $"+((Vendedor) empleado).calcularComision()+" )");
            }else {
                long salario = empleado.calcularSalario();
                System.out.println("El salario de " + empleado.nombre + " es: $" + salario);
            }
        }
    }

    public void listarDirectos() {
        System.out.println("Empleados directos:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof Directo) {
                System.out.println(empleado.nombre);
            }
        }
    }

    public void listarFreelancers() {
        System.out.println("Empleados freelance:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof Freelance) {
                System.out.println(empleado.nombre);
            }
        }
    }

    public void listarPromotores() {
        System.out.println("Empleados Promotores:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof Promotor) {
                System.out.println(empleado.nombre);
            }
        }
    }

    public void setEmpleados(Empleado empleado) {
        empleados.add(empleado);
    }
}
