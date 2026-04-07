package lab5.prob2;

public class RubberDuck extends Duck {
    public void assignFlyBehavior() {
        flyBehavior = new CannotFly();
    }

    public void assignQuackBehavior() {
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
