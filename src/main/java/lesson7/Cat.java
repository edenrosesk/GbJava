package lesson7;

public class Cat {
    public static int length;
    public String name;
    public int appetite;
    public boolean full;

    public  Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        full = false;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}
