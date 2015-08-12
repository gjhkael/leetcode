package algorithm.Tree;

import java.util.Stack;

/**
 * Created by hy on 2015/8/7.
 */
//判断一颗树是不是镜像树
public class IsSymmetric {

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        System.out.println(new IsSymmetric().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null||right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);

    }
    public boolean isSymmetric1(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }

}
