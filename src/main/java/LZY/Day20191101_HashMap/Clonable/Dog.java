package LZY.Day20191101_HashMap.Clonable;

/**
 * Dog对象
 */
public class Dog implements Cloneable {/*Cloneable接口可以理解为一个标记接口，它没有定义方法*/
    /*
    * 如果不实现Cloneable接口，在使用该对象的clone()方法时，会抛出CloneNotSupportedException 异常
    * 当对象的成员变量不含有其他成员变量时，调用clone方法为浅拷贝
    * 否则为深拷贝，在复制对象时，起成员变量对象也需要实现Cloneable接口
    * */
    private String name;
    private Integer age;
    private Food food;

    public Dog(String name, Integer age, Food food) {
        this.name = name;
        this.age = age;
        this.food = food;
    }

    public void action() {
        System.out.println(this.name + " say: wang wang wang!eat:" + food.getName());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", food=" + food.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
