package com.andresVelez.Guayabita.domain;

import javax.swing.*;
import java.util.Arrays;

public class Guayabita {
    private static final ImageIcon APP_ICONG = new ImageIcon(Guayabita.class.getResource("GuayabaG.png"));
    private static final ImageIcon APP_ICONP = new ImageIcon(Guayabita.class.getResource("GuayabaP.png"));
    private static final ImageIcon APP_ICON_ERROR = new ImageIcon(Guayabita.class.getResource("error.png"));
    private static final ImageIcon APP_ICON_WIN_ONE = new ImageIcon(Guayabita.class.getResource("ganadorUno.png"));
    private static final ImageIcon APP_ICON_WIN_TWO = new ImageIcon(Guayabita.class.getResource("ganadorDos.png"));
    private static final ImageIcon APP_ICON_MONEY_WIN = new ImageIcon(Guayabita.class.getResource("dinero.png"));
    private static final ImageIcon APP_ICON_MONEY_LOST = new ImageIcon(Guayabita.class.getResource("perdida.png"));
    private static final ImageIcon APP_ICON_JUGADOR_UNO = new ImageIcon(Guayabita.class.getResource("jugadorUno.png"));
    private static final ImageIcon APP_ICON_JUGADOR_DOS = new ImageIcon(Guayabita.class.getResource("jugadorDos.png"));
    private static final ImageIcon APP_ICON_JUGADOR_NEXT = new ImageIcon(Guayabita.class.getResource("pasarTurno.png"));
    private static final ImageIcon APP_ICON_JUGADOR_CURRENTMONEY = new ImageIcon(Guayabita.class.getResource("dineroActual.png"));
    private static final ImageIcon APP_ICON_JUGADOR_BET = new ImageIcon(Guayabita.class.getResource("apostar.png"));
    private static final ImageIcon APP_ICON_JUGADOR_DICESTHROW = new ImageIcon(Guayabita.class.getResource("tirandoDados.png"));
    private static final String APP_TITLE_MAIN = "GAME -- 'LA GUAYABITA'";
    private static final String APP_TITLE_THROW = "'THROW'";
    private static final String APP_TITLE_LOST = "'YOU LOST'";
    private static final String APP_TITLE_WIN = "'YOU WIN'";
    private static final String APP_TITLE_PLAYER = "'PLAYER'";
    private static final String APP_TITLE_NEXT = "'NEXT PLAYER'";
    private static final String APP_TITLE_BET = "'BET'";
    private static final String APP_TITLE_CURRENTMONEY = "'CURRENT MONEY $$$$$$'";
    private static final Object[] APP_OPTIONS_GAME = Arrays.asList("Play", "See instructions").toArray();
    private static final Object[] APP_OPTIONS_BET = Arrays.asList(50,100,150,200,250,300,350,400,450,500).toArray();
    private Jugador jugador1;
    private Jugador jugador2;
    private int apuesta;
    private int pote;

    public Guayabita() {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.apuesta = apuesta;
        this.pote = 0;
    }
    public void showMessageMain (){
        JOptionPane.showMessageDialog(null,"Welcome to \nthe GUAYABITA'S GAME !!!",APP_TITLE_MAIN, JOptionPane.PLAIN_MESSAGE, APP_ICONG);
        while (true){
            int selectedOption = JOptionPane.showOptionDialog(null,"Welcome to the GUAYABITA'S GAME !!!\n¿what want you do?",APP_TITLE_MAIN, 0 ,0,
                    APP_ICONP,APP_OPTIONS_GAME,null);
            switch (selectedOption) {
                case 0 -> {
                    String nombreJugador1 = dataValidationString(JOptionPane.showInputDialog(null, "Ingresa el nombre del JUGADOR 1"),"Ingresa el nombre del JUGADOR 1");
                    int dineroJugador1 = dataValidationInt("Ingresa el dinero inicial del JUGADOR 1");
                    String nombreJugador2 = dataValidationString(JOptionPane.showInputDialog(null, "Ingresa el nombre del JUGADOR 2"),"Ingresa el nombre del JUGADOR 2");
                    int dineroJugador2 = dataValidationInt("Ingresa el dinero inicial del JUGADOR 2");
                    int apuesta=0;
                    do{
                        apuesta = dataValidationInt("Ingresa la apuesta");
                        if (apuesta>dineroJugador1 || apuesta>dineroJugador2){
                            JOptionPane.showMessageDialog(null, "El pote inicial no puede ser tan grande \nUno o los dos jugadores no tienen suficiente dinero\nPon un pote el cual los jugadores puedan apostar","IMPOSIBLE",JOptionPane.OK_OPTION, APP_ICON_ERROR);
                        }
                    }while (apuesta>dineroJugador1 || apuesta>dineroJugador2);
                    jugador1 = new Jugador(nombreJugador1, dineroJugador1,APP_ICON_JUGADOR_UNO);
                    jugador2 = new Jugador(nombreJugador2, dineroJugador2,APP_ICON_JUGADOR_DOS);
                    cuadrarApuesta(apuesta,jugador1,jugador2);
//                    jugador1 = new Jugador("Andres", 1500, APP_ICON_JUGADOR_UNO);
//                    jugador2 = new Jugador("Alejandro", 1500, APP_ICON_JUGADOR_DOS);
//                    cuadrarApuesta(200,jugador1,jugador2);
                    jugar();
                }
                case 1 -> JOptionPane.showMessageDialog(null, showIntructions());
                default -> System.exit(0);
            }
        }
    }

