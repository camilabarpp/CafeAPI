package sprint5.cafeapi.model.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PayPal {
    private String id;
    private String nomeTitular;
    private String email;
    private String password;

    public static class Builder {

        private String id;
        private String nomeTitular;
        private String email;
        private String password;

        public Builder(String id, String nomeTitular, String email, String password) {
            this.id = id;
            this.nomeTitular = nomeTitular;
            this.email = email;
            this.password = password;
        }

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public PayPal registrationCompleted() {
            return new PayPal(id, nomeTitular, email, password);
        }
    }
}
