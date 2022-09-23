package sprint5.cafeapi.patterns.strategies;

import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.payment.DebitCard;
import sprint5.cafeapi.service.ShoppingCartService;

@Service
public class PayByDebitCard implements PayStrategy {
    private static final DebitCard card = new DebitCard("123456", "02/28", "123");
    private String number;
    private String date;
    private String cvv;
    private boolean signedIn;

    private ShoppingCartService shoppingCartService;

    public PayByDebitCard(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public String pay(String paymentAmount) {
        if (signedIn) {
            if (paymentAmount.startsWith("0,0")) {
                return  "Total amount R$ 0,00" +
                        "\nShopping cart is empty!";
            } else {
                shoppingCartService.deleteShoppingCart();
                return "Data verification has been sucessfull. \n" +"Paying " + paymentAmount + " using DebitCard.";
            }
        } else {
            return "Wrong number card, date expiration or cvv!";
        }
    }

    public boolean verify(DebitCard debitCard) {
        setSignedIn(debitCard.getNumber().equals(card.getNumber()));
        setSignedIn(debitCard.getDate().equals(card.getDate()));
        setSignedIn(debitCard.getCvv().equals(card.getCvv()));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
