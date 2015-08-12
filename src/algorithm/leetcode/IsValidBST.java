package algorithm.leetcode;

import java.util.Stack;

/**
 * Created by hy on 2015/8/5.
 */
public class IsValidBST {
    public static void main(String[] args){
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(0);
        root.left.right=new TreeNode(1);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static boolean isValidBST1(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode pre=null;
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            {
                TreeNode p = stack.pop();
                if (pre != null && pre.val > p.val) {
                    return false;
                }
                pre = p;
                cur = p.right;
            }
        }


        return true;
    }


}
