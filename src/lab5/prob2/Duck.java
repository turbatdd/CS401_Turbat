package lab5.prob2;

abstract public class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {
        assignFlyBehavior();
        assignQuackBehavior();
    }

    abstract public void display();

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    abstract protected void assignFlyBehavior();

    abstract protected void assignQuackBehavior();

    public void swim() {
        System.out.println("  swimming");
    }

}
