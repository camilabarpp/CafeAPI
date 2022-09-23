package sprint5.cafeapi.patterns.strategies;

import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.payment.PayPal;
import sprint5.cafeapi.service.ShoppingCartService;
@Service
public class PayByPayPal implements PayStrategy {

    private static final PayPal card = new PayPal
            .Builder("camila@gmail.com","123456")
            .registrationCompleted();

    private boolean signedIn;
    private final ShoppingCartService shoppingCartService;

    public PayByPayPal(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public boolean verify(PayPal payPal) {
        setSignedIn(payPal.getPassword().equals(card.getPassword()));
        setSignedIn(payPal.getEmail().equals(card.getEmail()));
        return signedIn;
    }
    @Override
    public String pay(String paymentAmount) {
        if (signedIn) {
            if (paymentAmount.startsWith("0,0")) {
                return  "Total amount R$ 0,00" +
                        "\nShopping cart is empty!";
            } else {
                shoppingCartService.deleteShoppingCart();
                return "Data verification has been sucessfull. \n" +"Paying " + paymentAmount + " using PayPal.";
            }
        } else {
            return "Wrong number card, date expiration or cvv!";
        }
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
