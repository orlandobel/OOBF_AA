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
public class Burbuja implements AlgoritmoOrdenamiento {
    
    private double[] arreglo;
    
    public Burbuja() {
        
    }

    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public double ordenarDatos() {
        //calcular cuando empieza
        double ti = System.currentTimeMillis();
        
        //ordenamos
        for(int i = 1; i < arreglo.length; i++) { 
            for(int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1])  // 4
                { 
                    double tmp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = tmp;
                }
            }
        }
        
        //calculamos el tiempo de termino
        double tf = System.currentTimeMillis();
        
        //tiempo total
        return tf-ti;
    }
    
}
