package sprint5.cafeapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sprint5.cafeapi.model.custumer.Custumer;

@Repository
public interface CustumerRepository extends MongoRepository<Custumer, String> {
}
