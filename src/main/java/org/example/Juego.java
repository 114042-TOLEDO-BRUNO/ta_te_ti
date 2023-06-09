package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Juego {

    private final String[][] tablero=new String[3][3];//tamaño del arreglo
   /*  0 1 2
    0  x x x
    1  o o o
    2  x x x
    */
    public void mostrarTablero(){
//        System.out.println("");
        for(int f=0;f< tablero.length;f++){
            for(int c=0;c<tablero[0].length;c++) {
                System.out.print(tablero[f][c]);
                if (c < tablero[0].length - 1) { // Si no es el último elemento de la fila, agregar un espacio en blanco
                    System.out.print(" ");
                }
            }
            System.out.println();//salto de linea para separar visualmente
        }
    }
    public boolean ponerFicha(int f,int c,String ficha){//ficha seria un "o" o una "x"
        if(tablero[f][c].equals("-")){//si esta posicion esta vacia osea que tiene el guion
            tablero[f][c]=ficha;//coloco la ficha
        } else {
            return false;
        }
        return true;
    }
    public void tableroVacio(){
        for(int i=0;i< tablero.length;i++){
            for(int j=0;j<tablero[0].length;j++){
                tablero[i][j]="-";
            }
        }
    }
    public boolean hayTateti(){
        //1era fila
        if(!tablero[0][0].equals("-") &&tablero[0][0].equals(tablero[0][1]) && tablero[0][1].equals(tablero[0][2])){

            return true;
        }
        //2da fila
        if(!tablero[1][0].equals("-")&&tablero[1][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[1][2])){

            return true;
        }
        //3ra fila
        if(!tablero[2][0].equals("-")&&tablero[2][0].equals(tablero[2][1]) && tablero[2][1].equals(tablero[2][2])){

            return true;
        }
        //1ra columna
        if(!tablero[0][0].equals("-")&&tablero[0][0].equals(tablero[1][0]) && tablero[1][0].equals(tablero[2][0])){

            return true;
        }
        //2da columna
        if(!tablero[0][1].equals("-")&&tablero[0][1].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][1])){

            return true;
        }
        //3ra columna
        if(!tablero[0][2].equals("-")&&tablero[0][2].equals(tablero[1][2]) && tablero[1][2].equals(tablero[2][2])){
            return true;
        }
        //1ra diagonal
        if(!tablero[0][0].equals("-")&&tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])){
            return true;
        }
        //2da diagonal
        if(!tablero[0][2].equals("-")&&tablero[2][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[0][2])){
            return true;
        }
        return false;
    }
}
