package Port;

import sea.Ship;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Sender extends Thread {
    // этот класс отправляет погруженные корабли обратно в море, сохраняя о них данные в отдельном журнале

    // используем синхронизированную коллекцию во избежение одновременного доступа от разных потоков
    private static Map<Ship, Date> journal = Collections.synchronizedMap(new HashMap<>());
    private Ship depart;

    public Sender(Ship depart) {
        this.depart = depart;
    }

    public Map<Ship, Date> getJournal() {
        return journal;
    }


    // показать журнал отправки загруженных судов
    public static void showJournal() {
        for (Map.Entry<Ship, Date> entry : journal.entrySet()) {
            System.out.println("Название " + entry.getKey().getName() + "; тип судна: "
                    + entry.getKey() + "; дата отправления: " +entry.getValue());
        }
    }

    // делаем запись в журнал отправки судов
    public void makeEntry(Ship depart) {
        journal.put(depart, new Date());
    }

    // отправить загруженное судно из порта (освободить место под новый корабль)
    public void sendAway(Ship depart) {
        Port.delShip(depart);
    }

    @Override
    public void run() {
        makeEntry(depart);
        sendAway(depart);
        System.out.println("Корабль " + depart.getName() + " успешно покинул порт.\n");
    }
}
