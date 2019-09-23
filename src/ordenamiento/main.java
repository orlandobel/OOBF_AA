/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class main {
    
    public static void main(String[] args) {
        Burbuja b = new Burbuja(true);
        BurbujaOptimizado b1 = new BurbujaOptimizado(true);
        InsertSort is = new InsertSort(true);
        MergeSort ms = new MergeSort(true);
        QuickSort qs = new QuickSort(true);
        
        ArrayList<AlgoritmoOrdenamiento> lista = new ArrayList<>();
        //lista.add(b);
        //lista.add(b1);
        //lista.add(is);
        lista .add(ms);
        lista.add(qs);
        
        Manager m = new Manager(lista);
        m.ejecutarPrueba(40000, 4, 100, true);
    }
    
}
