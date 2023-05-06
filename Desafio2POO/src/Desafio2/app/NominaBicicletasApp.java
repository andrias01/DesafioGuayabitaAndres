package Desafio2.app;

import Desafio2.domain.*;

import java.util.ArrayList;

public class NominaBicicletasApp {
    public static void main(String[] args) {
        Nomina nomina = new Nomina();

        Directo juan = new Directo("Juan", 4_840_000);
        Directo david = new Directo("David", 3_975_000);
        Vendedor julián = new Vendedor("Julián", 2_050_000, 45_510_000);
        Vendedor carolina = new Vendedor("Carolina", 980_000, 35_989_000);
        Freelance johanna = new Freelance("Johanna", 71_000, 89);
        Freelance gustavo = new Freelance("Gustavo", 42_500, 65);
        Promotor pedro = new Promotor("Pedro",1200,280,62);

        nomina.setEmpleados(juan);
        nomina.setEmpleados(david);
        nomina.setEmpleados(julián);
        nomina.setEmpleados(carolina);
        nomina.setEmpleados(johanna);
        nomina.setEmpleados(gustavo);
        nomina.setEmpleados(pedro);

        nomina.calcularNomina();

        nomina.listarDirectos();

        nomina.listarFreelancers();

        nomina.listarPromotores();


    }
}
