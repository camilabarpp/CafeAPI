package sprint5.cafeapi.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
}
