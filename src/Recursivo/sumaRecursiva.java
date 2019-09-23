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
public class sumaRecursiva {
    
    public sumaRecursiva() {
        
    }
    
    public int sumar(int a, int b) {
        if(b==0) { 
            return a;
        }
        
        return sumar(a,b-1)+1;
    }
}
