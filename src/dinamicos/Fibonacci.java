package dinamicos;
/*
Hector septiembre 2019 
*/

public class Fibonacci {

    public  static long fiboRecursivo(long pos){

        long retornado=0;
        if(pos==0 || pos==1) retornado=pos;
        else retornado=fiboRecursivo(pos-2)+fiboRecursivo(pos-1);
        return retornado;

    }
    public static long fiboRecursivoDinamico(long pos){
        if(pos<=1){
            return pos;
        } else {
            long n [] = new long[(int)pos+1];
            n[0]= 0;
            n[1]= 1;
            return lookUpFib(n,pos);
        }
    }

    private static long lookUpFib(long[] n, long pos) {
        if((pos==0 || pos ==1) || (n[(int)pos]!=0 && pos!=0))return n[(int)pos];

        // si no se conoce entonces calcular
        n[(int)pos]=lookUpFib(n, pos-1)+lookUpFib(n, pos-2);

        return n[(int)pos];
    }

}
