package javalanguage.DesignPattern.Facade;

/**
 * Created by hy on 2015/9/11.
 */
//解决类与类的依赖关系

public class Facade {
    private Cpu cpu;
    private Memory memory;
    private Disk disk;
    public Facade(){
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }
    public void startup(){
        System.out.println("start the computer");
        cpu.startup();
        memory.startup();
        disk.startup();
    }

    public void shutdown(){
        System.out.println("close the computer");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
    }

}
class Cpu{
    public void startup(){
        System.out.println("cpu start!");
    }
    public void shutdown(){
        System.out.println("cpu shutdown!");
    }
}

class Memory{
    public void startup(){
        System.out.println("Memory start!");
    }
    public void shutdown(){
        System.out.println("Memory shutdown!");
    }
}

class Disk{
    public void startup(){
        System.out.println("Disk start!");
    }
    public void shutdown(){
        System.out.println("Disk shutdown!");
    }
}