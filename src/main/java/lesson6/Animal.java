package lesson6;

public abstract class Animal {
    public final String name;
    private final int distanceRunLimit;
    private final int distanceSwimLimit;


    protected Animal(String name, int distanceRunLimit, int distanceSwimLimit) {
        this.name = name;
        this.distanceRunLimit = distanceRunLimit;
        this.distanceSwimLimit = distanceSwimLimit;

    }


    public void run(int distanceRun) {
        if (distanceRunLimit == 0) {
            System.out.printf("%s не умеет бегать%n", name);
        }
        else if (distanceRun > distanceRunLimit) {
            System.out.printf("%s пробежал %s метров из %s%n", name, distanceRunLimit, distanceRun);
        }
        else {
            System.out.printf("%s пробежал %s метров%n", name, distanceRun);
        }
    }

    public void swim(int distanceSwim) {
        if (distanceSwimLimit == 0) {
            System.out.printf("%s не умеет плавать%n", name);
        }
        else if (distanceSwim > distanceSwimLimit) {
            System.out.printf("%s проплыл %s метров из %s%n", name, distanceSwimLimit, distanceSwim);
        }
        else {
            System.out.printf("%s проплыл %s метров%n", name, distanceSwim);
        }
    }

}
