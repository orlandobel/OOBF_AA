/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamica.Mochila;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Odi
 */
public class Mochila {
    private ArrayList<Item> items;
    private ArrayList<Item> itemsSolucion;
    private double[][] mBeneficios;
    private int _W;
    private int maxBenefit;
    private String solucion;

    public Mochila(ArrayList<Item> items, int _W) {
        this.items = items;
        this._W = _W;
        this.solucion = "";
        construirMatrizBeneficios();

    }


    private void construirMatrizBeneficios() {
        // construimos la matriz de beneficios 
        this.mBeneficios = new double[this.items.size()+1][this._W+1];
        // agregar en la primer columna puros ceros
        for (int x=0;x <= this.items.size();x++)
            this.mBeneficios[x][0] = 0;
        // agregar en la primer fila puros ceros
        
        for (int x=0;x <= this._W;x++)
            this.mBeneficios[0][x] = 0;
        
    }
    
    
    public void buscarSolucion(){
        
        // calculamos la matriz de beneficios
        for (int i=1;i <= this.items.size();i++) {
            for(int w=0; w<= this._W;w++){
            // verificamos si el item puede ser parte de la solucion
                if  (this.items.get(i-1).getPeso()<= w){
               
                if ((this.items.get(i-1).getValor()+
                    this.mBeneficios[i-1][w-this.items.get(i-1).getPeso()])
                        >this.mBeneficios[i-1][w]) {
                   
                    this.mBeneficios[i][w] = this.items.get(i-1).getValor()+
                            this.mBeneficios[i-1][w-this.items.get(i-1).getPeso()];
                    
                } else {
                   
                    this.mBeneficios[i][w] = this.mBeneficios[i-1][w];
                   
                }
               
                } else {
                   this.mBeneficios[i][w] = this.mBeneficios[i-1][w];
                }
           
            }  
        }
        this.maxBenefit = (int)this.mBeneficios[items.size()][_W];
        
        this.itemsSolucion = new ArrayList<>();
        // calcular los elementos utilizados para _W
       
        int i = this.items.size();
        int j = this._W;

        while (i > 0 && j > 0){
            double val = this.mBeneficios[i][j];
            if( val != this.mBeneficios[i-1][j]){
                this.itemsSolucion.add(this.items.get(i-1));
                // imprimir el articulo
                String aux = this.items.get(i-1).getValor()+"";
                if(i == this.items.size() && j == _W)
                    this.solucion += aux;
                else
                    this.solucion += "-"+aux;
                
                //System.out.println(aux);
                i--;
                j = j - this.items.get(i).getPeso();
            } else {
                i--;
            }
                   
        }       
           
    }

    
    /*public void guardar() {
        File f = new File("mochila.txt");
        String aux = "";
        
        for(int i=0;i<this.mBeneficios.length;i++) {
            for(int j=0;j<this.mBeneficios[i].length;j++) {
                //try {
                    if(j==0) 
                        aux += this.mBeneficios[i][0];
                    else
                        aux += ","+this.mBeneficios[i][j];
                //} catch (Exception e){};
            }
            aux += "\n";
        }
        
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(aux);
            
            wr.close();
            bw.close();
            
        } catch(IOException e) {
            
        }
        
        System.out.println(aux);
    }*/
    
    public String getSolucion() {
        return this.solucion;
    }
    
    public String getItems() {
        String itm =  "|Benefcio|    Peso|\n";
        for(int i=0;i<this.items.size();i++) {
            String auxB = items.get(i).getValor()+"";
            String auxP = items.get(i).getPeso()+"";
            itm += "|"+String.format("%8s", auxB)+"|"+String.format("%8s", auxP)+"|";
            itm += "\n";
        }
        
        return itm;
    }

    @Override
    public String toString() {
        String m = "";
        
        for(int i=0;i<this.mBeneficios.length;i++) {
            m += "|";
            for(int j=0;j<this.mBeneficios[0].length;j++) {
                String aux = this.mBeneficios[i][j]+"";
                m += String.format("%6s", aux)+"|";
            }
            m += "\n";
        }
        
        return m;
    }
    
    
}
