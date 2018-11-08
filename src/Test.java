import sea.Constructor;
import sea.Ship;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Constructor constructor = new Constructor();
        constructor.setNeed(true);

        List<Ship> ships = new ArrayList();

        for (int i=0; i<10; i++) {
            try {
                ships.add(constructor.startFactory());
                System.out.println(ships.get(i).getClass() + ", вес = " + ships.get(i).getWeight());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
