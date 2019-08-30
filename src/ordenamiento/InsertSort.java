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
public class InsertSort implements AlgoritmoOrdenamiento, Runnable {
    
    private double[] arreglo;
    private double tt;
    private boolean thread;
    
    public InsertSort() {
        this.thread = false;
        this.arreglo = null;
    }
    
    public InsertSort(boolean thread) {
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
        
        for (int i=1;i<arreglo.length;++i) { 
            double key = arreglo[i]; 
            int j = i-1; 
            
            while (j >= 0 && arreglo[j] > key) { 
                arreglo[j+1] = arreglo[j]; 
                j = j-1; 
            } 
            arreglo[j+1] = key; 
        }
        
        double tf = System.currentTimeMillis();
        
        this.tt = tf-ti;
    }
    
}
