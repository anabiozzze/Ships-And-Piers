package sea;

public class GoldShip extends Ship {
    private static int count = 0;

    public GoldShip(int weight) {
        super(weight);
        count++;
        setName("");
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName("Golden №" + count);
    }

    @Override
    public String toString() {
        return "GoldShip{" +
                "weight=" + weight +
                '}';
    }
}
