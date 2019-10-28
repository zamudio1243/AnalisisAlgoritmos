package ordenamiento;
/*
Hector agosto 2019
*/

public class BurbujaOp implements AlgoritmoOrdenamiento , Runnable{
    private double[] arreglo;
    private double tt;
    private boolean thread;

    public BurbujaOp() {
        this.thread = false;
        this.arreglo = null;
    }


    public BurbujaOp(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
    }


    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo=arreglo;
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

        double ti = System.currentTimeMillis();

        for(int i= this.arreglo.length -1; i>0 ; i--){
            for(int j=0 ;j<i; j++){
                if(this.arreglo[j] > this.arreglo[j+1]){
                    double temp= this.arreglo[j];
                    this.arreglo[j]= this.arreglo[j+1];
                    this.arreglo[j+1]= temp;
                }
            }
        }

        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
    }

    public double getTt() {
        return tt;
    }

}

