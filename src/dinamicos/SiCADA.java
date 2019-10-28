package dinamicos;
/*
Hector septiembre 2019 
*/

import java.util.ArrayList;
import java.util.List;

public class SiCADA {

    public static void main(String[] args) {

        List<Double> t = new ArrayList<Double>();

        t.add(20.5);
        t.add(20.3);
        t.add(20.8);
        t.add(0.0);
        t.add(20.1);
        t.add(20.1);
        t.add(20.5);
        t.add(20.6);
        t.add(20.7);

        System.out.println("Programación Convencional");
        System.out.println("-------------------------");
        double max = 0;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) > max) {
                max = t.get(i);
            }
        }
        double min = max;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) < min) {
                min = t.get(i);
            }
        }
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);

        System.out.println("-------------------------");
        System.out.println("Expresiones Lambda");
        System.out.println("-------------------------");
        System.out.println("Máximo: " + t.stream().mapToDouble(i -> i).max().getAsDouble());
        System.out.println("Máximo: " + t.stream().mapToDouble(i -> i).min().getAsDouble());

    }

}