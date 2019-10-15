/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursivo;

import java.util.Hashtable;

/**
 *
 * @author Odi
 */
public class Fibonacci {
    
    double tt;

    public Fibonacci() {
        
    }
    
    public int fibonacciRecursivo(int n) {
        
        if(n>=0) {
            if(n==0 || n==1) {
                return 1;
            }
        
            return fibonacciRecursivo(n-1)+fibonacciRecursivo(n-2);
        }
        return 0;
    }
    
    public int fibonacciIterativo(int n){ 
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
        
        this.tt = tf - ti;
        
        return aux;
    }
    
    public int empezarRecursivo(int n) {
        double ti = System.currentTimeMillis();
        
        int aux = this.fibonacciRecursivo(n);
        
        double tf = System.currentTimeMillis();
        
        this.tt = tf - ti;
        
        return aux;
    }
    
    public double getTt() {
        return this.tt;
    }
}
