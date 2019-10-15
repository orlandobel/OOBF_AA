/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica.Mochila;

/**
 *
 * @author Odi
 */
public class Item {
    private int peso;
    private int valor;
    
    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }
    
    public int getPeso() {
        return this.peso;
    }
    
    public int getValor() {
        return this.valor;
    }
}
