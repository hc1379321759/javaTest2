package test1.generic;

public class Test {
    public static void main(String[] args) {
        Animal p1 = new Pig("pig1",210);
        Animal p2 = new Pig("pig2",240);
        Animal p3 = new Pig("pig3",190);
        Animal c1 = new Cow("Cow1",250);
        Animal c2 = new Cow("Cow2",220);
        Animal c3 = new Cow("Cow3",230);
        Animal s1 = new Sheep("Sheep1",150);
        Animal s2 = new Sheep("Sheep2",170);
        Animal s3 = new Sheep("Sheep3",205);

        GenericBubbleSorter<Animal> gbs = new GenericBubbleSorter<>();

        gbs.add(p1);
        gbs.add(p2);
        gbs.add(p3);
        gbs.add(c1);
        gbs.add(c2);
        gbs.add(c3);
        gbs.add(s1);
        gbs.add(s2);
        gbs.add(s3);

        System.out.println("---排序前---");
        gbs.printT();

        gbs.sort();

        System.out.println("--排序后--");
        gbs.printT();
    }
}
