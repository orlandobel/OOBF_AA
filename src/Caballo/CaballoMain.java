/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caballo;

/**
 *
 * @author Odi
 */
public class CaballoMain {
    public static void main(String[] args) {
        int t = 9;
//        int[] inicio = {1,6};
//        caballo c = new caballo(inicio,t);
//        c.buscar();
//        System.out.println(c.getCamino());
        
        int[] inicio = new int[2];
        caballo c = new caballo(t);
        for(int i=0;i<t;i++) {
            inicio[0] = i;
            for(int j=0;j<t;j++) {
                System.out.println("----------- Inicio ("+i+","+j+") -----------");
                inicio[1] = j;
                c.setInicio(inicio);
                c.iniciarTablero();
                c.buscar();
            }
        }
    }
}
