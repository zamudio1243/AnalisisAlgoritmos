package ordenamiento;
/*
Hector septiembre 2019 
*/

public class MergeSort implements AlgoritmoOrdenamiento,Runnable {
    private double[] arreglo;
    private double tt;
    private boolean thread;


    public MergeSort() {
        this.arreglo= null;
        this.thread= false;
    }

    public MergeSort(boolean thread) {
        this.thread= thread;
    }


    @Override
    public void run() {
        double ti=System.currentTimeMillis();
        sort(this.arreglo,0,this.arreglo.length-1);
        double tf=System.currentTimeMillis();
        this.tt = tf - ti;

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

        }else run();

    }

    @Override
    public double getTt() {
        return tt;
    }
    void sort(double arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    void merge(double arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        double L[] = new double[n1];
        double R[] = new double [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


}
