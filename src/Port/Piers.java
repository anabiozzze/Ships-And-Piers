package Port;

import sea.Ship;

public class Piers {
    // здесь рвботают пристани - забирают себе подходящие по типу товара корабли, определяют их макс. вес,
    // загружают товаром и отдают на дальнейшую отправку

    private static Sender sender;

    public static void loadOil(Ship current) {
        System.out.println("Loading oil to: " + current.getName()  +"\n");
        loadWait(current);
        sender = new Sender(current);
        sender.run();
    }

    public static void loadGold(Ship current) {
        System.out.println("Loading gold to: " + current.getName()  +"\n");
        loadWait(current);
        sender = new Sender(current);
        sender.run();
    }

    public static void loadWood(Ship current) {
        System.out.println("Loading wood to: " + current.getName()  +"\n");
        loadWait(current);
        sender = new Sender(current);
        sender.run();
    }

    private static void loadWait(Ship current) {
        try {
            switch (current.getWeight()) {
                case 10 : Thread.sleep(10*100); break;
                case 30 : Thread.sleep(30*100); break;
                case 50 : Thread.sleep(50*100); break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
