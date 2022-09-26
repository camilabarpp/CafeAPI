package sprint5.cafeapi.model.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sprint5.cafeapi.model.drink.Tea;

@Getter @Setter @ToString
public class Order {
    private Tea tea;
    private String totalCost;
    private boolean isClosed = false;
    public String setTotalCost (String cost) {
        this.totalCost += cost;
        return cost;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
