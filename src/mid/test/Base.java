package mid.test;

public class Base extends Extension{
    public static void main(String[] args){
        Extension e = new Extension();
        e.print();
    }

    public void print(){
        System.out.println("Print Base");
    }


}
