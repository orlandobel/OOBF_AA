/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.Random;

/**
 *
 * @author Odi
 */
public class Herramienta {
    
    public static double[] generarArregloAleatorio(int dim, int ran) {
        double arreglo[] = new double[dim];
        
        Random r = new Random();
                
        for(int i=0;i<dim;i++) {
            arreglo[i] = (double)r.nextInt(ran);
        }
        
        return arreglo;
    }
    
    public static double[] generarPeorCaso(int dim) {
        double arreglo[] = new double[dim];
        int j=0;
        
        for(double i=dim;i>0;i--) {
            arreglo[j]=i;
            j++;
        }
        return arreglo;
    }
    
}
