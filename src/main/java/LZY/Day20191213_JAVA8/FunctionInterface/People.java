package LZY.Day20191213_JAVA8.FunctionInterface;

/**
 * 声明为这是一个函数式接口
 * @Define: 函数式接口就是有且仅有一个抽象方法，可以包含多个非抽象方法(使用default或static修饰),函数式接口可以被隐式转换为Lambda表达式
 */
@FunctionalInterface
public interface People {
   void say(String name);
   default void eat() {
      System.out.println("People eat");
   }
}

/**
 * 普通接口声明
 */
interface Person {
   void say(String name);
   void go(String name);
   default void eat() {
      System.out.println("Person eat");
   }
   default void run() {
      System.out.println("Person run");
   }
}

class Test {
   public static void main(String[] args) {
      //1、 函数式接口声明
      People people = name -> System.out.println(name + " say");
      people.say("lin");
      people.eat();
      //2、 普通接口声明(使用匿名类声明) 因为不是函数式接口，可以有多个抽象方法(注意：当只有一个抽象方法时，声明可以使用Lambda表达式)
      Person person = new Person() {
         @Override
         public void say(String name) {
            System.out.println(name + " say");
         }

         @Override
         public void go(String name) {
            System.out.println(name + " go");
         }
      };
      person.say("lin");
      person.go("lin");
   }
}

/**
 * 当一个类实现了两个接口，如果两个接口中有相同的抽象和非抽象方法，子类需要重写这些方法
 */
class Boy implements People, Person {
   @Override
   public void say(String name) {

   }

   @Override
   public void go(String name) {

   }

   @Override
   public void eat() {

   }
}
