package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.paymentMethod.CreditCard;
import sprint5.cafeapi.model.paymentMethod.DebitCard;
import sprint5.cafeapi.model.paymentMethod.PayPal;
import sprint5.cafeapi.patterns.strategies.PayByCreditCard;
import sprint5.cafeapi.patterns.strategies.PayByDebitCard;
import sprint5.cafeapi.patterns.strategies.PayByPayPal;
import sprint5.cafeapi.patterns.strategies.PayStrategy;

@Service
public class PaymentService {

    private PayByCreditCard payByCreditCard;
    private PayByDebitCard payByDebitCard;
    private PayByPayPal payByPayPal;

    public PaymentService(PayByCreditCard payByCreditCard, PayByDebitCard payByDebitCard, PayByPayPal payByPayPal) {
        this.payByCreditCard = payByCreditCard;
        this.payByDebitCard = payByDebitCard;
        this.payByPayPal = payByPayPal;
    }

    private PayStrategy strategy;


    public String payAndVerifyCreditCard2(String payAmount) {
        strategy = new PayByCreditCard();
        return payByCreditCard.pay(payAmount);
    }

    public String payAndVerifyCreditCard(CreditCard creditCard, String payAmount) {
        payByCreditCard.verify(creditCard);
        return payByCreditCard.pay(payAmount);
    }

    public boolean verifyCreditCard(CreditCard creditCard) { //está verificando os dados do cartão corretamente
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
