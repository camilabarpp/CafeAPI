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

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public Builder idPayPal(String id) {
            this.id = id;
            return this;
        }

        public Builder nomeTitular(String nomeTitular) {
            this.nomeTitular = nomeTitular;
            return this;
        }

        public PayPal registrationCompleted() {
            return new PayPal(id, nomeTitular, email, password);
        }
    }
}
