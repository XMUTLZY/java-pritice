package LZY.Day20191101_HashMap.Clonable;

/**
 * cloneAble 学习
 */
public class CloneAble {
    public static void main(String[] args) throws CloneNotSupportedException {
        Food food = new Food("狗粮");
        Dog dog = new Dog("小白", 1, food);

        Dog object = (Dog) dog.clone();
        Food food1 = (Food) object.getFood().clone();
        food1.setName("猫粮");
        object.setFood(food1);

        System.out.println(dog.toString());
        System.out.println(object.toString());
    }
}
