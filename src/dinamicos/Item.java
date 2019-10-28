package dinamicos;
/*
Hector octubre 2019 
*/

import java.util.ArrayList;
import java.util.Random;

public class Item {
    private int weigth;
    private int benefit;

    public Item(int weigth, int benefit) {
        this.weigth = weigth;
        this.benefit = benefit;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    public static ArrayList<Item> generarItems(int numItems, int peso, int beneficio){
        ArrayList<Item> Items = new ArrayList<>();
        for (int i = 0; i <numItems ; i++) {
            Random ranPeso = new Random();
            Random ranBeneficio= new Random();
            Item aux = new Item(ranPeso.nextInt(peso)+1,ranBeneficio.nextInt(beneficio)+1);
            Items.add(aux);
        }
        return Items;
    }
    @Override
    public String toString(){
        return weigth+","+benefit;
    }
}
