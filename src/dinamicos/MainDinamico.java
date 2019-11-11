package dinamicos;
/*
Hector septiembre 2019 
*/

import java.util.ArrayList;
import java.util.Comparator;

public class MainDinamico {

    public  static void Fibo(){
        double ti= System.currentTimeMillis();
        long FR= Fibonacci.fiboRecursivo(60);
        double tf= System.currentTimeMillis();
        double tt=tf-ti;
        System.out.println("Fibonaci Recursivo: "+tt);
        ti= System.currentTimeMillis();
        FR=Fibonacci.fiboRecursivoDinamico(5000);
        tf=System.currentTimeMillis();
        tt=tf-ti;
        System.out.println("Fibonaci Dinamico Recursivo: "+tt);

    }
    public static void  Arreglos(){
        ArrayList<ArrayList<Integer>> camino = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> g = new ArrayList<>();
        ArrayList<Integer> h = new ArrayList<>();
        ArrayList<Integer> i = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();
        a.add(Integer.MAX_VALUE) ;a.add(13);a.add(33);a.add(28);a.add(37);a.add(7);a.add(32);a.add(40);a.add(80);a.add(26);
        b.add(13);b.add(Integer.MAX_VALUE) ;b.add(39);b.add(83);b.add(50);b.add(68);b.add(16);b.add(98);b.add(81);b.add(55);
        c.add(33);c.add(39);c.add(Integer.MAX_VALUE) ;c.add(80);c.add(88);c.add(49);c.add(53);c.add(75);c.add(63);c.add(55);
        d.add(28) ;d.add(83) ;d.add(80) ;d.add(Integer.MAX_VALUE);d.add(94);d.add(4);d.add(20);d.add(6);d.add(59);d.add(76);
        e.add(37) ;e.add(50) ;e.add(88) ;e.add(94);e.add(Integer.MAX_VALUE);e.add(81);e.add(87);e.add(85);e.add(4);e.add(19);
        f.add(7) ;f.add(68) ;f.add(49) ;f.add(4);f.add(81);f.add(Integer.MAX_VALUE);f.add(96);f.add(53);f.add(40);f.add(37);
        g.add(32) ;g.add(16) ;g.add(53);g.add(20);g.add(87);g.add(96);g.add(Integer.MAX_VALUE);g.add(80);g.add(57);g.add(68);
        h.add(40) ;h.add(98) ;h.add(75);h.add(6);h.add(85);h.add(53);h.add(80);h.add(Integer.MAX_VALUE);h.add(65);h.add(41);
        i.add(80) ;i.add(81) ;i.add(63);i.add(59);i.add(4);i.add(40);i.add(57);i.add(65);i.add(Integer.MAX_VALUE);i.add(97);
        j.add(26) ;j.add(55) ;j.add(55);j.add(76);j.add(19);j.add(37);j.add(68);j.add(41);j.add(97);j.add(Integer.MAX_VALUE);
        camino.add(a);camino.add(b);camino.add(c);camino.add(d);camino.add(e);camino.add(f);camino.add(g);
        camino.add(h);camino.add(i);camino.add(j);
        Camino cam = new Camino(camino,0);
        cam.minDistanciaGreedy();
        /*
        camino.forEach(x->{
            System.out.println(x.stream().mapToInt(z->z).min().getAsInt());
        });

         */
    }
    public static void fuerzaBruta(){
        int[][] matriz = {
                {0,  13, 33, 28, 37, 7, 32,  40, 80, 26},
                {13, 0,  39, 83, 50, 68, 16, 98, 81, 55},
                {33, 39, 0,  80, 88, 49, 53, 75, 63, 55},
                {28, 83, 80, 0,  94, 4, 20,  6,  59, 76},
                {37, 50, 88, 94, 0,  81, 87, 85, 4,  19},
                {7,  68, 49, 4,  81, 0, 96,  53, 40, 37},
                {32, 16, 53, 20, 87, 96, 0,  80, 57, 68},
                {40, 98, 75, 6,  85, 53, 80, 0,  65, 41},
                {80, 81, 63, 59, 4,  40, 57, 65, 0,  97},
                {26, 55, 55, 76, 19, 37, 68, 41, 97, 0}
        };

        Camino camino = new Camino(matriz,0);
        System.out.println(camino.minDistancia());
/*
        int[][] matriz={
            {0, 11,12,3},
            {11,0, 0, 9},
            {12,0, 0, 7},
            {3, 9, 7, 0}
        };


        int[][] matriz={
                {0,3,1,6},
                {3,0,4,12},
                {1,4,0,8},
                {6,12,8,0}

        };
        for (int i = 0; i < matriz.length; i++) {
            Camino camino = new Camino(matriz,i);
            System.out.println("Minimio a recorrer: "+camino.minDistancia());
        }

         */

    }

    public static void mochila(){
        //ArrayList<Item> items= Item.generarItems(10,55,100);
        //Mochila bagpack = new Mochila(items);
        //Herramientas.guardar(bagpack);
        //Herramientas.leerDatos();
        //Mochila bagpack= new Mochila(Herramientas.items);
       // System.out.println(bagpack.toString());

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(3,34));
        items.add(new Item(6,28));
        items.add(new Item(6,90));
        items.add(new Item(1,23));
        items.add(new Item(9,11));
        items.add(new Item(1,19));
        items.add(new Item(11,7));

        Mochila backpack = new Mochila(items,11);
        backpack.buscarSolucion();
        Herramientas.guardar(backpack);

    }
    public static  void main(String[] agrs){
        MainDinamico.mochila();
    }
}
