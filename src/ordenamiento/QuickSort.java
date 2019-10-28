package ordenamiento;

public class QuickSort implements AlgoritmoOrdenamiento,Runnable {
    private double[] arreglo;
    private double tt;
    private boolean thread;

    public QuickSort() {
        this.thread = false;
        this.arreglo = null;
    }


    public QuickSort(boolean thread) {
        this.thread = thread;
        this.arreglo = null;
    }


    @Override
    public void definirDatos(double[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void ordenarDatos() {

        if (this.thread) {
            Thread hilo = new Thread(this);
            hilo.start();

        } else {
            run();
        }
    }

    @Override
    public void run() {
        /*
        if(arreglo.length==0){
            return;
        }

         */
        //Tiempo inicial
        double ti = System.currentTimeMillis();
        //Ordenamos
        quickSort(this.arreglo);
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
    }

    public double getTt() {
        return tt;
    }

    public static void quickSort(double[] array) {
        recursiveQuickSort(array, 0, array.length -1);
    }
    public static void recursiveQuickSort(double[] array, int startIdx,
                                          int endIdx) {

        int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }
    public static int partition(double[] array, int left, int right) {

        double pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                double tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }



        return left;


    }



}
