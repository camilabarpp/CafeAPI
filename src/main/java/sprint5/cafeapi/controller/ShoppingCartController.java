package sprint5.cafeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sprint5.cafeapi.service.ShoppingCartService;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("shoppingCart/")
@AllArgsConstructor
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping
    public String showShoppingCart() {
        return "Total amount: R$ " + shoppingCartService.showShoppingCart() +
                "\n" + shoppingCartService.getNomes();
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteShoppingCart() {
        shoppingCartService.deleteShoppingCart();
    }

}
