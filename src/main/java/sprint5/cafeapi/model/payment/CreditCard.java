package sprint5.cafeapi.model.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditCard {
    private String id;
    private String nomeTitular;
    private String number;
    private String dateExpiration;
    private String cvv;

    public static class Builder {
        private String id;
        private String nomeTitular;
        private String number;
        private String dateExpiration;
        private String cvv;

        public Builder(String number, String dateExpiration, String cvv) {
            this.number = number;
            this.dateExpiration = dateExpiration;
            this.cvv = cvv;
        }

        public Builder idDebitCard(String id) {
            this.id = id;
            return this;
        }

        public Builder nomeTitular(String nomeTitular) {
            this.nomeTitular = nomeTitular;
            return this;
        }

        public CreditCard registrationCompleted() {
            return new CreditCard(id, nomeTitular, number, dateExpiration, cvv);
        }
    }
}
