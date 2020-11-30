package LZY.Day20191125_DesignPattern.BehaviorType.ObserverPattern;

/**
 * @author jake.lin
 * @date 2020/11/30
 */
public class Test {
    public static void main(String[] args) {
        SubjectRole subjectRole = new SubjectRole();
        Observer observer = new ObserverRole();
        subjectRole.addObserver(observer);
        subjectRole.doSomething();

    }
}
