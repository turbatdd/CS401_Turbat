package lab5.prob2;

public class MallardDuck extends Duck {
    public void assignFlyBehavior() {
        flyBehavior = new FlyWithWings();
    }

    public void assignQuackBehavior() {
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("  display");
    }
}
