/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*Restricciones
    -El caballo sólo se mueve en L
    -No podemos saltar de una orilla del tablero a la otra
    -Sólo podemos recorrer cada casilla una vez
 *Consideraciones
    -El tablero puede ser una matriz cuadrada
    -No podemos salirnos del tablero
    -Marcar las posiciones recorridas
    -¿Matriz de caminos faltaners?
*/
package Caballo;

/**
 *
 * @author Odi
 */
public class caballo {
    
    private int[][] tablero;
    private int[] inicio;
    private String camino;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m"; 
    
    public caballo(int[] inicio, int t) {
        this.tablero = new int[t][t];
        this.inicio = inicio;
        iniciarTablero();
    }
    
    public caballo(int t) {
        this.tablero = new int[t][t];
        iniciarTablero();
    }
    
    public void iniciarTablero() {
        for(int i=0;i<tablero.length;i++) {
            for(int j=0;j<tablero.length;j++) {
                tablero[i][j]=1;
            }
        }
    }
    
    public void buscar() {
        this.camino = "";
        int[] sig = inicio;
        int it = 1;
        
        while(sig[0] != -1 && sig[1] != -1) {
            camino += "("+sig[0]+","+sig[1]+")";
//            System.out.println("-------------- iteracion "+it+" --------------");
            int x = sig[0];
            int y = sig[1];
            tablero[y][x] = 0;
//            System.out.print(this.toString());
            it++;
            sig = siguiente(x,y);
        }
        System.out.print(this.toString());
    }
    
    private int[] siguiente(int x, int y) {
        int max = 8;
        int maux = 8;
        int aux[] = {-1,-1};
        
        /*Busca la casilla con menos caminos por recorrer y establece las cordenadas*/
        maux = restantes(x-1,y+2);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x-1;
            aux[1] = y+2;
        }
        
        maux = restantes(x-2,y+1);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x-2;
            aux[1] = y+1;
        }
        
        maux = restantes(x-2,y-1);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x-2;
            aux[1] = y-1;
        }
        
        maux = restantes(x-1,y-2);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x-1;
            aux[1] = y-2;
        }
        
        maux = restantes(x+1,y-2);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x+1;
            aux[1] = y-2;
        }
        
        maux = restantes(x+2,y-1);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x+2;
            aux[1] = y-1;
        }
        
        maux = restantes(x+2,y+1);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x+2;
            aux[1] = y+1;
        }
        
        maux = restantes(x+1,y+2);
        if(maux < max && maux != -1) {
            max = maux;
            aux[0] = x+1;
            aux[1] = y+2;
        }
        
        return aux;
    }
    
    private int restantes(int x, int y) {
        int restantes = 0;
        
        try {
            if(tablero[y][x] == 1) { // entra sólo si la coordenada no se ha recorrido
                /*
                    Verifica las coordenadas validas y aumenta el numero de restantes
                    cuando la casilla no se ha recorrido
                    
                    El recorrio se hace en de forma circular
                */
                try {
                    if(tablero[y+2][x-1] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y+1][x-2] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y-1][x-2] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y-2][x-1] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y-2][x+1] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y-1][x+2] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y+1][x+2] == 1)
                        restantes ++;
                } catch(Exception e){}

                try {
                    if(tablero[y+2][x+1] == 1)
                        restantes ++;
                } catch(Exception e){}
            } else {
                // Si la casilla ya ha sido recorrida se etablece -1 indicar que
                // la casilla no es valida
                restantes = -1; 
            }
        } catch(Exception e) {
            // Si se sale del tablero se establece -1 para indicar que la casilla
            // no es valida
            restantes = -1;
        }
        
        return restantes;
    }
    
    public void setInicio(int[] inicio) {
        this.inicio = inicio;
    }
    
    public String getCamino() {
        return this.camino;
    }

    @Override
    public String toString() {
        String aux = "";
        
        for(int i=0;i<tablero.length;i++) {
            for(int j=0;j<tablero.length;j++) {
                
                if(tablero[i][j] == 0) 
                    aux += "|"+ANSI_RED+String.format("%2s", tablero[i][j])+ANSI_RESET;
                else
                    aux += "|"+String.format("%2s", tablero[i][j]);
            }
            aux += "|\n";
        }
        
        return aux;
    }
    
}
