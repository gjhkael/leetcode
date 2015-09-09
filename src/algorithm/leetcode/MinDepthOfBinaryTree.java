package algorithm.leetcode;

/**
 * Created by havstack on 9/7/15.
 */
public class MinDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);


        return (left==0||right==0)?left+right+1:min(left,right)+1;
    }
    public int min(int a,int b){
        return a<b?a:b;
    }
}
