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
public class Manager {
    
    private ArrayList<AlgoritmoOrdenamiento> metodos;
    
    public Manager() {
        this.metodos = new ArrayList<>();
    }
    
    public Manager(ArrayList<AlgoritmoOrdenamiento> metodo) {
        this.metodos = metodo;
    }
    
    public void ejecutarPrueba(int pruebas,int rAumento,int rAleatorio , boolean grafica) {
        ArrayList<Double[]> tiemposTotales = new ArrayList<>();
        
        for(int j=0;j<this.metodos.size();j++) 
            tiemposTotales.add(new Double[pruebas]);
        
        for(int p=0;p<pruebas;p++) {
            double[] datos = Herramienta.generarArregloAleatorio(p*rAumento, rAleatorio);
            for(int a=0;a<this.metodos.size();a++) {
                AlgoritmoOrdenamiento aux = this.metodos.get(a);
                aux.definirDatos(datos.clone());
                tiemposTotales.get(a)[p]=aux.getTt();
            }
            System.out.println(p);
        }
        
        if(grafica) {
            Grafica g = new Grafica("Id_algoritmo","Tiempo","Prueba básica de ordenamientos");
            for(int x=0;x<tiemposTotales.size();x++)
                g.agregarSerie(tiemposTotales.get(x),""+x);
            g.creaYmuetraGrafica();
        }
        
    }
    
    public void ejecutarPrueba(double[] datos, boolean grafica) {
        double tiempos[] = new double[metodos.size()];
        int p = 0;
        //Recorremos la lista de algoritmos
        for(AlgoritmoOrdenamiento a:this.metodos) {
            a.definirDatos(datos.clone());
            tiempos[p] = a.getTt();
            System.out.println("tiempos: "+tiempos[p]);
            p++;
        }
        
        if(grafica) {
            Grafica g = new Grafica("Id_algoritmo","Tiempo","Prueba básica de ordenamientos");
            g.agregarSerie(tiempos, "0");
            g.creaYmuetraGrafica();
        }
    }
}
