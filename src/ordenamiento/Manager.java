/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.ArrayList;


public class Manager {
    
    private ArrayList<AlgoritmoOrdenamiento> metodos;
    
    public Manager() {
        this.metodos = new ArrayList<>();
    }
    public Manager(ArrayList<AlgoritmoOrdenamiento> metodos) {
        this.metodos = metodos;
    }
    public void ejecutarPrueba(double[] datos, boolean grafica){
        double tiempos [] = new double[metodos.size()];
        int p = 0;
        // recorremos la lista de algoritmos
        for(AlgoritmoOrdenamiento a:this.metodos){
            a.definirDatos(datos.clone());
            a.ordenarDatos();
            tiempos[p] = a.getTt();
           // System.out.println(tiempos[p]);
            p++;                 
        }
        if(grafica){
        Grafica g = new Grafica("Id Algoritmos", "Tiempos","Prueba Básica de Ordenamientos");
        g.agregarSerie(tiempos,"0");
        g.creaYmuestraGrafica();
        }
            
    }
    
    public void ejecutarPrueba(int pruebas,int rAumento,int rAleatorio, boolean grafica){
        ArrayList<Double[]> tiemposTotales = new ArrayList<>();
        for(int j = 0; j<this.metodos.size();j++)
            tiemposTotales.add(new Double[pruebas]);
        
        //tiemposTotales.add(new Double[pruebas]);
        
        for(int p=1;p<pruebas;p++){
            double[] datos = Herramientas.generarArregloAleatorio(p*rAumento,rAleatorio);
            for(int a=0;a<this.metodos.size();a++){
                AlgoritmoOrdenamiento aux = this.metodos.get(a);
                aux.definirDatos(datos.clone());
                aux.ordenarDatos();
                tiemposTotales.get(a)[p]=aux.getTt();
                
            }
           // tiemposTotales.get(tiemposTotales.size()-1)[p]=Math.pow(p, 2);
            System.out.println(p);
        }
        
        if(grafica){
        Grafica g = new Grafica("Id Algoritmos", "Tiempos","Prueba Ordenamientos");
        for (int x=0;x<tiemposTotales.size();x++){
            g.agregarSerie(tiemposTotales.get(x),""+x);
        }
        
        g.creaYmuestraGrafica(true);
        }
    }
    
    
    
}
