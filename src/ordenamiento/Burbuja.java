package ordenamiento;

/**
 *
 * @author CRUZLEIJA
 */
public class Burbuja implements AlgoritmoOrdenamiento, Runnable{

    private double[] arreglo;
    private double tt;
    private boolean thread;
    
     public Burbuja() {
        this.thread = false;
        this.arreglo = null;
    }
      
    
    public Burbuja(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
    }
      
    @Override
    public void definirDatos(double[] arreglo) {
       this.arreglo = arreglo;
    }

    @Override
     public void ordenarDatos() {
     
         if (this.thread){
             Thread hilo = new Thread(this);
             hilo.start();
         
         }else{
             run();
         }
    }

    @Override
    public void run() {
        
        // calcular cuando empieza 
        double ti = System.currentTimeMillis();
        // ordenamos
        for(int i=1;i<arreglo.length;i++){
            for(int j=0;j<arreglo.length-1;j++){
                if(arreglo[j]>arreglo[j+1]){
                    double temp=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=temp;
                }
            }
        }
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
        // calculamos el tiempo total
        
    }

    /**
     * @return the tt
     */
    public double getTt() {
        return tt;
    }
    
    
}
