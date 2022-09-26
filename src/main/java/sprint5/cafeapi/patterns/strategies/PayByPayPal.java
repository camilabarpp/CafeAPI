package sprint5.cafeapi.patterns.strategies;

import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.payment.DebitCard;
import sprint5.cafeapi.model.payment.PayPal;
import sprint5.cafeapi.service.ShoppingCartService;

import java.util.regex.Pattern;

@Service
public class PayByPayPal implements PayStrategy {

    private static final PayPal card = new PayPal
            .Builder("camila@gmail.com","123456")
            .idPayPal("1")
            .nomeTitular("Camila")
            .registrationCompleted();

    private static final PayPal paypalAccount = new PayPal
            .Builder("email@teste.com", "123")
            .registrationCompleted();

    private boolean signedIn;
    private final ShoppingCartService shoppingCartService;

    public PayByPayPal(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public boolean verify(PayPal payPal) {
        setSignedIn(payPal.getEmail().equals(card.getEmail()));
        setSignedIn(payPal.getPassword().matches(card.getPassword()));
            return signedIn;
    }
    @Override
    public String pay(String paymentAmount) {
        if (signedIn == true) {
            if (paymentAmount.startsWith("0,0")) {
                return  "Total amount R$ 0,00" +
                        "\nShopping cart is empty!";
            } else {
                shoppingCartService.deleteShoppingCart();
                return "Data verification has been sucessfull. \n" +"Paying " + paymentAmount + " using PayPal.";
            }
        } else {
            return "Wrong email or password!";
        }
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
