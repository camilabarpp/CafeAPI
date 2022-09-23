package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCartService {
    List<Double> items;

    public String shoppingCart(Double item)
    {
        items.add(item);
        return String.valueOf(items.stream()
                .reduce(Double::sum).
                orElse(0d));
    }

    public String showShoppingCart()
    {
        if (items.isEmpty()) {
            return "0,00" +
                   "\nShopping cart is empty!";
        } else {
            return String.valueOf(items.stream()
                    .reduce(Double::sum).
                    orElse(0d));
        }
    }

    public String deleteShoppingCart() {
        if (!items.isEmpty()) {
            items.clear();
        }
        return "0,00" +
           "\nShopping cart is empty!";
    }
}







