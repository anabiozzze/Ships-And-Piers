import Port.Customs;
import sea.Constructor;

public class Main {

    public static Constructor constructor = new Constructor();
    public static Customs customs = new Customs();

    public static void main(String[] args) {

        constructor.start();
        customs.start();


    }
}
