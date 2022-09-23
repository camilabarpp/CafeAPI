package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.drink.Drink;
import sprint5.cafeapi.model.paymentMethod.CreditCard;

@Service
@AllArgsConstructor
public class ServiceTest {

    private CafeService cafeService;
    private PaymentService paymentService;

    public String test(CreditCard creditCard) {
        //cafeService.order(nome, drink);
        return String.valueOf(paymentService.verifyCreditCard(creditCard));
    }
}
