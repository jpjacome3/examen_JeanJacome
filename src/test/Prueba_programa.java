
package test;

import dominio.Coordenada;
import java.util.Scanner;

/**
 *
 * @author JEAN_PIERRE
 */
public class Prueba_programa {
    static Scanner leer = new Scanner(System.in);
     public static void main(String[] args){
         System.out.println("Cuantos movimientos desea realizar?: ");
         int n =leer.nextInt();
         Coordenada [] puntos = new Coordenada[n];
         Desplazaminto(puntos);

         System.out.println("-------------------------------------");
         System.out.println("Estos son los Movimientos realizados");
         System.out.println("-------------------------------------");
         
         for(int i=0;i<puntos.length;i++){
             System.out.println("Movimiento" + (i+1) + " es= ");
             System.out.println("("+puntos[i].getX()+","+puntos[i].getY()+")");
         }
         
         System.out.println("-------------------------------------");
         System.out.println("Distancia de  los Desplazamientos realizados");
         System.out.println("-------------------------------------");
         System.out.println("Distancia total recorrida= "+Distancia(puntos));
         
    
     
         
     }
     
     public static int Desplazaminto(Coordenada p[]) {
        int x;
        int y;
        int des = 0;
        int ram;
        
        for (int i = 0; i < p.length; i++) {
            System.out.println("Movimiento" + (i+1) + ": ");
            System.out.println("Cuanto quiere desplazarse?:");
            des = leer.nextInt();
            if((i+1) % 2 == 0){
                ram = (int)(Math.random()*10+1);
                p[i] = new Coordenada(des+des,ram);
            }else{
                ram = (int)(Math.random()*10+1);
                p[i] = new Coordenada(ram,des+des);
            }
            
        }
        return des;
    }
     
    public static double Distancia(Coordenada p[]){
       double dis;
        double suma = 0;
        double aux = 0;
        for (int i = 0; i < p.length; i++) {

            if (i == 0) {
                
                int x = (int) Math.pow(p[i].getX(), 2);
                int y = (int) Math.pow(p[i].getY(), 2);
                dis = Math.sqrt(x + y);
                System.out.println("Distancia " + (i + 1) + "= " + dis);
                
            } else {
                int x = (int) Math.pow(p[i-1].getX()-p[i].getX(), 2);
                int y = (int) Math.pow(p[i-1].getY()-p[i].getY(), 2);
                dis = Math.sqrt(x + y);
                System.out.println("Distancia " + (i + 1) + "= " + dis);
            }
            suma = suma + dis;
        }
        return suma;
    }   
}