    public void jugar() {
        boolean turnoJugador1 = true;

        while (jugador1.getDinero() > 0 && jugador2.getDinero() > 0) {
            Jugador jugadorEnTurno = turnoJugador1 ? jugador1 : jugador2;
            Jugador jugadorEnEspera = turnoJugador1 ? jugador2 : jugador1;
            JOptionPane.showMessageDialog(null, "Es el turno de " + jugadorEnTurno.getNombre() + "\nTienes: "+ jugadorEnTurno.getDinero() + "\ny el pote actual es de: " + this.pote,APP_TITLE_PLAYER,JOptionPane.OK_OPTION,jugadorEnTurno.getIcono());
            Dado dado1 = new Dado();
            int resultado1 = dado1.tirar();
            JOptionPane.showMessageDialog(null,"Resultado del primer lanzamiento: " + resultado1,APP_TITLE_THROW,JOptionPane.OK_OPTION, dado1.mostrarDado(resultado1));
            if (resultado1 == 1 || resultado1 == 6) {
                JOptionPane.showMessageDialog(null, "Pasar de turno",APP_TITLE_NEXT,JOptionPane.OK_OPTION, APP_ICON_JUGADOR_NEXT);
            } else {
                int respuesta = JOptionPane.showConfirmDialog(null, jugadorEnTurno.getNombre()+" ¿Deseas apostar?", APP_TITLE_BET, JOptionPane.YES_NO_OPTION,JOptionPane.OK_OPTION, APP_ICON_JUGADOR_BET);

                if (respuesta == JOptionPane.YES_OPTION) {
                    int apuesta=0;
//                    SI QUIERO METER LA APUESTA POR TECLADO
//                    int apuesta = Integer.parseInt(JOptionPane.showInputDialog(null, jugadorEnTurno.getNombre() + " tu tienes: "+ jugadorEnEspera.getDinero() + "\n Cuanto vas a apostar?" ,APP_TITLE_BET));
                    boolean youCanContinuee;
                    do {
                        try {
                            do{

                                apuesta = (int) JOptionPane.showInputDialog(null, jugadorEnTurno.getNombre() + " tu tienes: "+ jugadorEnEspera.getDinero() + "\n Cuanto vas a apostar?" ,APP_TITLE_BET,0,APP_ICON_JUGADOR_BET,APP_OPTIONS_BET,100);
                                if (apuesta>this.pote){
                                    JOptionPane.showMessageDialog(null, "No puedes apostar tanto el pote solo tiene "+ this.pote,"NO PUEDES CONTINUAR",JOptionPane.OK_OPTION, APP_ICON_ERROR);
                                }
                                if (jugadorEnTurno.getDinero()<apuesta){
                                    JOptionPane.showMessageDialog(null, "No puedes apostar tanto, no tienes suficiente dinero tu tienes "+ jugadorEnTurno.getDinero() + "\nY intentas apostar "+ apuesta,"NO PUEDES CONTINUAR",JOptionPane.OK_OPTION, APP_ICON_ERROR);
                                }
                            }while (apuesta>this.pote && jugadorEnTurno.getDinero()<apuesta);
                            youCanContinuee = true;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "No puedes cancelar en este momento "+ jugadorEnTurno.getNombre()+ "\nDebes apostar algo","NO PUEDES CANCELAR",JOptionPane.OK_OPTION, APP_ICON_ERROR);
                            youCanContinuee = false;
                            //showMessage(String.valueOf(e));
                        }
                    } while (!youCanContinuee);

                    Dado dado2 = new Dado();
                    int resultado2 = dado2.tirar();
                    JOptionPane.showMessageDialog(null, "Lanzando los dados......... ",APP_TITLE_THROW,JOptionPane.OK_OPTION,APP_ICON_JUGADOR_DICESTHROW);
                    JOptionPane.showMessageDialog(null, "Resultado del segundo lanzamiento: " + resultado2,APP_TITLE_THROW,JOptionPane.OK_OPTION, dado2.mostrarDado(resultado2));

                    if (resultado2 > resultado1) {
                        JOptionPane.showMessageDialog(null, jugadorEnTurno.getNombre() + " ¡Ganaste!",APP_TITLE_WIN,JOptionPane.OK_OPTION,APP_ICON_MONEY_WIN);
                        jugadorEnTurno.sumarDinero(apuesta);
                        restarDineroPote(apuesta);
                    } else {
                        JOptionPane.showMessageDialog(null, jugadorEnTurno.getNombre() + " ¡Perdiste!",APP_TITLE_LOST,JOptionPane.OK_OPTION,APP_ICON_MONEY_LOST);
                        jugadorEnTurno.restarDinero(apuesta);
                        sumarDineroPote(apuesta);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pasar de turno",APP_TITLE_NEXT,JOptionPane.OK_OPTION, APP_ICON_JUGADOR_NEXT);
                }
            }

            if (jugador1.getDinero() <= 0) {
                JOptionPane.showMessageDialog(null, jugador1.getNombre() + " se ha quedado sin dinero. " + jugador2.getNombre() + " ha ganado el juego.",APP_TITLE_WIN,JOptionPane.OK_OPTION,APP_ICON_WIN_TWO);
                break;
            }

            if (jugador2.getDinero() <= 0) {
                JOptionPane.showMessageDialog(null, jugador2.getNombre() + " se ha quedado sin dinero. " + jugador1.getNombre() + " ha ganado el juego.",APP_TITLE_WIN,JOptionPane.OK_OPTION,APP_ICON_WIN_ONE);
                break;
            }

            JOptionPane.showMessageDialog(null, "El pote actual es de " + this.pote + " pesos.",APP_TITLE_CURRENTMONEY,JOptionPane.OK_OPTION, APP_ICON_JUGADOR_CURRENTMONEY);
            turnoJugador1 = !turnoJugador1;
        }
    }
    public void restarDineroPote(int cantidad) {
        pote -= cantidad;
    }

