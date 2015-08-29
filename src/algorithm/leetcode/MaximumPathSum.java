package algorithm.leetcode;

/**
 * Created by hy on 2015/8/5.
 */
public class MaximumPathSum {
    public static void main(String[] args){
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(-1);
        System.out.println(new MaximumPathSum().maxPathSum(root));
    }


    int maxvalue;
    public int maxPathSum(TreeNode root) {
        maxvalue=Integer.MIN_VALUE;
        maxPathDown(root);
        return maxvalue;
    }

    public int maxPathDown(TreeNode node){
        if(node==null)
            return 0;
        int left=max(0,maxPathDown(node.left));
        int right=max(0,maxPathDown(node.right));
        maxvalue=max(maxvalue,left+right+node.val);
       // System.out.println(maxvalue+" "+left+right+node.val);
        return max(left,right)+node.val;
    }

    public int max(int a,int b){
        return a>b?a:b;
    }
}
