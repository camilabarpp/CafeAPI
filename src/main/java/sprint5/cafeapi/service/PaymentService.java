package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.payment.CreditCard;
import sprint5.cafeapi.model.payment.DebitCard;
import sprint5.cafeapi.model.payment.PayPal;
import sprint5.cafeapi.patterns.strategies.PayByCreditCard;
import sprint5.cafeapi.patterns.strategies.PayByDebitCard;
import sprint5.cafeapi.patterns.strategies.PayByPayPal;

@Service
@AllArgsConstructor
public class PaymentService {
    private ShoppingCartService shoppingCartService;
    private PayByCreditCard payByCreditCard;
    private PayByDebitCard payByDebitCard;
    private PayByPayPal payByPayPal;

    public String payAndVerifyCreditCard(CreditCard creditCard) {
        payByCreditCard.verify(creditCard);
        return payByCreditCard.pay(shoppingCartService.showShoppingCart());
    }
    public String payAndVerifyDebitCard(DebitCard debitCard) {
        payByDebitCard.verify(debitCard);
        return payByDebitCard.pay(shoppingCartService.showShoppingCart());
    }

    public String payAndVerifyPayPal(PayPal payPal) {
        payByPayPal.verify(payPal);
        return payByPayPal.pay(shoppingCartService.showShoppingCart());
    }
}
