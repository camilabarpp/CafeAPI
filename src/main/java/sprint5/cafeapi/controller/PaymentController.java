package sprint5.cafeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint5.cafeapi.model.payment.CreditCard;
import sprint5.cafeapi.model.payment.DebitCard;
import sprint5.cafeapi.model.payment.PayPal;
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
    public String berifyAndPayDebitCard(@RequestBody DebitCard debitCard) {
        return service.payAndVerifyDebitCard(debitCard);
    }

    @GetMapping("/paypal")
    public String berifyAndPayPayPal(@RequestBody PayPal payPal) {
        return service.payAndVerifyPayPal(payPal);
    }
}
