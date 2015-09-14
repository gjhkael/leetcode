package algorithm.leetcode;

/**
 * Created by hy on 2015/9/14.
 */
public class IsSymmetric {


    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root,root);

    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left ==null || right==null){
            return left==right;
        }
        if(left.val !=right.val){
            return false;
        }
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);

    }
}
