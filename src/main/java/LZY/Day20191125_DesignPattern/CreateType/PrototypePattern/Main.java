package LZY.Day20191125_DesignPattern.CreateType.PrototypePattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title： 原型模式
 * @Explain: 当一个对象被多次创建时，我们可以缓存这个对象实例，当再次需要使用到该对象时，调用clone()方法完成对象复制
 * 在这里我使用hashmap缓存已实例化的对象
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        VehicleUtils.initDate();
        Vehicle vehicle1 = VehicleUtils.getVehicleByName("daZhong");
        Vehicle vehicle2 = VehicleUtils.getVehicleByName("fengTian");
        System.out.println(vehicle1.toString());
        System.out.println(vehicle2.toString());
    }
}
class Vehicle implements Cloneable{/**原型角色  实现Cloneable接口**/
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class DaZhong extends Vehicle {
    public DaZhong(String name) {
        super(name);
    }
}

class FengTian extends Vehicle {
    public FengTian(String name) {
        super(name);
    }
}

class VehicleUtils {
    private static Map<String, Vehicle> map = new HashMap<>();
    public static void initDate() {
        /**
         * 初始化数据
         */
        DaZhong daZhong = new DaZhong("daZhong");
        FengTian fengTian = new FengTian("fengTian");
        map.put("daZhong", daZhong);
        map.put("fengTian", fengTian);
    }
    public static Vehicle getVehicleByName(String name) throws CloneNotSupportedException {/**提供一个获取新实例的方法**/
        /**
         * 原型模式的核心就是调用clone()方法
         */
        Vehicle vehicle = map.get(name);/**提供一个找出正确实例原型的方法**/
        return (Vehicle) vehicle.clone();/**委托复制实例的方法生成新实例**/
    }
}
