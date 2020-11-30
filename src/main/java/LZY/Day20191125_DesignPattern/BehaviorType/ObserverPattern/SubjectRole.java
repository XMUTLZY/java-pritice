package LZY.Day20191125_DesignPattern.BehaviorType.ObserverPattern;

/**
 * @author jake.lin
 * @date 2020/11/30
 */
public class SubjectRole extends Subject {
    public void doSomething() {
        super.notifyAllObserver();
    }
}
