package javalanguage.DesignPattern.factoryPattern;

/**
 * Created by hy on 2015/9/10.
 */
public class AbstractFactory {
    public static void main(String[] args){
        IntelFactory intelFactory =new IntelFactory();
        Cpu cpu = intelFactory.createCpu();
        cpu.calculate();
    }
}

interface Cpu {
    public void calculate();
}
class IntelCpu implements Cpu{
    private int pins =0;
    public IntelCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("Intel cpu的针脚数：" + pins);
    }
}

class AmdCpu implements Cpu{
    private int pins =0;
    public AmdCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        System.out.println("AMD cpu的针脚数："+pins);
    }
}

interface MainBoard{
    public void installCPU();
}

class IntelMainBoard implements MainBoard{
    private int cpuHoles =0;
    public IntelMainBoard(int cpuHoles){
        this.cpuHoles=cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("Intel 主板的cpu插槽孔数："+cpuHoles);
    }
}

class AMDMainBoard implements MainBoard{
    private int cpuHoles =0;
    public AMDMainBoard(int cpuHoles){
        this.cpuHoles=cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("AMD 主板的cpu插槽孔数："+cpuHoles);
    }
}

interface AbstractFactorys{
    public Cpu createCpu();
    public MainBoard createMainboard();
}

class IntelFactory implements AbstractFactorys{

    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public MainBoard createMainboard() {
        return new IntelMainBoard(755);
    }
}

class AmdFactory implements AbstractFactorys{

    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public MainBoard createMainboard() {
        return new AMDMainBoard(938);
    }
}