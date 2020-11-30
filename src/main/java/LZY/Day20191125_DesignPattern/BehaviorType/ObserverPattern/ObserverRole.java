package LZY.Day20191125_DesignPattern.BehaviorType.ObserverPattern;

/**
 * @author jake.lin
 * @date 2020/11/30
 */
public class ObserverRole implements Observer {
    @Override
    public void update() {
        System.out.println("update ----");
    }
}
