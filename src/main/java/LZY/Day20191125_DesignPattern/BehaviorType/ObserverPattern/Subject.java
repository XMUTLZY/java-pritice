package LZY.Day20191125_DesignPattern.BehaviorType.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jake.lin
 * @date 2020/11/30
 */
public class Subject {
    private List<Observer> observerList = new ArrayList<>(16);

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void notifyAllObserver() {
        observerList.forEach(Observer::update);
    }

}
