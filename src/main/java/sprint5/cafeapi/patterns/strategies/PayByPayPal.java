package sprint5.cafeapi.patterns.strategies;

import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.paymentMethod.PayPal;

import java.util.HashMap;
import java.util.Map;
@Service
public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private static final PayPal card = new PayPal("camila@gmail.com","123456");

    private boolean signedIn;

    static {
        DATA_BASE.put("123456", "camila@gmail.com");
        DATA_BASE.put("1234567", "gabriel@gmail.com");
    }

    public boolean verify(PayPal payPal) {
        setSignedIn(payPal.getEmail().equals(card.getEmail()));
        setSignedIn(payPal.getPassword().equals(card.getPassword()));
        return signedIn;
    }
    @Override
    public String pay(String paymentAmount) {
        if (signedIn) {
        return "Data verification has been sucessfull. \n" + "Paying " + paymentAmount + " using PayPal.";
        } else {
            return "Wrong password or email!";
        }
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
