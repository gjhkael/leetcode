import utils.MyTime;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 本类实现了按行读取文件内容到内存，并打印输出的操作
 */
public class ReadFile implements Runnable{
    public static void main(String []args){
       ExecutorService service = Executors.newFixedThreadPool(30);
        int n = Integer.parseInt(args[1]);
        for(int i=0;i<n;i++) {
            ReadFile file = new ReadFile(args[0]);
            service.execute(file);
        }

        service.shutdown();


       /* System.out.println(MyTime.getStringDate());
        long timeStart = System.currentTimeMillis();
        String filepath ="F:\\ubuntu\\forgithub\\leetcode\\data.txt";
        try {
            readFile(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd-timeStart);
        System.out.println(MyTime.getStringDate());
       */
    }
    /**
     * @param fileName：文件的全路径名
     * @throws java.io.IOException
     */
    public ReadFile(String fileName){
        this.fileName = fileName;
    }

    public static void readFile(String file) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        File f=new File(file);
        BufferedReader br=new BufferedReader(new FileReader(f));
        String line="";
        while ((line = br.readLine()) != null)
        {
            list.add(line);
            //System.out.println(line);
        }
        System.out.println("end add");
        try {
            Thread.sleep(1800000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        br.close();

    }

    public static void writeFile() throws IOException{
        String filepath = System.getProperty("user.dir");
        filepath +="\\data.txt";
        System.out.println(filepath);
        try{
            File file = new File(filepath);
            if(!file.exists()){   //如果不存在data.txt文件则创建
                file.createNewFile();
                System.out.println("data.txt创建完成");
            }
            FileWriter fw = new FileWriter(file);       //创建文件写入
            BufferedWriter bw = new BufferedWriter(fw);

            //产生随机数据，写入文件
            Random random = new Random();
            for(int i=0;i<200000000;i++){
                int randint =(int)Math.floor((random.nextDouble()*100000.0));   //产生0-10000之间随机数
                bw.write(String.valueOf(randint));      //写入一个随机数
                bw.newLine();       //新的一行
            }
            bw.close();
            fw.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fileName;
}