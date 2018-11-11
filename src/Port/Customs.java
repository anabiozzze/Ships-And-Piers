package Port;

import sea.*;


public class Customs extends Thread {
    // цель класса - брать в море максимум пять кораблей и пропускать их в порт на погрузку,
    // предварительно оформив документы на таможне.

    // кроме того, класс считает кол-во судов, ожидающих входа в порт

    public Customs() {

    }

    @Override
    public void run() {
        while (true) {
            onGates();
            if (!Constructor.isNeed() && Constructor.ships.size()==0) {
                break;
            }
        }
    }

    // ворота таможни пропускают максимум пять судов из открытого моря в порт;
    // оформление документов занимает одну секунду на каждый вошедший корабль
    private synchronized void onGates() {

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
                sleeping(i);

                Ship arrive = Constructor.ships.get(i);
                Port.addShip(arrive);
                Constructor.ships.remove(i);
            }
        }

        // если в очереди меньше пяти судов - пропускаем их всех на сортировку
        else {
            for (int i=0; i<Constructor.ships.size(); i++) {
                sleeping(i);

                Port.addShip(Constructor.ships.get(i));
                Constructor.ships.remove(i);
            }
        }
    }

    private void sleeping(int i) {
        try {
            System.out.println("Оформление документов на судно: " + Constructor.ships.get(i).getName() +"\n");

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
