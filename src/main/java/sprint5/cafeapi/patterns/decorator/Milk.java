package sprint5.cafeapi.patterns.decorator;

import sprint5.cafeapi.model.drink.Drink;

public class Milk extends DrinkDecorator {

    //Decorator de Milk
    public Milk(Drink drink) { //Referencia para o drink original
        super(drink);
    }
    @Override
    public String servir() {
        drink.servir();
        drink.servir();
        return "\nAdding 30ml of Milk and " + drink.servir();
    }

    @Override
    public Double getPrice() {
        return drink.getPrice() + 0.50;
    }

    @Override
    public String toString() {
        return "Milk";
    }
}
