package sprint5.cafeapi.patterns.subject;

public class Doorman extends Subject {

    private boolean status = false;
    public void setStatus(boolean newStatus) {
        this.status = newStatus;
        notifyobservers(newStatus);
    }
}
