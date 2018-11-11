package Port;

import sea.GoldShip;
import sea.OilShip;
import sea.Ship;
import sea.WoodShip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Port {
    // принимает судна после прохождения таможни и распределяет по нужным пирсам, в зависимости от типа судна.
    // всего три пристани - нефть грузится только на одной из них, золото - на другой, лес - на третьей.
    // если порт заполнен (5 судов максимум) - таможня временно не пропускает новые суда.

    private static Customs customs;

    // используем синхронизированную коллекцию во избежение одновременного доступа от разных потоков
    private static List<Ship> inPort = Collections.synchronizedList(new ArrayList<>());

    public Port() {
    }

    public static List<Ship> getInPort() {
        return inPort;
    }

    // добавляем новый корабль в порт и отправляем на сортировку.
    // если места пока нет - просим таможню подождать.
    public static void addShip(Ship arrival) {

        if (inPort.size() < 5) {
            inPort.add(arrival);
            System.out.println(arrival.getName() + " вошёл в порт.\n");
            getSort(arrival);

            System.out.println(arrival.getName() + " прошел сортировку.\n");

        } else {

            try {
                System.out.println("В порту нет мест для погрузки. Ожидайте. \n");
                while (inPort.size() >= 5) {
                    customs.wait(100);
                }

                inPort.add(arrival);
                getSort(arrival);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // используется в классе Sender после погрузки
    public static void delShip(Ship depart) {
        inPort.remove(depart);
    }

    // передаем на нужный пирс в зависимости от типа судна;
    // погрузка судна занимает определенное время - 0,3 секунды за каждые 10 единиц веса
    private static void getSort(Ship incoming) {
        if (incoming.getClass().equals(GoldShip.class)) {
            Piers.loadGold(incoming);
        } else if (incoming.getClass().equals(WoodShip.class)) {
            Piers.loadWood(incoming);
        } else if (incoming.getClass().equals(OilShip.class)) {
            Piers.loadOil(incoming);
        } else System.out.println("Incorrect type of the ship.");
    }
}
