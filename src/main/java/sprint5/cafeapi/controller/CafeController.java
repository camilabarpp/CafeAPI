package sprint5.cafeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sprint5.cafeapi.service.CafeService;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/menu")
@AllArgsConstructor
public class CafeController {
    private CafeService service;

    @GetMapping()
    public String menu() {
        return service.menu();
    }

/*    @GetMapping("/shoppingCart")
    public String test() {
        return "Shopping Cart List \n" +
                service.getNomes();
    }*/
    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public String deleteShoppingCart() {
        return "Total amount: R$ " + deleteShoppingCart();
    }

    @GetMapping("/1")
    public String test1() {
        return service.menu() +
            service.test1();
    }

    @GetMapping("/2")
    public String test2() {
        return service.menu() +
               service.test2();
    }

    @GetMapping("/3")
    public String test3() {
        return service.menu() +
               service.test3();
    }

    @GetMapping("/4")
    public String test4() {
        return service.menu() +
               service.test4();
    }

    @GetMapping("/5")
    public String test5() {
        return service.menu() +
               service.test5();
    }

    @GetMapping("/6")
    public String test6() {
        return service.menu() +
               service.test6();
    }
}
