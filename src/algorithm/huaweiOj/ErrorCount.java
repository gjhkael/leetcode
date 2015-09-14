package algorithm.huaweiOj;
import java.util.Scanner;
import java.util.ArrayList;

public class ErrorCount {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> line = new ArrayList<Integer>();
        ArrayList<Integer> numbers =new ArrayList<Integer>();
        while(s.hasNextLine()){
            String str = s.next();
            if(!s.hasNext()){
                s.close();
                break;
            }
            int num = s.nextInt();
            int index = str.lastIndexOf("\\");
            String strName = str.substring(index + 1, str.length());
            boolean falg = false;
            int same = -1;
            for(int j = 0; j < line.size(); j ++){
                if(name.get(j).equals(new String(strName)) && line.get(j).equals(num)){
                    falg = true;
                    same = j;
                }
            }
            if(falg){
                int newTime = numbers.get(same) + 1;
                numbers.set(same, newTime);
            }else{
                name.add(new String(strName));
                line.add(num);
                numbers.add(1);
            }
            s.nextLine();
        }
        for(int i = 0; i < numbers.size() - 1; i ++){
            int maxTime = numbers.get(i);
            int maxLin = line.get(i);
            String max = name.get(i);
            for(int j = i + 1; j < numbers.size(); j ++){
                if(numbers.get(j) > maxTime){
                    maxTime = numbers.get(j);
                    maxLin = line.get(j);
                    max = name.get(j);
                    for(int k = j; k > i; k --){
                        numbers.set(k, numbers.get(k - 1));
                        line.set(k, line.get(k -1));
                        name.set(k, name.get(k - 1));
                    }
                    numbers.set(i, maxTime);
                    line.set(i, maxLin);
                    name.set(i, max);
                }
            }
        }
        for(int i = 0; i < (numbers.size() > 8 ? 8 : numbers.size()); i ++){
            StringBuffer result;
            if(name.get(i).length() > 16){
                result =new StringBuffer(name.get(i).substring(name.get(i).length() - 16, name.get(i).length()));
            }else{
                result =new StringBuffer(name.get(i));
            }
            result.append(" ").append(line.get(i)).append(" ").append(numbers.get(i));
            System.out.println(result.toString());
        }
        s.close();

    }

}