package sprint5.cafeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint5.cafeapi.model.custumer.Custumer;
import sprint5.cafeapi.model.custumer.Custumer.Builder;
import sprint5.cafeapi.service.CustumerService;

import java.util.List;

import static sprint5.cafeapi.model.custumer.custumerMapper.requestPessoa;

@AllArgsConstructor
@RestController
@RequestMapping("/custumer")
public class CustumerController {

    private CustumerService service;

/*    @GetMapping
    public List<Builder> getAllCustumers() {
        return service.getAllCustumers();
    }*/

    @PostMapping
    public Custumer createACustumer(Custumer custumer) {
        return service.createACustumer(custumer);
    }
}