    public void sumarDineroPote(int cantidad) {
        pote += cantidad;
    }
    public void cuadrarApuesta(int apuesta,Jugador jugador1,Jugador jugador2){
        jugador1.restarDinero(apuesta);
        jugador2.restarDinero(apuesta);
        apuesta = apuesta*2;
        this.pote = apuesta;
    }
    public String showIntructions(){
        return "---------Instruciones---------\n El juego de la guayabita\n\"Si el jugador saca 1 o 6 entonces pierde la posibilidad de apostar y por ende\\n\"\r\n"
                + "													+\"cede el turno al otro jugador.\\n\\n\"\r\n"
                + "													+ \"Si por el contrario saca un numero del 2 al 5 tiene la posibilidad de apostar por\\n\"\r\n"
                + "													+\"el pote que hay en juego. Si elige que no quiere apostar cede su turno, pero si\\n\"\r\n"
                + "													+\"quiere hacerlo el juego le debe permitir ingresar el monto por el que desea\\n\"\r\n"
                + "													+\"apostar y luego tirar nuevamente el dado.\\n\\n\"\r\n"
                + "													+\"El jugador puede apostar por la totalidad del pote o por una parte (por ejemplo,\\n\"\r\n"
                + "													+\"si el pote es de $1200 el jugador puede apostar $1200 o un valor inferior). Se\\n\"\r\n"
                + "													+\"debe controlar que el jugador si cuente con el valor de la apuesta que desea\\n\"\r\n"
                + "													+\"realizar.\\n\\n\"\r\n"
                + "													+\"Si el jugador saca un numero mayor al que sacó en la tirada anterior entonces\\n\"\r\n"
                + "													+\"se lleva el dinero del pote (la parte que apostó). Si por el contrario el jugador\\n\"\r\n"
                + "													+\"saca un numero igual o inferior entonces tendrá que entregar lo que aposto al\\n\"\r\n"
                + "													+\"pote y asi este irá aumentando.\\n\\n\"\r\n"
                + "													+\"Si despues de una jugada el pote queda en $0, el juego vuelve a comenzar \\n\"\r\n"
                + "													+\"(volviendo a apostar cantidades iguales).\\n\\n\"\r\n"
                + "													+\"Despues de esto al otro jugador se le pregunta si desea lanzar el dado y\\n\"\r\n"
                + "													+\"comienza su flujo nuevamente.\\n\\n\"\r\n"
                + "													+\"El juego termina cuando uno de los dos jugadores no tenga dinero suficiente\\n\"\r\n"
                + "													+\"para iniciar una ronda.\";\r\n"
                + "";
    }
    public String dataValidationString (String text,String message) {
        boolean youCanContinue = false;
        do {
            if (text == null || text.trim().isEmpty()) {
                youCanContinue = false;
                text = JOptionPane.showInputDialog(message).trim();
            } else {
                youCanContinue = true;
            }
        } while (!youCanContinue);
        return text;
    }
    public int dataValidationInt (String message) {
        boolean youCanContinue;
        int amount = 0;
        do {
            try {
                amount = Integer.parseInt(JOptionPane.showInputDialog(message));
                youCanContinue = true;
            } catch (Exception e) {
                youCanContinue = false;
                //showMessage(String.valueOf(e));
            }
        } while (!youCanContinue);
        return amount;
    }
}



