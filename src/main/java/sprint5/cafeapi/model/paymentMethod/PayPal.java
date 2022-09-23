package sprint5.cafeapi.model.paymentMethod;

import lombok.Getter;

@Getter
public class PayPal {
    private String email;
    private String password;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
