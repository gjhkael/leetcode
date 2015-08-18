package algorithm.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by hy on 2015/8/6.
 */
//判断一个二叉数是不是排序二叉树
public class ValidateBinarySearchTree {
    public static void main(String[] args){
        TreeNode node=new TreeNode(2);
        node.left=new TreeNode(1);
        node.left.right=new TreeNode(4);
        System.out.println(validateBinarySearchTree(node));
    }

    public static boolean validateBinarySearchTree(TreeNode node){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode pre=null;
        TreeNode cur=node;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);  //不断的将左节点放入到栈中去，
                cur=cur.left;
            }else{
                TreeNode tmp=stack.pop();  //然后出栈，并且比较前面出栈的数进行比较，
                if(pre!=null&&pre.val>=tmp.val)
                    return false;
                pre=tmp;
                cur=tmp.right;  //将右子树进栈
            }
        }
        return true;
    }



}
