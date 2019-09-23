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
public class MergeSort implements AlgoritmoOrdenamiento, Runnable {
    
    private double[] arreglo;
    public double tt;
    public boolean thread;
    
    public MergeSort() {
        this.thread = false;
        this.arreglo = null;
    }
    
    public MergeSort(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
    }

    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void ordenarDatos() {
        if(this.thread==true) {
            Thread hilo = new Thread(this);
            hilo.start();
        } else {
            run();
        }
    }
    
    public void ordenarDatos(int n) {
        if(n < 2) {
            return;
        }
        
        int mid = n / 2;
        double[] l = new double[mid];
        double[] r = new double[n - mid];
 
        for (int i = 0; i < mid; i++) {
        l[i] = arreglo[i];
        }
        for (int i = mid; i < n; i++) {
        r[i - mid] = arreglo[i];
        }
        ordenarDatos(l, mid);
        ordenarDatos(r, n - mid);
 
        merge(this.arreglo, l, r, mid, n - mid);
    }
    
    public void ordenarDatos(double[] a, int n) {
        if(n < 2) {
            return;
        }
        
        int mid = n / 2;
        double[] l = new double[mid];
        double[] r = new double[n - mid];
 
        for (int i = 0; i < mid; i++) {
        l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
        }
        ordenarDatos(l, mid);
        ordenarDatos(r, n - mid);
 
        merge(a, l, r, mid, n - mid);
    }
    
    public static void merge(
        double[] a, double[] l, double[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    @Override
    public double getTt() {
        return this.tt;
    }

    @Override
    public void run() {
        
        double ti = System.currentTimeMillis();
        
        ordenarDatos(this.arreglo.length);
        
        double tf = System.currentTimeMillis();
        
        this.tt = tf-ti;
    }
    
}
