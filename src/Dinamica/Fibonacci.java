/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica;

import java.util.Hashtable;

/**
 *
 * @author Odi
 */
public class Fibonacci {
    private Hashtable<Integer,Integer> calculados;
    
    public Fibonacci() {
        this.calculados = new Hashtable();
    }
    
    public int recursivo(int n) {
        
        if(n>=0) {
            if(n==0 || n==1) {
                return 1;
            }
        
            return recursivo(n-1)+recursivo(n-2);
        }
        return 0;
    }
    
    public int iterativo(int n){ 
        int i = 0;
        int j = 1;
        int aux = 0;
        
        double ti = System.currentTimeMillis();
        
        for(int k=1;k<=n;k++) {
            aux = i+j;
            i=j;
            j=aux;
        }
        
        double tf = System.currentTimeMillis();
        
        double tt =  tf - ti;
        System.out.println("tiempo: "+tt);
        
        return aux;
    }
    
    public int emepzarRecursivo(int n) {
        double ti = System.currentTimeMillis();
        
        int aux = this.recursivo(n);
        
        double tf = System.currentTimeMillis();
        
        double tt = tf - ti;
        System.out.println("tiempo: "+tt);
        
        return aux;
    }
    
    public int iterativoDinamico(int n) {
        
        double ti = System.currentTimeMillis();
        
        calculados.put(0,1);
        calculados.put(1,1);
        for(int i=2; i<=n;i++){ 
            calculados.put(i,(calculados.get(i-2)+calculados.get(i-1)));
        }
        
        double tf = System.currentTimeMillis();
        
        double tt = tf - ti;
        System.out.println("tiempo: "+tt);
        int aux = calculados.get(n);
        calculados.clear();
        return aux;
    }
    
    public int recursivoDinamico(int n) {
        
        if(n == 0 || n == 1) {
            calculados.put(n, 1);
            return 1;
        } else if(calculados.containsKey(n)) {
            return calculados.get(n);
        }
        int aux = recursivoDinamico(n-1)+recursivoDinamico(n-2);
        calculados.put(n,aux);
        
        return aux;
    }
    
    public int emepzarRecursivoDinamico(int n) {
        double ti = System.currentTimeMillis();
        
        int aux = this.recursivoDinamico(n);
        
        double tf = System.currentTimeMillis();
        
        double tt = tf - ti;
        System.out.println("tiempo: "+tt);
        
        calculados.clear();
        return aux;
    }
}
