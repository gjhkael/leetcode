package algorithm.huaweiOj;

import java.util.*;

/**
 * Created by hy on 2015/9/9.
 */
public class ErrorCount {

    public static void main(String[] args){
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        int count=0;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            if(!scan.hasNext()){
                scan.close();
                break;
            }
            String s = scan.nextLine();
            if(s.equals(" "))
                break;
            String[] nums = s.split(" ");
            String[] path = nums[0].split("\\\\");
            String last = path[path.length - 1];
            if (last.length() > 16) {
                last = last.substring(last.length() - 16, last.length());
            }
            last = last + " " + nums[1];
            if (result.containsKey(last)) {
                result.put(last, result.get(last) + 1);
            } else {
                if (count >= 8) {
                    continue;
                }
                result.put(last, 1);
                count++;
            }

        }
        ArrayList<String> keys = new ArrayList<String>(result.keySet());
        ByValueComparator bvc = new ByValueComparator(result);
        Collections.sort(keys, bvc);

        for(String s: result.keySet()){
            System.out.println(s+" "+result.get(s));
        }
    }
}
class ByValueComparator implements Comparator<String>{
    HashMap<String,Integer> base_map;
    public ByValueComparator(HashMap<String,Integer> map){
        this.base_map = map;
    }
    @Override
    public int compare(String o1, String o2) {
        if(!base_map.containsKey(o1) || !base_map.containsKey(o2))
            return 0;
        if(base_map.get(o1)<base_map.get(o2)){
            return 1;
        }else
            return -1;
    }
}