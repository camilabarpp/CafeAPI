package sprint5.cafeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sprint5.cafeapi.model.custumer.Custumer;
import sprint5.cafeapi.model.custumer.Custumer.Builder;
import sprint5.cafeapi.repository.CustumerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CustumerService {

    private CustumerRepository repository;

    public List<Custumer> getAllCustumers() {
        return repository.findAll();
    }

    public Custumer createACustumer(Custumer custumer) {
        return repository.save(custumer);
    }
}
