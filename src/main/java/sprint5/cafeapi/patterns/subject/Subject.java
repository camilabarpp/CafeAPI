package sprint5.cafeapi.patterns.subject;

import sprint5.cafeapi.patterns.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void notifyobservers(boolean status) {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
