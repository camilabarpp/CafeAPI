package sprint5.cafeapi.model.paymentMethod;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private String name;
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
