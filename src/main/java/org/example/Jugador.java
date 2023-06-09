package org.example;

import lombok.*;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    private Juego juego;
    private String ficha;
    private String nombre;


    public void jugar(){
        int f=0;
        int c=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese un numero del 1 al 9"+" jugador "+nombre);
        int jugada=scanner.nextInt();
        switch(jugada){
            case 1:f=2;c=0;//mapeando segun teclado numerico
            break;
            case 2: f=2;c=1;
            break;
            case 3:f=2;c=2;
            break;
            case 4:f=1;c=0;
            break;
            case 5:f=1;c=1;
            break;
            case 6:f=1;c=2;
            break;
            case 7:f=0;c=0;
            break;
            case 8:f=0;c=1;
            break;
            case 9:f=0;c=2;
            break;
            default:
                System.out.println("el numero ingresado no es valido");//valida que no sea un numero <1 o >9
                break;
        }
        if(!juego.ponerFicha(f,c,ficha)){//si el jugador pone una ficha en un lugar que ya hay una ficha
            System.out.println("pusiste una ficha en un lugar ocupado");
        }

    }
}
