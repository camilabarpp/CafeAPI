package sprint5.cafeapi.model.custumer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sprint5.cafeapi.model.Address.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Custumer {
    @Id
    private String id;
    private String name;
    private String birthdate;
    private Address address;

    public Custumer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.birthdate = builder.birthdate;
        this.address = builder.address;
    }

    @Getter
    @Setter
    public static class Builder {
        private String id;
        private String name;
        private String birthdate;
        private Address address;

        public Builder(String id, String name, String birthdate) {
            this.id = id;
            this.name = name;
            this.birthdate = birthdate;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Custumer build(){
            return new Custumer(this);
        }
    }
}
