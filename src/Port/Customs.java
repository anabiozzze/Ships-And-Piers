package Port;

import sea.*;

import java.util.List;

public class Customs {

    // цель класса - брать в море максимум пять кораблей и пропускать их в порт на погрузку к соответствующим
    // пристаням - нефть грузится только на одной из них, золото - на другой, лес - на третьей.

    private Constructor constructor = new Constructor();
    private Piers piers = new Piers();

    public void onGates() {
        int count = constructor.ships.size();

        if (count>=5) {
            for (int i=0; i<5; i++) {
                getSort(constructor.ships.get(i));
            }
        }

        else {
            for (int i=0; i<constructor.ships.size(); i++) {
                getSort(constructor.ships.get(i));
            }
        }
    }

    public void getSort(Ship incoming) {
        if (incoming.getClass().equals(GoldShip.class)) {
            piers.loadGold();
        } else if (incoming.getClass().equals(WoodShip.class)) {
            piers.loadWood();
        } else if (incoming.getClass().equals(OilShip.class)) {
            piers.loadOil();
        } else System.out.println("Incorrect type of the ship.");
    }
}
