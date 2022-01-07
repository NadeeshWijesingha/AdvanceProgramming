import java.util.ArrayList;
import java.util.List;

public class ObserverSubject {
    private final List<ObserverAbstract> observers = new ArrayList<ObserverAbstract>();

    public void attach(ObserverAbstract observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (ObserverAbstract observer : observers) {
            observer.displayFrame();
        }
    }
}
