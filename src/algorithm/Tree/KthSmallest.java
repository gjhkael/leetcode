package algorithm.Tree;

import java.util.Stack;

/**
 * Created by hy on 2015/9/14.
 */
public class KthSmallest {


    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode pre = stack.pop();
                if(k==1){
                    return pre.val;
                }
                k=k-1;
                if(pre.right!=null){
                    cur = pre.right;
                }
            }
        }
        return -1;
    }
}
