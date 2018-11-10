package Port;

import sea.*;


public class Customs extends Thread {
    // цель класса - брать в море максимум пять кораблей и пропускать их в порт на погрузку к соответствующим
    // пристаням - нефть грузится только на одной из них, золото - на другой, лес - на третьей.

    public Customs() {

    }

    @Override
    public void run() {
        while (true) {
            onGates();
        }
    }

    // ворота таможни пропускают максимум пять судов из открытого моря на погрузку;
    // оформление документов занимает одну секунду на каждый вошедший корабль
    public void onGates() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // всего кораблей ождают у ворот таможни:
        System.out.println("Кораблей на входе: " + Constructor.ships.size()  +"\n");

        // если в очереди пять или более судов - пропускаем их группами по пять штук на сортировку
        if (Constructor.ships.size()>=5) {
            for (int i=4; i>=0; i--) {
                try {
                    System.out.println("Оформление документов на судно: " + Constructor.ships.get(i).getName() +"\n");

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Ship arrive = Constructor.ships.get(i);
                getSort(arrive);
                Constructor.ships.remove(i);
            }
        }

        // если в очереди меньше пяти судов - пропускаем их всех на сортировку
        else {
            for (int i=0; i<Constructor.ships.size(); i++) {
                try {
                    System.out.println("Оформление документов на судно: " + Constructor.ships.get(i).getName() +"\n");

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                getSort(Constructor.ships.get(i));
                Constructor.ships.remove(i);
            }
        }
    }

    // передаем на нужный пирс в зависимости от типа судна;
    // погрузка судна занимает определенное время - 0,3 секунды за каждые 10 единиц веса
    public void getSort(Ship incoming) {
        if (incoming.getClass().equals(GoldShip.class)) {
            Piers.loadGold(incoming);
        } else if (incoming.getClass().equals(WoodShip.class)) {
            Piers.loadWood(incoming);
        } else if (incoming.getClass().equals(OilShip.class)) {
            Piers.loadOil(incoming);
        } else System.out.println("Incorrect type of the ship.");
    }
}
