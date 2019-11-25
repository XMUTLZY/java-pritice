package LZY.Day20191121_JavaBase.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title:反射机制基础知识
 * @Definition:在运行状态中，对于任意一个类都能够知道这个类所有的属性和方法；并且对于任意一个对象，都能够调用它的任意一个方法；
 * @这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制
 *
 *
 * @Java反射Api
 * Class类：反射的核心类，可以获取类的属性、方法等信息
 * Field类：java.lang.reflect包中的类，表示类的成员变量，可以用来获取和设置类之中的属性值
 * Method类：java.lang.reflect包中的类，表示类的方法，可以用来获取类中的方法信息或者执行方法
 * Constructor：java.lang.reflect包中的类，表示类的构造方法
 */
public class ReflectBasic {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Student student = new Student(1, "lzy");
        /**
         * @获取Class对象的三种方式
         */
        Class aClass1 = student.getClass(); /**1、调用已有对象的getClass()方法*/
        Class aClass2 = Student.class;/**2、调用某个类的class属性*/
        Class aClass3 = Class.forName("LZY.Day20191121_JavaBase.Reflect.Student");/**3、使用Class类中的forName()方法 推荐！！！*/
        /**
         * @获取到Class对象后，可以使用Java反射api获取成员变量、方法和构造方法
         */
        Method[] methods = aClass3.getDeclaredMethods();/**获取该类的所有方法*/
        Field[] fields = aClass3.getDeclaredFields();/**获取该类的所有成员属性*/
        Constructor[] constructors = aClass3.getConstructors();/**获取该类的所有构造方法信息*/
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        /**
         * @创建实例化对象的两种方式
         */
        Student student1 = (Student) aClass3.newInstance();/**1、使用Class对象的newInstance()方法，前提：Student类中必须有无参构造方法*/
        student1.setNumber(1);
        student1.setName("lzy");
        Constructor constructor = aClass3.getDeclaredConstructor(Integer.class, String.class);/**2、先获取构造方法，再创建对象*/
        Student student2 = (Student) constructor.newInstance(2, "ly");
        System.out.println(student1.toString());
        System.out.println(student2.toString());
    }
}
class Student {
    public Integer number;
    public String name;

    public Student() {

    }

    public Student(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
