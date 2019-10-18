/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica.Mochila;

import java.util.ArrayList;
import java.util.Random;

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
    
    public static ArrayList<Item> geraraitems(int n, int v, int p){
        ArrayList<Item> items= new ArrayList<>();
        for(int i =0; i<n; i++){
             Random rndp = new Random();
             Random rndv = new Random();
             Item it= new Item(rndv.nextInt(v)+1,rndp.nextInt(p)+1);
             items.add(it);
        }
        return items;
    }
    
    public int getPeso() {
        return this.peso;
    }
    
    public int getValor() {
        return this.valor;
    }
    
    @Override
    public String toString() {
        String aux ="";
        aux+=this.peso+"-"+this.valor;
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
}
