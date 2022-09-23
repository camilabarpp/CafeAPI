package sprint5.cafeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint5.cafeapi.service.ShoppingCartService;

@RestController
@RequestMapping("shoppingCart/")
@AllArgsConstructor
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping
    public String showShoppingCart() {
        return "Total amount: R$ " + shoppingCartService.showShoppingCart();
    }

    @DeleteMapping
    public String deleteShoppingCart() {
        return "Total amount: R$ " + shoppingCartService.deleteShoppingCart();
    }
}
