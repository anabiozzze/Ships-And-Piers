import sea.Constructor;
import sea.GoldShip;
import sea.Ship;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static boolean isNeed = true;
    static List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
//        Constructor constructor = new Constructor();
//        constructor.setNeed(true);
//
//        List<Ship> ships = new ArrayList();
//
//        for (int i=0; i<10; i++) {
//            try {
//                ships.add(constructor.startFactory());
//                System.out.println(ships.get(i).getClass() + ", вес = " + ships.get(i).getWeight());
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running;");
                startFactory();
            }
        });

        thread.start();


        for (int i =0; i<10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(ships.get(ships.size()-1));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isNeed = false;

    }


    public static Ship startFactory() {
        Ship result = null;

        while (isNeed) {

            try {
                ships.add(new GoldShip(50));
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
