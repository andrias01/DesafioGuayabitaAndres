package com.andresVelez.Guayabita.domain;

import javax.swing.*;
import java.util.Random;

public class Dado {
    private int valor;

    public int tirar() {
        Random random = new Random();
        valor = random.nextInt(6) + 1;
        return valor;
    }

    public int getValor() {
        return valor;
    }

    public ImageIcon mostrarDado(int numero){
        switch (numero) {
            case 1: {
                return new ImageIcon(Guayabita.class.getResource("uno.png"));
            }
            case 2: {
                return new ImageIcon(Guayabita.class.getResource("dos.png"));
            }
            case 3: {
                return new ImageIcon(Guayabita.class.getResource("tres.png"));
            }
            case 4: {
                return new ImageIcon(Guayabita.class.getResource("cuatro.png"));
            }
            case 5: {
                return new ImageIcon(Guayabita.class.getResource("cinco.png"));
            }
            case 6: {
                return new ImageIcon(Guayabita.class.getResource("seis.png"));
            }
        }
        return null;
    }
}

