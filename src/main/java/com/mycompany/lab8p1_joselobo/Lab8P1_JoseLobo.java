package com.mycompany.lab8p1_joselobo;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseLobo
 */
public class Lab8P1_JoseLobo {

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Menu();

            switch (opcion) {
                case 1 -> {
                    int gen = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Numero de Generaciones", "Jugar", -1));
                    JuegoDeLaVida J = new JuegoDeLaVida();

                    J.jugar(0);
                    for (int i = 1; i <= gen; i++) {
                        J.jugar(i);
                    }
                }//case 1
                case 2 -> {
                    JOptionPane.showMessageDialog(null, "Saliendo...", "Salida", -1);
                }//case 2
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "Opcion Invalida", "Error", 0);

                }//case 3
            }//switch

        } while (opcion != 2);
    }//main

    public static int Menu() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                    1. Juego de la vida
                                    2. Salir
                                    """, "Menu", -1));
        return opcion;
    }//menu
}//public class
