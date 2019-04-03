package test1.generic;

public class Sheep extends Animal {
    public Sheep(String name, Integer weight) {
        super(name, weight);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Integer getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(Integer weight) {
        super.setWeight(weight);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
