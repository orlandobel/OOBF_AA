/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica.TSP;

import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class DinamicTSP {
    private int[][] matriz;
    private int nodos;
    private ArrayList<String> caminosS;
    private ArrayList<String> CaminosR;
    private ArrayList<String> caminos;
    
    public DinamicTSP(int nodos){
        this.nodos = nodos;
        this.matriz = new int[nodos][nodos];
        
        this.CaminosR = new ArrayList();
        this.caminosS = new ArrayList();
        this.caminos  = new ArrayList();
    }
    
}
