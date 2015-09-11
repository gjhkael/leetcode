package javalanguage.DesignPattern.Composite;

/**
 * Created by hy on 2015/9/11.
 */
import java.util.ArrayList;

interface Node{
    public void copy(); //定义统一的接口：复制
}

class Folder implements Node{
    private String folderName;
    private ArrayList nodeList =new ArrayList(); //用于存储文件夹下的文件夹或文件的信息

    public Folder(String folderName){
        this.folderName = folderName;
    }

    public void add(Node node){ //增加文件或文件夹
        nodeList.add(node);
    }

    public void copy(){  //文件夹复制操作实现递归
        System.out.println("复制文件夹：" + folderName);
        for(int i=0;i<nodeList.size();i++) {
            Node node = (Node) nodeList.get(i);
            node.copy();
        }
    }
}

class File implements Node{
    private String fileName;

    public File(String fileName){
        this.fileName = fileName;
    }

    public void copy(){
        System.out.println("复制文件：" + fileName);
    }
}

public class Composite{
    public static void main(String[] args){
        Folder document = new Folder("我的资料"); //我的资料文件夹
        File book = new File("Java编程思想.pdf");  //文档文件
        Folder music = new Folder("我的音乐");   //我的音乐文件夹
        File music1 = new File("你是我的眼.mp3");   //音乐文件1
        File music2 = new File("Without You.mp3");  //音乐文件2
        //确定树形结构关系
        document.add(book);
        document.add(music);
        music.add(music1);
        music.add(music2);

        document.copy(); //复制“我的资料”文件夹，递归地复制了其下所有文件夹和文件。
    }
}