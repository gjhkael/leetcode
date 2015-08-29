package algorithm.leetcode;

/**
 * Created by hy on 2015/8/4.
 */
//小偷偷东西，但是相邻的街道不能同时偷，给一个数组，求怎么偷，偷得最多
public class HouseRobber {
    public static void main(String[] args){
        int[] nums=new int[]{1,2,-3,4,-5,6,-7};
        //System.out.println(houseRobber(nums));
        //System.out.println(houseRobber1(nums));
        System.out.println(houseRobber2(nums));
    }
    public static int houseRobber(int[] nums){ //空间复杂度为O(n)
        if(nums.length==0||nums==null){
            return 0;
        }
        int[][] mid=new int[nums.length+1][2];
        for(int i=1;i<=nums.length;i++){
            mid[i][0]=max(mid[i-1][0],mid[i-1][1]);
            mid[i][1]=nums[i-1]+mid[i-1][0];
            System.out.println(mid[i][0]+" "+mid[i][1]);
        }
        return max(mid[nums.length][0],mid[nums.length][1]);
    }

    public static int houseRobber1(int[] nums){  //空间复杂度为O(1)
        if(nums.length==0||nums==null){
            return 0;
        }
        int preNo=0;
        int preYes=0;
        for(int i=1;i<=nums.length;i++){
            int tmp=preNo;
            preNo=max(preNo,preYes);
            preYes=nums[i-1]+tmp;
        }
        return max(preNo,preYes);
    }

    public static int houseRobber2(int[] nums){  //百度笔试题，只需要在前提基础之上添加一个判断即可
        if(nums.length==0||nums==null)
            return 0;
        int preNo=0;
        int preYes=0;
        for(int i=1;i<=nums.length;i++){
            int tmp=preNo;
            preNo=max(preNo,preYes);
            if(nums[i-1]<=0)
                preYes=tmp;
            else
                preYes=tmp+nums[i-1];
        }
        return max(preNo,preYes);
    }


    public int rob(int[] nums) {  //如果第一个数和最后一个数也算是相邻的情况，怎么办？

        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        return max(rob(nums,1,nums.length-1),rob(nums,0,nums.length-2));  //这里分两种情况进行计算，得到最大值
    }

    public int rob(int[] nums,int start,int end){
        int preNo=0;
        int preYes=0;
        for(int i=start;i<=end;i++){
            int tmp=preYes;
            preNo=max(preYes,preNo);
            preYes=nums[i]+tmp;
        }
        return max(preYes,preNo);
    }

    public static int max(int numa,int numb){
        return numa>numb?numa:numb;
    }


}
