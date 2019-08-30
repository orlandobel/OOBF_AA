/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author Odi
 */
public class BurbujaOptimizado implements AlgoritmoOrdenamiento, Runnable {
    
    private double[] arreglo;
    public double tt;
    public boolean thread;
    
    public BurbujaOptimizado() {
        this.thread = false;
        this.arreglo = null;
    }
    
    public BurbujaOptimizado(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
    }

    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void ordenarDatos() {
        if(this.thread) {
            Thread hilo = new Thread(this);
            hilo.start();
        } else {
            run();
        }
    }

    @Override
    public double getTt() {
        return tt;
    }

    @Override
    public void run() {
        
        double ti = System.currentTimeMillis();
        
        for(int i = arreglo.length-1; i >0 ; i--) { 
            for(int j = 0; j < i; j++) {
                
                if (arreglo[j] > arreglo[j + 1]) 
                { 
                    double tmp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = tmp;
                }
            }
        }
        
        double tf = System.currentTimeMillis();
        
        this.tt = tf-ti;
    }
    
}