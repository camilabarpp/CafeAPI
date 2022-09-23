package sprint5.cafeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint5.cafeapi.model.paymentMethod.CreditCard;
import sprint5.cafeapi.model.paymentMethod.DebitCard;
import sprint5.cafeapi.model.paymentMethod.PayPal;
import sprint5.cafeapi.service.PaymentService;

@RestController
@RequestMapping("payment")
@AllArgsConstructor
public class PaymentController {

    private PaymentService service;

    @GetMapping("/credito")
    public String verifyAndPayCreditCard(@RequestBody CreditCard creditCard) {
        return service.payAndVerifyCreditCard(creditCard);
    }

    @GetMapping("/debito")
    public String berifyAndPayDebitCard(@RequestBody DebitCard debitCard, String amout) {
        return service.payAndVerifyDebitCard(debitCard, amout);
    }

    @GetMapping("/paypal")
    public String berifyAndPayPayPal(@RequestBody PayPal payPal, String amout) {
        return service.payAndVerifyPayPal(payPal, amout);
    }
}
