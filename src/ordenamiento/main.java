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
        Burbuja b = new Burbuja();
        BurbujaOptimizado b1 = new BurbujaOptimizado();
        InsertSort is = new InsertSort();
        
        ArrayList<AlgoritmoOrdenamiento> lista = new ArrayList<>();
        lista.add(b);
        lista.add(b1);
        lista.add(is);
        
        Manager m = new Manager(lista);
        m.ejecutarPrueba(2500, 11, 100, true);
    }
    
}
