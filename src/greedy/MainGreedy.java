package greedy;
/*
Hector octubre 2019 
*/

public class MainGreedy {
    public static void main(String[] args) {
        Caballo kotex = new Caballo(4,3,3);
        int numMovimientos = kotex.recorridoCaballo();
        for (int i = 0; i < kotex.getTablero().length ; i++) {
            for (int j = 0; j < kotex.getTablero().length ; j++) {
                System.out.print(kotex.getTablero()[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("Llego hasta: "+numMovimientos);

    }
}
