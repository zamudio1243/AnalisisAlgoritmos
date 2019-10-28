/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.Random;


public class Herramientas {
    
    public static double[] generarArregloAleatorio(int dim, int ran){
        // declaramos y asignamos memoria
        double arreglo[] = new double[dim];
        // declaramos r como Random para generar el numero aleatorio
        Random r = new Random();
        // asignamos aleatorios usando el ciclo
        for(int x=0; x<dim;x++){
            
        arreglo[x] = r.nextInt(ran);
        }
        return arreglo;
    }
    
    public static double[] generarArregloPeorCaso(int dim){
        // declaramos y asignamos memoria
        double arreglo[] = new double[dim];
        int j=0;
        for(int i=dim;i>0;i--) {
            arreglo[j]=i;
            j++;
        }
        return arreglo;
    }
    
     public static double[] generarArregloMejorCaso(int dim){
        // declaramos y asignamos memoria
        double arreglo[] = new double[dim];
        
        for(int i=0;i<dim;i++) {
            arreglo[i]=i;
          
        }
        return arreglo;
    }
}
