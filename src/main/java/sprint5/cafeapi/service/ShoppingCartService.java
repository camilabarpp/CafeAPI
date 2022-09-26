package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

@Service
@AllArgsConstructor
public class ShoppingCartService {
    List<Double> items;
    List<String> nomes;

    public void add(String name) {
        nomes.add(0, String.valueOf(name));
    }

    public List<String> getNomes() {
        return nomes;
    }


    public String getPrice(Double item)
    {
        items.add(item);
        return String.valueOf(items.stream()
                .reduce(Double::sum).
                orElse(0d));
    }

    public String showShoppingCart()
    {
        if (items.isEmpty()) {
            return   "0,00" +
                   "\nShopping cart is empty!";
        } else {
            return String.valueOf(items.stream()
                   .reduce(Double::sum).
                    orElse(0d));
        }
    }

    public String deleteShoppingCart() {
        if (!items.isEmpty()) {
            nomes.clear();
            items.clear();
        }
        return "";
    }
}







