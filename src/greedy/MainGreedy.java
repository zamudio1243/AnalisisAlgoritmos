package greedy;
/*
Hector octubre 2019 
*/

public class MainGreedy {
    public static void main(String[] args) {
        Caballo caballo = new Caballo(9,7,6);
        int numMovimientos = caballo.recorridoCaballo();
        for (int i = 0; i < caballo.getTablero().length ; i++) {
            for (int j = 0; j < caballo.getTablero().length ; j++) {
                System.out.print(String.format("[%3d]",caballo.getTablero()[i][j]));
            }
            System.out.println("");
        }
        System.out.println("Llego hasta: "+numMovimientos);
    }
}
