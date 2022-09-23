package sprint5.cafeapi.model.paymentMethod;

import lombok.Getter;

@Getter
public class DebitCard {
    private String number;
    private String date;
    private String cvv;

    public DebitCard(String number, String date, String cvv) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }
}
