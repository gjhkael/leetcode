package javalanguage;

/**
 * Created by hy on 2015/8/6.
 */
public class test {
    public static void main(String[] args){

        int []test={1,2,-3,4,5,16,10};
        System.out.println(houseRobber2(test));
        Class s=test.getClass();
        new test().getClass();
    }


    public static int houseRobber2(int[] nums){
        if(nums.length==0||nums==null)
            return 0;
        int preYes=0;
        int preNo=0;
        for(int i=0;i<nums.length;i++){
            int tmp=preNo;
            preNo=Math.max(preYes,preNo);
//            if(nums[i]<0){
//                preYes=tmp;
//            }else {
            preYes = tmp + nums[i];
            //}
        }
        return Math.max(preYes,preNo);
    }
}
