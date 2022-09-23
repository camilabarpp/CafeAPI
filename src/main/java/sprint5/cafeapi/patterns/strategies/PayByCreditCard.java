package sprint5.cafeapi.patterns.strategies;

import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.paymentMethod.CreditCard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
@Service
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final CreditCard card = new CreditCard("123456", "02/28", "123");
    private String number;
    private String date;
    private String cvv;
    private boolean signedIn;

    @Override
    public String pay(String paymentAmount) {
        if (signedIn) {
            if (paymentAmount.startsWith("0,0")) {
                return  "Total amount R$ 0,00" +
                        "\nShopping cart is empty!";
            } else {
                return "Data verification has been sucessfull. \n" +"Paying " + paymentAmount + " using CreditCard.";
            }
        } else {
            return "Wrong number card, date expiration or cvv!";
        }
    }
    public boolean verify(CreditCard creditCard) {
        setSignedIn(creditCard.getNumber().equals(card.getNumber()));
        setSignedIn(creditCard.getDate().equals(card.getDate()));
        setSignedIn(creditCard.getCvv().equals(card.getCvv()));
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
