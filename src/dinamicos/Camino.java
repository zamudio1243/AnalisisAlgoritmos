package dinamicos;
/*
Hector septiembre 2019 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Camino{
    private ArrayList<ArrayList<Integer>> ALcaminos;
    private int[][] caminos;
    private int[] caminoFinal;
    private  int nodoInicial;


    public Camino(ArrayList<ArrayList<Integer>> caminos, int nodoInicial) {
        this.ALcaminos = caminos;
        this.nodoInicial = nodoInicial;
    }

    public Camino(int[][] caminos, int nodoInicial) {
        this.caminos = caminos;
        this.nodoInicial = nodoInicial;
    }

    public ArrayList<ArrayList<Integer>> getCaminos() {
        return ALcaminos;
    }

    public int getNodoInicial() {
        return nodoInicial;
    }

    public void minDistanciaGreedy(){
        String cam="";
        int x = 0;
        ArrayList<ArrayList<Integer>> aux= (ArrayList<ArrayList<Integer>>) this.ALcaminos.clone();
        for (ArrayList<Integer> i: this.ALcaminos) {
            Collections.sort(i);

            cam+=this.ALcaminos.get(x).indexOf(i.get(0))+" ";
            x++;


        }
        System.out.println(cam);
    }
    public int minDistancia(){
        int min= Integer.MAX_VALUE;

        int[] cities = new int[caminos.length];
        cities[0]= this.nodoInicial;
        for (int i = 1; i < caminos.length ; i++) {
            if(i==this.nodoInicial)
                cities[i]= 0;
            else
                cities[i]=i;
        }
        do{
            int nuevaDistancia= 0;
            for (int i = 0; i < cities.length -1 ; i++) {
               nuevaDistancia+=caminos[cities[i]][cities[i+1]];
            }
            nuevaDistancia+=caminos[cities[cities.length-1]][cities[0]];

            if(nuevaDistancia < min) {
                min = nuevaDistancia;
                caminoFinal=cities.clone();

            }
        }while (nextPermutation(cities) && cities[0] == nodoInicial);

        System.out.println("Final: "+Arrays.toString(caminoFinal));

        return min;
    }
    private static boolean nextPermutation(int[] array) {

        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}


