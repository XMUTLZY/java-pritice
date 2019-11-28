package LZY.Day20191125_DesignPattern.CreateType.FactoryPattern;

import org.springframework.util.StringUtils;

/**
 * @Title:工厂方法模式  抽象工厂方法模式，这里具体不介绍，实际上就是传入不同参数，获取到不同的工厂类
 */
public class Main {
    public static void main(String[] args) {
        AoDi aoDi = (AoDi) CreatedByTypeFactory.createdByType("AoDi");
        BenChi benChi = (BenChi) CreatedByTypeFactory.createdByType("BenChi");
    }
}

interface Car {
    void print();
}

class AoDi implements Car {
    @Override
    public void print() {
        System.out.println(getClass() + " has been created");
    }
}

class BenChi implements Car {
    @Override
    public void print() {
        System.out.println(getClass() + " has been created");
    }
}

/**
 * 创建工厂类
 */
class CreatedByTypeFactory {
    public static Car createdByType(String carType) {
        if (!StringUtils.hasText(carType)) {
            return null;
        }
        if ("AoDi".equals(carType)) {
            return new AoDi();
        }
        if ("BenChi".equals(carType)) {
            return new BenChi();
        }
        return null;
    }
}