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
public class main {
    public static void main(String[] args) {
        sumaRecursiva s = new sumaRecursiva();
        
        /*Factorial f = new Factorial();
        Fibonacci fi = new Fibonacci();
        
        System.out.println("Recursivo: "+f.factorialRecursivo(4));
        System.out.println("Iterativo: "+f.factorialIterativo(4));
        
        System.out.println("Fibonacci recursivo: "+fi.fib(6));
        System.out.println("Fibonacci iterativo: "+fi.fibIt(6));*/
        
        System.out.println(s.sumar(5,8));
        
    }
}
