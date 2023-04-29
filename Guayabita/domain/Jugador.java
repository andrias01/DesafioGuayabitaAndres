package com.andresVelez.Guayabita.domain;

import javax.swing.*;

public class Jugador {
    private String nombre;
    private int dinero;
    private ImageIcon icono;

    public Jugador(String nombre, int dinero, ImageIcon icon) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.icono = icon;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void restarDinero(int cantidad) {
        dinero -= cantidad;
    }

    public void sumarDinero(int cantidad) {
        dinero += cantidad;
    }

    public ImageIcon getIcono() {
        return icono;
    }
}



