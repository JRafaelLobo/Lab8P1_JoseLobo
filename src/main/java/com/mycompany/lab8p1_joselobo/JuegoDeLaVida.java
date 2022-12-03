package com.mycompany.lab8p1_joselobo;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author La Vida
 */
public class JuegoDeLaVida {

    public int[][] tablero = aleatoriotablero();
    public int[][] gen;

    public void jugar(int x) {
        gen = tablero;
        for (int i = 0; i < x; i++) {
            gen = NextGen();

        }//for
        JOptionPane.showMessageDialog(null, "Coordenadas de celdas vivas \n" + Arrays.toString(Vivos()) + "\nTablero \n" + imprimirmatrix(gen), "Generacion " + x, -1);

    }//jugar

    public int[][] aleatoriotablero() {
        int[][] temp = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[i][j] = (int) (Math.random() * 2);
            }//for j
        }//for i
        temp = CeroAlrededor(temp);
        return temp;
    }//aleatorio

    public String imprimirmatrix(int[][] a) {
        String temp = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                temp += "[" + a[i][j] + "]";
            }//for j
            temp += "\n";
        }//for i
        return temp;
    }//imprimirmatrix

    public int[][] NextGen() {
        int[][] temp = new int[10][10];
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int test = 0;
                for (int k = -1; k <= 1; k++) {
                    if (k != 0) {
                        test += gen[i + k][j + k];//diagonal
                        test += gen[i][j + k];
                        test += gen[i + k][j];
                        test += gen[i + k][j + (k * -1)];

                        if (gen[i][j] == 0) {
                            if (test == 3) {
                                temp[i][j] = 1;
                            }
                        } else {
                            if (test < 2 || test > 3) {
                                temp[i][j] = 1;
                            } else {
                                temp[i][j] = 0;
                            }
                        }//if change
                    }//if k
                }//for k
            }//for j
        }//for i
        temp = CeroAlrededor(temp);
        return temp;
    }//nextGen

    public int[][] CeroAlrededor(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == 0 || j == 0 || i == a.length - 1 || j == a[0].length - 1) {
                    a[i][j] = 0;
                }
            }//for j
        }//for i
        return a;
    }//ceroalrededor

    public String[] Vivos() {
        String x = "";
        for (int i = 0; i < this.gen.length; i++) {
            for (int j = 0; j < this.gen[i].length; j++) {
                if (this.gen[i][j] == 1) {
                    x += Integer.toString(i) + ":" + Integer.toString(j) + ",";
                }//if
            }//for j
        }//for i

        String[] coordenadas = x.split(",");
        return coordenadas;
    }//vivos

    public int[][] getgen() {
        return gen;
    }

    public void setgen(int[][] gen) {
        this.gen = gen;
    }

    public void settablero(int[][] gen) {
        this.tablero = tablero;
    }

    public int[][] gettablero() {
        return tablero;
    }

}//public class
