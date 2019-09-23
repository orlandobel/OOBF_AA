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
public class Factorial {
    
    public Factorial() {
        
    }
    
    public int factorialRecursivo(int n){ 
        if(n==0) {
            return 1;
        }
        
        return n*factorialRecursivo(n-1);
    }
    
    public int factorialProivido(int n){
        return n*factorialRecursivo(n-1);
    }
    
    public int factorialIterativo(int n) {
        int i=1;
        for(int j=1;j<=n;j++) {
            i *= j;
        }
        
        return i;
    }
    
}
