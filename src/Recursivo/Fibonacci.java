/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursivo;

/**
 *
 * @author Odi
 */
public class Fibonacci {

    public Fibonacci() {
        
    }
    
    public int fib(int n) {
        if(n>=0) {
            if(n==0 || n==1) {
                return 1;
            }
        
            return fib(n-1)+fib(n-2);
        }
        return 0;
    }
    
    public int fibIt(int n){ 
        int i = 0;
        int j = 1;
        int aux = 0;
        
        for(int k=1;k<=n;k++) {
            aux = i+j;
            i=j;
            j=aux;
        }
        
        return aux;
    }
}
