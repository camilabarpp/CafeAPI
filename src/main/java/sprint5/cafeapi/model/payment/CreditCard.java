package sprint5.cafeapi.model.payment;

import lombok.Getter;

@Getter
public class CreditCard {
    private String number;
    private String date;
    private String cvv;

    public CreditCard(String number, String date, String cvv) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }
}
