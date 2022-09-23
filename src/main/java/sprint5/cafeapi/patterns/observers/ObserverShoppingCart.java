package sprint5.cafeapi.patterns.observers;

public class ObserverShoppingCart implements Observer {

    public String sendGift() {
        return "Look, I bought your favorite beer!";
    }

    @Override
    public void update(boolean status) {
        if (status) {
            sendGift();
        } else {
        }
    }
}
