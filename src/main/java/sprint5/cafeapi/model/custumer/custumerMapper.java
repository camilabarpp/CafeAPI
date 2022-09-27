package sprint5.cafeapi.model.custumer;

import lombok.experimental.UtilityClass;
import sprint5.cafeapi.model.custumer.Custumer.Builder;

@UtilityClass
public class custumerMapper {

    public static Custumer requestPessoa(Builder pessoaRequest) {
        return new Custumer.Builder(
                pessoaRequest.getId(),
                pessoaRequest.getName(),
                pessoaRequest.getBirthdate())
                .withAddress(pessoaRequest.getAddress())
                .build();

    }

/*    public static Builder requestPessoa(Custumer pessoaRequest) {
        return new Builder.(pessoaRequest.getId(),
                pessoaRequest.getName(),
                pessoaRequest.getBirthdate())
                .withAddress(pessoaRequest.getAddress())
                .registrationCompleted();

    }*/
}
