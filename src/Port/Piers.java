package Port;

import sea.Ship;

public class Piers {
    // здесь рвботают пристани - забирают себе подходящие по типу товара корабли, определяют их макс. вес,
    // загружают товаром и отдают на дальнейшую отправку

    public static void loadOil(Ship current) {
        System.out.println("Loading oil to: " + current.getName()  +"\n");

    }

    public static void loadGold(Ship current) {
        System.out.println("Loading gold to: " + current.getName() +"\n");
    }

    public static void loadWood(Ship current) {
        System.out.println("Loading wood to: " + current.getName() +"\n");
    }
}
