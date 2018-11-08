package sea;

import java.util.ArrayList;
import java.util.List;

public class Constructor extends Thread {
    // должен выдавать рандомно корабли 3х разных типов с 3мя разными категориями веса
    public List<Ship> ships = new ArrayList<>();
    public boolean isNeed;

    public Constructor() {
    }

    private Ship createShip() {

        if (Math.random()<0.33)
            return new GoldShip(randomWeight());
        else if (Math.random()<0.7)
            return new WoodShip(randomWeight());
        else return new OilShip(randomWeight());

    }

    private int randomWeight() {

        if (Math.random()<0.33)
            return 50;
        else if (Math.random()<0.7)
            return 30;
        else return 10;

    }

    public Ship startFactory() {
        while (isNeed) {
            ships.add(createShip());
                return ships.get(ships.size()-1);
        }
        return null;
    }

    public boolean isNeed() {
        return isNeed;
    }

    public void setNeed(boolean need) {
        isNeed = need;
    }
}
