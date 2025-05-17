package src.main.java.design.decoratorpattern;

public class Main {

    public static void main(String[] args) {
            BasePizza basePizza = new Margherita();
            basePizza = new ExtraCheese(basePizza);
            basePizza = new Mushroom(basePizza);

            System.out.println(basePizza.cost());
    }
}
