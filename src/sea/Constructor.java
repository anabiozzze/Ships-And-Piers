package sea;

import java.util.ArrayList;
import java.util.List;

public class Constructor extends Thread {
    // должен выдавать рандомно корабли 3х разных типов с 3мя разными категориями веса

    public static volatile List<Ship> ships = new ArrayList<>();
    public boolean isNeed;

    public Constructor() {
    }

    @Override
    public void run() {
        setNeed(true);
        startFactory();
    }

    // здесь создаем корабли разных типов
    private Ship createShip() {

        if (Math.random()<0.33)
            return new GoldShip(randomWeight());
        else if (Math.random()<0.7)
            return new WoodShip(randomWeight());
        else return new OilShip(randomWeight());

    }

    // здесь задаем кораблям случайцный вес
    private int randomWeight() {

        if (Math.random()<0.33)
            return 50;
        else if (Math.random()<0.7)
            return 30;
        else return 10;

    }


    public Ship startFactory() {
        Ship result = null;

        while (isNeed) {
            result = createShip();
            ships.add(result);
            System.out.println(ships.get(ships.size()-1).toString() + " is coming from sea...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean isNeed() {
        return isNeed;
    }

    public void setNeed(boolean need) {
        isNeed = need;
    }
}
