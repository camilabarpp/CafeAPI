package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCartService {
    public List<Double> items;

    public String shoppingCart(Double item)
    {
        items.add(item);
        return String.valueOf(items.stream()
                .reduce(Double::sum).
                orElse(0d));
    }

    public String calculateShoppingCart() {
        return String.valueOf(calculateShoppingCart(0d));
    }

    public String calculateShoppingCart(Double item)
    {
        if (items.isEmpty()) {
            return "0,00" +
                   "\nShopping cart is empty!";
        } else {
            String.valueOf(items.get(0));
            return String.valueOf(items.stream()
                    .reduce(Double::sum).
                    orElse(0d));
        }
    }
}
        .






