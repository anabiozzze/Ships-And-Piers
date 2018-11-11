import Port.Customs;
import Port.Sender;
import sea.Constructor;

public class Main {

    public static Constructor constructor = new Constructor();
    public static Customs customs = new Customs();

    public static void main(String[] args) {
        // запускам производство кораблей (трех разных типов) на полминуты и начинаем работу таможни
        // по истечении времени производство кораблей останавливается, а таможня острается открытой,
        // пока в море есть не принятые корабли

        // все этапы жизни судна выводятся в консоль

        constructor.start();
        customs.start();

        try {
            Thread.currentThread().sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // прекращаем производство кораблей
        constructor.setNeed(false);


        // когда таможня и порт закончат работу - запросим у порта журнал отправки загруженных судов
        while (true) {
            if (!customs.isAlive()) {
                Sender.showJournal();
                break;
            }
        }

    }
}
