package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.paymentMethod.CreditCard;
import sprint5.cafeapi.model.paymentMethod.DebitCard;
import sprint5.cafeapi.model.paymentMethod.PayPal;
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
        return payByCreditCard.pay(shoppingCartService.showShoppingCart())
            + shoppingCartService.deleteShoppingCart();
    }

    public boolean verifyCreditCard(CreditCard creditCard) {
        return payByCreditCard.verify(creditCard);
    }

    public String payAndVerifyDebitCard(DebitCard debitCard, String payAmount) {
        payByDebitCard.verify(debitCard);
        return payByDebitCard.pay(payAmount);
    }

    public String payAndVerifyPayPal(PayPal payPal, String payAmount) {
        payByPayPal.verify(payPal);
        return payByPayPal.pay(payAmount);
    }
}
