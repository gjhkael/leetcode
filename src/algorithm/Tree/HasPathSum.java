package algorithm.Tree;

import java.util.Stack;

/**
 * Created by hy on 2015/8/7.
 */
public class HasPathSum {
    public static void main(String[] args){
        TreeNode root=new TreeNode(-2);
       // root.left=new TreeNode(2);
        root.right=new TreeNode(-3);
        System.out.println(hasPathSum(root, -3));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

    }
}
