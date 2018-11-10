package sea;

public class OilShip extends Ship {
    private static int count = 0;

    public OilShip(int weight) {
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
    public String toString() {
        return "OilShip{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName("Oiled №" + count);
    }
}
