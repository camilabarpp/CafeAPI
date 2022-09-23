package sprint5.cafeapi.patterns.decorator;

import sprint5.cafeapi.model.drink.Drink;

public class DoubleDrink extends DrinkDecorator {

    //Decorator de DoubleDrink
   public DoubleDrink(Drink drink) { //Referecia ao Drink original
       super(drink);
   }
    @Override
    public String servir() {
        drink.servir();
        drink.servir();
        return "\nAdding double of " + drink;
    }

    @Override
    public Double getPrice() {
        return drink.getPrice() * 2.00;
    }
}
