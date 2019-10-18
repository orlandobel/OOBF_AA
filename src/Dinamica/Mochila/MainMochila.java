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
public class MainMochila {
    public static void main(String[] args) {
        LeerMochila.leerDatos();
        
        Mochila m = new Mochila(LeerMochila.instancias, 8);
        m.buscarSolucion();
        m.guardar();
    }
}
