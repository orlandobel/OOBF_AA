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
public class QuickSort implements AlgoritmoOrdenamiento, Runnable {

    private double[] arreglo;
    private double tt;
    private boolean thread;
    
    public QuickSort() {
        this.thread = false;
        this.arreglo = null;
    }
    
    public QuickSort(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
    }
    
    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void ordenarDatos() {
        if(thread==true) {
            Thread hilo = new Thread(this);
            hilo.start();
        } else {
            run();
        }
    }

    @Override
    public double getTt() {
        return this.tt;
    }
    
    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        double pivot = arreglo[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (arreglo[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (arreglo[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        double temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    @Override
    public void run() {
        if(arreglo.length == 0) {
            return;
        }
        double ti = System.currentTimeMillis();
        
        quicksort(0,arreglo.length-1);
        
        double tf = System.currentTimeMillis();
        
        this.tt = tf-ti;
    }
    
}
