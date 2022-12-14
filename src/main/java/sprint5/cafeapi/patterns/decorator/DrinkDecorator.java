package sprint5.cafeapi.patterns.decorator;

import sprint5.cafeapi.model.drink.Drink;

public abstract class DrinkDecorator implements Drink {

    //Apartir dessa composição, nós vamos conseguir adcionar novas funcionalidades
    //e ainda respeitar a ‘interface’ Drink
    protected Drink drink;

    protected DrinkDecorator(Drink drink) {
        this.drink = drink;
    }
}
