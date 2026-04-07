package lab5.prob2;

public class DecoyDuck extends Duck {
    public void assignFlyBehavior() {
        flyBehavior = new CannotFly();
    }

    public void assignQuackBehavior() {
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
