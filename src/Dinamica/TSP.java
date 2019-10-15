/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica;

import java.util.ArrayList;



/**
 *
 * @author Odi
 */
public class TSP {
    
    private int[][] matriz;
    private int maux[][];
    private String[] nombres;
    private int ciudades[];
    
    private ArrayList<Integer> distancias;
    private ArrayList<int[]> caminos;
    
    private ArrayList<Integer> dMin;
    private ArrayList<int[]> cMin;
    
    private int distancia;
    private String ruta;
    
    public TSP(int[][] m) {
        this.matriz = m.clone();
        this.maux = (int[][])m.clone();
        this.ciudades = new int[m.length];
        
        this.distancias = new ArrayList();
        this.caminos = new ArrayList();
        
        this.dMin = new ArrayList();
        this.cMin = new ArrayList();
        
        this.distancia = 0;
        this.ruta = "";
    }
    
    public void permutaciones(int inicio) {
        
        this.caminos.clear();
        
        //this.ciudades = ciudades.clone();
        this.ciudades[0] = inicio;
        int j = 0;
        for(int i=1;i<this.ciudades.length;i++) {
            if(j==inicio)
                j++;
            
            this.ciudades[i] = j;
            j++;
        }
        
        caminos.add(ciudades.clone());
        while(nextPermutation(this.ciudades)) {
            if(ciudades[0] > inicio)
                break;
            
            caminos.add(this.ciudades.clone());
//            for(int i=0;i<ciudades.length;i++) {
//                System.out.print(ciudades[i]+" ");
//            }
//            System.out.println();
        }
        
    }
    
    public void distancias() {
        
        this.distancias.clear();
        
        for(int i=0; i<caminos.size();i++) {
            int d = 0;
            for(int j=0;j<this.caminos.get(i).length-1;j++) {
                if(matriz[this.caminos.get(i)[j]][this.caminos.get(i)[j+1]] != 0)
                    d += matriz[this.caminos.get(i)[j]][this.caminos.get(i)[j+1]];
                else
                    d += matriz[this.caminos.get(i)[j+1]][this.caminos.get(i)[j]];
            }
            
            if(matriz[this.caminos.get(i)[0]][this.caminos.get(i)[this.caminos.get(i).length-1]] != 0)
                d += matriz[this.caminos.get(i)[0]][this.caminos.get(i)[this.caminos.get(i).length-1]];
            else
                d += matriz[this.caminos.get(i)[this.caminos.get(i).length-1]][this.caminos.get(i)[0]];
            
            distancias.add(d);
        }   
    }
    
    public void buscarMinimo() {
        int aux = Integer.MAX_VALUE;
        int min = 0;
        
        for(int i=0;i<distancias.size();i++) {
            if(distancias.get(i)<aux) {
                aux = distancias.get(i);
                min = i;
            }
        }
        
        this.dMin.add(aux);
        this.cMin.add(caminos.get(min));
    }
    
    public void buscarMinimo(int inicio) {
        int in = inicio;
        int inaux = inicio;
        int ma[] = new int[matriz.length];
        
        for(int i=0;i<matriz.length;i++) {
            if(i == inicio)
                continue;
            if(maux[inicio][i] != 0)
                ma[i] = maux[inicio][i];
            else
                ma[i] = maux[i][inicio];
        }
        
        this.ruta += inicio;
        while(in != -1) {
            inaux = in;
            in = calcular(in);
        }
        
        this.ruta += "-"+inicio;        
        this.distancia += ma[inaux];
        
        
        System.out.println();
    }
    
    public int calcular(int inicio) {
        int c = -1;
        int d = Integer.MAX_VALUE;
        
        for(int i=inicio;i<maux.length;i++) {
            if(maux[inicio][i]<d && maux[inicio][i] != 0) {
                c = i;
                d = maux[inicio][i];
            }
        }
        
        for(int i=inicio;i>=0;i--) {
            if(maux[i][inicio]<d && maux[i][inicio] != 0) {
                c = i;
                d = maux[i][inicio];
            }
        }
        
        if(c != -1) {
            this.distancia += d;
            this.ruta += "-"+c;
            borrar(inicio);
        }
        
        return c;
    }
    
    public void borrar(int inicio) {
        for(int i = inicio;i<maux.length;i++) {
            maux[inicio][i] = 0;
        }
        
        for(int i=inicio;i>=0;i--) {
            maux[i][inicio] = 0;
        }
    }
    
    private static boolean nextPermutation(int[] array) {

        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    @Override
    public String toString() {
        
        String s = "";
        
        for(int i=0;i<this.cMin.size();i++) {
            s += "[";
            for(int j=0;j<this.cMin.get(i).length;j++) {
                String aux = String.format("%2s", cMin.get(i)[j]);
                s += aux;
            }
            s += "] = "+this.dMin.get(i)+"\n";
        }
        
        return s;
    }
    
    public int getDistacia() {
        return this.distancia;
    }
    
    public String getRuta() {
        return this.ruta;
    }
    
    
}
