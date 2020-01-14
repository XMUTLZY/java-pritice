package LZY.Day20191125_DesignPattern.StructType.DecoratorPattern;

/**
 * @Title：装饰器模式
 * @Explain: 动态的给对象添加职责
 */
public class Main {
    public static void main(String[] args) {
        Tank tank = new BigTank();
        XraySkill xraySkill = new XraySkill(tank);
        xraySkill.shoot();
    }
}

/**1、实体类接口**/
interface Tank {
    void shoot();
}

/**2、具体实体类**/
class BigTank implements Tank {
    @Override
    public void shoot() {
        System.out.println("biu biu biu");
    }
}

/**3、抽象装饰类**/
class ExtendSkill implements Tank {
    public Tank tank;

    public ExtendSkill(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void shoot() {
        this.tank.shoot();
    }
}

/**4、具体装饰类**/
class XraySkill extends ExtendSkill {
    public XraySkill(Tank tank) {
        super(tank);
    }

    public void shoot() {
        System.out.println("x-ray biu biu biu");
        this.tank.shoot();
    }
}


