package algorithm.leetcode;

/**
 * Created by havstack on 9/6/15.
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

}
