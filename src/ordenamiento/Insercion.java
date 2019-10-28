package ordenamiento;

public class Insercion implements AlgoritmoOrdenamiento, Runnable{

    private double[] arreglo;
    private double tt;
    private boolean thread;

    public Insercion() {
        this.thread = false;
        this.arreglo = null;
    }


    public Insercion(boolean thread) {
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
        int pos;
        double aux;
        //Tiempo inicial
        double ti=System.currentTimeMillis();
        //Ordenamos
        for(int i= 0; i<this.arreglo.length; i++){
            pos=i;
            aux= this.arreglo[i];
            while((pos>0)&&(this.arreglo[pos-1]>aux)){
                this.arreglo[pos]= this.arreglo[pos-1];
                pos--;
            }
            this.arreglo[pos]=aux;
        }
        double tf=System.currentTimeMillis();
        this.tt = tf - ti;
    }

    public double getTt() {
        return tt;
    }

}
