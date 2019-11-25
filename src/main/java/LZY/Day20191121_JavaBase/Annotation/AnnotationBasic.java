package LZY.Day20191121_JavaBase.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @自定义注解使用
 * @Tips: 在这里我只举了一个简单例子，说明了自定义注解的使用方式，具体需求肯定不是这么简单  自定义注解常被用于权限控制、登录校验和日志等功能，具体实现可以百度
 */
public class AnnotationBasic {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(AnnotationUtils.getInfo(Class.forName("LZY.Day20191121_JavaBase.Annotation.Student")));/**反射获取Class对象**/
    }
}

/**
 * @注解的声明
 * @Params： @Target：说明了该注解所修饰的作用范围，点开源代码可以看到长度为8的枚举类型变量
 * @Params： @Retention：定义被保留时间的长短，用于描述注解的生命周期，指定参数如果为RetentionPolicy.RUNTIME 表示标记的注释由jvm保留，因此运行环境可以使用它
 * 即可以使用反射机制
 * @Parmas： @Document:注解文档化
 * @Params： @Inherited：被该注解标注的类型，其子类也会被标注
 * @Params： @Repeatable：在java8中引入，表示可以重复标注某一个类、属性或方法等
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Name {
    String value() default "";
}

/**
 * @声明一个学生类
 */
class Student {
    @Name(value = "lzy")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * @测试工具类，获取Student对象的属性值
 */
class AnnotationUtils {
    static String getInfo(Class c) {
        Field[] fields = c.getDeclaredFields();/**获取所有成员变量**/
        String result = "";
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {/**判断该成员变量是否含有Name注解**/
                Name name = field.getAnnotation(Name.class);/**获取该成员变量上的注解**/
                String value = name.value();
                result = result + value;
            }
        }
        return result;
    }
}
