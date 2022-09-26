package sprint5.cafeapi.patterns.strategies;

import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.payment.CreditCard;
import sprint5.cafeapi.service.ShoppingCartService;
@Service
public class PayByCreditCard implements PayStrategy {
    private static final CreditCard card = new CreditCard
            .Builder("123456", "02/28", "123")
            .idDebitCard("1")
            .nomeTitular("Camila")
            .registrationCompleted();
    private boolean signedIn;
    private final ShoppingCartService shoppingCartService;

    public PayByCreditCard(ShoppingCartService shoppingCartService) {
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
                return "Data verification has been sucessfull. \n" +"Paying " + paymentAmount + " using CreditCard.";
            }
        } else {
            return "Wrong number card, date expiration or cvv!";
        }
    }
    public boolean verify(CreditCard creditCard) {
        setSignedIn(creditCard.getNumber().equals(card.getNumber()));
        setSignedIn(creditCard.getDateExpiration().equals(card.getDateExpiration()));
        setSignedIn(creditCard.getCvv().equals(card.getCvv()));
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
