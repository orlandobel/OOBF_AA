/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica.TSP;

import Dinamica.TSP.TSP;

/**
 *
 * @author Odi
 */
public class Main {
    public static void main(String args[]) {
        int matriz[][] = new int[10][10];
        String[] nombres = new String[10];
        
        matriz[0][1] = 13;
        matriz[0][2] = 33;
        matriz[0][3] = 28;
        matriz[0][4] = 37;
        matriz[0][5] = 7;
        matriz[0][6] = 32;
        matriz[0][7] = 40;
        matriz[0][8] = 80;
        matriz[0][9] = 26;
        
        matriz[1][2] = 39;
        matriz[1][3] = 83;
        matriz[1][4] = 50;
        matriz[1][5] = 68;
        matriz[1][6] = 16;
        matriz[1][7] = 98;
        matriz[1][8] = 81;
        matriz[1][9] = 55;
        
        matriz[2][3] = 80;
        matriz[2][4] = 88;
        matriz[2][5] = 49;
        matriz[2][6] = 53;
        matriz[2][7] = 75;
        matriz[2][8] = 63;
        matriz[2][9] = 55;
        
        matriz[3][4] = 94;
        matriz[3][5] = 4;
        matriz[3][6] = 20;
        matriz[3][7] = 6;
        matriz[3][8] = 59;
        matriz[3][9] = 76;
        
        matriz[4][5] = 81;
        matriz[4][6] = 87;
        matriz[4][7] = 85;
        matriz[4][8] = 4;
        matriz[4][9] = 19;
        
        matriz[5][6] = 96;
        matriz[5][7] = 53;
        matriz[5][8] = 40;
        matriz[5][9] = 37;
        
        matriz[6][7] = 80;
        matriz[6][8] = 57;
        matriz[6][9] = 68;
        
        matriz[7][8] = 65;
        matriz[7][9] = 41;
        
        matriz[8][9] = 97;
        
        nombres[0] = "A";
        nombres[1] = "B";
        nombres[2] = "C";
        nombres[3] = "D";
        nombres[4] = "E";
        nombres[5] = "F";
        nombres[6] = "G";
        nombres[7] = "H";
        nombres[8] = "I";
        nombres[9] = "J";
        
        int ciudades[] = {0, 1, 2,3,4,5,6,7,8,9};
//        int ciudades[] = {0, 1, 2,3};
        
        TSP t = new TSP(matriz);
        /*for(int i=0;i<matriz.length;i++) {
            t.permutaciones(i);
            t.distancias();
            t.buscarMinimo();
        }
        
        System.out.println(t.toString());*/
        
        t.buscarMinimo(0);
        System.out.println(t.getDistacia()+": "+t.getRuta());
        
//        Fibonacci fib = new Fibonacci();
        
//        System.out.println("Iterativo: "+fib.iterativo(15)+"\n");
//        
//        System.out.println("Iterativo dinamico: "+fib.iterativoDinamico(47)+"\n");
//        
//        System.out.println("Recursivo: "+fib.emepzarRecursivo(47)+"\n");
        
//        System.out.println("Recursivo dinamico: "+fib.emepzarRecursivoDinamico(3)+"\n");
    }
}
