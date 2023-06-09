package org.example;


import java.util.Scanner;

/**
 * Hello to Practica Parcial 1 - TA TE TI
 *
 */
public class App 
{

    /**
     * This is the main program
     * 
     */
    public static void main( String[] args ) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Hello, Practica Parcial 1 - TA TE TI.");
        System.out.println("Bienvenidos a TATETI.Ingrese los nombres de los jugadores");
        int puntajeJ1=0;
        int puntajeJ2=0;
        Jugador j1=null;
        Jugador j2=null;
        Juego tateti=new Juego();//creo que el juego
        while(true){
            //creacion de jugadores
            if(j1==null ||j2==null){
                String jug1=scanner.nextLine();
                String jug2=scanner.nextLine();
                j1=new Jugador(tateti,"x",jug1);
                j2=new Jugador(tateti,"o",jug2);
            }else{
                Jugador aux = j1;//intercambio entre partidas
                j1 = j2;
                j2 = aux;
            }

            tateti.tableroVacio();
            tateti.mostrarTablero();

            boolean ganador=false;//es falso porque todavia no hay ganador
            boolean empate=false;
            String ultimo="";
            int casillasOcupadas=0;

            while (!ganador){//mientras no haya ganador
                j1.jugar();
                ultimo=j1.getNombre();
                casillasOcupadas++;
                tateti.mostrarTablero();
                if(casillasOcupadas==9){
                    empate=true;
                    break;
                }
                //actualizar estado de la aplicacion
                if(!(ganador=tateti.hayTateti())){//cuando no haya tateti entra
                    j2.jugar();//deja jugar al j2
                    ultimo=j2.getNombre();
                    casillasOcupadas++;
                    tateti.mostrarTablero();
                    if(casillasOcupadas==9){
                        empate=true;
                        break;
                    }
                    ganador=tateti.hayTateti();
                }
                ganador=tateti.hayTateti();
            }
            if(ganador){
                if(ultimo.equals(j1.getNombre())){
                    puntajeJ1+=3;
                    puntajeJ2+=1;
                }else{
                    puntajeJ2+=4;
                    puntajeJ1+=1;
                }
                System.out.println("GANASTE!!! "+ultimo);
            }else if(empate){
                    puntajeJ1+=1;
                    puntajeJ2+=2;
                System.out.println("Hay EMPATE!!!");
            }
            System.out.println("¿Desea volver a jugar? s/n");
            String respuesta=scanner.nextLine();
            if(!respuesta.equalsIgnoreCase("s")){
                break;
            }

        }
        System.out.println("Puntajes: "+j1.getNombre()+" = "+puntajeJ1+"  "+j2.getNombre()+" = "+puntajeJ2);
        System.out.println("Gracias por jugar!!!");
    }

}
