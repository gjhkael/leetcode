package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hy on 2015/10/9.
 */
public class PascalTrangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(numRows<=0)
            return result;
        List<Integer>tmp=new ArrayList<Integer>();
        tmp.add(1);
        result.add(tmp);
        if(numRows==1){
            return result;
        }
        for(int i=2;i<=numRows;i++){
            tmp=new ArrayList<Integer>();
            List<Integer> tmp1=result.get(i-2);
            for(int j=0;j<i;j++){
                if(j==0)
                    tmp.add(1);
                else if(j==(i-1))
                    tmp.add(1);
                else{
                    tmp.add(tmp1.get(j-1)+tmp1.get(j));
                }
            }

            result.add(tmp);

        }

        return result;
    }
}
